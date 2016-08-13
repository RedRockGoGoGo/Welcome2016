package com.gavynzhang.welcome2016.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gavynzhang.welcome2016.R;

import java.util.List;

import cn.carbs.android.expandabletextview.library.ExpandableTextView;

/**
 * Created by a on 2016/8/11.
 */
public class TextAdapter extends RecyclerView.Adapter<TextAdapter.BangdanViewHolder>{
    private List<String> introduction;
    private List<String> title;
    private Fragment mFragment;
    private OnItemClickListener mListener;
    private int yn = 0;
    private Context context;
    public TextAdapter (Context context,
                         List<String>title,
                         List<String>introduction,
                         Fragment mFragment){
        this.title = title;
        this.introduction = introduction;
        this.mFragment = mFragment;
        this.context = context;
        this.yn = 0;
    }
    public TextAdapter (int yn,
                        Context context,
                        List<String>title,
                        List<String>introduction,
                        Fragment mFragment){
        this.title = title;
        this.introduction = introduction;
        this.mFragment = mFragment;
        this.context = context;
        this.yn = yn;
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }
    @Override
    public BangdanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //创建条目缓存的视图。
        View itemView;
        if (yn==0)
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.xuzhi_item, parent, false);
        else
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.zuzhi_item, parent, false);

        return new BangdanViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final BangdanViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mListener.OnItemClick(v,
                                introduction.get(position),
                                title.get(position));
                    }
                }
        );
        //绑定数据到条目.
        holder.introduction.setText(introduction.get(position));
        holder.title.setText(title.get(position));
    }

    @Override
    public int getItemCount() {
        //返回有多少个条目。
        return title.size();
    }
    public interface OnItemClickListener {
        public void OnItemClick(View view,
                                String introduction,
                                String pic);
    }
    class BangdanViewHolder extends RecyclerView.ViewHolder{
        ExpandableTextView introduction;
        TextView title;
        //ImageView songImage;
        public BangdanViewHolder(View itemView) {
            super(itemView);
            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });*/
            introduction = (ExpandableTextView) itemView.findViewById(R.id.xuzhi_introduce);
            title = (TextView) itemView.findViewById(R.id.xuzhi_title);
            //songImage = (ImageView) itemView.findViewById(R.id.image1);
            // songName = (TextView) itemView.findViewById(R.id.song1);
            // singerName = (TextView) itemView.findViewById(R.id.singer1);
        }
    }
}
