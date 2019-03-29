package com.common.shy.englishmodule.activity.repository;

import android.os.Environment;
import android.util.Log;

import com.common.shy.commonutils.utils.TimeUtils;
import com.common.shy.englishmodule.BuildConfig;
import com.common.shy.englishmodule.activity.pojo.Word;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableWorkbook;

public class WordsRepository {

    public static String TAG = "WordsRepository";

    public String mFileName = BuildConfig.file_name;

    private static WordsRepository mRepository;

    private LinkedHashMap<String, List> mDifferentCategories = new LinkedHashMap();

    private WordsRepository() {
        TimeUtils timeUtils = new TimeUtils();
        timeUtils.beginRecording();
        getDataFromExcel();
        timeUtils.endRecording();
    }

    public static WordsRepository getWordsRepository() {
        if (mRepository == null) {
            mRepository = new WordsRepository();
        }
        return mRepository;
    }

    public HashMap<String, List> getmDifferentCategories() {
        return mDifferentCategories;
    }

    public List<Word> getOneList(String title) {
        if (mDifferentCategories.get(title) != null) {
            return mDifferentCategories.get(title);
        }
        return null;
    }

    private void getDataFromExcel() {
        String pate = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + mFileName;
        File excel = new File(pate);
        int wordsTotal = 0;
        Log.e(TAG, "pate" + pate + "f=" + excel.exists());
        try {
            Workbook rwb = Workbook.getWorkbook(excel);
            int sheetsNum = rwb.getNumberOfSheets();
            for (int i = 0; i < sheetsNum; i++) {
                Sheet sheet = rwb.getSheet(i);
                String sheetName = sheet.getName();
                List<Word> questions = new ArrayList<>();
                int rawNum = sheet.getRows();
                wordsTotal = wordsTotal + rawNum;
                Log.e(TAG, "sheetName = " + sheetName+"rawNum="+rawNum);
                for (int j = 0; j < rawNum; j++) {
                    Cell[] row = sheet.getRow(j);
                    Word.WordBuilder builder = new Word.WordBuilder();
                    if (row.length > 0 && row[0] != null) {
                        builder.word(row[0].getContents());
                    }
                    if (row.length > 1 && row[1] != null) {
                        builder.chineseExplanation(row[1].getContents());
                    }
                    if (row.length > 2 && row[2] != null) {
                        builder.phonetic(row[2].getContents());
                    }
                    if (row.length > 3 && row[3] != null) {
                        builder.englishExplanation(row[3].getContents());
                    }
                    Word word = builder.build();
//                    Log.e(TAG,""+word.toString());
                    questions.add(word);
                }
                mDifferentCategories.put(sheetName, questions);
            }
            Log.e(TAG, "totalNum = " + wordsTotal);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    private void writeExcel() {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/aa.xls";
        File file = new File(path);
        WritableWorkbook wwb;
        try {
            OutputStream os = new FileOutputStream(file);
            wwb = Workbook.createWorkbook(os);
            wwb.write();
            wwb.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
