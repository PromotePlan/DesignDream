package com.designdream.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.designdream.R;
import com.designdream.activity.LoginActivity;
import com.designdream.activity.RegisterActivity;

/**
 * Created by leianjun on 2017/3/24.
 */

public class FragmentPerson extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_person, null);

//        final TableRow num1Row1 = (TableRow)view.findViewById(R.id.num1Row1);
//        final TableRow num2Row1 = (TableRow)view.findViewById(R.id.num2Row1);
//        final TableRow num3Row1 = (TableRow)view.findViewById(R.id.num3Row1);
//        final TableRow num3Row2 = (TableRow)view.findViewById(R.id.num3Row2);
//        final TableRow num3Row3 = (TableRow)view.findViewById(R.id.num3Row3);
//
//        num1Row1.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                Toast.makeText(getActivity(),"反封建",Toast.LENGTH_LONG).show();
//            }
//        });

        return view;
    }
}
