package com.zyc.linegridviewdemo;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import com.zyc.customview.LineGridView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    LineGridView mLineGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLineGridView = (LineGridView) findViewById(R.id.LineGridView);

        ArrayList<HashMap<String, Object>> sourceList = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> tempHashMap = new HashMap<String, Object>();
        @IdRes int[] image = {
                R.drawable.ic_filter_1_black_24dp,
                R.drawable.ic_filter_2_black_24dp,
                R.drawable.ic_filter_3_black_24dp,
                R.drawable.ic_filter_4_black_24dp,
                R.drawable.ic_filter_5_black_24dp,
                R.drawable.ic_filter_6_black_24dp,
                R.drawable.ic_filter_7_black_24dp,
                R.drawable.ic_filter_8_black_24dp,
                R.drawable.ic_filter_9_black_24dp,
                R.drawable.ic_filter_1_black_24dp,
                R.drawable.ic_filter_2_black_24dp,
                R.drawable.ic_filter_3_black_24dp,
                R.drawable.ic_filter_4_black_24dp,
                R.drawable.ic_filter_5_black_24dp,
                R.drawable.ic_filter_6_black_24dp,
                R.drawable.ic_filter_7_black_24dp,
                R.drawable.ic_filter_8_black_24dp,
                R.drawable.ic_filter_9_black_24dp,
        };
        for (int i = 0; i < 14; i++) {
            tempHashMap.put("ItemImage", image[i]);
            tempHashMap.put("ItemText", "图片" + i);
            sourceList.add(tempHashMap);
            tempHashMap = new HashMap<String, Object>();
        }
        SimpleAdapter adapter = new SimpleAdapter(this, sourceList, R.layout.item_linegridview,
                new String[]{"ItemImage", "ItemText"}, new int[]{R.id.ItemImage, R.id.ItemText});
        mLineGridView.setAdapter(adapter);
    }
}
