package com.example.livedatademo.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.example.livedatademo.R;
import com.example.livedatademo.model.Blog;

import org.w3c.dom.Text;

import java.util.List;

public class BlogAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private static final String TAG = "BlogAdapter";
    private List<Blog> mBlogList;

    public BlogAdapter(List<Blog> blogList) {
        mBlogList = blogList;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {\
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.blog_item, parent, false));

    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        if (mBlogList != null && mBlogList.size() > 0) {
            return mBlogList.size();
        }
        else {
            return 0;
        }
    }

    public class ViewHolder extends BaseViewHolder {

        ImageView ivThumbnail;
        TextView tvTitle;
        TextView tvDescription;
        TextView tvLink;

        public ViewHolder(View itemView) {
            super(itemView);
            ivThumbnail = itemView.findViewById(R.id.ivThumbnail);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvLink = itemView.findViewById(R.id.tvLink);

        }

        @Override
        protected void clear() {
            ivThumbnail.setImageDrawable(null);
            tvTitle.setText("");
            tvLink.setText("");

        }

        public void onBind(int position) {
            super.onBind(position);

            final Blog mBlog = mBlogList.get(position);

            if (mBlog.getThumbnail() != null) {
                Glide.with(itemView.getContext()).load(mBlog.getThumbnail()).into(ivThumbnail);
            }

            
        }
    }

}
