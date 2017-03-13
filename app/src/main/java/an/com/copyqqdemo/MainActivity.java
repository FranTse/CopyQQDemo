package an.com.copyqqdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import an.com.copyqqdemo.Adapter.MessageListViewAdapter;
import an.com.copyqqdemo.Fragment.ContactsFragment;
import an.com.copyqqdemo.Fragment.MessageFragment;
import an.com.copyqqdemo.Fragment.NewsFragment;


public class MainActivity extends FragmentActivity implements View.OnClickListener , AdapterView.OnItemClickListener{

    DrawerLayout mDrawerLayout;

    //主界面
    //主界面展示的3个要打开的Fragment(消息 ， 联系人 ， 动态)
    private MessageFragment messageFragment;
    private ContactsFragment contactsFragment;
    private NewsFragment newsFragment;

    //布局
    private View messageLayout , contactsLayout , newsLayout;

    //Fragment管理
    private FragmentManager fragmentManager;

    //左边界面
    ListView left_listView;
    //左边界面ListView中的数据
    private String[] left_listView_MenuTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initLeftListView();

        fragmentManager = getSupportFragmentManager();
        setTabSelection(0);//设置信息Fragment为默认打开的fragment
    }

    private void initView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        messageLayout = findViewById(R.id.message_layout);
        contactsLayout = findViewById(R.id.contacts_layout);
        newsLayout = findViewById(R.id.news_layout);

        messageLayout.setOnClickListener(this);
        contactsLayout.setOnClickListener(this);
        newsLayout.setOnClickListener(this);


        //点击头像打开左边的界面
        ImageView headImage = (ImageView)findViewById(R.id.head_image);
        headImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                int drawerLockMode = mDrawerLayout.getDrawerLockMode(GravityCompat.START);
                if (mDrawerLayout.isDrawerVisible(GravityCompat.START)
                        && (drawerLockMode != DrawerLayout.LOCK_MODE_LOCKED_OPEN)) {
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                } else if (drawerLockMode != DrawerLayout.LOCK_MODE_LOCKED_CLOSED) {
                    mDrawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });
    }

    private void initLeftListView() {
        left_listView = (ListView)findViewById(R.id.left_list_view_item);
        left_listView_MenuTitles = getResources().getStringArray(R.array.left_menu_titles);
        left_listView.setAdapter(new ArrayAdapter<String>(MainActivity.this , android.R.layout.simple_list_item_1 , left_listView_MenuTitles));
        left_listView.setOnItemClickListener(this);
    }

    private void setTabSelection(int index) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //先隐藏所有的Fragemnt,防止多个Fragment显示
        hideFragment(fragmentTransaction);

        switch (index)
        {
            case 0:
                if(messageFragment == null)
                {
                    messageFragment = new MessageFragment();
                    fragmentTransaction.add(R.id.content , messageFragment);
                }
                else
                {
                    fragmentTransaction.show(messageFragment);
                }
                break;
            case 1:
                if(contactsFragment == null)
                {
                    contactsFragment = new ContactsFragment();
                    fragmentTransaction.add(R.id.content , contactsFragment);
                }
                else
                {
                    fragmentTransaction.show(contactsFragment);
                }
                break;
            case 2:
                if(newsFragment == null)
                {
                    newsFragment = new NewsFragment();
                    fragmentTransaction.add(R.id.content , newsFragment);
                }
                else
                {
                    fragmentTransaction.show(newsFragment);
                }
                break;
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.message_layout:
                setTabSelection(0);
                break;
            case R.id.contacts_layout:
                setTabSelection(1);
                break;
            case R.id.news_layout:
                setTabSelection(2);
                break;
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //判断左边的listView中点击哪个，传送对应文字打开SecondActivity
        switch (position)
        {
            case 0:
                setMenuSelection(0);
                break;
            case 1:
                setMenuSelection(1);
                break;
            case 2:
                setMenuSelection(2);
                break;
            case 3:
                setMenuSelection(3);
                break;
            case 4:
                setMenuSelection(4);
                break;
            case 5:
                setMenuSelection(5);
                break;
        }
    }

    private void setMenuSelection(int i) {
        Intent intent = new Intent(MainActivity.this , SecondActivity.class);
        intent.putExtra("key" ,left_listView_MenuTitles[i]);
        startActivity(intent);
    }

    private void hideFragment(FragmentTransaction fragmentTransaction) {
        if (messageFragment != null)
        {
            fragmentTransaction.hide(messageFragment);
        }
        if (contactsFragment != null)
        {
            fragmentTransaction.hide(contactsFragment);
        }
        if (newsFragment != null)
        {
            fragmentTransaction.hide(newsFragment);
        }
    }

}
