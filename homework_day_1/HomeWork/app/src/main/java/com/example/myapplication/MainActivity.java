package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String Tag = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mBt = findViewById(R.id.button2);
        final TextView mTv = findViewById(R.id.textView);
        final TextView mTV4 = findViewById(R.id.textView4);
        CheckBox mCb = findViewById(R.id.checkBox);
        mCb.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.d(Tag,"find a star");
                mTV4.setText("thank you for starring!");
            }
        });

        mBt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.d(Tag,"guest log in");
            }
        });
    }
}
