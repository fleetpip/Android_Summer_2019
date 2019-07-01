package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_group);
        View v = findViewById(R.id.groupview_linear);
        int num = getViewCount(v);
        TextView text3 = findViewById(R.id.text3);
        text3.setText("Answer is:"+num);
    }



    public static int getViewCount(View view) {
        //todo 补全你的代码
        int a = 0;
        if(view instanceof ViewGroup){
            ViewGroup vp = (ViewGroup) view;
            for(int i = 0;i<vp.getChildCount();i++){
                a=a+getViewCount(vp.getChildAt(i));
            }
            return a+1;
        }
        else {
            return 1;
        }
    }
}

