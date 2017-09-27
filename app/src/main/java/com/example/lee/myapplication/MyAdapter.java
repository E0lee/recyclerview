package com.example.lee.myapplication;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by lee on 2016/5/22.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    public List<item> mDataset;
    public OnLoadMoreListener mOnLoadMoreListener;

    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;
    public boolean isLoading;
    public void setLoaded() {
        isLoading = false;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView artistTextView,titleTextView,contentTextView;
        public ViewHolder(View itemView) {//ViewHolder一定要
            super(itemView);
            artistTextView = (TextView)itemView.findViewById(R.id.artist);
            titleTextView = (TextView)itemView.findViewById(R.id.title);
            contentTextView =  (TextView)itemView.findViewById(R.id.content);
        }
    }
    public static class LoadingViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar progressBar;

        public LoadingViewHolder(View itemView) {
            super(itemView);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar1);
        }
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.mOnLoadMoreListener = onLoadMoreListener;
    }


    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<item> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup,
                                                   int viewType) {//建立 view，並將 view 轉成 ViewHolder
        Context context = viewGroup.getContext();
        // create a new view
        View contactView = LayoutInflater.from(context).inflate(
                R.layout.my_text_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        ViewHolder viewHolder2 = new ViewHolder(LayoutInflater.from(context).inflate(
                R.layout.layout_loading_item, viewGroup, false));
        if (viewType == VIEW_TYPE_ITEM) {
            View view = LayoutInflater.from(context).inflate(R.layout.my_text_view, viewGroup, false);
            return new ViewHolder(view);
        } else if (viewType == VIEW_TYPE_LOADING) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_loading_item, viewGroup, false);
            return new ViewHolder(view);
        }
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {//將 Contact 顯示在 view 中
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
            item item = mDataset.get(position);
            holder.artistTextView.setText((CharSequence) item.getArtist());
            holder.titleTextView.setText((CharSequence) item.getTitle());
            holder.contentTextView.setText((CharSequence) item.getContent());
            if(!item.getRead()){
                holder.artistTextView.setTypeface(null, Typeface.BOLD);
                holder.titleTextView.setTypeface(null,Typeface.BOLD);

            }


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
