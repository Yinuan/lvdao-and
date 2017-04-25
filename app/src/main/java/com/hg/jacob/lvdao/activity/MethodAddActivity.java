package com.hg.jacob.lvdao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jacob.lvdao.R;
import com.hg.jacob.lvdao.adapter.GridviewChoseAdapter;
import com.hg.jacob.lvdao.base.BaseActivity;
import com.hg.jacob.lvdao.entry.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MethodAddActivity extends BaseActivity {

    @Bind(R.id.back_text)
    TextView backText;
    @Bind(R.id.back_btn)
    LinearLayout backBtn;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.add_method)
    TextView addMethod;
    @Bind(R.id.back_layout)
    RelativeLayout backLayout;
    @Bind(R.id.lauou_s)
    LinearLayout lauouS;
    @Bind(R.id.add_method_name)
    EditText addMethodName;
    @Bind(R.id.add_method_acup)
    EditText addMethodAcup;
    @Bind(R.id.hint_acup_chosed)
    EditText hintAcupChosed;
    @Bind(R.id.grid_chose)
    GridView gridChose;
    @Bind(R.id.base_msg)
    LinearLayout baseMsg;
    @Bind(R.id.cure_msg)
    LinearLayout cureMsg;
    @Bind(R.id.add_acup)
    TextView addAcup;
    @Bind(R.id.add_model)
    TextView addModel;
    @Bind(R.id.add_rate)
    TextView addRate;
    @Bind(R.id.add_strong)
    TextView addStrong;
    @Bind(R.id.add_time)
    TextView addTime;
    @Bind(R.id.btn_save)
    LinearLayout btnSave;
    @Bind(R.id.activity_method_msg)
    RelativeLayout activityMethodMsg;

    //选择好的穴位显示的适配器
    private GridviewChoseAdapter adapter;
    private List<User> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //顶部菜单栏
        Intent intent = getIntent();
        title.setText("方案详情");
        //backText.setBackgroundResource(R.drawable.iconfont_xialakuang);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        addMethod.setText(R.string.method_detail_edit);
        addMethod.setVisibility(View.VISIBLE);

        initdatas();
        //穴位选择适配器
        if (datas.size()>0 && datas !=null){

            adapter = new GridviewChoseAdapter(this);
            adapter.setList(datas);
            gridChose.setAdapter(adapter);
            gridChose.setVisibility(View.VISIBLE);
            hintAcupChosed.setVisibility(View.GONE);

        }else {
            gridChose.setVisibility(View.GONE);
            hintAcupChosed.setVisibility(View.VISIBLE);
        }

        //点击事件
        setclick();
    }

    private void setclick() {
        addMethod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MethodAddActivity.this,MethodEidtActivity.class));
            }
        });
    }

    private void initdatas() {
        datas = new ArrayList<>();
        User user1 = new User(R.drawable.head, "太阳穴");
        User user2 = new User(R.drawable.head, "笑穴");
        User user3 = new User(R.drawable.head, "痛穴");
        User user4 = new User(R.drawable.head, "阳光穴");
        User user5 = new User(R.drawable.head, "屌穴");

        datas.add(user1);
        datas.add(user2);

        //设置基本信息
        addMethodName.setText(R.string.method_detail_name);
        addMethodAcup.setText(R.string.method_detail_symptom);
        //失去焦点
        addMethodName.setFocusable(false);
        addMethodAcup.setFocusable(false);

        //list穴位设置的信息
        addAcup.setText(R.string.method_detail_list_acup);
        addModel.setText(R.string.method_detail_list_model);
        addRate.setText(R.string.method_detail_list_rate);
        addStrong.setText(R.string.method_detail_list_strong);
        addTime.setText(R.string.method_detail_list_time);

    }


    @Override
    protected int getLayout() {
        return R.layout.activity_method_msg;
    }
}
