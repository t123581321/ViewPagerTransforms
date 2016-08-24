package com.simple.viewpagertransforms;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.simple.transformslibrary.Like3DReversalTransform;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private List<View> viewList = new ArrayList<>();
    private int[] colors = {Color.BLUE, Color.GREEN, Color.GRAY, Color.BLACK, Color.RED,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        for (int i = 0; i < 5; i++) {
            View rootView = View.inflate(MainActivity.this, R.layout.item_pager, null);
            rootView.setBackgroundColor(colors[i]);
            TextView textView = (TextView) rootView.findViewById(R.id.pager_tv);
            textView.setText(String.valueOf(i + 1));
            viewList.add(rootView);
        }

        mViewPager.setPageTransformer(false,new Like3DReversalTransform());
        mViewPager.setAdapter(new MyAdapter());
    }

    private class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewList.get(position));
            return viewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewList.get(position));
        }

    }
}