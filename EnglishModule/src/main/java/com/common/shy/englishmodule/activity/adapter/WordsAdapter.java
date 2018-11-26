package com.common.shy.englishmodule.activity.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.common.shy.commonutils.utils.StringUtils;
import com.common.shy.englishmodule.R;
import com.common.shy.englishmodule.activity.pojo.Word;

import java.util.List;


public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.WrongWordViewHolder> {

    private List<Word> mData;

    public WordsAdapter(List<Word> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public WrongWordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.eng_words_list, null, false);
        WrongWordViewHolder holder = new WrongWordViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull WrongWordViewHolder holder, final int position) {
        Word question = mData.get(position);
        holder.chinese.setText(question.getChineseExplanation());
        holder.rightWord.setText("正确答案为：" + question.getWord());
        holder.phonetic.setText(question.getPhonetic());
        if (!StringUtils.isEmpty(question.getWrongWord())) {
            holder.wrongWord.setText("你的答案为：" + question.getWrongWord());
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class WrongWordViewHolder extends RecyclerView.ViewHolder {

        public TextView chinese;
        public TextView rightWord;
        public TextView wrongWord;
        public TextView phonetic;

        public WrongWordViewHolder(View itemView) {
            super(itemView);
            chinese = itemView.findViewById(R.id.chinese);
            rightWord = itemView.findViewById(R.id.english);
            wrongWord = itemView.findViewById(R.id.wrong_word);
            phonetic = itemView.findViewById(R.id.phonetic);
        }
    }

}
