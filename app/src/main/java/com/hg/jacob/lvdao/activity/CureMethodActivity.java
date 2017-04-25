package com.hg.jacob.lvdao.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jacob.lvdao.R;
import com.hg.jacob.lvdao.adapter.AcupMsgSetAdapter;
import com.hg.jacob.lvdao.adapter.GridviewChoseAdapter;
import com.hg.jacob.lvdao.base.BaseActivity;
import com.hg.jacob.lvdao.entry.AcupLists;
import com.hg.jacob.lvdao.entry.AcupSetBean;
import com.hg.jacob.lvdao.entry.User;
import com.hg.jacob.lvdao.widget.CustomPopWindow;
import com.hg.jacob.lvdao.widget.WheelView;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;

public class CureMethodActivity extends BaseActivity {


    @Bind(R.id.back_text)
    TextView backText;
    @Bind(R.id.back_btn)
    LinearLayout backBtn;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.add_method)
    TextView addMethod;
    @Bind(R.id.add_method_iv)
    ImageView addMethodIv;
    @Bind(R.id.back_layout)
    RelativeLayout backLayout;
    @Bind(R.id.lauou_s)
    LinearLayout lauouS;
    @Bind(R.id.grid_chose)
    GridView gridChose;
    @Bind(R.id.chose_acup_layout)
    LinearLayout choseAcupLayout;
    @Bind(R.id.set_cure_listview)
    ListView setCureListview;
    @Bind(R.id.btn_save)
    LinearLayout btnSave;
    @Bind(R.id.btn_start_cure)
    LinearLayout btnStartCure;
    @Bind(R.id.activity_cure_method)
    LinearLayout activityCureMethod;

    //选择好的穴位显示的适配器
    private GridviewChoseAdapter adapter;
    private List<User> datas;

    //显示的穴位设置信息
    private AcupMsgSetAdapter setAdapter;
    private List<AcupSetBean> acupDatas;

    //编辑保存的方案
    private CustomPopWindow mCustomPopWindow;

    private static final String[] MODEL = new String[]{"连续", "间接", "疏密", "循环"};
    private static final String[] STRONG = new String[]{"10", "20", "30", "40"};
    private static final String[] RATE = new String[]{"10", "20", "30", "40"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //eventBus
        EventBus.getDefault().register(this);


        //返回按钮
       Intent intent = getIntent();
        title.setText("配穴");
        //backText.setBackgroundResource(R.drawable.iconfont_xialakuang);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //穴位选择适配器
        initDatas();
        adapter = new GridviewChoseAdapter(this);
        adapter.setList(datas);
        gridChose.setAdapter(adapter);

        //listview显示的治疗
        initAcupSetData();
        setAdapter = new AcupMsgSetAdapter(this);
        setAdapter.setList(acupDatas);
        setCureListview.setAdapter(setAdapter);

        //点击事件
        setclick();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_cure_method;
    }

    private void setclick() {
        //保存方案
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //弹出一个Pop窗口，保存常用的治疗方案
                View contentView = LayoutInflater.from(CureMethodActivity.this).inflate(R.layout.pop_edittext, null);

                //处理popWindow 显示内容
                handleLogic(contentView);
                //创建并显示popWindow
                mCustomPopWindow = new CustomPopWindow.PopupWindowBuilder(CureMethodActivity.this)
                        .setView(contentView)
                        .setFocusable(false)
                        .setOutsideTouchable(false)
                        .create()
                        .showAtLocation(activityCureMethod, Gravity.CENTER, 0, 0);
            }
        });
        //选择穴位
        setAdapter.setOnback_acup(new AcupMsgSetAdapter.onDianzan() {
            @Override
            public void onDianzanCallBack(int numt) {

            }
        });
        //选择模式
        setAdapter.setOnback_model(new AcupMsgSetAdapter.onSetModel() {
            @Override
            public void onDianzanCallBack(final int numt) {
                setCure(Arrays.asList(MODEL),numt);
            }


        });
        //选择强度
        setAdapter.setOnback_strong(new AcupMsgSetAdapter.onSetStrong() {
            @Override
            public void onDianzanCallBack(int numt) {
                setCure(Arrays.asList(STRONG),numt);


            }
        });
        //选择频率
        setAdapter.setOnback_rate(new AcupMsgSetAdapter.onSetRate() {
            @Override
            public void onDianzanCallBack(int numt) {
                setCure(Arrays.asList(RATE),numt);
            }
        });
        //选择时间
        setAdapter.setOnback_time(new AcupMsgSetAdapter.onSetTime() {
            @Override
            public void onDianzanCallBack(int numt) {

            }
        });



    }

    /**
     * 处理选择模式/强度/频率等
     * @param
     */
    private void setCure(List<String> data, final int num)
        {
            final String[] items = {null};
            //加载pop布局
            View view1 = LayoutInflater.from(CureMethodActivity.this).inflate(R.layout.pop_bottom_item, null);
            WheelView wheelVi = (WheelView) view1.findViewById(R.id.wheelview_pop);
            TextView tv_cancle = (TextView) view1.findViewById(R.id.pop_cancle);
            TextView tv_confrim = (TextView) view1.findViewById(R.id.pop_confrim);
            wheelVi.setOffset(1);
            wheelVi.setItems(data);
            //  wheelVi.setSeletion(2);
            wheelVi.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
                @Override
                public void onSelected(int selectedIndex, String item) {
                    super.onSelected(selectedIndex, item);
                    items[0] =item;
                }
            });

            final PopupWindow popupWindow = new PopupWindow(view1, ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);

            popupWindow.setFocusable(false);// 取得焦点
            //注意  要是点击外部空白处弹框消息  那么必须给弹框设置一个背景色  不然是不起作用的

            popupWindow.setBackgroundDrawable(new BitmapDrawable());
            //点击外部消失
            //  popupWindow.setOutsideTouchable(true);
            //设置可以点击
            popupWindow.setTouchable(true);
            popupWindow.showAtLocation(view1, Gravity.BOTTOM, 0, 0);

            activityCureMethod.setBackgroundColor(getResources().getColor(R.color.bg_gray));
            tv_cancle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activityCureMethod.setBackgroundColor(getResources().getColor(R.color.white));
                    popupWindow.dismiss();
                }
            });
            tv_confrim.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //取值
                    String str =items[0];
                    //更改数据
                    activityCureMethod.setBackgroundColor(getResources().getColor(R.color.white));
                    popupWindow.dismiss();
                    acupDatas.get(num).setModel(str);
                    setAdapter.notifyDataSetChanged();
                }
            });

    }

    private void handleLogic(View contentView) {
        final EditText et_name = (EditText) contentView.findViewById(R.id.pop_name);
        EditText et_pass = (EditText) contentView.findViewById(R.id.pop_pass);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCustomPopWindow != null) {
                    mCustomPopWindow.dissmiss();
                }

                switch (v.getId()) {
                    case R.id.cancle:
                        mCustomPopWindow.dissmiss();
                        break;
                    case R.id.confirm:
                        //保存方案
                        Logger.d("---", "---" + et_name.getText().toString());
                        mCustomPopWindow.dissmiss();

                        break;

                }

            }
        };
        contentView.findViewById(R.id.cancle).setOnClickListener(listener);
        contentView.findViewById(R.id.confirm).setOnClickListener(listener);

    }

    private void initAcupSetData() {
        acupDatas = new ArrayList<>();
        AcupSetBean acup1 = new AcupSetBean("1", "太阳穴", "连续", "100", "50", "20：00");
        AcupSetBean acup2 = new AcupSetBean("2", "太阳穴", "连续", "100", "50", "20：00");
        AcupSetBean acup3 = new AcupSetBean("3", "太阳穴", "连续", "100", "50", "20：00");
        AcupSetBean acup4 = new AcupSetBean("4", "太阳穴", "连续", "100", "50", "20：00");
        acupDatas.add(acup1);
        acupDatas.add(acup2);
        acupDatas.add(acup3);
        acupDatas.add(acup4);

    }



    private void initDatas() {
        datas = new ArrayList<>();
        User user1 = new User(R.drawable.head, "太阳穴");
        User user2 = new User(R.drawable.head, "笑穴");
        User user3 = new User(R.drawable.head, "痛穴");
        User user4 = new User(R.drawable.head, "阳光穴");
        User user5 = new User(R.drawable.head, "屌穴");

        datas.add(user1);
        datas.add(user2);
        datas.add(user3);
        datas.add(user4);
        datas.add(user5);
    }


    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    public void getDatas(AcupLists datas) {
        //取出来


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
