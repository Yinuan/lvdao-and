package com.hg.jacob.lvdao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jacob.lvdao.R;

import butterknife.ButterKnife;

/**
 * author : yinjuan
 * time： 2017/3/28 14:34
 * email：yin.juan@yuendong.com
 * Description:描述
 */
public class LiteFra extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.flm_two_jinglo, null);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
