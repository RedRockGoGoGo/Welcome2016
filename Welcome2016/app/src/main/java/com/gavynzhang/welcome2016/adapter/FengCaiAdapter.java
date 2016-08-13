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
import com.gavynzhang.welcome2016.utils.GlideRoundTransform;

import java.util.List;

/**
 * Created by a on 2016/8/9.
 */
public class FengCaiAdapter extends RecyclerView.Adapter<FengCaiAdapter.BangdanViewHolder>{
    private List<String> introduction;
    private List<String> title;
    private List<String> name;
    private List<String> pic;
    private Fragment mFragment;
    private OnItemClickListener mListener;
    private Context context;
    public FengCaiAdapter (Context context,
                           List<String>pic,
                           List<String>name,
                           List<String>title,
                           List<String>introduction,
                           Fragment mFragment){
        this.pic = pic;
        this.name = name;
        this.title = title;
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
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_item, parent, false);
        return new BangdanViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final BangdanViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.OnItemClick(view,
                        pic.get(position),
                        name.get(position),
                        title.get(position),
                        introduction.get(position));
            }
        });
        //绑定数据到条目.
        holder.name.setText(name.get(position));
        holder.title.setText(title.get(position));
        Glide.with(mFragment).load(pic.get(position)).transform(new GlideRoundTransform(context,8)) .into(holder.pic);
        //holder.songImage.setImageBitmap(pic_song.get(position));
    }

    @Override
    public int getItemCount() {
        //返回有多少个条目。
        return name.size();
    }
    public interface OnItemClickListener {
        void OnItemClick(View view,
                         String pic,
                         String name,
                         String title,
                         String introduction);
    }
    class BangdanViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView title;
        ImageView pic;
        public BangdanViewHolder(View itemView) {
            super(itemView);
            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });*/
            name = (TextView) itemView.findViewById(R.id.person_name);
            title = (TextView) itemView.findViewById(R.id.person_title);
            pic = (ImageView) itemView.findViewById(R.id.person_pic);
        }
    }


}
