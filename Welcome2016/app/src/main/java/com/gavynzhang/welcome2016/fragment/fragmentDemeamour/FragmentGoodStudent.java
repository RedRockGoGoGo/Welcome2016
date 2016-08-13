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
import com.gavynzhang.welcome2016.adapter.FengCaiAdapter;
import com.gavynzhang.welcome2016.model.Student;
import com.gavynzhang.welcome2016.utils.GlideRoundTransform;
import com.gavynzhang.welcome2016.utils.HttpCallbackListener;
import com.gavynzhang.welcome2016.utils.HttpUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 2016/8/8.
 */
public class FragmentGoodStudent extends Fragment {
    private List<String> name;
    private List<String> title;
    private List<String> introduction;
    private List<String> pic;
    private RecyclerView recyclerView;
    private TextView textView;
    public static final int NO = 2;
    public static final int UPDATE = 1;
    private AlertDialog myDialog = null;
    private ImageView image;
    private TextView text;
    private TextView toName;
    //public static final String ARG_PAGE = "ARG_PAGE";
    //public static RecyclerView gongLueRecyclerView ;
    private Handler handler =  new  Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case UPDATE :
                    recyclerView= (RecyclerView) getView().findViewById(R.id.list_recycler_view);
                    FengCaiAdapter adapter = new FengCaiAdapter(getContext(),pic,name,title,introduction,FragmentGoodStudent.this);
                    adapter.setOnItemClickListener(new FengCaiAdapter.OnItemClickListener() {
                        @Override
                        public void OnItemClick(View view, String pic, String name, String title, String introduction) {
                            myDialog = new AlertDialog.Builder(getContext()).create();
                            myDialog.show();
                            myDialog.getWindow().setContentView(R.layout.textdialog_item);
                            image = (ImageView) myDialog.findViewById(R.id.ic_dialog);
                            text = (TextView) myDialog.findViewById(R.id.text_dialog);
                            toName = (TextView) myDialog.findViewById(R.id.name);
                            toName.setText(name);
                            text.setText(introduction);
                            Glide.with(getContext()).load(pic).transform(new GlideRoundTransform(getContext(),8)).into(image);
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
    public static FragmentGoodStudent newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt("ARG_PAGE", page);
        FragmentGoodStudent fragmentGoodStudent = new FragmentGoodStudent();
        fragmentGoodStudent.setArguments(args);
        return fragmentGoodStudent;
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
        String address = "http://hongyan.cqupt.edu.cn/cyxbsMobile/index.php/Home/WelcomeFreshman/outstandingStudent";
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
        List introduction = new ArrayList<String>();
        List title = new ArrayList<String>();
        Gson gson = new Gson();
        Student bangdanes = gson.fromJson(jsonData, Student.class);
        List<Student.DataBean> songlist = bangdanes.getData();
        for (Student.DataBean c : songlist){
            name.add(c.getName());
            pic.add(c.getPhoto().get(0).getPhoto_src());
            introduction.add(c.getIntroduction());
            title.add(c.getDescription());
        }
        this.name = name;
        this.pic = pic;
        this.title = title;
        this.introduction = introduction;
        Message message = new Message();
        message.what = UPDATE;
        handler.sendMessage(message);
    }
}
