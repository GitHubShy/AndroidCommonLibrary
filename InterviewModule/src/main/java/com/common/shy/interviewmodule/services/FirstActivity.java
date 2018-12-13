package com.common.shy.interviewmodule.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.common.shy.basemodule.dispatcher.ActivityDispatcher;
import com.common.shy.commonutils.utils.Logger;
import com.common.shy.interviewmodule.R;

@Route(path = ActivityDispatcher.INTER_SERVICE_FIRST_ACTIVITY)
public class FirstActivity extends AppCompatActivity {
    @Override
    protected void onResume() {
        Logger.e("11111111111111","onResume");
        super.onResume();
    }

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message ms1g) {
            Logger.e("11111111111111","ms1g="+ms1g.toString());
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inter_activity_main);
        Logger.e("11111111111111","onCreate");
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FirstActivity.this, Services.class);
                bindService(i, mConnection, Context.BIND_AUTO_CREATE);
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityDispatcher.toServiceSecondActivity();
            }
        });

        new Thread(new Runnable() {
            private Handler mHandler1;
            @Override
            public void run() {
//                Looper.prepare();
//                mHandler1 = new Handler(new Handler.Callback() {
//                    @Override
//                    public boolean handleMessage(Message msg) {
//                        Logger.e("22222222222222","msg="+msg.toString());
//                        return false;
//                    }
//                });
//                Looper.loop();
//                Message m = Message.obtain();
//                m.arg1 =1;
//                m.sendToTarget();

            }
        }).start();

    }

    @Override
    protected void onStop() {
        Logger.e("11111111111111","onStop");
        super.onStop();
    }

    @Override
    protected void onStart() {
        Logger.e("11111111111111","onStart");
        super.onStart();
    }
    @Override
    protected void onPause() {
        Logger.e("11111111111111","onPause");
        super.onPause();
    }

    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.e("11111111111111","onDestroy");
        unbindService(mConnection);
    }
}
