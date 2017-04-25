package com.hg.jacob.lvdao.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jacob.lvdao.R;
import com.hg.jacob.lvdao.entry.AcupSetBean;

/**
 * author : yinjuan
 * time： 2017/4/1 15:44
 * email：yin.juan2016@outlook.com
 * Description:描述
 */
public class CureHistoryAdapter extends MyAdapter<AcupSetBean> {


    /**
     * 构造方法描述:基类构造方法
     *
     * @param mContext
     */
    public CureHistoryAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view ==null){
            view=View.inflate(mContext, R.layout.item_cure_history_list,null);
        }

        TextView tv_time =ViewHolder.get(view,R.id.history_time);
        TextView tv_acup =ViewHolder.get(view,R.id.history_acup);
        TextView tv_model =ViewHolder.get(view,R.id.history_model);

        AcupSetBean acup =getItem(position);
        tv_acup.setText(acup.getAcupName());
        tv_model.setText(acup.getModel());
        tv_time.setText(acup.getTime());




        return view;
    }
}
