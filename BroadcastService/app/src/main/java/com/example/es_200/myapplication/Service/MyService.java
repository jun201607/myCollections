package com.example.es_200.myapplication.Service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

import com.example.es_200.myapplication.MainActivity;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");

    }

    @Override
    public void onCreate() {
        super.onCreate();
        MyReciver myReciver=new MyReciver();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("toservice");
        registerReceiver(myReciver,intentFilter);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }
    public class  MyReciver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String iin=intent.getStringExtra("b");

            Intent intent1=new Intent("sendToActivity");
            Log.d("========","asdfads"+iin);
            intent1.putExtra("m","mmmmmmm萨尔法爱的阿萨德按时m");
            intent1.putExtra("n",iin);
            sendBroadcast(intent1);


            Intent dialogIntent = new Intent(getBaseContext(), MainActivity.class);
            dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplication().startActivity(dialogIntent);
        }
    }
}
