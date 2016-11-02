package com.wzd.androidframe;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.wolf.android.app.BaseActivity;
import com.wolf.android.data.CommonData;
import com.wolf.android.http.OkHttpUtils;
import com.wolf.android.http.callback.StringCallback;
import com.wolf.android.tools.AppHelper;
import com.wolf.android.tools.GsonUtil;
import com.wolf.android.tools.Log4JUtil;
import com.wolf.android.tools.MD5Util;
import com.wzd.androidframe.Setting.URLSetting;
import com.wzd.androidframe.data.rep.RepLoginResultDTO;
import com.wzd.androidframe.data.rep.RepSysinfoDTO;
import com.wzd.androidframe.data.rep.RepUserSignInAddScoreDTO;

import okhttp3.Call;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private EditText mNameEt;
    private EditText mPasswordEt;
    private Button mLoginBtn;
    private Button mGetSysInfoBtn;
    private Button mSignInBtn;
    private TextView mResultTv;
    private ImageView mPicassoIv;
    private long mId;

    @Override
    protected void initComponent() {
        mNameEt = (EditText) findViewById(R.id.name_et);
        mPasswordEt = (EditText) findViewById(R.id.password_et);
        mLoginBtn = (Button) findViewById(R.id.login_btn);
        mGetSysInfoBtn = (Button) findViewById(R.id.get_sys_info_btn);
        mSignInBtn = (Button) findViewById(R.id.sign_in_btn);
        mResultTv = (TextView) findViewById(R.id.http_result_tv);
        mPicassoIv = (ImageView) findViewById(R.id.picasso_iv);

        mLoginBtn.setOnClickListener(this);
        mGetSysInfoBtn.setOnClickListener(this);
        mSignInBtn.setOnClickListener(this);
    }

    @Override
    protected void initData() {
//        OkHttpUtils.get().url(URLSetting.baseApiUrl + "open/adverpic/getadverpicList/1/10").build().execute(new StringCallback() {
//            @Override
//            public void onError(Call call, Exception e, int id) {
//
//            }
//
//            @Override
//            public void onResponse(String response, int id) {
//                Log.i("test", response);
//                mResultTv.setText(response);
//            }
//        });
    }

    @Override
    protected int getMainContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn:
                login();
                break;
            case R.id.get_sys_info_btn:
                getSysInfo();
                break;
            case R.id.sign_in_btn:
                signIn();
                break;
        }
    }

    private void signIn() {
        OkHttpUtils.get().url(URLSetting.baseApiUrl+"user/"+mId+"/signinaddscore").build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                RepUserSignInAddScoreDTO result = GsonUtil.jsonToBean(response, RepUserSignInAddScoreDTO.class);
                mResultTv.append("\n"+result.getIntegralAmount());
            }
        });
    }

    private void login() {
        String name = mNameEt.getText().toString().trim();
        String password = mPasswordEt.getText().toString().trim();
        password = MD5Util.getMD5Str(password);
        Log4JUtil.debugInfo(password);
        OkHttpUtils.post().url(URLSetting.baseApiUrl + "user/login")
                .addParams("account", name)
                .addParams("password", password)
                .addParams("imei", AppHelper.getIMEI(mContext))
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                RepLoginResultDTO resultDTO = GsonUtil.jsonToBean(response, RepLoginResultDTO.class);
                mId = resultDTO.getUserDTO().getId();
                try {
                    OkHttpUtils.getInstance().setAuthKey(mContext, resultDTO.getToken(), resultDTO.getUserDTO().getId());
                    mResultTv.append(CommonData.LOGIN_TOKEN + "\n");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mResultTv.append(response);
            }
        });
    }

    public void getSysInfo() {
        OkHttpUtils.get().url(URLSetting.baseApiUrl + "open/getSysinfo").build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log4JUtil.debugInfo(e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                RepSysinfoDTO sysInfo = GsonUtil.jsonToBean(response, RepSysinfoDTO.class);
                mResultTv.setText(sysInfo.toString());
            }
        });
    }
}
