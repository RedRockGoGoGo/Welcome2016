package com.gavynzhang.welcome2016.fragment.fragmentBigData;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gavynzhang.welcome2016.Data.BigData;
import com.gavynzhang.welcome2016.R;
import com.gavynzhang.welcome2016.model.Pie;
import com.gavynzhang.welcome2016.view.PieView;


/**
 * Created by GavynZhang on 2016/8/10.
 */
public class FragmentBigData extends Fragment implements View.OnClickListener{

    //相关数据
    private int collegeTag = -1;
    private int majorTag = -1;

    //Tag
    public static final String BIGDATA_PAGE = "BIGDATA_PAGE";

    //ListViewAdapter
    ArrayAdapter<String> collegeAdapter = null;
    ArrayAdapter<String> majorAdapter = null;

    //当前Fragment所在tab
    private int pageCount;

    //ListView描边布局
    private RelativeLayout collegeListStroke;
    private RelativeLayout majorListStroke;

    //底下标识
    private RelativeLayout ratioString;
    private RelativeLayout difficultString;

    //底下需要变颜色的第三个图
    private ImageView thirdImg;

    //饼图
    private PieView pieView;
    //专业选择框（设置可见性）
    private RelativeLayout majorCkeckBox;
    //学院选择框背景（设置点击事件）
    private ImageView collegeCheckBoxBacImg;
    //专业选择框背景（设置点击事件）
    private ImageView majorCheckBoxBacImg;
    //学院下拉ListView
    private ListView collegeList;
    //专业下拉ListView
    private ListView majorList;
    //选择框文字
    private TextView collegeText;
    private TextView majorText;

    //外层布局
    private RelativeLayout outLayout;

    //最难科目标识文字
    private TextView maxDiffCourse;
    private TextView midDiffCourse;
    private TextView minDiffCourse;



    public static FragmentBigData newInstance(int page){
        Bundle args = new Bundle();
        args.putInt(BIGDATA_PAGE, page);
        FragmentBigData fragmentBigData = new FragmentBigData();
        fragmentBigData.setArguments(args);
        return fragmentBigData;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bigdata, container, false);

        Log.w("Fragment","pageCount:  "+pageCount);

        collegeAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,BigData.collegesName );

        //ListView描边布局
        collegeListStroke = (RelativeLayout)view.findViewById(R.id.college_list_stroke);
        majorListStroke = (RelativeLayout)view.findViewById(R.id.major_list_stroke);

        //底下比例标识
        ratioString = (RelativeLayout)view.findViewById(R.id.radio_string);
        //底下科目标识
        difficultString = (RelativeLayout)view.findViewById(R.id.difficult_strings);

        thirdImg = (ImageView) view.findViewById(R.id.pink_recf_diff3);

        pieView = (PieView)view.findViewById(R.id.pie);
        //major下拉选框外层RelativeLayout
        majorCkeckBox = (RelativeLayout)view.findViewById(R.id.major_checkbox);

        collegeText = (TextView)view.findViewById(R.id.college_text);
        majorText = (TextView)view.findViewById(R.id.major_text);

        //最难科目标识文字
        maxDiffCourse = (TextView)view.findViewById(R.id.diff1_string);
        midDiffCourse = (TextView)view.findViewById(R.id.diff2_string);
        minDiffCourse = (TextView)view.findViewById(R.id.diff3_string);

        //寻找到两个ListView
        collegeList = (ListView)view.findViewById(R.id.college_list);
        majorList = (ListView)view.findViewById(R.id.major_list);

        //两个可点击的下拉框
        collegeCheckBoxBacImg = (ImageView)view.findViewById(R.id.college_checkbox_bacimg);
        majorCheckBoxBacImg = (ImageView)view.findViewById(R.id.major_checkbox_bacimg);

        //外层布局
        outLayout = (RelativeLayout)view.findViewById(R.id.out_layout);

        SharedPreferences pref = getActivity().getSharedPreferences("tag",Context.MODE_PRIVATE);
        SharedPreferences.Editor tagEditor = getActivity().getSharedPreferences("tag", Context.MODE_PRIVATE).edit();

        int collegeTag1 = pref.getInt("collegeTag1", -1);
        int collegeTag2 = pref.getInt("collegeTag2", -1);
        int collegeTag3 = pref.getInt("collegeTag3", -1);
        majorTag = pref.getInt("majorTag", -1);
        Log.w("Fragment", "Load the saved data of collegeTag and majorTag, collegeTag1: "+collegeTag1+" collegeTag2: "+collegeTag2+" collegeTag3: "+collegeTag3+" majorTag: "+majorTag);
        Log.w("Fragment", "collegeTag:  "+collegeTag);

        //设置监听事件
        collegeCheckBoxBacImg.setOnClickListener(this);
        majorCheckBoxBacImg.setOnClickListener(this);

        //选择了学院未选择专业，重置学院
        if (collegeTag != -1 && majorTag == -1 ) {
            collegeTag = -1;
            tagEditor.putInt("collegeTag1",-1);
            tagEditor.commit();
        }

        //tab跳到最难科目和毕业去向时，专业选择框不可见
        if(pageCount == 1){

            //加载已保存的数据
            if(collegeTag1 != -1 && majorTag != -1){

                Log.w("Fragment", "onCreateView majorTag:   "+majorTag+"  onCreateView collegeTag1:   "+collegeTag1);
                collegeTag = collegeTag1;

                majorAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, BigData.majorsName[collegeTag]);

                collegeText.setText(BigData.collegesName[collegeTag1]);
                majorText.setText(BigData.majorsName[collegeTag1][majorTag]);
                setRatioPieView(collegeTag1, majorTag);
                //半导体学院没有数据，不显示
                if (BigData.collegesName[collegeTag1].equals("半导体")){
                    pieView.setVisibility(View.INVISIBLE);
                }else
                    pieView.setVisibility(View.VISIBLE);


            }

        }
        if(pageCount == 2){

            majorCkeckBox.setVisibility(View.INVISIBLE);
            ratioString.setVisibility(View.GONE);

            if(collegeTag2 != -1){
                collegeText.setText(BigData.collegesName[collegeTag2]);
                setDifficultPieView(collegeTag2);

            }

            difficultString.setVisibility(View.VISIBLE);
        }
        if(pageCount ==3){

            majorCkeckBox.setVisibility(View.INVISIBLE);
            ratioString.setVisibility(View.GONE);
            difficultString.setVisibility(View.VISIBLE);

            if(collegeTag3 != -1){

                collegeText.setText(BigData.collegesName[collegeTag3]);

                if(collegeTag3 == 13 ){
                    maxDiffCourse.setText("暂无数据");
                    midDiffCourse.setText("暂无数据");
                    minDiffCourse.setText("暂无数据");
                    pieView.setVisibility(View.INVISIBLE);
                }else {
                    maxDiffCourse.setText("签就业协议");
                    midDiffCourse.setText("升学出国");
                    minDiffCourse.setText("其他");
                    setGraduateSituationsPieView(collegeTag3);
                }


            }

        }

        //collegeList的点击事件
        collegeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.w("Fragment", " on collegeList clicked, Set the collegeTag:  "+i+" set majorTag = -1");
                collegeTag = i;


                //存储选择的学院tag
                SharedPreferences.Editor tagEditor = getActivity().getSharedPreferences("tag", Context.MODE_PRIVATE).edit();

                //设置选框文字
                collegeText.setText(BigData.collegesName[i]);

                //fragment为第一页时才有选择专业框
                if(pageCount == 1) {
                    tagEditor.putInt("collegeTag1", collegeTag);
                    Log.w("Fragment", "save collegeTag1 on Ratio Page, Num is: "+collegeTag);

                    majorTag = -1;
                    tagEditor.putInt("majorTag", majorTag);
                    Log.w("Fragment", "save the majorTag = -1");

                    majorCkeckBox.setVisibility(View.VISIBLE);
                    ratioString.setVisibility(View.VISIBLE);
                    majorText.setText("请选择专业");
                    majorAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, BigData.majorsName[collegeTag]);
                }

                //当Fragment为最难科目时视图处理逻辑
                if (pageCount == 2){
                    tagEditor.putInt("collegeTag2", collegeTag);
                    Log.w("Fragment", "save collegeTag2 on Difficult Page, Num is: "+collegeTag);
                    pieView.setVisibility(View.VISIBLE);
                    difficultString.setVisibility(View.VISIBLE);
                    setDifficultPieView(collegeTag);

                }

                //当Fragment为毕业去向时视图处理逻辑
                if (pageCount == 3){

                    tagEditor.putInt("collegeTag3", collegeTag);
                    Log.w("Fragment", "save collegeTag3 on Graduation Page, Num is: "+collegeTag);

                    difficultString.setVisibility(View.VISIBLE);
                    if(collegeTag == 13 ){
                        maxDiffCourse.setText("暂无数据");
                        midDiffCourse.setText("暂无数据");
                        minDiffCourse.setText("暂无数据");
                        pieView.setVisibility(View.INVISIBLE);
                    }else {
                        maxDiffCourse.setText("签就业协议");
                        midDiffCourse.setText("升学出国");
                        minDiffCourse.setText("其他");
                        pieView.setVisibility(View.VISIBLE);
                    }
                    setGraduateSituationsPieView(collegeTag);

                }
                tagEditor.commit();


                collegeListStroke.setVisibility(View.INVISIBLE);
            }
        });

        //majorList的点击事件(弹出来的专业列表，需要让本身不显示，让其他组件显示出来，并且设置饼图)
        majorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.w("Fragment", "on majorList Clicked, set the majorTag: "+i);
                majorTag = i;
                SharedPreferences.Editor tagEditor = getActivity().getSharedPreferences("tag", Context.MODE_PRIVATE).edit();
                tagEditor.putInt("majorTag", majorTag);
                tagEditor.commit();
                if(collegeTag != -1) {
                    majorText.setText(BigData.majorsName[collegeTag][i]);
                    majorListStroke.setVisibility(View.INVISIBLE);
                    //set the collegeCheckBoxBacImg can be click
                    collegeCheckBoxBacImg.setEnabled(true);

                    if(pageCount == 1){

                        setRatioPieView(collegeTag, majorTag);
                        if (BigData.collegesName[collegeTag].equals("半导体")){
                            pieView.setVisibility(View.INVISIBLE);
                        }else
                            pieView.setVisibility(View.VISIBLE);
                    }

                }

            }
        });


        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取现在是第几页
        pageCount = getArguments().getInt(BIGDATA_PAGE);
    }

    //设置点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.college_checkbox_bacimg:

                Log.w("Fragment", "学院选择框被按下");

                collegeList.setAdapter(collegeAdapter);

                if(collegeListStroke.getVisibility() == View.INVISIBLE) {

                    if (pageCount == 1) {
                        ratioString.setVisibility(View.INVISIBLE);
                        majorCkeckBox.setVisibility(View.INVISIBLE);
                    } else {
                        difficultString.setVisibility(View.INVISIBLE);
                    }

                    pieView.setVisibility(View.INVISIBLE);
                    collegeListStroke.setVisibility(View.VISIBLE);

                } else {
                    if (pageCount == 1) {
                        ratioString.setVisibility(View.VISIBLE);
                        majorCkeckBox.setVisibility(View.VISIBLE);

                        if (majorTag != -1 && collegeTag != -1){
                            pieView.setVisibility(View.VISIBLE);
                        }else
                            pieView.setVisibility(View.INVISIBLE);

                    } else {
                        difficultString.setVisibility(View.VISIBLE);
                        pieView.setVisibility(View.VISIBLE);
                    }
                    collegeListStroke.setVisibility(View.INVISIBLE);
                    majorCheckBoxBacImg.setEnabled(true);
                }

                break;
            case R.id.major_checkbox_bacimg:

                Log.w("Fragment", "专业选择框被按下, collegeTag: "+ collegeTag+" majorTag: "+majorTag);


                if (majorListStroke.getVisibility() == View.INVISIBLE){

                    Log.w("Test","collegeTag:"+collegeTag);
                    if(collegeTag != -1) {
                        majorList.setAdapter(majorAdapter);
                        pieView.setVisibility(View.INVISIBLE);
                        majorListStroke.setVisibility(View.VISIBLE);
                        //set collegeCheckBoxBacImg can not be click
                        collegeCheckBoxBacImg.setEnabled(false);

                    }
                }else {

                    Log.w("Fragment","majorTag:  "+majorTag);
                    if (majorTag != -1 && collegeTag != -1) {
                        pieView.setVisibility(View.VISIBLE);
                        majorListStroke.setVisibility(View.INVISIBLE);
                        //set collegeCheckBoxBacImg can be click
                        collegeCheckBoxBacImg.setEnabled(true);

                    }else {
                        pieView.setVisibility(View.INVISIBLE);
                        majorListStroke.setVisibility(View.INVISIBLE);
                        collegeCheckBoxBacImg.setEnabled(true);
                    }

                }

                break;

        }

    }

    private void setRatioPieView(int collegeTag, int majorTag){

        Pie ratioPies[] = new Pie[2];

        Pie manPie = new Pie();
        Pie womenPie = new Pie();

        manPie.setColor(getResources().getColor(R.color.blue_back));
        manPie.setDeepColor(getResources().getColor(R.color.blue_stroke));
        manPie.setTextColor(getResources().getColor(R.color.blue_text));
        manPie.setNumber(BigData.majorsSexualRatio[collegeTag][majorTag]);
        if (String.valueOf(BigData.majorsSexualRatio[collegeTag][majorTag]).length() > 3) {
            manPie.setText(String.valueOf(BigData.majorsSexualRatio[collegeTag][majorTag]).substring(0, 4) + "%");
        }else {
            manPie.setText(String.valueOf(BigData.majorsSexualRatio[collegeTag][majorTag])+"%");
        }
        manPie.setDepartNum(4);

        womenPie.setColor(getResources().getColor(R.color.purple_back));
        womenPie.setDeepColor(getResources().getColor(R.color.purple_stroke));
        womenPie.setTextColor(getResources().getColor(R.color.purple_text));
        womenPie.setNumber(100 - BigData.majorsSexualRatio[collegeTag][majorTag]);
        if (String.valueOf(100 - BigData.majorsSexualRatio[collegeTag][majorTag]).length() > 3) {
            womenPie.setText(String.valueOf(100 - BigData.majorsSexualRatio[collegeTag][majorTag]).substring(0, 4) + "%");
        }else {
            womenPie.setText(String.valueOf(100 - BigData.majorsSexualRatio[collegeTag][majorTag])+"%");
        }
        womenPie.setDepartNum(4);

        ratioPies[0] = manPie;
        ratioPies[1] = womenPie;

        pieView.setPies(ratioPies);

    }

    private void setDifficultPieView(int collegeTag){

        Pie difficulePies[] = new Pie[3];

        Pie maxDiffPie = new Pie();
        Pie midDiffPie = new Pie();
        Pie minDiffPie = new Pie();

        maxDiffPie.setColor(getResources().getColor(R.color.purple_back));
        maxDiffPie.setDeepColor(getResources().getColor(R.color.purple_stroke));
        maxDiffPie.setTextColor(getResources().getColor(R.color.purple_text));
        maxDiffPie.setNumber(BigData.difficultRatio[collegeTag][0]);
        if (String.valueOf(BigData.difficultRatio[collegeTag][0]).length() > 3) {
            maxDiffPie.setText(String.valueOf(BigData.difficultRatio[collegeTag][0]).substring(0, 4) + "%");
        }else {
            maxDiffPie.setText(String.valueOf(BigData.difficultRatio[collegeTag][0])+"%");
        }
        maxDiffPie.setDepartNum(4);

        maxDiffCourse.setText(BigData.difficultCourse[collegeTag][0]);

        midDiffPie.setColor(getResources().getColor(R.color.blue_back));
        midDiffPie.setDeepColor(getResources().getColor(R.color.blue_stroke));
        midDiffPie.setTextColor(getResources().getColor(R.color.blue_text));
        midDiffPie.setNumber(BigData.difficultRatio[collegeTag][1]);
        if (String.valueOf(BigData.difficultRatio[collegeTag][1]).length() > 3) {
            midDiffPie.setText(String.valueOf(BigData.difficultRatio[collegeTag][1]).substring(0, 4) + "%");
        }else {
            midDiffPie.setText(String.valueOf(BigData.difficultRatio[collegeTag][1])+"%");
        }
        midDiffPie.setDepartNum(4);

        midDiffCourse.setText(BigData.difficultCourse[collegeTag][1]);

        minDiffPie.setColor(getResources().getColor(R.color.pink_back));
        minDiffPie.setDeepColor(getResources().getColor(R.color.pink_stroke));
        minDiffPie.setTextColor(getResources().getColor(R.color.pink_text));
        minDiffPie.setNumber(BigData.difficultRatio[collegeTag][2]);
        if (String.valueOf(BigData.difficultRatio[collegeTag][2]).length() > 3) {
            minDiffPie.setText(String.valueOf(BigData.difficultRatio[collegeTag][2]).substring(0, 4) + "%");
        }else {
            minDiffPie.setText(String.valueOf(BigData.difficultRatio[collegeTag][2])+"%");
        }
        minDiffPie.setDepartNum(4);

        minDiffCourse.setText(BigData.difficultCourse[collegeTag][2]);

        difficulePies[0] = maxDiffPie;
        difficulePies[1] = midDiffPie;
        difficulePies[2] = minDiffPie;
        pieView.setPies(difficulePies);

    }

    private void setGraduateSituationsPieView(int collegeTag){
        Pie graduateSituationsPies[] = new Pie[3];

        Pie jobPie = new Pie();

        jobPie.setColor(getResources().getColor(R.color.purple_back));
        jobPie.setDeepColor(getResources().getColor(R.color.purple_stroke));
        jobPie.setTextColor(getResources().getColor(R.color.purple_text));
        jobPie.setNumber(BigData.situationRatio[collegeTag][0]);

        if (String.valueOf(BigData.situationRatio[collegeTag][0]).length() > 3) {
            jobPie.setText(String.valueOf(BigData.situationRatio[collegeTag][0]).substring(0, 4) + "%");
        }else {
            jobPie.setText(String.valueOf(BigData.situationRatio[collegeTag][0])+"%");
        }
        jobPie.setDepartNum(4);

        Pie higherGradePie = new Pie();

        higherGradePie.setColor(getResources().getColor(R.color.blue_back));
        higherGradePie.setDeepColor(getResources().getColor(R.color.blue_stroke));
        higherGradePie.setTextColor(getResources().getColor(R.color.blue_text));
        higherGradePie.setNumber(BigData.situationRatio[collegeTag][1]);
        if (String.valueOf(BigData.situationRatio[collegeTag][1]).length() > 3) {
            higherGradePie.setText(String.valueOf(BigData.situationRatio[collegeTag][1]).substring(0, 4) + "%");
        }else {
            higherGradePie.setText(String.valueOf(BigData.situationRatio[collegeTag][1])+"%");
        }
        higherGradePie.setDepartNum(4);

        Pie otherPie = new Pie();

        otherPie.setColor(getResources().getColor(R.color.pink_back));
        otherPie.setDeepColor(getResources().getColor(R.color.pink_stroke));
        otherPie.setTextColor(getResources().getColor(R.color.pink_text));

        if(BigData.situationRatio[collegeTag][2]+BigData.situationRatio[collegeTag][3] >= 4.00){
            otherPie.setNumber(BigData.situationRatio[collegeTag][2]+BigData.situationRatio[collegeTag][3]);
            //文字长度限制
            if (String.valueOf(BigData.situationRatio[collegeTag][2]+BigData.situationRatio[collegeTag][3]).length() > 3) {
                otherPie.setText(String.valueOf(BigData.situationRatio[collegeTag][2] + BigData.situationRatio[collegeTag][3]).substring(0, 4) + "%");
            }else {
                otherPie.setText(String.valueOf(BigData.situationRatio[collegeTag][2] + BigData.situationRatio[collegeTag][3]) + "%");
            }
            otherPie.setDepartNum(4);
        }else if(BigData.situationRatio[collegeTag][2]+BigData.situationRatio[collegeTag][3] > 0.00){
            otherPie.setNumber(4.00);
            //文字长度限制
            if (String.valueOf(BigData.situationRatio[collegeTag][2]+BigData.situationRatio[collegeTag][3]).length() > 3) {
                otherPie.setText(String.valueOf(BigData.situationRatio[collegeTag][2] + BigData.situationRatio[collegeTag][3]).substring(0, 4) + "%");
            }else {
                otherPie.setText(String.valueOf(BigData.situationRatio[collegeTag][2] + BigData.situationRatio[collegeTag][3]) + "%");
            }
            otherPie.setDepartNum(4);
        }else if(BigData.situationRatio[collegeTag][2]+BigData.situationRatio[collegeTag][3] == 0.00){
            otherPie = null;
        }


        graduateSituationsPies[0] = jobPie;
        graduateSituationsPies[1] = higherGradePie;
        graduateSituationsPies[2] = otherPie;

        pieView.setPies(graduateSituationsPies);
    }

}
