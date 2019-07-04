package com.bytedance.clockapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bytedance.clockapplication.widget.Clock;

public class MainActivity extends AppCompatActivity {

    private View mRootView;
    private Clock mClockView;
    private  Thread ClockThread = new Thread(){

        @Override
        public void run() {
            super.run();
            while(true){
                try {
                    sleep(1*1000);
                    mClockView.postInvalidate();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRootView = findViewById(R.id.root);
        mClockView = findViewById(R.id.clock);
        //ClockHandlerThread mClockThread = new ClockHandlerThread("clock");
        //mClockThread.run();

        mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClockView.setShowAnalog(!mClockView.isShowAnalog());
            }
        });
        ClockThread.start();

    }


}

//public class ClockHandlerThread extends HandlerThread implements Handler.Callback{
//    public static final int MSG_CLOCK_UPDATE = 100;
//    private Handler mWorkerHandler;
//    public ClockHandlerThread(String name) {
//        super(name);
//    }
//
//    @Override
//    protected void onLooperPrepared() {
//        mWorkerHandler = new Handler(getLooper(),this);
//        mWorkerHandler.sendEmptyMessage(MSG_CLOCK_UPDATE);
//
//    }
//
//    @Override
//    public boolean handleMessage(Message msg) {
//        switch (msg.what){
//            case MSG_CLOCK_UPDATE:
//                //TO DO
//
//                mWorkerHandler.sendEmptyMessageDelayed(MSG_CLOCK_UPDATE,1*1000);
//                break;
//        }
//
//        return true;
//    }
//}

