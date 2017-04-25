package com.hg.jacob.lvdao.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jacob.lvdao.R;
import com.hg.jacob.lvdao.adapter.GridViewCureAdapter;
import com.hg.jacob.lvdao.adapter.GridviewChoseAdapter;
import com.hg.jacob.lvdao.base.BaseActivity;
import com.hg.jacob.lvdao.entry.User;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class IllnessTreatActivity extends BaseActivity {

    @Bind(R.id.back_text)
    TextView backText;
    @Bind(R.id.back_btn)
    LinearLayout backBtn;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.grid_chose)
    GridView gridChose;
    @Bind(R.id.back_layout)
    RelativeLayout backLayout;
    @Bind(R.id.tv_content)
    TextView tvContent;
    @Bind(R.id.tv_style1)
    TextView tvStyle1;
    @Bind(R.id.tv_style2)
    TextView tvStyle2;
    @Bind(R.id.tv_style3)
    TextView tvStyle3;
    @Bind(R.id.tv_style4)
    TextView tvStyle4;
    @Bind(R.id.item_cure_gview)
    GridView itemCureGview;
    @Bind(R.id.chose_acup)
    TextView choseAcup;
    @Bind(R.id.chose_method)
    TextView choseMethod;
    @Bind(R.id.bottom_layout)
    LinearLayout bottomLayout;


    //选择好的穴位显示的适配器
    private GridviewChoseAdapter adapter;
    private List<User> datas;
    //显示治疗穴位的适配器
    private GridViewCureAdapter cureAdapter;
    private List<User> acupDatas;
    //选择穴位和取消穴位选择
    private boolean isTag =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //返回按钮
        Intent intent = getIntent();
        title.setText(intent.getStringExtra("illness"));
        //backText.setBackgroundResource(R.drawable.iconfont_xialakuang);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //穴位选择适配器
        initDatas();
        adapter = new GridviewChoseAdapter(IllnessTreatActivity.this);
        adapter.setList(datas);
        gridChose.setAdapter(adapter);


        //概述
        tvContent.setText("小儿惊风是以四肢抽搐，空进不开，佳洁士，一般以1到5随的小孩常见，整整下哦那个线可以危险声明");

        //临床表现
        tvStyle1.setText("1、急惊风，发病快速，下哦那个梦收到");
        tvStyle2.setText("2、慢惊风，白日依山尽，黄河入海流，欲穷千里目，更上一层楼。白日依山尽，黄河入海流，欲穷千里目，更上一层楼。" +
                "白日依山尽，黄河入海流，欲穷千里目，更上一层楼。");
        tvStyle2.setVisibility(View.VISIBLE);

        //治疗方案
        initAcupDatas();
        cureAdapter =new GridViewCureAdapter(this);
        cureAdapter.setList(acupDatas);
        itemCureGview.setAdapter(cureAdapter);




        //选择穴位
        choseAcup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isTag){
                    choseAcup.setText("取消选择");
                    choseMethod.setTextColor(Color.parseColor("#6eb2f6"));
                    isTag =true;
                }else {
                    isTag =false;
                    choseAcup.setText("选择穴位");
                }
            }
        });

        //点击事件
        choseMethod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //EventBus.getDefault().postSticky(datas);
                //startActivity(new Intent(IllnessTreatActivity.this,CureMethodActivity.class));
              ArrayList<String> items =null;
                    if (isTag){
                        //选择了穴位才可以点击跳转
                        if (datas!=null && datas.size()>0){
                            items =new ArrayList<String>();
                            for (int i = 0; i <datas.size() ; i++) {
                                items.add(datas.get(i).getName());
                            }
                        }

                        Intent intent =new Intent(IllnessTreatActivity.this,CureMethodActivity.class);
                        Bundle b =new Bundle();
                        b.putStringArrayList("data",items);
                        intent.putExtras(b);
                        startActivity(intent);


                }
            }
        });
        setclick();

    }

    private void setclick() {

        itemCureGview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (!isTag){        //处于未选择穴位的状态
                    startActivity(new Intent(IllnessTreatActivity.this,AcupointMsgActivity.class));
                }else {             //处于选择穴位的状态
                    //适配器的数据变动，并且通知适配器相应更新
                    if (datas !=null && datas.size()>0){
                      if (datas.contains(acupDatas.get(i))){
                          for (int j = 0; j <datas.size() ; j++) {
                              if (datas.get(j).equals(acupDatas.get(i))){
                                  datas.remove(j);
                                  break;
                              }
                          }
                      }else {
                          datas.add(acupDatas.get(i));
                      }

                    }else {
                        datas.add(acupDatas.get(i));
                    }
                    //通知适配器发生变化
                   // adapter.notifyDataSetChanged();
                    Logger.i("---","-----"+datas.size());
                    adapter.setList(datas);

                }
            }
        });

    }

    private void initAcupDatas() {
        acupDatas =new ArrayList<>();
        User user1 = new User(R.drawable.head, "足穴");
        User user2 = new User(R.drawable.head, "笑穴");
        User user3 = new User(R.drawable.head, "太阳穴");
        User user4 = new User(R.drawable.head, "大股东");
        User user5 = new User(R.drawable.head, "大股东");
        acupDatas.add(user1);
        acupDatas.add(user2);
        acupDatas.add(user3);
        //acupDatas.add(user4);
        //acupDatas.add(user5);
    }

    private void initDatas() {
        datas = new ArrayList<>();
        User user1 = new User(R.drawable.head, "威锋网");
        User user2 = new User(R.drawable.head, "XW");
        User user3 = new User(R.drawable.head, "锋网");
        User user4 = new User(R.drawable.head, "大股东");
        User user5 = new User(R.drawable.head, "大股东");

        datas.add(user1);
        datas.add(user2);
        datas.add(user3);
        datas.add(user4);
        datas.add(user5);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_illness_treat;
    }
}
