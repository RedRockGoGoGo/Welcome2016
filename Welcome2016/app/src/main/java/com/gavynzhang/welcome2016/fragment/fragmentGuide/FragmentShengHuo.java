package com.gavynzhang.welcome2016.fragment.fragmentGuide;


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

import com.bumptech.glide.Glide;
import com.gavynzhang.welcome2016.R;
import com.gavynzhang.welcome2016.adapter.GongLueAdapter;
import com.gavynzhang.welcome2016.model.ShengHuo;
import com.gavynzhang.welcome2016.utils.HttpCallbackListener;
import com.gavynzhang.welcome2016.utils.HttpUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 2016/8/5.
 */
public class FragmentShengHuo extends Fragment {
    private List<String> title;
    private List<String> address;
    private List<String> pic;
    private AlertDialog myDialog = null;
    public static final int UPDATE = 1;
    private TextView textView;
    public static final int NO = 2;
    private ImageView image;
    private RecyclerView recyclerView;
    private Handler handler =  new  Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case UPDATE :
                    recyclerView= (RecyclerView) getView().findViewById(R.id.list_recycler_view);
                    GongLueAdapter adapter_gangtai = new GongLueAdapter(1,getContext(),pic,title,address,null,FragmentShengHuo.this);
                    adapter_gangtai.setOnItemClickListener(new GongLueAdapter.OnItemClickListener() {
                        @Override
                        public void OnItemClick(View view, String pic, String title, String introduction) {
                            myDialog = new AlertDialog.Builder(getContext()).create();
                            myDialog.show();
                            myDialog.getWindow().setContentView(R.layout.mydialog);
                            image = (ImageView) myDialog.findViewById(R.id.ic_dialog);
                            Glide.with(getContext()).load(pic).into(image);
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
    public static FragmentShengHuo newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt("ARG_PAGE", page);
        FragmentShengHuo fragmentShengHuo = new FragmentShengHuo();
        fragmentShengHuo.setArguments(args);
        return fragmentShengHuo;
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
        String address = "http://hongyan.cqupt.edu.cn/cyxbsMobile/index.php/Home/WelcomeFreshman/daylyLife";
        HttpUtil.sendHttpRequest(address, new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                Log.i("redrock3", response);
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
        List<String> address = new ArrayList<String>();
        List<String> pic = new ArrayList<String>();
        List<String> title = new ArrayList<>();
        Gson gson = new Gson();
        ShengHuo qinShi = gson.fromJson(jsonData, ShengHuo.class);
        List<ShengHuo.DataBean> qinshilist = qinShi.getData();
        for (ShengHuo.DataBean c : qinshilist){
            title.add(c.getName());
            address.add(c.getAddress());
            pic.add(c.getPhoto().get(0).getPhoto_src());
        }
        this.address = address;
        this.title = title;
        this.pic = pic;
        Message message = new Message();
        message.what = UPDATE;
        handler.sendMessage(message);

    }
}
