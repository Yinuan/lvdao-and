package com.hg.jacob.lvdao.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jacob.lvdao.R;
import com.hg.jacob.lvdao.entry.User;

/**
 * author : yinjuan
 * time： 2017/3/31 14:01
 * email：yin.juan2016@outlook.com
 * Description:疾病治疗详情的适配器，用来显示已选择的穴位
 */
public class GridviewChoseAdapter extends MyAdapter<User> {


    /**
     * 构造方法描述:基类构造方法
     *
     * @param mContext
     */
    public GridviewChoseAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view ==null){
            view =View.inflate(mContext, R.layout.item_chose,null);

        }
        User user =getItem(position);
        TextView tv_name =ViewHolder.get(view,R.id.item_illness);
        tv_name.setText(user.getName());

        return view;
    }
}
