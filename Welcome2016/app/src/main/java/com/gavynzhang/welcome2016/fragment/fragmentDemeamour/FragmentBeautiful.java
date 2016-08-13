package com.gavynzhang.welcome2016.fragment.fragmentDemeamour;

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
import com.gavynzhang.welcome2016.adapter.BeautifulAdapter;
import com.gavynzhang.welcome2016.model.Beautiful;
import com.gavynzhang.welcome2016.utils.HttpCallbackListener;
import com.gavynzhang.welcome2016.utils.HttpUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 2016/8/8.
 */
public class FragmentBeautiful extends Fragment {
    private View view;
    private TextView textView;
    private List<String> text;
    private List<String> pic;
    private RecyclerView recyclerView;
    private ImageView image;
    private AlertDialog myDialog = null;
    public static final int UPDATE = 1;
    public static final int NO = 2;
    public static final String ARG_PAGE = "ARG_PAGE";
    private Handler handler =  new  Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case UPDATE :
                    recyclerView= (RecyclerView) getView().findViewById(R.id.list_recycler_view);
                    BeautifulAdapter adapter = new BeautifulAdapter(getContext(),pic,text,FragmentBeautiful.this);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    break;
                case 2:
                    textView.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
    public static FragmentBeautiful newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt("ARG_PAGE", page);
        FragmentBeautiful fragmentBeautiful = new FragmentBeautiful();
        fragmentBeautiful.setArguments(args);
        return fragmentBeautiful;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list, container, false);
        textView = (TextView) view.findViewById(R.id.no);
        initDates();
        return view;
    }
    private void initDates(){
        String address = "http://hongyan.cqupt.edu.cn/cyxbsMobile/index.php/Home/WelcomeFreshman/cquptView";
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
        List<String> text = new ArrayList<String>();
        Gson gson = new Gson();
        Beautiful bangdanes = gson.fromJson(jsonData, Beautiful.class);
        List<Beautiful.DataBean> songlist = bangdanes.getData();
        for (Beautiful.DataBean c : songlist){
            pic.add(c.getPhoto().get(0).getPhoto_src());
            Log.i("AAAAAAAA", c.getPhoto().get(0).getPhoto_src());
        }
        text.add(0,"我在期待，期待一棵会开花的树，期待一个会存放青春的匣子，期待着一个能和我对话的地方……\n" +
                "我抬头仰望，那专属的红绿蓝，牵引着我追寻梦想的思绪。整个校园，就像是一艘正在缓慢行驶的帆船，而这巍峨的第八教学楼仿佛在诉说：“我亲爱的孩子，这里就是你梦想的帆！”\n");
        text.add(1,"一下子，我跳进了装满情怀的老操场的怀抱，感受着青春留给我的恩泽。不知道在这片红色的跑道上，留下了我多少曾奋力奔跑的脚印。我继续奔跑着，风在我的耳边轻吟：“不停地奔跑，不要放弃！”");

        text.add(2,"恰同学少年的我，常常奔赴于书生意气浓厚的数字图书馆。它就像一本厚厚的百科全书，而里面珍藏的书籍，是它每一章节最强精彩的部分。当我翻开她的卷首，她告诉我：“静观，静思，静记。”");
        text.add(3,null);
        text.add(4,null);
        text.add(5,"我不知道走过了多少次这样的路，二教，三教，四教……上课，下课，嬉笑，和这几座静谧而安定的教学楼串成了一个个精彩纷呈的，无语伦比的小故事。那一大片的草坪，都在浅唱：“修德、博学、求实、创新。”");
        text.add(6,"我来到信科楼下，驻足，仰望，我想要飞，飞进信科顶端的云层里，憧憬，翱翔，细数我曾在这里做实验敲代码的日日夜夜……云朵在我的身体里飘过，呼唤着：“亲爱的孩子，一步一个脚印，梦想在你的翅膀上！”");
        text.add(7,"在爬完这个远近闻名的重邮天梯，虽然感觉到一阵疲惫但我的心里，却充满了时时刻刻的幸福。我的一个个向上攀爬的身躯都在激励我：“会当凌绝顶，一览众山小。”");
        text.add(8,"夕阳下，你吟出了绝美的一幕。日光与云层交相辉映的太极操场，填满着我整颗感动的心。缓缓坐在足球场上，体味着夕阳融入身体的温暖。身在哪里，心就在哪里，仿佛自己也是这幅画卷里一部分。渐渐的，我听见了整个太极都在呢喃：“青春是一束束淡淡的日光，耀眼并且温暖人心。”");
        text.add(9,"这时，夜幕来临我站在你的面前，凝望着你散发出的神秘色彩，轻抚着你的身躯，感受着你心脏的跳动，全身血液的沸腾，听见了你说，“晚安，我亲爱的孩子！”\n" +
                "结束了这一段浅浅的重游旅程，我爱上了我所看见的，我所听见的，我所触摸到的……\n" +
                "我亲爱的校园，你将伴我度过四个春秋，今日和你的浅浅对话，让我心神向往你的美丽……\n");
        Log.i("AAAAAAAAAA", "ssssssssss");
        this.text = text;
        this.pic= pic;
        Message message = new Message();
        message.what = UPDATE;
        handler.sendMessage(message);

    }
}
