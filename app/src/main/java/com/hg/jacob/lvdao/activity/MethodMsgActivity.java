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

public class MethodMsgActivity extends BaseActivity {

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
    @Bind(R.id.hint_acup_chosed)
    EditText hintAcupChosed;


    //选择好的穴位显示的适配器
    private GridviewChoseAdapter adapter;
    private List<User> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //顶部菜单栏
        Intent intent = getIntent();
        title.setText("新增方案");
        //backText.setBackgroundResource(R.drawable.iconfont_xialakuang);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        addMethod.setText(R.string.chosed_acup);
        addMethod.setVisibility(View.VISIBLE);

        //穴位选择适配器
        initDatas();
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



    }

    @Override
    protected int getLayout() {
        return R.layout.activity_method_msg;
    }

    private void initDatas() {

        datas = new ArrayList<>();
        User user1 = new User(R.drawable.head, "太阳穴");
        User user2 = new User(R.drawable.head, "笑穴");
        User user3 = new User(R.drawable.head, "痛穴");
        User user4 = new User(R.drawable.head, "阳光穴");
        User user5 = new User(R.drawable.head, "屌穴");

       // datas.add(user1);
      //  datas.add(user2);

        //初始化穴位设置数据
        addAcup.setText(R.string.list_acup_set);
        addModel.setText(R.string.list_model_set);
        addRate.setText(R.string.list_rate_set);
        addStrong.setText(R.string.list_strong_set);
        addTime.setText(R.string.list_time_set);

    }
}
