package com.hg.jacob.lvdao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jacob.lvdao.R;
import com.hg.jacob.lvdao.adapter.CommenMethodAdpater;
import com.hg.jacob.lvdao.base.BaseActivity;
import com.hg.jacob.lvdao.entry.MethodBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class CommenMethodActivity extends BaseActivity {

    @Bind(R.id.back_text)
    TextView backText;
    @Bind(R.id.back_btn)
    LinearLayout backBtn;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.back_layout)
    RelativeLayout backLayout;
    @Bind(R.id.lauou_s)
    LinearLayout lauouS;
    @Bind(R.id.history_null)
    LinearLayout historyNull;
    @Bind(R.id.lv_history)
    ListView lvHistory;
    @Bind(R.id.add_method_iv)
    ImageView addMethod;
    @Bind(R.id.activity_commen_method)
    LinearLayout activityCommenMethod;
    @Bind(R.id.comm_method_webview)
    WebView webview;

    //适配器‘
    private CommenMethodAdpater adpater;
    private List<MethodBean> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initweb();
        //显示添加按钮
        addMethod.setVisibility(View.VISIBLE);
        //返回按钮
        title.setText("常用方案");
        // backText.setBackgroundResource(R.drawable.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        backLayout.setVisibility(View.GONE);
        //显示listview
        initDatas();
        adpater = new CommenMethodAdpater(this);
        adpater.setList(datas);
        if (datas != null && datas.size() > 0) {
            lvHistory.setAdapter(adpater);
            historyNull.setVisibility(View.GONE);
        } else {
            historyNull.setVisibility(View.VISIBLE);
        }

        //点击事件
        setclick();

    }

    private void initweb() {

        webview.loadUrl("http://192.168.1.21:8089/forms/FrmSolution.solutionSelect");
    }

    private void setclick() {
        //点击加号，新增穴位治疗方案
        addMethod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转至新的界面
                startActivity(new Intent(CommenMethodActivity.this, MethodMsgActivity.class));
            }
        });
        //点击常用方案list，查看详情
        lvHistory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(CommenMethodActivity.this, MethodAddActivity.class));
            }
        });
    }

    private void initDatas() {
        datas = new ArrayList<>();
        datas.add(new MethodBean("方案一", "适应症: 手脚冰冷"));
        datas.add(new MethodBean("方案一", "适应症: 手脚冰冷"));
        datas.add(new MethodBean("方案一", "适应症: 手脚冰冷"));
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_commen_method;
    }
}
