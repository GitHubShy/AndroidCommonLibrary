package com.common.shy.englishmodule.activity;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.common.shy.basemodule.custom.HandDrawView;
import com.common.shy.basemodule.dispatcher.ActivityDispatcher;
import com.common.shy.commonutils.http.HttpRequestManager;
import com.common.shy.commonutils.http.SimpleRequestBean;
import com.common.shy.commonutils.utils.BitmapUtils;
import com.common.shy.commonutils.utils.FileUtils;
import com.common.shy.commonutils.utils.Logger;
import com.common.shy.commonutils.utils.MD5;
import com.common.shy.commonutils.utils.StringUtils;
import com.common.shy.commonutils.voice.VoiceManager;
import com.common.shy.englishmodule.R;
import com.common.shy.englishmodule.activity.adapter.WordsAdapter;
import com.common.shy.englishmodule.activity.pojo.Word;
import com.common.shy.englishmodule.activity.repository.WordsRepository;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Route(path = ActivityDispatcher.ENG_SPELLING_ACTIVITY)
public class SpellingActivity extends AppCompatActivity {

    private TextView mQuestion;
    private TextView mCheckAll;
    private TextView mDisplayPhonetic;
    private TextView mDisplayChinese;
    private TextView mPhonetic;
    private EditText mUserAnswer;
    private TextView mRecognize;
    private TextView mClear;
    private TextView mSubmit;
    private TextView mAccuracy;
    private HandDrawView mDrawView;
    private RecyclerView mRecycleView;


    @Autowired
    String title;

    private List<Word> mOriginalDatas;
    private List<Word> mQuestionRepository = new ArrayList<>();
    private List<Word> mWrongQuestion = new ArrayList<>();

    private Word mCurrentWord;

    private int mRepoSize;
    private int mCorrectNum;


