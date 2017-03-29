package com.designdream.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.designdream.R;
import com.designdream.fragment.FragmentDiscovery;
import com.designdream.fragment.FragmentHome;
import com.designdream.fragment.FragmentInfo;
import com.designdream.fragment.FragmentPerson;
import com.designdream.fragment.FragmentPublish;

/**
 * Created by leianjun on 2017/3/26.
 */

public class MainFragmentActivity extends FragmentActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_fragment);
        fragmentManager = getSupportFragmentManager();

        radioGroup = (RadioGroup)findViewById(R.id.radioGroup1);
        ((RadioButton)radioGroup.findViewById(R.id.radio0)).setChecked(true);

        transaction = fragmentManager.beginTransaction();
        Fragment fragment = new FragmentHome();
        transaction.replace(R.id.content, fragment);
        transaction.commit();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio0:
                        transaction = fragmentManager.beginTransaction();
                        Fragment fragmentHome = new FragmentHome();
                        transaction.replace(R.id.content, fragmentHome);
                        transaction.commit();
                        break;
                    case R.id.radio1:
                        transaction = fragmentManager.beginTransaction();
                        Fragment fragmentInfo = new FragmentInfo();
                        transaction.replace(R.id.content, fragmentInfo);
                        transaction.commit();
                        break;
                    case R.id.radio2:
                        transaction = fragmentManager.beginTransaction();
                        Fragment fragmentPublish = new FragmentPublish();
                        transaction.replace(R.id.content, fragmentPublish);
                        transaction.commit();
                        break;
                    case R.id.radio3:
                        transaction = fragmentManager.beginTransaction();
                        Fragment fragmentDiscovery = new FragmentDiscovery();
                        transaction.replace(R.id.content, fragmentDiscovery);
                        transaction.commit();
                        break;
                    case R.id.radio4:
                        transaction = fragmentManager.beginTransaction();
                        Fragment fragmentPerson = new FragmentPerson();
                        transaction.replace(R.id.content, fragmentPerson);
                        transaction.commit();
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
