package com.gavynzhang.welcome2016.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gavynzhang.welcome2016.R;
import com.gavynzhang.welcome2016.fragment.fragmentBigData.BigDataAdapter;
import com.gavynzhang.welcome2016.fragment.fragmentBigData.FragmentBigData;

import org.w3c.dom.Text;

/**
 *
 * 对应大数据板块
 *
 * */

public class BigDataActivity extends AppCompatActivity {

    private FragmentBigData fragmentBigData;

    private BigDataAdapter bigdataAdapter;
    private ViewPager bigDataViewPager;
    private TabLayout bigDataTab;

    private ImageView back;

    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_data);
        back = (ImageView)findViewById(R.id.back);
        title = (TextView)findViewById(R.id.title);

        title.setText("大数据");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        initTablayout();
    }


    private void initTablayout(){
        bigdataAdapter = new BigDataAdapter(getSupportFragmentManager());
        bigDataViewPager = (ViewPager)findViewById(R.id.bigdata_viewpage);
        bigDataViewPager.setAdapter(bigdataAdapter);

        bigDataTab = (TabLayout)findViewById(R.id.bigdata_tab);
        bigDataTab.setTabMode(TabLayout.MODE_FIXED);
        bigDataTab.setupWithViewPager(bigDataViewPager);
    }
}

