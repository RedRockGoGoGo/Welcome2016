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
 * Created by a on 2016/8/9.
 */
public class BeautifulAdapter extends RecyclerView.Adapter<BeautifulAdapter.BangdanViewHolder> {

    private Fragment mFragment;
    private OnItemClickListener mListener;
    private List<String>pic;
    private Context context;
    private static List<String> text;
    //private LayoutInflater inflater;
    public BeautifulAdapter (Context context,
                             List<String>pic,
                             List<String>text,
                             Fragment mFragment){
        this.pic = pic;
        this.text = text;
        this.mFragment = mFragment;
        this.context = context;
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }
    @Override
    public BangdanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //创建条目缓存的视图。
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.beautiful_item, parent, false);
        return new BangdanViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final BangdanViewHolder holder, final int position) {
        //Glide.with(mFragment).load(pic_song_txt.get(position)).into(holder.songImage);
        Glide.with(mFragment).load(pic.get(position)).into(holder.songImage);


            holder.textView.setText(text.get(position));


        //holder.songImage.setImageBitmap(pic_song.get(position));
    }

    @Override
    public int getItemCount() {
        //返回有多少个条目。
        return pic.size();
    }
    public interface OnItemClickListener {
        public void OnItemClick(View view,
                                String pic);
    }
    class BangdanViewHolder extends RecyclerView.ViewHolder{
        // TextView songName ;
        // TextView singerName;
        RoundedImageView songImage;
        TextView textView;
        public BangdanViewHolder(View itemView) {
            super(itemView);
            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });*/
            songImage = (RoundedImageView) itemView.findViewById(R.id.beautiful_image);
            textView = (TextView) itemView.findViewById(R.id.beautiful_text);
            // songName = (TextView) itemView.findViewById(R.id.song1);
            // singerName = (TextView) itemView.findViewById(R.id.singer1);
        }
    }

}
