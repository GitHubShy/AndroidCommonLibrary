package com.common.shy.englishmodule.activity.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.common.shy.englishmodule.R;
import com.common.shy.englishmodule.activity.pojo.Catalogue;

import java.util.List;


public class CatalogueAdapter extends RecyclerView.Adapter<CatalogueAdapter.CatalogueViewHolder> {

    private List<Catalogue> mData;

    private OnItemClickListener mClickListener;

    public void setmClickListener(OnItemClickListener mClickListener) {
        this.mClickListener = mClickListener;
    }

    public CatalogueAdapter(List<Catalogue> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public CatalogueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.eng_catalogue_list, null, false);
        CatalogueViewHolder holder = new CatalogueViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CatalogueViewHolder holder, final int position) {
        Catalogue catalogue = mData.get(position);
        holder.title.setText(catalogue.title);
        holder.chinese2english.setOnClickListener(v -> mClickListener.onItemClick(position, 1));
        holder.english2chinese.setOnClickListener(v -> mClickListener.onItemClick(position, 2));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class CatalogueViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView chinese2english;
        public TextView english2chinese;

        public CatalogueViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            chinese2english = itemView.findViewById(R.id.c2e);
            english2chinese = itemView.findViewById(R.id.e2c);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position, int type);
    }

}
