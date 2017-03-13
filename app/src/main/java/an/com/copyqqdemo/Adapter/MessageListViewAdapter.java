package an.com.copyqqdemo.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import an.com.copyqqdemo.R;



public class MessageListViewAdapter extends BaseAdapter {

    private List<Map<String ,Object>> mList;
    private LayoutInflater mIbflater;
    private Context context;

    public MessageListViewAdapter(Context context , List<Map<String , Object>> data) {
        this.mList = data;
        this.context = context;
        this.mIbflater = mIbflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Zujian zujian = null;
        if(convertView == null)
        {
            convertView = mIbflater.inflate(R.layout.item_listview_message , null);
            zujian = new Zujian();
            zujian.imageView = (ImageView) convertView.findViewById(R.id.item_message_image);
            zujian.textView01 = (TextView)convertView.findViewById(R.id.item_message_text01) ;
            zujian.textView02 = (TextView)convertView.findViewById(R.id.item_message_text02) ;
            convertView.setTag(zujian);
        }
        else
        {
            zujian = (Zujian) convertView.getTag();
        }

        zujian.textView01.setText((String)mList.get(position).get("text01"));
        zujian.textView02.setText((String)mList.get(position).get("text02"));

        return convertView;
    }

    //listview组件
    private class Zujian
    {
        private ImageView imageView;
        private TextView textView01 , textView02;
    }
}
