package com.gavynzhang.welcome2016.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.gavynzhang.welcome2016.R;

public class HomePageActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView intoGuide;
    private ImageView intoDemeanour;
    private ImageView intoBigData;
    private Intent intent;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        intoGuide = (ImageView) findViewById(R.id.button_guide);
        intoDemeanour = (ImageView) findViewById(R.id.button_demeanour);
        intoBigData = (ImageView)findViewById(R.id.button_bigData);

        intoGuide.setOnClickListener(this);
        intoDemeanour.setOnClickListener(this);
        intoBigData.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.button_guide :
                intent = new Intent(HomePageActivity.this,GuideActivity.class);
                startActivity(intent);
                break;
            case R.id.button_demeanour :
                intent = new Intent(HomePageActivity.this,DemeanourActivity.class);
                startActivity(intent);
                break;
            case R.id.button_bigData:
                intent = new Intent(HomePageActivity.this, BigDataActivity.class);
                startActivity(intent);
        }
    }
}
