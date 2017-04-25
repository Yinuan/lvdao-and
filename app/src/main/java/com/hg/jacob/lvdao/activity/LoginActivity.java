package com.hg.jacob.lvdao.activity;

import android.content.Intent;
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

public class LoginActivity extends BaseActivity implements View.OnClickListener{

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
    @Bind(R.id.login_mobile)
    EditText loginMobile;
    @Bind(R.id.login_pass)
    EditText loginPass;
    @Bind(R.id.forget_pass)
    TextView forgetPass;
    @Bind(R.id.sign_up)
    TextView signUp;
    @Bind(R.id.activity_login)
    LinearLayout activityLogin;
    @Bind(R.id.login)
    LinearLayout login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //顶部菜单栏
        backBtn.setVisibility(View.GONE);
        title.setText(getResources().getString(R.string.login));
        title.setTextSize(18);

        forgetPass.setOnClickListener(this);
        signUp.setOnClickListener(this);


    }



    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    //点击事件
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.forget_pass:  //忘记密码
                startActivity(new Intent(LoginActivity.this,ForgetPassActivity.class));
                break;
            case R.id.login:  //登录
                break;
            case R.id.sign_up:  //立即注册
                startActivity(new Intent(LoginActivity.this,RegistActivity.class));
                break;
        }
    }
}
