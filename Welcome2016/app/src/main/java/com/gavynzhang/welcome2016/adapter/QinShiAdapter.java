package com.gavynzhang.welcome2016.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gavynzhang.welcome2016.R;

import java.util.List;

import cn.carbs.android.expandabletextview.library.ExpandableTextView;

/**
 * Created by a on 2016/8/11.
 */
public class QinShiAdapter extends RecyclerView.Adapter<QinShiAdapter.BangdanViewHolder>{
    private List<String> introduction;
    private List<String> pic;
    private String title[] = {"老寝室","四人间","六人间"};
    private Fragment mFragment;
    private OnItemClickListener mListener;
    private Context context;
    //private LayoutInflater inflater;
    public QinShiAdapter (Context context,
                        List<String>pic,
                        List<String>introduction,
                        Fragment mFragment){
        this.pic  = pic;
        this.introduction = introduction;
        this.mFragment = mFragment;
        this.context = context;
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }
    @Override
    public BangdanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //创建条目缓存的视图。
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.qinshi_item, parent, false);
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
                                pic.get(position));
                    }
                }
        );
        //绑定数据到条目.
        if (position!=0){
            holder.introduction.setText("寝室情况:\n"+introduction.get(position));
        }else {
            holder.introduction.setText(introduction.get(position));
        }
            holder.title.setText(title[position]);
        //Glide.with(mFragment).load(pic_song_txt.get(position)).into(holder.songImage);
        Glide.with(mFragment).load(pic.get(position)).into(holder.pic);
    }

    @Override
    public int getItemCount() {
        //返回有多少个条目。
        return pic.size();
    }
    public interface OnItemClickListener {
        public void OnItemClick(View view,
                                String introduction,
                                String pic);
    }
    class BangdanViewHolder extends RecyclerView.ViewHolder{
        ImageView pic;
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
            pic = (ImageView) itemView.findViewById(R.id.ic_old_qinshi);
            introduction = (ExpandableTextView) itemView.findViewById(R.id.qinshi_introduction);
            title = (TextView) itemView.findViewById(R.id.qinshi_title);
            //songImage = (ImageView) itemView.findViewById(R.id.image1);
            // songName = (TextView) itemView.findViewById(R.id.song1);
            // singerName = (TextView) itemView.findViewById(R.id.singer1);
        }
    }
}
