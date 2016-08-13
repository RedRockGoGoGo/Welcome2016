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

/**
 * Created by a on 2016/8/12.
 */
public class YuanChuangAdapter extends RecyclerView.Adapter<YuanChuangAdapter.BangdanViewHolder>{
    private List<String> introduction;
    private List<String> title;
    private List<String> pic;
    private List<String> url;
    private List<String> time;
    private Fragment mFragment;
    private OnItemClickListener mListener;
    private Context context;
    //private LayoutInflater inflater;
    public YuanChuangAdapter (Context context,
                               List<String>title,
                               List<String>introduction,
                              List<String>pic,
                              List<String>url,
                              List<String>time,
                               Fragment mFragment){

        this.title  = title;
        this.introduction = introduction;
        this.time = time;
        this.url = url;
        this.pic = pic;
        this.mFragment = mFragment;
        this.context = context;
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }
    @Override
    public BangdanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //创建条目缓存的视图。
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.gonglue_item, parent, false);
        return new BangdanViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final BangdanViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mListener.OnItemClick(v,
                                title.get(position),
                                introduction.get(position),
                                pic.get(position),
                                url.get(position),
                                time.get(position));
                    }
                }
        );
        //绑定数据到条目.
        holder.title.setText(title.get(position));
        holder.introduction.setText(introduction.get(position));
        holder.time.setText(time.get(position));
        holder.time_title.setText("时长:");
        Glide.with(mFragment).load(pic.get(position)).into(holder.pic);
        //Glide.with(mFragment).load(pic_song_big.get(position)).transform(new GlideRoundTransform(context,8)) .into(holder.songImage);
    }

    @Override
    public int getItemCount() {
        //返回有多少个条目。
        return title.size();
    }



    public interface OnItemClickListener {
        public void OnItemClick(View view,
                                String title,
                                String introduction,
                                String pic,
                                String url,
                                String time);
    }
    class BangdanViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView introduction;
        TextView time;
        ImageView pic;
        TextView time_title;
        //ImageView songImage;
        public BangdanViewHolder(View itemView) {
            super(itemView);
            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });*/
            time_title = (TextView) itemView.findViewById(R.id.time);
            title = (TextView) itemView.findViewById(R.id.title);
            introduction = (TextView) itemView.findViewById(R.id.introduction);
            time = (TextView) itemView.findViewById(R.id.address);
            pic = (ImageView) itemView.findViewById(R.id.pic);
            //songImage = (ImageView) itemView.findViewById(R.id.image1);
            // songName = (TextView) itemView.findViewById(R.id.song1);
            // singerName = (TextView) itemView.findViewById(R.id.singer1);
        }
    }



}
