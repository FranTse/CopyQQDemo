package an.com.copyqqdemo.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import an.com.copyqqdemo.Adapter.MessageListViewAdapter;
import an.com.copyqqdemo.MainActivity;
import an.com.copyqqdemo.R;
import an.com.copyqqdemo.ViewPager.MessageViewPager;


/**
 * Created by 11757 on 2017/3/9.
 */

public class MessageFragment extends Fragment implements View.OnClickListener{
    private MessageViewPager mViewPager;
    private ArrayList<Fragment> fragmentArrayList;

    private Button bn_message , bn_phone;

    private int currIndex = 0;//目前运行

    MessageFragment01 fragment01;
    MessageFragment02 fragment02;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_message ,null);

        bn_message = (Button)view.findViewById(R.id.bn_head_message);
        bn_phone = (Button)view.findViewById(R.id.bn_head_phone);
        bn_message.setOnClickListener(this);
        bn_phone.setOnClickListener(this);

        fragmentArrayList = new ArrayList<Fragment>();
        fragment01 = new MessageFragment01();
        fragment02 = new MessageFragment02();
        fragmentArrayList.add(fragment01);
        fragmentArrayList.add(fragment02);


        mViewPager = (MessageViewPager) view.findViewById(R.id.viewpager);
        mViewPager.setCanScroll(false);
        mViewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentArrayList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentArrayList.size();
            }
        });

        mViewPager.setCurrentItem(0);//设置默认
        bn_message.setEnabled(false);
        bn_phone.setEnabled(true);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bn_head_message:
                currIndex = 0;
                bn_message.setEnabled(false); //改变颜色和能否点击
                bn_phone.setEnabled(true);
                mViewPager.setCurrentItem(0);
                break;
            case R.id.bn_head_phone:
                currIndex = 1;
                bn_message.setEnabled(true);
                bn_phone.setEnabled(false);
                mViewPager.setCurrentItem(1);
                break;
        }
    }

}
