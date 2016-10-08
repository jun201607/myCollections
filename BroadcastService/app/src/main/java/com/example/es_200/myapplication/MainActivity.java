package com.example.es_200.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Abroadcast ab;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text= (TextView) findViewById(R.id.ww);

        ab= new Abroadcast();
        IntentFilter intentfiler=new IntentFilter();
        intentfiler.addAction("sendToActivity");
        registerReceiver(ab,intentfiler);

//        Intent intent=new Intent(MainActivity.this, MyService.class);
//        startService(intent);
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

    public class Abroadcast extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
          String s=intent.getStringExtra("m");
            Log.d("=========",s+"  被service发送的广播启动");
            text.setText(s);
            Toast.makeText(MainActivity.this, ""+s, Toast.LENGTH_SHORT).show();
        }
    }
    private void Stringdemo() {
        String s1="001.";
        String s2="010.";
        String s3="009";
        if (s1.startsWith("0")){
            s1.substring(1);
            Log.d("========",s1.substring(1));
            if (s1.substring(1).startsWith("0")){
                s1.substring(1).substring(1);
                Log.d("========",s1.substring(1).substring(1));
            }
        }
    }
}
