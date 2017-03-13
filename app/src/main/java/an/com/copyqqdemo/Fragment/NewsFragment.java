package an.com.copyqqdemo.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import an.com.copyqqdemo.MainActivity;
import an.com.copyqqdemo.R;


/**
 * Created by 11757 on 2017/3/9.
 */

public class NewsFragment extends Fragment {
    View newsLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        newsLayout = inflater.inflate(R.layout.fragment_news , container , false);
        return newsLayout;
    }

}
