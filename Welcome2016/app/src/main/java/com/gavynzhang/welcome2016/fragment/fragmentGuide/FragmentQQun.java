package com.gavynzhang.welcome2016.fragment.fragmentGuide;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gavynzhang.welcome2016.R;

/**
 * Created by a on 2016/8/5.
 */
public class FragmentQQun extends Fragment {
    private TextView textXinsheng;
    private TextView textLaoxiang;
    public static FragmentQQun newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt("ARG_PAGE", page);
        FragmentQQun fragmentQQun = new FragmentQQun();
        fragmentQQun.setArguments(args);
        return fragmentQQun;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_qqun, container, false);
        textXinsheng = (TextView) view.findViewById(R.id.qqun_text_xinsheng);
        textLaoxiang = (TextView) view.findViewById(R.id.qqun_text_laoxiang);
        textXinsheng.setText("通信与信息工程学院：561165428\n" +
                "554320581（交流群）\n" +
                "计算机与科学技术学院：295557817（学生会）\n" +
                "338572942\n" +
                "自动化学院：152354704\n" +
                "光电学院国际半导体学院：481054099\n" +
                "软件工程学院：237085236\n" +
                "先进制造学院：459929235\n" +
                "外国语学院：528147534\n" +
                "体育学院：514172370\n" +
                "传媒艺术学院：218509477\n" +
                "生物信息学院：201563258\n" +
                "法学院：569104494\n" +
                "经济管理学院：107961087（信管：324274314工程管理：547781573工商：497763971\n" +
                "电子商务：578509964）\n" +
                "（国际学院）中美合作群：548496592\n" +
                "理学院：301047601\n" +
                "重邮16级广电与树莓类，群号码：495242730\n" +
                "国际学院，中美群，345070285，辅导员创建\n");
        textLaoxiang.setText("贵州：126851693\n" +
                "河北：548535234\n" +
                "安徽：562487104\n" +
                "辽宁：134489031\n" +
                "河南：310222276重邮河南老乡群：251311309\n" +
                "河南安阳：116198098\n" +
                "山东：384043802\n" +
                "江苏：123736116\n" +
                "黑龙江：316348915\n" +
                "潮汕：4958681\n" +
                "贵州：126851693\n" +
                "江西：3889855\n" +
                "江西上饶：476426072\n" +
                "浙江：247010642\n" +
                "广西贵港：5819894\n" +
                "广西南宁：：16026851 \n" +
                "广西：9651531\n" +
                "广西柳州：7045893\n" +
                "广东：113179139\n" +
                "广东韶关：66484867\n" +
                "广东惠州：213337022\n" +
                "山西：119738941\n" +
                "海南：9334029\n" +
                "福建：173210510\n" +
                "吉林：118060379\n" +
                "云南宣威：211910023\n" +
                "云南玉溪：256581906\n" +
                "云南曲靖：117499346\n" +
                "云南： 548640416重邮云南老乡会（包括云南各地）官方群：42052111\n" +
                "天津：8690505\n" +
                "湖北恩施：179765240\n" +
                "湖北：33861584\n" +
                "湖北黄冈老乡群：181704337\n" +
                "湖南：204491110\n" +
                "重庆梁平：85423833\n" +
                "重庆忠县：115637967\n" +
                "重庆铜梁：198472776 重庆大足：462534986 重庆开县：5657168 重庆荣昌：149452192\n" +
                "重庆永川：467050041 重庆丰都：343292119 重庆涪陵：199748999 重庆云阳：118971621\n" +
                "重庆璧山：112571803 重庆石柱：289615375 重庆彭水：283978475 重庆南川：423494314\n" +
                "重庆长寿：69124125  重庆垫江307233230重庆合川：226325326重庆綦江：109665788\n" +
                "重庆奉节：50078959 重庆铜梁：198472776重庆黔江：102897346重庆万州：469527984\n" +
                "重庆巫溪：143884210 重庆巫山：129440237 四川简阳：570320904\n" +
                "四川大群：148985246 142604890 四川成都：298299346 四川自贡：444020511\n" +
                "四川绵阳：191653502 \n" +
                "陕西：193388613 黑龙江：316348915  重邮新疆： 248052400\n" +
                "青海：282597612北京：143833720\n" +
                "甘肃美术老乡：578076400甘肃：155724412\n");
        return view;
    }

}
