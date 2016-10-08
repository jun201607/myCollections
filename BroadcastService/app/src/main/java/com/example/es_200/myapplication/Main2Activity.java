package com.example.es_200.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.es_200.myapplication.Service.MyService;

public class Main2Activity extends AppCompatActivity {
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button= (Button) findViewById(R.id.by);


        Intent intent=new Intent(Main2Activity.this, MyService.class);
       startService(intent);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent1);
            }
        });
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent("toservice");
                intent.putExtra("b","bbbbbbbbbb");
                sendBroadcast(intent);
            }
        }, 2000);
    }
}
