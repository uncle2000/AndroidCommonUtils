package com.uncle2000.androidcommonutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.uncle2000.androidcommonutils.uitls.system.PermissionUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*测试文件时需要的动态授权*/
        PermissionUtil.requestPermissions(this, 0, android
                .Manifest.permission.WRITE_EXTERNAL_STORAGE);
//        ((WebView)findViewById(R.id.webview)).loadUrl("file:///android_asset/loa.html");

        /**/
//        SimpleWaveView simpleWaveView = new SimpleWaveView(this);
//        ((ViewGroup) findViewById(R.id.fl)).addView(simpleWaveView);
//        simpleWaveView.setWaveDiffrentColor(0xffff0f04, 0xfffdd803, 0xff00ed04, 0.3F, 0.6F);
//        simpleWaveView.setRefresh(0.8F);


//        List<List<String>> list_date = new ArrayList<List<String>>();
//        List<String> list1 = new ArrayList<String>();
//        List<String> list2 = new ArrayList<String>();
//        list1.add("123");
//        list1.add("123");
//        list1.add("123");
//        list1.add("34");
//        list1.add("123");
//        list1.add("45");
//        list1.add("123");
//        list1.add("99");
//        list2.add("aaa");
//        list2.add("aaa");
//        list2.add("aaa");
//        list2.add("aaa");
//        list2.add("aaa");
//        list2.add("aaa");
//        list2.add("aaa");
//        list2.add("aaa");
//        list2.add("aaa");
//        list_date.add(list2);
//        list_date.add(list1);
//        SimplePillarsView myview = new SimplePillarsView(getApplicationContext(),
//                DensityUtils.dp2px(this, 300), DensityUtils.dp2px(this, 100), 1.0f);
//        myview.setListDate(list_date);
//        myview.setPillars(15, 0xff000000, 0, 0);
//        ((ViewGroup) findViewById(R.id.fl)).addView(myview);
    }
}