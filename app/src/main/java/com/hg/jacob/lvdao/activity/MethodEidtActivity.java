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
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jacob.lvdao.R;
import com.hg.jacob.lvdao.adapter.GridviewChoseAdapter;
import com.hg.jacob.lvdao.base.BaseActivity;
import com.hg.jacob.lvdao.entry.User;
import com.hg.jacob.lvdao.widget.WheelView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;

public class MethodEidtActivity extends BaseActivity {

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

    private static final String[] MODEL = new String[]{"连续", "间接", "疏密", "循环"};
    private static final String[] STRONG = new String[]{"10", "20", "30", "40"};
    private static final String[] RATE = new String[]{"10", "20", "30", "40"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //顶部菜单栏
        Intent intent = getIntent();
        title.setText("编辑");
        //backText.setBackgroundResource(R.drawable.iconfont_xialakuang);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
        addMethod.setText(R.string.chosed_acup);
        addMethod.setVisibility(View.VISIBLE);

        initdatas();
        //穴位选择适配器
        if (datas.size()>0 && datas !=null){
            adapter = new GridviewChoseAdapter(this);
            adapter.setList(datas);
            gridChose.setAdapter(adapter);
            gridChose.setVisibility(View.VISIBLE);
            hintAcupChosed.setVisibility(View.GONE);
            gridChose.setColumnWidth(120);
        }else {
            gridChose.setVisibility(View.GONE);

            hintAcupChosed.setVisibility(View.VISIBLE);
        }

        //点击事件
        setclick();

    }

    private void setclick() {
        //穴位选择
        addAcup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //模式选择
        addModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCure(Arrays.asList(MODEL),1);
            }
        });
        //频率选择
        addRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCure(Arrays.asList(RATE),2);
            }
        });
        //强度选择
        addStrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCure(Arrays.asList(STRONG),3);
            }
        });
        //时间选择
        addTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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


    /**
     * 处理选择模式/强度/频率等
     * @param
     */
    private void setCure(final List<String> data, final int num)
    {
        final String[] items = {null};
        //加载pop布局
        View view1 = LayoutInflater.from(MethodEidtActivity.this).inflate(R.layout.pop_bottom_item, null);
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

        activityMethodMsg.setBackgroundColor(getResources().getColor(R.color.bg_gray));
        tv_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityMethodMsg.setBackgroundColor(getResources().getColor(R.color.white));
                popupWindow.dismiss();
            }
        });
        tv_confrim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //取值
                String str =items[0];
                //更改数据
                activityMethodMsg.setBackgroundColor(getResources().getColor(R.color.white));
                popupWindow.dismiss();
                switch (num){
                    case 0:
                        break;
                    case 1:
                        addModel.setText(str);
                        break;
                    case 2:
                        addRate.setText(str);
                        break;
                    case 3:
                        addStrong.setText(str);
                        break;
                    case 4:
                        addTime.setText(str);
                        break;
                }

            }
        });

    }

}
