package com.gavynzhang.welcome2016.fragment.fragmentGuide;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gavynzhang.welcome2016.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 2016/8/5.
 */
public class FragmentLuXian extends Fragment {
    List<TextView> textViews;
    public static FragmentLuXian newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt("ARG_PAGE", page);
        FragmentLuXian fragmentLuXian = new FragmentLuXian();
        fragmentLuXian.setArguments(args);
        return fragmentLuXian;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_luxian, container, false);
        textViews = new ArrayList<>();
        textViews.add((TextView) view.findViewById(R.id.text_1));
        textViews.add((TextView) view.findViewById(R.id.text_2));
        textViews.add((TextView) view.findViewById(R.id.text_3));
        textViews.add((TextView) view.findViewById(R.id.text_4));
        textViews.add((TextView) view.findViewById(R.id.text_5));
        textViews.add((TextView) view.findViewById(R.id.text_6));
        textViews.add((TextView) view.findViewById(R.id.text_7));
        textViews.add((TextView) view.findViewById(R.id.text_8));
        textViews.add((TextView) view.findViewById(R.id.text_9));
        textViews.add((TextView) view.findViewById(R.id.text_10));
        int i;
        for(i=0;i<=9;i++){
            initData(textViews.get(i));
        }
        return view;
    }
    private void initData(TextView textView) {
        int g;
        SpannableStringBuilder builder = new SpannableStringBuilder(textView.getText().toString());
        //ForegroundColorSpan 为文字前景色，BackgroundColorSpan为文字背景色
        //ForegroundColorSpan blueSpan = new ForegroundColorSpan(Color.BLUE);
        String s = textView.getText().toString();
        for (g = 0; g < s.length(); g++) {
            if (s.charAt(g)>=48&&s.charAt(g)<=57) {
                builder.setSpan(new ForegroundColorSpan(Color.parseColor("#68aff4")),g,g+1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
              //  builder.setSpan(new ForegroundColorSpan(Color.BLUE),2,3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }

        textView.setText(builder);
    }
}
