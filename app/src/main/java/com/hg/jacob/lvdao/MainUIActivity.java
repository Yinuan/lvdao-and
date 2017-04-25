package com.hg.jacob.lvdao;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jacob.lvdao.R;
import com.hg.jacob.lvdao.base.BaseActivity;
import com.hg.jacob.lvdao.fragment.FragmentFive;
import com.hg.jacob.lvdao.fragment.FragmentFour;
import com.hg.jacob.lvdao.fragment.FragmentOne;
import com.hg.jacob.lvdao.fragment.FragmentThree;
import com.hg.jacob.lvdao.fragment.FragmentTwo;
import com.hg.jacob.lvdao.otto.BusProvide;

import butterknife.Bind;

public class MainUIActivity extends BaseActivity implements View.OnClickListener {


    @Bind(R.id.main_ui)
    FrameLayout mainUi;
    @Bind(R.id.activity_main_ui)
    RelativeLayout activityMainUi;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.one)
    RelativeLayout one;
    @Bind(R.id.two)
    RelativeLayout two;
    @Bind(R.id.three)
    RelativeLayout three;
    @Bind(R.id.four)
    RelativeLayout four;
    @Bind(R.id.five)
    RelativeLayout five;
    @Bind(R.id.right_info)
    ImageView rightInfo;
    @Bind(R.id.bottom_btn)
    FrameLayout bottomBtn;
    @Bind(R.id.one_iv)
    ImageView oneIv;
    @Bind(R.id.one_tv)
    TextView oneTv;
    @Bind(R.id.two_iv)
    ImageView twoIv;
    @Bind(R.id.two_tv)
    TextView twoTv;
    @Bind(R.id.three_iv)
    ImageView threeIv;
    @Bind(R.id.three_tv)
    TextView threeTv;
    @Bind(R.id.four_iv)
    ImageView fourIv;
    @Bind(R.id.four_tv)
    TextView fourTv;
    @Bind(R.id.five_iv)
    ImageView fiveIv;
    @Bind(R.id.five_tv)
    TextView fiveTv;


    //五个碎片
    private FragmentOne flm_one;
    private FragmentTwo flm_two;
    private FragmentThree flm_three;
    private FragmentFour flm_four;
    private FragmentFive flm_five;

    private FragmentManager fragmentManager;// 碎片管理器


    private int pagerPostion = 0;// 保存当前显示的是第几页

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            pagerPostion = savedInstanceState.getInt("lvdao");
        }


        //绑定点击事件初始化碎片
        initFragment();
        bindClick();
        //默认选中状态
        getcheck(true, false, false, false, false);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main_ui;
    }
  /*  @Subscribe(threadMode = ThreadMode.MAIN)
    public void getStr(EventMessage message){
        topBtn.setText(message.getMessage());
    }*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // EventBus.getDefault().unregister(this);
    }

    private void initFragment() {
        fragmentManager = getSupportFragmentManager();
        flm_one = (FragmentOne) fragmentManager.findFragmentByTag("one");
        flm_two = (FragmentTwo) fragmentManager.findFragmentByTag("two");
        flm_three = (FragmentThree) fragmentManager.findFragmentByTag("three");
        flm_four = (FragmentFour) fragmentManager.findFragmentByTag("four");
        flm_five = (FragmentFive) fragmentManager.findFragmentByTag("five");
        setTabSelection(pagerPostion);// 第一次启动时选中第0个tab

    }

    @Override
    protected void onResume() {
        super.onResume();
        BusProvide.getInstance().register(this);
        BusProvide.getInstance().post("我是活动");
        Log.d("--", "-活动事件分发--");
    }

    @Override
    protected void onPause() {
        super.onPause();
        BusProvide.getInstance().unregister(this);
    }

    private void setTabSelection(int pagerPostion) {
        getcheck(false, false, false, false, false);// 每次选中之前先清楚掉上次的选中状态
        //开启一个事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //隐藏碎片，保证存在一个
        hideFragment(transaction);
        switch (pagerPostion) {
            case 0:
                getcheck(true, false, false, false, false);
                title.setText("开始治疗");
                rightInfo.setVisibility(View.VISIBLE);
                if (flm_one == null) {
                    flm_one = new FragmentOne();
                    transaction.add(R.id.main_ui, flm_one, "one");
                } else {
                    transaction.show(flm_one);
                }
                break;
            case 1:
                getcheck(false, true, false, false, false);
                title.setText("穴位应用");
                rightInfo.setVisibility(View.GONE);
                if (flm_two == null) {
                    flm_two = new FragmentTwo();
                    transaction.add(R.id.main_ui, flm_two, "two");
                } else {
                    transaction.show(flm_two);
                }
                break;
            case 2:
                getcheck(false, false, true, false, false);
                title.setText("疾病治疗");
                rightInfo.setVisibility(View.GONE);
                if (flm_three == null) {
                    flm_three = new FragmentThree();
                    transaction.add(R.id.main_ui, flm_three, "three");
                } else {
                    transaction.show(flm_three);
                }
                break;
            case 3:
                getcheck(false, false, false, true, false);
                title.setText("仪器操作");
                rightInfo.setVisibility(View.GONE);
                if (flm_four == null) {
                    flm_four = new FragmentFour();
                    transaction.add(R.id.main_ui, flm_four, "four");
                } else {
                    transaction.show(flm_four);
                }
                break;
            case 4:
                getcheck(false, false, false, false, true);
                title.setText("我的");
                rightInfo.setVisibility(View.GONE);
                if (flm_five == null) {
                    flm_five = new FragmentFive();
                    transaction.add(R.id.main_ui, flm_five, "five");
                } else {
                    transaction.show(flm_five);
                }
                break;


        }
        //提交事务
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (flm_one != null) {
            transaction.hide(flm_one);
        }
        if (flm_two != null) {
            transaction.hide(flm_two);
        }
        if (flm_three != null) {
            transaction.hide(flm_three);
        }
        if (flm_four != null) {
            transaction.hide(flm_four);
        }
        if (flm_five != null) {
            transaction.hide(flm_five);
        }

    }

    /**
     * 点击改变控件样式
     */
    private void getcheck(boolean b, boolean b1, boolean b2, boolean b3, boolean b4) {

        oneIv.setSelected(b);
        twoIv.setSelected(b1);
        threeIv.setSelected(b2);
        fourIv.setSelected(b3);
        fiveIv.setSelected(b4);

        oneTv.setSelected(b);
        twoTv.setSelected(b1);
        threeTv.setSelected(b2);
        fourTv.setSelected(b3);
        fiveTv.setSelected(b4);

    }

    private void bindClick() {
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("lvdao", pagerPostion);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.one:
                setTabSelection(0);
                pagerPostion = 0;
                break;
            case R.id.two:
                setTabSelection(1);
                pagerPostion = 1;
                break;
            case R.id.three:
                setTabSelection(2);
                pagerPostion = 2;
                break;
            case R.id.four:
                setTabSelection(3);
                pagerPostion = 3;
                break;
            case R.id.five:
                setTabSelection(4);
                pagerPostion = 4;
                break;

        }
    }
}
