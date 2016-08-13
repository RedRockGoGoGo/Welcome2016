package com.gavynzhang.welcome2016.fragment.fragmentDemeamour;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gavynzhang.welcome2016.R;
import com.gavynzhang.welcome2016.activity.WebActivity;
import com.gavynzhang.welcome2016.adapter.YuanChuangAdapter;
import com.gavynzhang.welcome2016.model.YuanChuang;
import com.gavynzhang.welcome2016.utils.HttpCallbackListener;
import com.gavynzhang.welcome2016.utils.HttpUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 2016/8/8.
 */
public class FragmentYuanChuang extends Fragment{
    private List<String> title;
    private List<String> introduction;
    private List<String> time;
    private List<String> url;
    private List<String> pic;
    private TextView textView;
    public static final int UPDATE = 1;
    public static final int NO = 2;
    private ImageView image;
    private AlertDialog myDialog = null;
    private RecyclerView recyclerView;
    private Handler handler =  new  Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case UPDATE :
                    Log.i("AAAAAAA", "hehe");
                    recyclerView= (RecyclerView) getView().findViewById(R.id.list_recycler_view);
                    YuanChuangAdapter adapter_gangtai = new YuanChuangAdapter(getContext(),title,introduction,pic,url,time,FragmentYuanChuang.this);
                    adapter_gangtai.setOnItemClickListener(new YuanChuangAdapter.OnItemClickListener() {
                        @Override
                        public void OnItemClick(View view, String title, String introduction, String pic, String url, String time) {
                            Intent intent = new Intent(getActivity(), WebActivity.class);
                            intent.putExtra("url",url);
                            startActivity(intent);
                        }
                    });
                    recyclerView.setAdapter(adapter_gangtai);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    break;
                case NO:
                    textView.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
    public static FragmentYuanChuang newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt("ARG_PAGE", page);
        FragmentYuanChuang fragmentYuanChuang = new FragmentYuanChuang();
        fragmentYuanChuang.setArguments(args);
        return fragmentYuanChuang;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        textView = (TextView) view.findViewById(R.id.no);
        initDates();
        return view;
    }
    private void initDates(){
        String address = "http://hongyan.cqupt.edu.cn/cyxbsMobile/index.php/Home/WelcomeFreshman/cquptOriginal";
        HttpUtil.sendHttpRequest(address, new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                Log.i("AAAAAAAA", response);
                parseJSONWithGSON(response);
            }
            @Override
            public void onError(Exception e) {
                Message message = new Message();
                message.what = NO;
                handler.sendMessage(message);
            }
        });

    }
    private void parseJSONWithGSON(String jsonData){
        List<String> pic = new ArrayList<String>();
        List<String> url = new ArrayList<String>();
        List<String> time = new ArrayList<String>();
        List<String> title = new ArrayList<String>();
        List<String> introduction = new ArrayList<String>();
        Gson gson = new Gson();
        YuanChuang bangdanes = gson.fromJson(jsonData, YuanChuang.class);
        List<YuanChuang.DataBean> songlist = bangdanes.getData();
        for (YuanChuang.DataBean c : songlist){
            pic.add(c.getPhoto().get(0).getPhoto_src());
            time.add(c.getTime());
            url.add(c.getVideo_url());
            title.add(c.getName());
            introduction.add(c.getIntroduction());
        }
        this.introduction = introduction;
        this.pic= pic;
        this.time = time;
        this.url = url;
        this.title = title;

        Message message = new Message();
        message.what = UPDATE;
        handler.sendMessage(message);

    }
}
