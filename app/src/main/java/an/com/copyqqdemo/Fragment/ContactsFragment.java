package an.com.copyqqdemo.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import an.com.copyqqdemo.Adapter.ExpandaleListViewAdapter;
import an.com.copyqqdemo.R;


/**
 * Created by 11757 on 2017/3/9.
 */

public class ContactsFragment extends Fragment {

    private ExpandableListView expandableListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_contacts , null);

        Context context = getActivity();

        expandableListView = (ExpandableListView)view.findViewById(R.id.contacts_expandable_listview);
        expandableListView.setAdapter(new ExpandaleListViewAdapter(context));

        return view;
    }


}
