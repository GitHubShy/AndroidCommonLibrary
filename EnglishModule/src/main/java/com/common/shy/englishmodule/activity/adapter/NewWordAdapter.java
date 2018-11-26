package com.common.shy.englishmodule.activity.adapter;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.common.shy.commonutils.utils.StringUtils;
import com.common.shy.englishmodule.R;
import com.common.shy.englishmodule.activity.pojo.Word;

public class NewWordAdapter extends PagedListAdapter<Word, WordsAdapter.WrongWordViewHolder> {
    public NewWordAdapter() {
        super(DIFF_CALLBACK);
    }


    @NonNull
    @Override
    public WordsAdapter.WrongWordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.eng_words_list, null, false);
        WordsAdapter.WrongWordViewHolder holder = new WordsAdapter.WrongWordViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull WordsAdapter.WrongWordViewHolder holder, int position) {
        Word question = getItem(position);
        holder.chinese.setText(question.getChineseExplanation());
        holder.rightWord.setText("正确答案为：" + question.getWord());
        holder.phonetic.setText(question.getPhonetic());
        if (!StringUtils.isEmpty(question.getWrongWord())) {
            holder.wrongWord.setText("你的答案为：" + question.getWrongWord());
        }
    }

    private static DiffUtil.ItemCallback<Word> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Word>() {
                // Concert details may have changed if reloaded from the database,
                // but ID is fixed.
                @Override
                public boolean areItemsTheSame(Word oldConcert, Word newConcert) {
                    return oldConcert.getWord() == newConcert.getWord();
                }

                @Override
                public boolean areContentsTheSame(Word oldConcert,
                                                  Word newConcert) {
                    return oldConcert.equals(newConcert);
                }
            };

}
