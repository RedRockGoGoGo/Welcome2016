package com.gavynzhang.welcome2016.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gavynzhang.welcome2016.R;
import com.gavynzhang.welcome2016.fragment.fragmentDemeamour.DemeanourAdapter;

/**
 *
 * 对应重邮风采板块
 *
 * */

public class DemeanourActivity extends AppCompatActivity {

    private DemeanourAdapter demeanourAdapter;

    private ViewPager viewPager;

    private TabLayout tabLayout;

    private ImageView back;

    private TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        back = (ImageView) findViewById(R.id.back);
        title = (TextView)findViewById(R.id.title);
        title.setText("重邮风采");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        initTablayout();
    }
    private void initTablayout(){
        demeanourAdapter = new DemeanourAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(demeanourAdapter);
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE); //模式设置
        tabLayout.setupWithViewPager(viewPager);    //绑定

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);

        }
    }
}
