package com.hg.jacob.lvdao.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jacob.lvdao.R;
import com.hg.jacob.lvdao.entry.User;

/**
 * author : yinjuan
 * time： 2017/3/31 14:52
 * email：yin.juan2016@outlook.com
 * Description:描述
 */
public class GridViewCureAdapter extends MyAdapter<User> {

    private boolean isTag;//用来决定 按钮点击

    /**
     * 构造方法描述:基类构造方法
     *
     * @param mContext
     */
    public GridViewCureAdapter(Context mContext) {
        super(mContext);
    }

    public GridViewCureAdapter(Context mContext, boolean isTag) {
        super(mContext);
        this.isTag = isTag;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view ==null){
            view =View.inflate(mContext, R.layout.item_cure_acup,null);

        }
        User user =getItem(position);
        TextView tv_name =ViewHolder.get(view,R.id.acup_btn);
        tv_name.setText(user.getName());

        return view;
    }
}
