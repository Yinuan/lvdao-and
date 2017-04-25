package com.hg.jacob.lvdao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jacob.lvdao.R;
import com.hg.jacob.lvdao.otto.BusProvide;
import com.squareup.otto.Subscribe;

import butterknife.ButterKnife;

/**
 * author : yinjuan
 * time： 2017/3/28 10:22
 * email：yin.juan@yuendong.com
 * Description:描述
 */
public class FragmentFive extends Fragment implements View.OnClickListener {





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fagment_five, null);
        ButterKnife.bind(this, view);


        return view;
    }



    @Override
    public void onPause() {
        super.onPause();
        BusProvide.getInstance().unregister(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        BusProvide.getInstance().register(this);
    }

    /**
     * 接受碎片1发过来的数据
     */


    @Subscribe
    public void getDatas(String str) {
        Log.d("-----","--事件---"+str);

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
