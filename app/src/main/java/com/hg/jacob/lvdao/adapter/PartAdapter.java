package com.hg.jacob.lvdao.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jacob.lvdao.R;
import com.hg.jacob.lvdao.activity.AcupointMsgActivity;
import com.hg.jacob.lvdao.activity.IllnessTreatActivity;
import com.hg.jacob.lvdao.entry.User;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * author : yinjuan
 * time： 2017/3/31 10:58
 * email：yin.juan2016@outlook.com
 * Description:部位的适配器
 */
public class PartAdapter extends BaseAdapter implements Filterable {

    private Context mContext;

    /**
     * Contains the list of objects that represent the data of this Adapter.
     * Adapter数据源
     */
    private List<User> mDatas;

    private LayoutInflater mInflater;
    private static final String Tag ="---";

    //过滤相关
    /**
     * This lock is also used by the filter
     * (see {@link #getFilter()} to make a synchronized copy of
     * the original array of data.
     * 过滤器上的锁可以同步复制原始数据。
     */
    private final Object mLock = new Object();

    private String[] item ={"以及","as","sdad","sd","dd"};
    private List<String> list =new ArrayList<>();

    // A copy of the original mObjects array, initialized from and then used instead as soon as
    // the mFilter ArrayFilter is used. mObjects will then only contain the filtered values.
    //对象数组的备份，当调用ArrayFilter的时候初始化和使用。此时，对象数组只包含已经过滤的数据。
    private ArrayList<User> mOriginalValues;
    private PartAdapter.ArrayFilter mFilter;

    public PartAdapter(Context context, List<User> datas) {
        mContext = context;
        mDatas = datas;
        mInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return mDatas.size() > 0 ? mDatas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final PartAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_user, parent, false);
            holder = new PartAdapter.ViewHolder();
            holder.list_item = (RelativeLayout) convertView.findViewById(R.id.list_item);
            holder.name = (TextView) convertView.findViewById(R.id.tv_name);
            holder.stub = (ViewStub) convertView.findViewById(R.id.stub);
            holder.down = (ImageView) convertView.findViewById(R.id.down);


