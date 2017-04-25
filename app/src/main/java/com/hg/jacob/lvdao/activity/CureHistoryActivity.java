package com.hg.jacob.lvdao.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jacob.lvdao.R;
import com.hg.jacob.lvdao.adapter.CureHistoryAdapter;
import com.hg.jacob.lvdao.base.BaseActivity;
import com.hg.jacob.lvdao.entry.AcupSetBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class CureHistoryActivity extends BaseActivity {

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
    @Bind(R.id.lv_history)
    ListView lvHistory;
    @Bind(R.id.history_null)
    LinearLayout historyNull;

    private CureHistoryAdapter adapter;
    private List<AcupSetBean> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //返回按钮

        title.setText("治疗历史");
       // backText.setBackgroundResource(R.drawable.iconfont_xialakuang);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //设置listview显示
        initDatas();
        adapter = new CureHistoryAdapter(this);
        adapter.setList(datas);
        if (datas != null && datas.size() > 0) {
            lvHistory.setAdapter(adapter);
            historyNull.setVisibility(View.GONE);
        }else {
            historyNull.setVisibility(View.VISIBLE);
        }


    }

    private void initDatas() {
        datas = new ArrayList<>();
        datas.add(new AcupSetBean("2017-3-30-16:00", "承满 大亨", "普通模式"));
        datas.add(new AcupSetBean("2017-3-30-16:00", "承满 大亨", "普通模式"));
        datas.add(new AcupSetBean("2017-3-30-16:00", "承满 大亨", "普通模式"));

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_cure_history;
    }
}
