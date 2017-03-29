package com.designdream.adapter;

/**
 * Created by leianjun on 2017/3/24.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class FragmentAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> list;

    public FragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public FragmentAdapter(FragmentManager fragmentManager, ArrayList<Fragment> list) {
        super(fragmentManager);
        this.list=list;
    }

    @Override
    public Fragment getItem(int arg0) {
        // TODO Auto-generated method stub
        return list.get(arg0);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

}
