package com.hg.jacob.lvdao.activity;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.jacob.lvdao.R;
import com.hg.jacob.lvdao.adapter.DeciveListApater;
import com.hg.jacob.lvdao.base.BaseActivity;
import com.hg.jacob.lvdao.entry.DeciveBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MyDeciveActivity extends BaseActivity {

    @Bind(R.id.back_text)
    TextView backText;
    @Bind(R.id.back_btn)
    LinearLayout backBtn;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.decive_list)
    ListView deciveList;
    @Bind(R.id.device_search)
    FrameLayout deviceSearch;

    private DeciveListApater mAdapter;
    private List<DeciveBean> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        iniView();
        setclick();

    }

    private void setclick() {


        //设备搜索点击事件
        deviceSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //弹出窗口
                showPop();
            }
        });
    }

    /**
     * pop窗口展示提示
     */
    private void showPop() {
        View view1 = LayoutInflater.from(MyDeciveActivity.this).inflate(R.layout.pop_decive_item, null);
        TextView tv_set = (TextView) view1.findViewById(R.id.decive_setting);
        TextView tv_ok = (TextView) view1.findViewById(R.id.decive_ok);
        final PopupWindow popupWindow = new PopupWindow(view1, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        ColorDrawable cd = new ColorDrawable(0x000000);
        popupWindow.setBackgroundDrawable(cd);
        WindowManager.LayoutParams lp=getWindow().getAttributes();
        lp.alpha = 0.4f;
        getWindow().setAttributes(lp);
        popupWindow.setFocusable(false);// 取得焦点
        //注意  要是点击外部空白处弹框消息  那么必须给弹框设置一个背景色  不然是不起作用的
        // 设置允许在外点击消失
        popupWindow.setOutsideTouchable(false);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        //点击外部消失
        //  popupWindow.setOutsideTouchable(true);
        //设置可以点击
        popupWindow.setTouchable(true);
        // 设置背景，这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        // 软键盘不会挡着popupwindow
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        popupWindow.showAtLocation(view1, Gravity.CENTER, 0, 0);
        //set 点击
        tv_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });
        //hao 点击
        tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });
        // 监听菜单的关闭事件
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
            }
        });
        // 监听触屏事件
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                return false;
            }
        });
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

            //在dismiss中恢复透明度
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1f;
                getWindow().setAttributes(lp);
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_my_decive;
    }

    private void iniView() {

        title.setText("我的设备");
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mAdapter =new DeciveListApater(this);
        mAdapter.setList(mData);
        deciveList.setAdapter(mAdapter);


    }


    private void initData() {
        mData  =new ArrayList<>();
        mData.add(new DeciveBean("CC41-A","在线"));
        mData.add(new DeciveBean("CC41-B","离线"));
        mData.add(new DeciveBean("CC41-C","离线"));
        mData.add(new DeciveBean("CC41-D","离线"));

    }


}
