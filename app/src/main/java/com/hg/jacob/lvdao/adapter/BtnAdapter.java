package com.hg.jacob.lvdao.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jacob.lvdao.R;
import com.hg.jacob.lvdao.entry.User;

/**
 * author : yinjuan
 * time： 2017/4/1 11:54
 * email：yin.juan2016@outlook.com
 * Description:按钮适配器
 */
public class BtnAdapter extends MyAdapter<User> {

    /**
     * 构造方法描述:基类构造方法
     *
     * @param mContext
     */
    public BtnAdapter(Context mContext) {
        super(mContext);
    }


    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view==null){
            view =View.inflate(mContext, R.layout.btn_item,null);
        }
        User user =getItem(position);
        TextView textView =ViewHolder.get(view,R.id.btn_item);
        textView.setText(user.getName());
        return view;
    }
}
