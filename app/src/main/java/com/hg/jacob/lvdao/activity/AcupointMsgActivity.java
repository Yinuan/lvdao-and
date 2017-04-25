package com.hg.jacob.lvdao.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jacob.lvdao.R;
import com.hg.jacob.lvdao.base.BaseActivity;

import butterknife.Bind;

public class AcupointMsgActivity extends BaseActivity {

    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.back_btn)
    LinearLayout backBtn;
    @Bind(R.id.back_text)
    TextView backText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title.setText("穴位介绍");
        //backText.setBackgroundResource(R.drawable.iconfont_xialakuang);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_acupoint_msg;
    }


}
