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
import com.gavynzhang.welcome2016.adapter.QinShiAdapter;
import com.gavynzhang.welcome2016.model.QinShi;
import com.gavynzhang.welcome2016.utils.HttpCallbackListener;
import com.gavynzhang.welcome2016.utils.HttpUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 2016/8/5.
 */
public class FragmentQinShi extends Fragment{
    private List<String> pic;
    private List<String> introduction;
    public static final int UPDATE = 1;
    private TextView textView;
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
                    Log.i("AAAAAAA", introduction.get(0));
                    QinShiAdapter adapter_gangtai = new QinShiAdapter(getContext(),pic,introduction,FragmentQinShi.this);
                    adapter_gangtai.setOnItemClickListener(new QinShiAdapter.OnItemClickListener() {
                        @Override
                        public void OnItemClick(View view, String introduction,String pic) {
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
    public static FragmentQinShi newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt("ARG_PAGE", page);
        FragmentQinShi fragmentQinShi = new FragmentQinShi();
        fragmentQinShi.setArguments(args);
        return fragmentQinShi;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        textView = (TextView) view.findViewById(R.id.no);
        initDates();
        return view;
    }

    private void initDates(){
        String address = "http://hongyan.cqupt.edu.cn/cyxbsMobile/index.php/Home/WelcomeFreshman/dormitoryIntroduction";
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
        List<String> introduction = new ArrayList<String>();
        List<String> pic = new ArrayList<String>();
        Gson gson = new Gson();
        QinShi qinShi = gson.fromJson(jsonData, QinShi.class);
        List<QinShi.DataBean> qinshilist = qinShi.getData();
        int i=0;
        for (QinShi.DataBean c : qinshilist){
            i++;
            if(i>=4)
                break;
            introduction.add(c.getIntroduction());
            if (c.getPhoto().get(0).getPhoto_src() != null) {
                pic.add(c.getPhoto().get(0).getPhoto_src());
            }

        }
        this.introduction = introduction;
        this.pic = pic;

        Message message = new Message();
        message.what = UPDATE;
        handler.sendMessage(message);

    }
}
