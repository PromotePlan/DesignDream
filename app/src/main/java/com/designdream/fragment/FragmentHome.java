package com.designdream.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.designdream.R;
import com.designdream.adapter.FragmentAdapter;
import com.designdream.constants.FragmentConstants;
import com.designdream.view.TitleView;

import java.util.ArrayList;

/**
 * Created by leianjun on 2017/3/24.
 */


public class FragmentHome extends Fragment {

	private ArrayList<Fragment> list = null;
	private ViewPager mViewPager;
	private ImageView iv_bottom_line;
	private TitleView titleView;
	private TextView all_c, look_c, focus_c, fans_c;
	private int pageIndex = 0;
	private int first = 0;
	private int second = 0;
	private int third = 0;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_home, null);

		initView(view);
		initWidth();
		initViewPager();

		return view;
	}

	private void initViewPager() {

		Fragment all_c = MyFragment.newInstance(FragmentConstants.ALL_CONSTANT);
		Fragment look_c = MyFragment.newInstance(FragmentConstants.LOOK_CONSTANT);
		Fragment focus_c = MyFragment.newInstance(FragmentConstants.FOCUS_CONSTANT);
		Fragment fans_c = MyFragment.newInstance(FragmentConstants.FANS_CONSTANT);

		list = new ArrayList<Fragment>();

		list.add(all_c);
		list.add(look_c);
		list.add(focus_c);
		list.add(fans_c);

		mViewPager.setAdapter(new FragmentAdapter(getChildFragmentManager(), list));
		mViewPager.setCurrentItem(pageIndex);
		mViewPager.setOnPageChangeListener(new MyViewPagerChangedListener());
	}

	private void initView(View view) {

		titleView = (TitleView) view.findViewById(R.id.titleBarView);
		titleView.showReft("首 页", getResources().getDrawable(R.drawable.menu_choose_icon), new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), "好多事大", Toast.LENGTH_LONG).show();
			}
		});

		mViewPager = (ViewPager) view.findViewById(R.id.myviewpager);
		iv_bottom_line = (ImageView) view.findViewById(R.id.iv_bottom_line);
		all_c = (TextView) view.findViewById(R.id.all_c);
		look_c = (TextView) view.findViewById(R.id.look_c);
		focus_c = (TextView) view.findViewById(R.id.focus_c);
		fans_c = (TextView) view.findViewById(R.id.fans_c);

		changeStyle(all_c);

		all_c.setOnClickListener(new MyClickListener(0));
		look_c.setOnClickListener(new MyClickListener(1));
		focus_c.setOnClickListener(new MyClickListener(2));
		fans_c.setOnClickListener(new MyClickListener(3));
	}

	private void initWidth() {
		int lineWidth = iv_bottom_line.getLayoutParams().width;
		Log.d("lineWidth ", lineWidth + "");
		DisplayMetrics displayMetrics = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		int width = displayMetrics.widthPixels;

		first = width /4;
		second = first * 2;
		third = first * 3;
	}

	private int currPosition = 0;

	class MyViewPagerChangedListener implements ViewPager.OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
		}

		@Override
		public void onPageSelected(int arg0) {
			Log.d("onchanged", "onchanged " + arg0);
			TranslateAnimation ta = null;
			switch (arg0) {
				case 0:
					if (currPosition == 1) {
						changeStyle(all_c);
						ta = new TranslateAnimation(first, 0, 0, 0);
					}
					if (currPosition == 2) {
						changeStyle(all_c);
						ta = new TranslateAnimation(second, 0, 0, 0);
					}
					if (currPosition == 3) {
						changeStyle(all_c);
						ta = new TranslateAnimation(third, 0, 0, 0);
					}
					changeRecover(look_c);
					changeRecover(focus_c);
					changeRecover(fans_c);
					break;

				case 1:
					if (currPosition == 0) {
						changeStyle(look_c);
						ta = new TranslateAnimation(0, first, 0, 0);
					}
					if (currPosition == 2) {
						changeStyle(look_c);
						ta = new TranslateAnimation(second, first, 0, 0);
					}
					if (currPosition == 3) {
						changeStyle(look_c);
						ta = new TranslateAnimation(third, first, 0, 0);
					}
					changeRecover(all_c);
					changeRecover(focus_c);
					changeRecover(fans_c);
					break;

				case 2:
					if (currPosition == 0) {
						changeStyle(focus_c);
						ta = new TranslateAnimation(0, second, 0, 0);
					}
					if (currPosition == 1) {
						changeStyle(focus_c);
						ta = new TranslateAnimation(first, second, 0, 0);
					}
					if (currPosition == 3) {
						changeStyle(focus_c);
						ta = new TranslateAnimation(third, second, 0, 0);
					}
					changeRecover(all_c);
					changeRecover(look_c);
					changeRecover(fans_c);
					break;

				case 3:
					if (currPosition == 0) {
						changeStyle(fans_c);
						ta = new TranslateAnimation(0, third, 0, 0);
					}
					if (currPosition == 1) {
						changeStyle(fans_c);
						ta = new TranslateAnimation(first, third, 0, 0);
					}
					if (currPosition == 2) {
						changeStyle(fans_c);
						ta = new TranslateAnimation(second, third, 0, 0);
					}
					changeRecover(all_c);
					changeRecover(look_c);
					changeRecover(focus_c);
					break;
			}

			currPosition = arg0;

			pageIndex = arg0;

			ta.setDuration(300);
			ta.setFillAfter(true);
			iv_bottom_line.startAnimation(ta);
		}

	}

	class MyClickListener implements View.OnClickListener {

		private int index =0;

		public MyClickListener (int i){
			index = i;
		}

		@Override
		public void onClick(View v) {
			mViewPager.setCurrentItem(index);

		}
	}

	/**
	 *  字体颜色变化
	 */
	private void changeRecover(TextView textView) {
		textView.setTextColor(getResources().getColor(R.color.black));
	}
	private void changeStyle(TextView textView) {
		textView.setTextColor(getResources().getColor(R.color.jacinth));
	}
}