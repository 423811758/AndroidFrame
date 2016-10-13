package com.wzd.androidframe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.wolf.android.app.BaseActivity;
import com.wolf.android.http.OkHttpUtils;
import com.wolf.android.http.callback.StringCallback;

import okhttp3.Call;

public class MainActivity extends BaseActivity {

    private TextView mResultTv;

    @Override
    protected void initComponent() {
        mResultTv = (TextView) findViewById(R.id.http_result_tv);
    }

    @Override
    protected void initData() {
        OkHttpUtils.get().url("http://218.5.79.104/api/open/adverpic/getadverpicList/1/10").build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                Log.i("aaaaaaaaaa", response);
                mResultTv.setText(response);
            }
        });
    }

    @Override
    protected int getMainContentViewId() {
        return R.layout.activity_main;
    }
}
