package an.com.copyqqdemo.ViewPager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by 11757 on 2017/3/13.
 */

//重写viewPager  ，设置不可滑动（t 滑动  f  不划动）

public class MessageViewPager extends ViewPager {

    private boolean isCanScroll = true;

    public MessageViewPager(Context context) {
        super(context);
    }

    public MessageViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (isCanScroll == true)
        {
            return super.onTouchEvent(ev);
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (isCanScroll == true) {
            return super.onInterceptTouchEvent(ev);
        }
        else
        {
            return false;
        }
    }

    //设置是否允许滑动，true是可以滑动，false是禁止滑动
    public void setCanScroll(boolean isCanScroll)
    {
        this.isCanScroll = isCanScroll;
    }


}