    private VoiceManager mVoiceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eng_activity_test_spelling);
        ARouter.getInstance().inject(this);
        initView();
        initListener();
        initData();
    }

    private void initView() {
        mQuestion = findViewById(R.id.question);
        mCheckAll = findViewById(R.id.all_word);
        mDisplayPhonetic = findViewById(R.id.display_phonetic);
        mDisplayChinese = findViewById(R.id.display_chinese);
        mPhonetic = findViewById(R.id.phonetic);
        mUserAnswer = findViewById(R.id.answer);
        mRecognize = findViewById(R.id.recognize);
        mClear = findViewById(R.id.clear);
        mSubmit = findViewById(R.id.submit);
        mAccuracy = findViewById(R.id.accuracy);
        mDrawView = findViewById(R.id.broad);
        mRecycleView = findViewById(R.id.words_list);
    }

    private void initListener() {
        mRecognize.setOnClickListener(view -> recognize());
        mClear.setOnClickListener(view -> mDrawView.clear());
        mSubmit.setOnClickListener(view -> estimate());
        mUserAnswer.setOnEditorActionListener((v, actionId, event) -> {
            //当actionId == XX_SEND 或者 XX_DONE时都触发
            //或者event.getKeyCode == ENTER 且 event.getAction == ACTION_DOWN时也触发
            //注意，这是一定要判断event != null。因为在某些输入法上会返回null。
            if (actionId == EditorInfo.IME_ACTION_SEND
                    || actionId == EditorInfo.IME_ACTION_DONE
                    || (event != null && KeyEvent.KEYCODE_ENTER == event.getKeyCode() && KeyEvent.ACTION_DOWN == event.getAction())) {
                estimate();
            }
            return false;
        });
        mDisplayPhonetic.setOnClickListener(view -> mPhonetic.setVisibility(View.VISIBLE));
        mDisplayChinese.setOnClickListener(v -> mQuestion.setVisibility(View.VISIBLE));
        mCheckAll.setOnClickListener(view -> showAllWords());
    }

    private void initData() {
        mVoiceManager = new VoiceManager();
        getLifecycle().addObserver(mVoiceManager);
        mOriginalDatas = WordsRepository.getWordsRepository().getOneList(title);
        if (mOriginalDatas != null) {
            mQuestionRepository.addAll(mOriginalDatas);
            mRepoSize = mQuestionRepository.size();
            displayQuestion();
            Logger.e("1111111111111", "mQuestionRepository=" + mQuestionRepository.size());
        }
    }

    /**
     * https://doc.xfyun.cn/rest_api/%E6%89%8B%E5%86%99%E6%96%87%E5%AD%97%E8%AF%86%E5%88%AB.html
     */
    private void recognize() {
        Bitmap bitmap = BitmapUtils.ViewToBitmap(mDrawView);
        File f = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/a.png");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileUtils.bitmapToFile(bitmap, f);
        String appid = "5aa8f6c4";
        String TEST_API_KEY = "4484a842bbbcb4390854ed2fb5e76168";
        String time = System.currentTimeMillis()/ 1000L + "";
        String json = "{" + "\"language\":\"en\"," + "\"location\":\"false\"" + "}";
        String s = Base64.encodeToString(json.getBytes(),Base64.DEFAULT);

        String checkNum = MD5.md5(TEST_API_KEY + time + "eyJsYW5ndWFnZSI6ImVuIiwibG9jYXRpb24iOiJmYWxzZSJ9");
        String img = BitmapUtils.bitmapToBase64(bitmap);
        String ss= "";
        try {
            ss = FileUtils.encodeBase64File(f);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            img = URLEncoder.encode(img, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        SimpleRequestBean.RequestBuilder rb = new SimpleRequestBean.RequestBuilder(HttpRequestManager.FORM, "http://webapi.xfyun.cn/v1/service/v1/ocr/handwriting");
        HashMap<String, String> header = new HashMap<>();
        header.put("X-Appid", appid);
        header.put("X-CurTime", time);
        header.put("X-Param", "eyJsYW5ndWFnZSI6ImVuIiwibG9jYXRpb24iOiJmYWxzZSJ9");
        header.put("X-CheckSum", checkNum);
        rb.setHeaders(header);
        HashMap<String, String> para = new HashMap<>();
        para.put("image", ss);
        rb.setParameters(para);
        HttpRequestManager.request(rb.build());

    }

    private void displayQuestion() {
        Random random = new Random();
        Integer randomKey = random.nextInt(mQuestionRepository.size());
        mCurrentWord = mQuestionRepository.get(randomKey);
        mQuestion.setText(mCurrentWord.getChineseExplanation());
        mPhonetic.setText(mCurrentWord.getPhonetic());
        mPhonetic.setVisibility(View.GONE);
        mQuestion.setVisibility(View.GONE);
        mUserAnswer.setText("");
        mVoiceManager.speakText(mCurrentWord.getWord());
    }

    private void estimate() {
        String text = mUserAnswer.getText().toString().trim();

        if (StringUtils.isEmpty(text) || !mCurrentWord.getWord().equals(text)) {
            mCurrentWord.setWrongWord(text);
            mWrongQuestion.add(mCurrentWord);
        } else {
            mCorrectNum++;
        }
        mQuestionRepository.remove(mCurrentWord);

        if (mQuestionRepository.size() == 0) {
            mAccuracy.setVisibility(View.VISIBLE);
            DecimalFormat df = new DecimalFormat("0.00");
            mAccuracy.setText(df.format((float) mCorrectNum / mRepoSize));
            showWrongWords();
        } else {
            displayQuestion();
        }

    }

    private void showWrongWords() {
        WordsAdapter adapter = new WordsAdapter(mWrongQuestion);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mRecycleView.setAdapter(adapter);
    }

    private void showAllWords() {
        WordsAdapter adapter = new WordsAdapter(mOriginalDatas);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mRecycleView.setAdapter(adapter);
    }


}
