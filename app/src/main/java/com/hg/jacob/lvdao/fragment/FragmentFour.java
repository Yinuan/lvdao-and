package com.hg.jacob.lvdao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jacob.lvdao.R;

import butterknife.ButterKnife;

/**
 * author : yinjuan
 * time： 2017/3/28 10:22
 * email：yin.juan@yuendong.com
 * Description:描述
 */
public class FragmentFour extends android.support.v4.app.Fragment implements View.OnClickListener {




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show, null);
        ButterKnife.bind(this, view);

        return view;
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
