package com.designdream.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.designdream.R;

/**
 * Created by leianjun on 2017/3/28.
 */

public class TitleView extends RelativeLayout {

    private View titleView;
    private LayoutInflater layoutInflater;
    // 左边图片
    private ImageView leftImage;
    // 右边图片
    private ImageView rightImage;
    // 中间标题
    private TextView centerTitle;
    private TextView rightStr;
    private RelativeLayout allView;

    public TitleView(Context context,AttributeSet attrs){
        super(context, attrs);
        // TODO Auto-generated constructor stub
        InitTitleBarView(context);
    }

    public TitleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
        InitTitleBarView(context);
    }
    public TitleView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        InitTitleBarView(context);
    }
    public void InitTitleBarView(Context context){
        layoutInflater=LayoutInflater.from(context);
        titleView=layoutInflater.inflate(R.layout.title_view, this);
        leftImage=(ImageView)titleView.findViewById(R.id.titleBarLeftImage);
        rightImage=(ImageView)titleView.findViewById(R.id.titleBarRightImage);
        centerTitle=(TextView)titleView.findViewById(R.id.title);
        allView=(RelativeLayout)titleView.findViewById(R.id.titleBarView);
        rightStr=(TextView)titleView.findViewById(R.id.titleBarRightStr);
    }

    /**
     * 显示左边图片
     * @param title
     * @param leftImages
     * @param onclick
     */
    public void showLeft(String title,Drawable leftImages,OnClickListener onclick){
        centerTitle.setText(title);
        centerTitle.setVisibility(View.VISIBLE);
        leftImage.setImageDrawable(leftImages);
        leftImage.setVisibility(View.VISIBLE);
        leftImage.setOnClickListener(onclick);
    }

    /**
     * 显示右边图片
     * @param title
     * @param rightImages
     * @param onclick
     */
    public void showReft(String title,Drawable rightImages,OnClickListener onclick){
        centerTitle.setText(title);
        centerTitle.setVisibility(View.VISIBLE);
        rightImage.setImageDrawable(rightImages);
        rightImage.setVisibility(View.VISIBLE);
        rightImage.setOnClickListener(onclick);
    }

    /**
     * 左右都显示
     * @param title
     * @param leftImages
     * @param rightImages
     * @param leftClicki
     * @param rightClick
     */
    public void showLeftAndRight(String title,Drawable leftImages,Drawable rightImages,OnClickListener leftClicki,OnClickListener rightClick){
        centerTitle.setText(title);
        centerTitle.setVisibility(View.VISIBLE);
        leftImage.setImageDrawable(leftImages);
        leftImage.setVisibility(View.VISIBLE);
        leftImage.setOnClickListener(leftClicki);
        rightImage.setImageDrawable(rightImages);
        rightImage.setVisibility(View.VISIBLE);
        rightImage.setOnClickListener(rightClick);
    }

    /**
     * 左边图片+右边文字
     * @param title
     * @param rightStrs
     * @param leftImages
     * @param leftClick
     * @param rightClick
     */
    public void showLeftImageAndRightStr(String title, String rightStrs, Drawable leftImages, OnClickListener leftClick, OnClickListener rightClick){
        centerTitle.setVisibility(View.VISIBLE);
        centerTitle.setText(title);
        leftImage.setImageDrawable(leftImages);
        leftImage.setVisibility(View.VISIBLE);
        rightStr.setText(rightStrs);
        rightStr.setVisibility(View.VISIBLE);
        leftImage.setOnClickListener(leftClick);
        rightStr.setOnClickListener(rightClick);
        rightStr.setTextSize(16);
    }

    /**
     * 设置背景颜色
     * @param color
     */
    public void setBgColor(int color){
        allView.setBackgroundColor(color);
    }

    /**
     * 只显示标题
     * @param title
     */
    public void showCenterTitle(String title){
        centerTitle.setText(title);
        centerTitle.setVisibility(View.VISIBLE);
    }
}
