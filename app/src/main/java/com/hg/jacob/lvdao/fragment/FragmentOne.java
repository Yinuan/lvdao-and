package com.hg.jacob.lvdao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.jacob.lvdao.R;
import com.hg.jacob.lvdao.activity.MethodEidtActivity;
import com.hg.jacob.lvdao.activity.MusicCureActivity;
import com.hg.jacob.lvdao.activity.MyDeciveActivity;
import com.hg.jacob.lvdao.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * author : yinjuan
 * time： 2017/3/28 10:20
 * email：yin.juan@yuendong.com
 * Description:碎片1发送一个东西
 */
public class FragmentOne extends BaseFragment implements View.OnClickListener {


    @Bind(R.id.one_btn_left)
    RelativeLayout oneBtnLeft;
    @Bind(R.id.one_btn_right)
    RelativeLayout oneBtnRight;
    @Bind(R.id.search_decive)
    ImageView searchDecive;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        //点击事件
        setonclick();

        ButterKnife.bind(this, mView);
        return mView;
    }

    private void setonclick() {

        oneBtnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 startActivity(new Intent(getActivity(), MethodEidtActivity.class));
            }
        });

        oneBtnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  startActivity(new Intent(getActivity(), CommenMethodActivity.class));
                startActivity(new Intent(getActivity(), MusicCureActivity.class));
            }
        });

        searchDecive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MyDeciveActivity.class));
            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_one;
    }

    @Override
    protected void initLayout() {

    }

    @Override
    public void loadLayout() {

    }

    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();


    }


    @Override
    public void onClick(View view) {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
