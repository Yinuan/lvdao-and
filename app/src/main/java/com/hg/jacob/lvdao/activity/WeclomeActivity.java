package com.hg.jacob.lvdao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.jacob.lvdao.R;
import com.hg.jacob.lvdao.MainUIActivity;
import com.hg.jacob.lvdao.base.BaseActivity;

public class WeclomeActivity extends BaseActivity {


    private Handler mHandle = new Handler() {
        public void handleMessage(android.os.Message msg) {
			/*
			 * // 如果有更新就提示 if (isNeedUpdate()) { //在下面的代码段 showUpdateDialog();
			 * //下面的代码段 }
			 */
            switch (msg.what){
                case 0:
                    startActivity(new Intent(WeclomeActivity.this, MainUIActivity.class));
                    break;
            }
        };
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //跳转界面
        skipUi();
    }

    private void skipUi() {
      mHandle.sendEmptyMessageDelayed(0,2000);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_weclome;
    }
}
