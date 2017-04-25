package com.hg.jacob.lvdao.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jacob.lvdao.R;
import com.hg.jacob.lvdao.entry.User;

/**
 * author : yinjuan
 * time： 2017/3/31 10:35
 * email：
 * Description:疾病治疗的适配器。采用继承方式实现。封装好的一个适配器myadpter，源自于源动斌彬
 */
public class IllnessAdapter extends MyAdapter<User> {

    /**
     * 构造方法描述:基类构造方法
     *
     * @param mContext
     */
    public IllnessAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        if (view ==null){
            view =View.inflate(mContext, R.layout.item_user,null);
        }

        User user =getItem(position);
        RelativeLayout layout =ViewHolder.get(view,R.id.list_item);
        TextView name= ViewHolder.get(view,R.id.tv_name);
        final ImageView iv_dowm =ViewHolder.get(view,R.id.down);
        final View viewStub = ViewHolder.get(view,R.id.stub);

        name.setText(user.getName());

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewStub.getVisibility() ==View.GONE){
                    //view没显示的时候，构架。此方法只执行一次
                  if (viewStub instanceof ViewStub){
                      //viewStub =((ViewStub) viewStub).inflate();
                  }
                    viewStub.setVisibility(View.VISIBLE);
                    iv_dowm.setImageResource(R.drawable.ros_up);
                    Button btn1 =ViewHolder.get(view,R.id.btn_item_1);
                    Button btn2 =ViewHolder.get(view,R.id.btn_item_2);
                    Button btn3 =ViewHolder.get(view,R.id.btn_item_3);
                    Button btn4 =ViewHolder.get(view,R.id.btn_item_4);
                    Button btn5 =ViewHolder.get(view,R.id.btn_item_5);
                    Button btn6 =ViewHolder.get(view,R.id.btn_item_6);
                    Button btn7 =ViewHolder.get(view,R.id.btn_item_7);
                    Button btn8 =ViewHolder.get(view,R.id.btn_item_8);
                    Button btn9 =ViewHolder.get(view,R.id.btn_item_9);
                    Button btn10 =ViewHolder.get(view,R.id.btn_item_10);
                    Button btn11 =ViewHolder.get(view,R.id.btn_item_11);
                    Button btn12 =ViewHolder.get(view,R.id.btn_item_12);
                    switch (position){
                        case 0:
                                btn1.setVisibility(View.VISIBLE);
                            btn1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                }
                            });
                            break;
                        case 1:
                            btn1.setVisibility(View.VISIBLE);
                            btn2.setVisibility(View.VISIBLE);
                            break;
                        case 2:
                            btn1.setVisibility(View.VISIBLE);
                            break;
                    }
                }else {
                    viewStub.setVisibility(View.GONE);
                    iv_dowm.setImageResource(R.drawable.ros_down);
                }

            }
        });
        return view;
    }
}
