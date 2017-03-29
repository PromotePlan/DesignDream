package com.designdream.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.designdream.R;
import com.designdream.constants.HttpConstants;
import com.designdream.util.Verification;
import com.designdream.view.TitleView;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

/**
 * Created by leianjun on 2017/3/28.
 */

public class RegisterActivity extends BaseActivity
        implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private TitleView titleView;
    private TextView tvAgreement;
    private EditText userPhoneEt;
    private EditText passwordEt;
    private EditText passwordConEt;
    private CheckBox ck;
    private Button btnRegister;
    private boolean isSelect = false;
    private ImageView ivClearPhone;
    private ImageView ivClearPassword;
    private ImageView ivClearPasswordCon;
    private String phoneStr, passwordStr, passwordConStr;

    @Override
    protected void onCreate(Bundle arg0) {
        // TODO Auto-generated method stub
        super.onCreate(arg0);
        setContentView(R.layout.register);
        initViews();
    }

    @Override
    protected void onStart() {
        super.onStart();

        titleView = (TitleView) findViewById(R.id.titleBarView);
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

        tvAgreement = (TextView) findViewById(R.id.tvAboutAgreement);
        tvAgreement.setOnClickListener(this);

        userPhoneEt = (EditText) findViewById(R.id.user_phone_edit);
        userPhoneEt.addTextChangedListener(new TextWatcher(){
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                phoneStr = userPhoneEt.getText().toString().trim();
                if (!"".equals(phoneStr)) {
                    ivClearPhone.setVisibility(View.VISIBLE);
                } else {
                    ivClearPhone.setVisibility(View.INVISIBLE);
                }
            }
        });
        passwordEt = (EditText) findViewById(R.id.password_edit);
        passwordEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                passwordStr = passwordEt.getText().toString().trim();
                if (!"".equals(passwordStr)){
                    ivClearPassword.setVisibility(View.VISIBLE);
                } else {
                    ivClearPassword.setVisibility(View.INVISIBLE);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        passwordConEt = (EditText) findViewById(R.id.confirm_password_edit);
        passwordConEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                passwordConStr = passwordConEt.getText().toString().trim();
                if (!"".equals(passwordConStr)){
                    ivClearPasswordCon.setVisibility(View.VISIBLE);
                } else {
                    ivClearPasswordCon.setVisibility(View.INVISIBLE);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        ivClearPhone = (ImageView) findViewById(R.id.iv_clear_phone);
        ivClearPhone.setOnClickListener(this);

        ivClearPassword = (ImageView) findViewById(R.id.iv_clear_password);
        ivClearPassword.setOnClickListener(this);

        ivClearPasswordCon = (ImageView) findViewById(R.id.iv_clear_password_con);
        ivClearPasswordCon.setOnClickListener(this);

        ck = (CheckBox) findViewById(R.id.ck);
        ck.setOnCheckedChangeListener(this);

        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.tvAboutAgreement:
                SkipActivityforClass(RegisterActivity.this, AgreementActivity.class);
                break;
            case R.id.iv_clear_phone:
                userPhoneEt.setText("");
                ivClearPhone.setVisibility(View.INVISIBLE);
                break;
            case R.id.iv_clear_password:
                passwordEt.setText("");
                ivClearPassword.setVisibility(View.INVISIBLE);
                break;
            case R.id.iv_clear_password_con:
                passwordConEt.setText("");
                ivClearPasswordCon.setVisibility(View.INVISIBLE);
                break;
            case R.id.btnRegister:
                checkUserInput();
                break;
        }
    }
    private void checkUserInput(){

        phoneStr = userPhoneEt.getText().toString().trim();
        passwordStr = passwordEt.getText().toString().trim();
        passwordConStr = passwordConEt.getText().toString().trim();

        if (!"".equals(phoneStr)) {
            if (Verification.isPhoneNumberValid(phoneStr) == true) {
                if (!"".equals(passwordStr)) {
                    if (passwordStr.length() >= 6 && passwordStr.length() <= 16) {
                        if (!"".equals(passwordConStr)) {
                            if (passwordStr.equals(passwordConStr)) {
                                if (isSelect) {
                                    if (Verification.checkNetwork(RegisterActivity.this) == true) {
                                        executeHttp();
                                    } else {
                                        showToast("请检查一下网络连接！");
                                    }
                                } else {
                                    showToast("请查看一下用户注册协议！");
                                }
                            } else {
                                showToast("两次输入的密码不一致");
                            }
                        } else {
                            showToast("请再次输入密码");
                        }
                    } else {
                        showToast("密码要在6-16位之间（只能是数字和字母的组合");
                    }
                } else {
                    showToast("密码不能为空");
                }
            } else {
                showToast("您输入的手机号格式不对");
            }
        } else {
            showToast("手机号不能为空");
        }
    }

    private void showToast(String str){
        Toast.makeText(RegisterActivity.this, str, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
        // TODO Auto-generated method stub
        if(isChecked){
            isSelect=true;
        }else{
            isSelect=false;
        }
    }

    private void executeHttp() {

        AjaxParams params = new AjaxParams();
        params.put("phone", phoneStr);
        params.put("password", passwordStr);

        FinalHttp fh = new FinalHttp();
        initProgressDialog("注册中...");
        fh.post(HttpConstants.HTTP_REGISTER, params, new AjaxCallBack<Object>() {

            @Override
            public void onFailure(Throwable t, int errorNo, String msgStr) {
                super.onFailure(t, errorNo, msgStr);
                Toast.makeText(RegisterActivity.this, "服务器连接失败...", Toast.LENGTH_LONG).show();
                close();
            }
            @Override
            public void onSuccess(Object t) {
                // TODO Auto-generated method stub
                super.onSuccess(t);
                showToast("注册返回过来的数据:"+String.valueOf(t));
                close();
            }
        });
    }
}
