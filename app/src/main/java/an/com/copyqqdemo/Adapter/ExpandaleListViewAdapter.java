package an.com.copyqqdemo.Adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import an.com.copyqqdemo.R;


public class ExpandaleListViewAdapter extends BaseExpandableListAdapter{

    private Context mcontext;

    //数据
    private String[] groups = {"我的好友" , "计维" ,"我的同学" , "陌生人", "黑名单"};
    private String[][] child = {
            {"邓小平" , "习近平"} ,
            {"张烜" , "志远" , "红映"},
            {"树杰", "嘉东" , "梓标"},
            {"李先生"},
            {"推销的人"}
    };

    //子容器的组件
    public class ChildHolder{
        private ImageView imageView;
        private TextView textView;
    }

    //父容器的组件
    public class GrorpHolder{
        private ImageView imageView;
        private TextView name;
        private TextView childnum;
    }

    public ExpandaleListViewAdapter(Context context) {
        this.mcontext = context;
    }

    @Override
    public int getGroupCount() {
        return groups.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return child[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return child[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GrorpHolder grorpHolder = null;
        if(convertView == null)
        {
            convertView = LayoutInflater.from(mcontext).inflate(R.layout.item_listview_contacts_group ,null);

            grorpHolder = new GrorpHolder();
            grorpHolder.imageView = (ImageView)convertView.findViewById(R.id.item_contacts_group_image);
            grorpHolder.name = (TextView)convertView.findViewById(R.id.item_contacts_group_name);
            grorpHolder.childnum = (TextView)convertView.findViewById(R.id.item_contacts_child_num);
            convertView.setTag(grorpHolder);
        }
        else
        {
            grorpHolder = (GrorpHolder)convertView.getTag();
        }

        //箭头效果
        if(isExpanded == true) {
            grorpHolder.imageView.setImageResource(R.drawable.qb_down);
        } else {
            grorpHolder.imageView.setImageResource(R.drawable.qb_right);
        }

        grorpHolder.name.setText(groups[groupPosition]);
        grorpHolder.childnum.setText( getChildrenCount(groupPosition) + "/" +getChildrenCount(groupPosition));

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildHolder holder = null;
        if(convertView == null)
        {
            convertView = LayoutInflater.from(mcontext).inflate(R.layout.item_listview_contacts_child , null);

            holder = new ChildHolder();
            holder.imageView = (ImageView)convertView.findViewById(R.id.item_contacts_head);
            holder.textView = (TextView)convertView.findViewById(R.id.item_contacts_name);
            convertView.setTag(holder);
        }
        else{
            holder = (ChildHolder)convertView.getTag();
        }

        holder.textView.setText( getChild(groupPosition ,childPosition ).toString() );
        holder.imageView.setImageResource(R.drawable.head);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
