package com.designdream.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.designdream.R;
import com.designdream.baseInterface.BaseInterfaces;

/**
 * Created by leianjun on 2017/3/28.
 */

public class BaseActivity extends FragmentActivity implements BaseInterfaces {

    private Dialog loadbar = null;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    public void SkipActivityforClass(Context ctx, Class<?>cla){
        Intent intent=new Intent();
        intent.setClass(ctx, cla);
        startActivity(intent);
    }

    @Override
    public void initViews() {
        // TODO Auto-generated method stub
    }
    @Override
    public void initData() {
        // TODO Auto-generated method stub
    }

    public void initProgressDialog(String str) {

        if (loadbar == null) {
            loadbar = new Dialog(this, R.style.load_dialog);
            LayoutInflater mInflater = this.getLayoutInflater();
            View v = mInflater.inflate(R.layout.anim_load, null);

            // 加载数据
            TextView textView = (TextView) v.findViewById(R.id.loadText);
            textView.setText(str);

            loadbar.setContentView(v);
            loadbar.setCancelable(false);
            loadbar.show();
        } else {
            loadbar.show();
        }
    }

    public void close() {
        if (loadbar != null) {
            if (loadbar.isShowing()) {
                loadbar.dismiss();
            }
        }
    }
}
