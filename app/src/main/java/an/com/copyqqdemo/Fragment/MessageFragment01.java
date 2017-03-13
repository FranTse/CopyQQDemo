package an.com.copyqqdemo.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import an.com.copyqqdemo.Adapter.MessageListViewAdapter;
import an.com.copyqqdemo.R;
import an.com.copyqqdemo.View.XCRoundImageView;

/**
 * Created by 11757 on 2017/3/12.
 */

public class MessageFragment01 extends Fragment {
    private Context mContext;
    private View mBaseView;

    private MessageListViewAdapter mAdapter;

    private List<Map<String,Object>> list;
    private Map<String , Object> map;

    private ListView messageListView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getActivity();
        mBaseView = inflater.inflate(R.layout.fragment_message01 ,null);

        messageListView = (ListView)mBaseView.findViewById(R.id.list_message);

        list = new ArrayList<Map<String, Object>>();
        for(int i = 0 ; i < 9 ; i++)
        {
            map= new HashMap<String ,Object>();
            map.put("text01" , "开心一刻");
            map.put("text02" , "加油");
            list.add(map);
        }
        messageListView.setAdapter(new MessageListViewAdapter(mContext , list));

        return mBaseView;
    }
}
