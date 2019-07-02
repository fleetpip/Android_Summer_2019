package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class PlaceholderFragment extends Fragment {
    private LottieAnimationView animationView;
    private ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_placeholder, container, false);
        animationView = view.findViewById(R.id.animation_view);
        listView = view.findViewById(R.id.list_view);
        listView.setAdapter(new ListViewAdapter(this.getActivity()));

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行


                listView.setVisibility(View.VISIBLE);
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(listView,
                        "alpha", 0f,1.0f);
                animator1.setRepeatCount(1);
                animator1.setInterpolator(new LinearInterpolator());
                animator1.setDuration(1);

                ObjectAnimator animator2 = ObjectAnimator.ofFloat(animationView,
                        "alpha", 1.0f,0f);
                animator2.setRepeatCount(1);
                animator2.setInterpolator(new LinearInterpolator());
                animator2.setDuration(1);

                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(animator1,animator2);
                animatorSet.start();


            }
        }, 5000);


    }


    public static class ListViewAdapter extends BaseAdapter {
        private Context mContext;

        public ListViewAdapter(Context context) {
            mContext = context;
        }

        @Override
        public int getCount() {
            return 7;
        }

        @Override public Object getItem(int position) {
            return null;
        }

        @Override public long getItemId(int position) {
            return 0;
        }

        @Override public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView;
            if (convertView == null) {
                textView = new TextView(mContext);
            } else {
                //!=null
                textView = (TextView) convertView;
            }
            int numA = position+1;
            textView.setText("Item "+numA);
            textView.setTextSize(18);
            return textView;
        }
    }
}
