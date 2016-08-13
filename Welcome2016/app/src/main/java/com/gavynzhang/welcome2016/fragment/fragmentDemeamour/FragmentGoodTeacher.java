package com.gavynzhang.welcome2016.fragment.fragmentDemeamour;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gavynzhang.welcome2016.R;
import com.gavynzhang.welcome2016.adapter.TeacherAdapter;
import com.gavynzhang.welcome2016.model.Teacher;
import com.gavynzhang.welcome2016.utils.HttpCallbackListener;
import com.gavynzhang.welcome2016.utils.HttpUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 2016/8/8.
 */
public class FragmentGoodTeacher extends Fragment{
    private List<String> name;
    private List<String> title;
    private List<String> pic;
    private ImageView image;
    private AlertDialog myDialog = null;
    private TextView textView;
    private RecyclerView recyclerView;
    public static final int NO = 2;
    public static final int UPDATE = 1;
    private Handler handler =  new  Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case UPDATE :
                    recyclerView= (RecyclerView) getView().findViewById(R.id.list_recycler_view);
                    TeacherAdapter adapter = new TeacherAdapter(getContext(),pic,name,title,FragmentGoodTeacher.this);
                    adapter.setOnItemClickListener(new TeacherAdapter.OnItemClickListener() {
                        @Override
                        public void OnItemClick(View view, String pic, String name, String title) {
                            myDialog = new AlertDialog.Builder(getContext()).create();
                            myDialog.show();
                            myDialog.getWindow().setContentView(R.layout.mydialog);
                            image = (ImageView) myDialog.findViewById(R.id.ic_dialog);
                            Glide.with(getContext()).load(pic).into(image);
                        }
                    });
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
                    break;
                case NO:
                    textView.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
    public static FragmentGoodTeacher newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt("ARG_PAGE", page);
        FragmentGoodTeacher fragmentGoodTeacher = new FragmentGoodTeacher();
        fragmentGoodTeacher.setArguments(args);
        return fragmentGoodTeacher;
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
        String address = "http://hongyan.cqupt.edu.cn/cyxbsMobile/index.php/Home/WelcomeFreshman/outstandingTeacher";
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
        List name = new ArrayList<String>();
        List pic = new ArrayList<String>();
        List title = new ArrayList<String>();
        Gson gson = new Gson();
        Teacher bangdanes = gson.fromJson(jsonData, Teacher.class);
        List<Teacher.DataBean> songlist = bangdanes.getData();
        for (Teacher.DataBean c : songlist){
            name.add(c.getName());
            pic.add(c.getPhoto().get(0).getPhoto_src());
            title.add(c.getCollege());
        }
        this.name = name;
        this.pic = pic;
        this.title = title;
        Message message = new Message();
        message.what = UPDATE;
        handler.sendMessage(message);
    }
}
