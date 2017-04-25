package com.hg.jacob.lvdao.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jacob.lvdao.R;
import com.hg.jacob.lvdao.entry.DeciveBean;

/**
 * author : yinjuan
 * time： 2017/4/24 11:39
 * email：yin.juan2016@outlook.com
 * Description:设备列表适配器
 */
public class DeciveListApater extends MyAdapter<DeciveBean>{


    /**
     * 构造方法描述:基类构造方法
     *
     * @param mContext
     */
    public DeciveListApater(Context mContext) {
        super(mContext);
    }


    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view==null){
            view =View.inflate(mContext,R.layout.item_device_list,null);
        }
        DeciveBean deciveBean =getItem(position);
        TextView name =ViewHolder.get(view,R.id.decice_name);//设备名
        TextView state =ViewHolder.get(view,R.id.decive_state);//设备状态
        ImageView point =ViewHolder.get(view,R.id.decive_point);
         name.setText(deciveBean.getName());
        state.setText(deciveBean.getState());

        if (state.getText().toString().equals("在线")){
            point.setImageResource(R.drawable.decive_point);
            name.setTextColor(mContext.getResources().getColor(R.color.btn_press));
            state.setTextColor(mContext.getResources().getColor(R.color.btn_press));
            Drawable nav_up=mContext.getResources().getDrawable(R.mipmap.jump_right_blue);
            nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
            state.setCompoundDrawables(null, null, nav_up, null);
        }else if (state.getText().toString().equals("离线")){
            point.setImageResource(R.drawable.decive_point_offline);
            name.setTextColor(mContext.getResources().getColor(R.color.bg_gray));
            state.setTextColor(mContext.getResources().getColor(R.color.bg_gray));
            Drawable nav_up=mContext.getResources().getDrawable(R.mipmap.jump_right);
            nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
            state.setCompoundDrawables(null, null, nav_up, null);
        }
        return view;
    }
}
