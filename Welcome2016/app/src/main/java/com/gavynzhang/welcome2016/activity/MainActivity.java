package com.gavynzhang.welcome2016.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.gavynzhang.welcome2016.R;

public class MainActivity extends AppCompatActivity {

    private Button enter;
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        back = (ImageView) findViewById(R.id.back);
        enter = (Button)findViewById(R.id.enter);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,HomePageActivity.class);
                startActivity(intent);
            }
        });
    }
}
