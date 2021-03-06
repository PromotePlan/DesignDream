package com.designdream.adapter;

/**
 * Created by leianjun on 2017/3/24.
 */

import java.util.List;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.designdream.R;

public class ListViewAdapter extends BaseAdapter {

    List<String>list;

    LayoutInflater inflater;

    FragmentActivity activity;

    public ListViewAdapter(FragmentActivity fragmentActivity, List<String> list) {
        // TODO Auto-generated constructor stub
        this.list = list;
        this.activity = fragmentActivity;
        inflater = (LayoutInflater) fragmentActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return list.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    @Override
    public View getView(int arg0, View view, ViewGroup arg2) {
        // TODO Auto-generated method stub
        if (view == null) {
            view = inflater.inflate(R.layout.item, null);
        }
        return view;
    }
    class ViewHolder {
        TextView tv;
        ImageView im;
    }
}
