package com.hg.jacob.lvdao.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jacob.lvdao.R;
import com.hg.jacob.lvdao.base.BaseActivity;

import butterknife.Bind;

public class RegistActivity extends BaseActivity implements View.OnClickListener {

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
    @Bind(R.id.regist_mobile)
    EditText registMobile;
    @Bind(R.id.regist_code)
    EditText registCode;
    @Bind(R.id.get_code)
    LinearLayout getCode;
    @Bind(R.id.regist_pass)
    EditText registPass;
    @Bind(R.id.regist_pass_agin)
    EditText registPassAgin;
    @Bind(R.id.regist)
    LinearLayout regist;
    @Bind(R.id.activity_regist)
    LinearLayout activityRegist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //顶部菜单
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        title.setText(getResources().getString(R.string.regist));
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_regist;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.get_code:     //获取验证码
                break;
            case R.id.regist:     //确认
                //判断两次输入 密码是否相同
                break;

        }
    }
}