            convertView.setTag(holder);
        } else {
            holder = (PartAdapter.ViewHolder) convertView.getTag();
        }
        User user = mDatas.get(position);
        holder.name.setText(user.getName());
        Logger.i(Tag,"-----"+user.getName());
        final View finalConvertView = convertView;
        holder.list_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.stub.getVisibility() ==View.GONE){
                    if (holder.stub instanceof  ViewStub){
                        holder.stub =((ViewStub) holder.stub).inflate();
                    }

                    holder.stub.setVisibility(View.VISIBLE);
                    //holder.gridView = (GridView) finalConvertView.findViewById(R.id.gridview);
                    holder.btn1 = (TextView) finalConvertView.findViewById(R.id.btn_item_1);
                    holder.btn2 = (TextView) finalConvertView.findViewById(R.id.btn_item_2);
                    holder.btn3 = (TextView) finalConvertView.findViewById(R.id.btn_item_3);
                    holder.btn4 = (TextView) finalConvertView.findViewById(R.id.btn_item_4);
                    holder.btn5 = (TextView) finalConvertView.findViewById(R.id.btn_item_5);
                    holder.btn6 = (TextView) finalConvertView.findViewById(R.id.btn_item_6);
                    holder.btn7 = (TextView) finalConvertView.findViewById(R.id.btn_item_7);
                    holder.btn8 = (TextView) finalConvertView.findViewById(R.id.btn_item_8);
                    holder.btn9 = (TextView) finalConvertView.findViewById(R.id.btn_item_9);
                    holder.btn10 = (TextView) finalConvertView.findViewById(R.id.btn_item_10);
                    holder.btn11 = (TextView) finalConvertView.findViewById(R.id.btn_item_11);
                    holder.btn12 = (TextView) finalConvertView.findViewById(R.id.btn_item_12);
                    //在这里，根据位置来显示多少的button数量
                    switch (position){
                        case 0:
                            holder.btn1.setVisibility(View.VISIBLE);
                            holder.btn2.setVisibility(View.VISIBLE);
                            holder.btn3.setVisibility(View.VISIBLE);

                            holder.btn1.setText("慢性支气管炎");
                            holder.btn2.setText("肺炎");
                            holder.btn1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent =new Intent(mContext,IllnessTreatActivity.class);
                                    intent.putExtra("illness",holder.btn1.getText());
                                    mContext.startActivity(intent);
                                   // mContext.startActivity(new Intent(mContext, AcupointMsgActivity.class));
                                }
                            });
                            holder.btn2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    mContext.startActivity(new Intent(mContext, AcupointMsgActivity.class));
                                }
                            });
                            holder.btn3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    mContext.startActivity(new Intent(mContext, AcupointMsgActivity.class));
                                }
                            });

                            break;
                        case 1:
                            holder.btn1.setVisibility(View.VISIBLE);

                            break;
                        case 2:
                            holder.btn1.setVisibility(View.VISIBLE);
                            holder.btn2.setVisibility(View.VISIBLE);

                            break;
                    }


                    holder.down.setImageResource(R.drawable.ros_up);
                }else {
                    holder.stub.setVisibility(View.GONE);
                    holder.down.setImageResource(R.drawable.ros_down);
                }
            }
        });
        return convertView;
    }

    public class ViewHolder {
        RelativeLayout list_item;
        TextView name;
        View stub;
        ImageView down;
        TextView btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12;
        GridView gridView;
    }

    @Override
    public Filter getFilter() {
        if (mFilter == null) {
            mFilter = new PartAdapter.ArrayFilter();
        }
        return mFilter;
    }

    /**
     * 过滤数据的类
     */
    /**
     * <p>An array filter constrains the content of the array adapter with
     * a prefix. Each item that does not start with the supplied prefix
     * is removed from the list.</p>
     * <p/>
     * 一个带有首字母约束的数组过滤器，每一项不是以该首字母开头的都会被移除该list。
     */
    private class ArrayFilter extends Filter {
        //执行刷选
        @Override
        protected FilterResults performFiltering(CharSequence prefix) {
            FilterResults results = new FilterResults();//过滤的结果
            //原始数据备份为空时，上锁，同步复制原始数据
            if (mOriginalValues == null) {
                synchronized (mLock) {
                    mOriginalValues = new ArrayList<>(mDatas);
                }
            }
            //当首字母为空时
            if (prefix == null || prefix.length() == 0) {
                ArrayList<User> list;
                synchronized (mLock) {//同步复制一个原始备份数据
                    list = new ArrayList<>(mOriginalValues);
                }
                results.values = list;
                results.count = list.size();//此时返回的results就是原始的数据，不进行过滤
            } else {
                String prefixString = prefix.toString().toLowerCase();//转化为小写

                ArrayList<User> values;
                synchronized (mLock) {//同步复制一个原始备份数据
                    values = new ArrayList<>(mOriginalValues);
                }
                final int count = values.size();
                final ArrayList<User> newValues = new ArrayList<>();

                for (int i = 0; i < count; i++) {
                    final User value = values.get(i);//从List<User>中拿到User对象
//                    final String valueText = value.toString().toLowerCase();
                    final String valueText = value.getName().toString().toLowerCase();//User对象的name属性作为过滤的参数
                    // First match against the whole, non-splitted value
                    if (valueText.startsWith(prefixString) || valueText.indexOf(prefixString.toString()) != -1) {//第一个字符是否匹配
                        newValues.add(value);//将这个item加入到数组对象中
                    } else {//处理首字符是空格
                        final String[] words = valueText.split(" ");
                        final int wordCount = words.length;

                        // Start at index 0, in case valueText starts with space(s)
                        for (int k = 0; k < wordCount; k++) {
                            if (words[k].startsWith(prefixString)) {//一旦找到匹配的就break，跳出for循环
                                newValues.add(value);
                                break;
                            }
                        }
                    }
                }
                results.values = newValues;//此时的results就是过滤后的List<User>数组
                results.count = newValues.size();
            }
            return results;
        }

        //刷选结果
        @Override
        protected void publishResults(CharSequence prefix, FilterResults results) {
            //noinspection unchecked
            mDatas = (List<User>) results.values;//此时，Adapter数据源就是过滤后的Results
            if (results.count > 0) {
                notifyDataSetChanged();//这个相当于从mDatas中删除了一些数据，只是数据的变化，故使用notifyDataSetChanged()
            } else {
                /**
                 * 数据容器变化 ----> notifyDataSetInValidated

                 容器中的数据变化  ---->  notifyDataSetChanged
                 */
                notifyDataSetInvalidated();//当results.count<=0时，此时数据源就是重新new出来的，说明原始的数据源已经失效了
            }
        }
    }
}
