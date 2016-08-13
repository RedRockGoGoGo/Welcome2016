package com.gavynzhang.welcome2016.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gavynzhang.welcome2016.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

/**
 * Created by a on 2016/8/11.
 */
public class GongLueAdapter extends RecyclerView.Adapter<GongLueAdapter.BangdanViewHolder>{
    private List<String> address;
    private List<String> title;
    private List<String> pic;
    private List<String> introduction;
    private Fragment mFragment;
    private OnItemClickListener mListener;
    private Context context;
    private int page;
    //private LayoutInflater inflater;
    public GongLueAdapter (int page,
                           Context context,
                           List<String>pic,
                           List<String>title,
                           List<String>address,
                           List<String>introduction,
                           Fragment mFragment){
        this.page = page;
        this.title  = title;
        this.address = address;
        this.mFragment = mFragment;
        this.pic = pic;
        this.introduction = introduction;
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
                                pic.get(position),
                                address.get(position),
                                title.get(position));
                    }
                }
        );
        //绑定数据到条目.
        //holder.singerName.setText(song.get(position));
        // holder.songName.setText(singer.get(position));
        holder.title.setText(title.get(position));
        Glide.with(mFragment).load(pic.get(position)).into(holder.pic);
        if (page==1) {
            holder.textView.setVisibility(View.GONE);
            holder.address.setText( address.get(position));
            holder.introduction.setVisibility(View.GONE);
        }
        else if (page==2|page == 3) {
            holder.address.setText(address.get(position));
            holder.introduction.setText(introduction.get(position));
        }
        //SetScaleType(ImageView.ScaleType.CENTER_CROP);
        //Glide.with(mFragment).load(pic_song_txt.get(position)).into(holder.songImage);
        //Glide.with(mFragment).load(pic_song_big.get(position)).transform(new GlideRoundTransform(context,8)) .into(holder.songImage);
    }

    @Override
    public int getItemCount() {
        //返回有多少个条目。
        return title.size();
    }
    public interface OnItemClickListener {
        public void OnItemClick(View view,
                                String pic,
                                String title,
                                String introduction);
    }
    class BangdanViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView address;
        TextView textView;
        RoundedImageView pic;
        TextView introduction;
        //ImageView songImage;
        public BangdanViewHolder(View itemView) {
            super(itemView);
            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });*/
            introduction = (TextView) itemView.findViewById(R.id.introduction);
            pic = (RoundedImageView) itemView.findViewById(R.id.pic);
            title = (TextView) itemView.findViewById(R.id.title);
            address = (TextView) itemView.findViewById(R.id.address);
            textView = (TextView) itemView.findViewById(R.id.text_o);
            //songImage = (ImageView) itemView.findViewById(R.id.image1);
            // songName = (TextView) itemView.findViewById(R.id.song1);
            // singerName = (TextView) itemView.findViewById(R.id.singer1);
        }
    }


}
