package com.hg.jacob.lvdao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jacob.lvdao.R;
import com.hg.jacob.lvdao.eventBus.EventMessage;
import com.hg.jacob.lvdao.unit.GlobalTools;
import com.hg.jacob.lvdao.widget.anima.LoadingDialogProgress;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SendActivity extends AppCompatActivity {

    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.button2)
    Button button2;
    @Bind(R.id.button3)
    Button button3;

    private LoadingDialogProgress progress;//加载数据的进度条动画

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        ButterKnife.bind(this);
        //注册
        EventBus.getDefault().register(this);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progress = GlobalTools.getInstance().showDailog(SendActivity.this, "加载");

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progress.dismiss();
            }
        });
    }

    /**
     * 接受消息的方法
     * threadModle有四种
     * 1.posting 默认的。哪个线程发出就在哪个线程运行/避免过多运算，否则ANR
     * 2.MAIN。主线程运行，一般进行UI界面更新，操作
     * 3.ASYNC  无论怎么样都开辟子线程来运行，禁止UI更新
     * 4.BACKGROUP 在主线程时则继续在主线程中运行，在子线程中则继续在子线程中运行，禁止UI操作
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getMsg(EventMessage msg) {
        textView.setText(msg.getMessage());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
