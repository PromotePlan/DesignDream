package com.designdream.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.designdream.R;
import com.designdream.baseInterface.ResultCallback;
import com.designdream.bean.BaseBean;
import com.designdream.bean.LoginResultBean;
import com.designdream.constants.HttpConstants;
import com.designdream.db.SharedPreferenceDb;
import com.designdream.util.HttpUtil;
import com.designdream.util.Verification;
import com.designdream.view.TitleView;

import net.tsz.afinal.FinalDb;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leianjun on 2017/3/29.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private RelativeLayout tvRegister;
    private Button btnLogin;
    private EditText etPhone, etPassword;
    private CheckBox ck;
    private TextView forgetPwd;
    private boolean isSelect = false;
    private ImageView ivClearPhone;
    private ImageView ivClearPassword;
    private String phoneStr, passwordStr;
    FinalDb finalDb = null;

    @Override
    protected void onCreate(Bundle arg0) {
        // TODO Auto-generated method stub
        super.onCreate(arg0);
        setContentView(R.layout.login);

        initViews();
        // 使用finalDb操作数据库
        finalDb = FinalDb.create(this);
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        TitleView titleView=(TitleView) findViewById(R.id.titleBarView);
        titleView.showLeft("", getResources().getDrawable(R.drawable.app_back), new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }

    @Override
    public void initViews() {
        super.initViews();

        tvRegister = (RelativeLayout) findViewById(R.id.newUserRegister);
        tvRegister.setOnClickListener(this);

        etPhone = (EditText) findViewById(R.id.user_phone_edit);
        etPassword = (EditText) findViewById(R.id.password_edit);

        ck = (CheckBox) findViewById(R.id.ck);

        ivClearPhone = (ImageView) findViewById(R.id.iv_clear_phone);
        ivClearPhone.setOnClickListener(this);

        ivClearPassword = (ImageView) findViewById(R.id.iv_clear_password);
        ivClearPassword.setOnClickListener(this);

        forgetPwd = (TextView) findViewById(R.id.forgetPwd);
        forgetPwd.setOnClickListener(this);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

        if ("YES".equals(new SharedPreferenceDb(LoginActivity.this).getIsRemember())
                && !"".equals(new SharedPreferenceDb(LoginActivity.this).getUserId())
                && !"".equals(new SharedPreferenceDb(LoginActivity.this).getPassword())) {

            ck.setChecked(true);
            etPhone.setText(new SharedPreferenceDb(LoginActivity.this).getUserId());
            etPassword.setText(new SharedPreferenceDb(LoginActivity.this).getPassword());

            ivClearPhone.setVisibility(View.VISIBLE);
            ivClearPassword.setVisibility(View.VISIBLE);
        }
        etPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                phoneStr = etPhone.getText().toString().trim();
                if (!"".equals(phoneStr)) {
                    ivClearPhone.setVisibility(View.VISIBLE);
                } else {
                    ivClearPhone.setVisibility(View.INVISIBLE);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                passwordStr = etPassword.getText().toString().trim();
                if (!"".equals(passwordStr)) {
                    ivClearPassword.setVisibility(View.VISIBLE);
                } else {
                    ivClearPassword.setVisibility(View.INVISIBLE);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        ck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    isSelect = true;
                    new SharedPreferenceDb(LoginActivity.this).setIsRemember("YES");
                } else {
                    isSelect = false;
                    new SharedPreferenceDb(LoginActivity.this).setIsRemember("NO");
                    new SharedPreferenceDb(LoginActivity.this).setUserId("");
                    new SharedPreferenceDb(LoginActivity.this).setPassword("");
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.newUserRegister:
                SkipActivityforClass(LoginActivity.this, RegisterActivity.class);
                break;
            case R.id.iv_clear_phone:
                etPhone.setText("");
                ivClearPhone.setVisibility(View.INVISIBLE);
                break;
            case R.id.iv_clear_password:
                etPassword.setText("");
                ivClearPassword.setVisibility(View.INVISIBLE);
                break;
            case R.id.forgetPwd:
                showToast("忘记密码");
                break;
            case R.id.btnLogin:
                login();
                break;
        }
    }
    private void showToast(String str){
        Toast.makeText(LoginActivity.this, str, Toast.LENGTH_LONG).show();
    }

    private void login() {

        phoneStr = etPhone.getText().toString().trim();
        passwordStr = etPassword.getText().toString().trim();

        if (!"".equals(phoneStr)) {
            if (!"".equals(passwordStr)) {
                if (Verification.checkNetwork(LoginActivity.this) == true) {


                    /**
                     * 假数据模拟
                     */
                    LoginResultBean loginResultBean = new LoginResultBean();
                    loginResultBean.setNicNam("张云");
                    loginResultBean.setPhone("15018272816");

                    // 保存数据到数据库中
                    finalDb.save(loginResultBean);

                    if (isSelect) {
                        new SharedPreferenceDb(LoginActivity.this).setUserId(phoneStr);
                        new SharedPreferenceDb(LoginActivity.this).setPassword(passwordStr);
                    }
//                    List<NameValuePair> allP = new ArrayList<NameValuePair>();
//                    allP.add(new BasicNameValuePair("phoneDreId", phoneStr));
//                    allP.add(new BasicNameValuePair("password", passwordStr));
//
//                    initProgressDialog("正在登陆...");
//
//                    HttpUtil.doPost(HttpConstants.HTTP_LOGIN, allP, new ResultCallback() {
//                        @Override
//                        public void getReslt(String result) {
//                            // 如果返回的结果不为空，并且不是1
//                            if (!"".equals(result) && !"1".equals(result)) {
//                                // 解析返回的数据
//                                BaseBean b = JSON.parseObject(result, BaseBean.class);
//
//                                if ("0".equals(b.getRespcode())) {
//
//                                    LoginResultBean loginResultBean = JSON.parseObject(b.getData(),
//                                            LoginResultBean.class);
//                                    // 保存数据到数据库中
//                                    finalDb.save(loginResultBean);
//
//                                    finish();
//                                    close();
//                                } else {
//                                    showToast("用户名或密码错误");
//                                    close();
//                                }
//                            } else {
//                                showToast("服务器响应失败");
//                                close();
//                            }
//                        }
//                    });
                } else {
                    showToast("请查看一下网络连接");
                }
            } else {
                showToast("密码不能为空");
            }
        } else {
            showToast("账号不能为空");
        }
    }
}
