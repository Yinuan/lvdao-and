package com.hg.jacob.lvdao.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jacob.lvdao.R;
import com.hg.jacob.lvdao.entry.AcupSetBean;

/**
 * author : yinjuan
 * time： 2017/4/1 10:15
 * email：yin.juan2016@outlook.com
 * Description:穴位选择治疗的配置信息，模式，频率等的适配器
 */
public class AcupMsgSetAdapter extends MyAdapter<AcupSetBean> {


    /**
     * 构造方法描述:基类构造方法
     *
     * @param mContext
     */
    public AcupMsgSetAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        if (view==null){
            view =View.inflate(mContext, R.layout.item_acup_set,null);

        }
        AcupSetBean setBean =getItem(position);

        TextView tv_num = ViewHolder.get(view,R.id.set_num);
        TextView tv_name = ViewHolder.get(view,R.id.set_acup);
        TextView tv_model = ViewHolder.get(view,R.id.set_model);
        TextView tv_rate = ViewHolder.get(view,R.id.set_rate);
        TextView tv_strength = ViewHolder.get(view,R.id.set_strength);
        TextView tv_time = ViewHolder.get(view,R.id.set_time);

        tv_num.setText(setBean.getNum());
        tv_name.setText(setBean.getAcupName());
        tv_model.setText(setBean.getModel());
        tv_strength.setText(setBean.getStrength());
        tv_rate.setText(setBean.getRate());
        tv_time.setText(setBean.getTime());

        //穴位
       tv_name.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               onback.onDianzanCallBack(position);
           }
       });
        //模式
        tv_model.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSetModel.onDianzanCallBack(position);
            }
        });
        //频率
        tv_rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //接口回调
                onSetRate.onDianzanCallBack(position);
            }
        });
        //强度
        tv_strength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSetStrong.onDianzanCallBack(position);
            }
        });
        //时间
        tv_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSetTime.onDianzanCallBack(position);
            }
        });



        return view;
    }

    //点赞的回调接口

    public  onDianzan onback;
    public void setOnback_acup(onDianzan onback) {
        this.onback = onback;
    }
    public onSetModel onSetModel;
    public void setOnback_model(onSetModel onback) {
        this.onSetModel = onback;
    }
    public onSetRate onSetRate;
    public void setOnback_rate(onSetRate onback) {
        this.onSetRate = onback;
    }
    public onSetStrong onSetStrong;
    public void setOnback_strong(onSetStrong onback) {
        this.onSetStrong = onback;
    }
    public onSetTime onSetTime;
    public void setOnback_time(onSetTime onback) {
        this.onSetTime = onback;
    }
    public interface  onDianzan
    {
        void onDianzanCallBack(int numt);
    };
    public interface  onSetModel
    {
        void onDianzanCallBack(int numt);
    };
    public interface  onSetRate
    {
        void onDianzanCallBack(int numt);
    };
    public interface  onSetStrong
    {
        void onDianzanCallBack(int numt);
    }; public interface  onSetTime
    {
        void onDianzanCallBack(int numt);
    };

}
