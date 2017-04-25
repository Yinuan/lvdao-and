package com.hg.jacob.lvdao.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jacob.lvdao.R;
import com.hg.jacob.lvdao.entry.MethodBean;

/**
 * author : yinjuan
 * time： 2017/4/1 16:24
 * email：yin.juan2016@outlook.com
 * Description:常用方案的适配器
 */
public class CommenMethodAdpater extends MyAdapter<MethodBean> {


    /**
     * 构造方法描述:基类构造方法
     *
     * @param mContext
     */
    public CommenMethodAdpater(Context mContext) {
        super(mContext);
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view ==null){
            view =View.inflate(mContext, R.layout.item_commen_method,null);

        }
        TextView tv_method =ViewHolder.get(view,R.id.commen_num);
        TextView tv_work =ViewHolder.get(view,R.id.commen_work);
        MethodBean method =getItem(position);
       tv_method.setText(method.getName());
        tv_work.setText(method.getWork());
        return view;
    }
}
