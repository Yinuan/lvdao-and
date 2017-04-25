package com.hg.jacob.lvdao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jacob.lvdao.R;
import com.hg.jacob.lvdao.base.BaseFragment;

import butterknife.Bind;

;
;

/**
 * author : yinjuan
 * time： 2017/3/28 10:22
 * email：yin.juan@yuendong.com
 * Description:含有两个碎片
 */
public class FragmentTwo extends BaseFragment implements View.OnClickListener {


    @Bind(R.id.pager)
    ViewPager pager;
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;


    private static final String TAG = "FragmentTwo";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return mView;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_two;
    }

    /**
     * 初始化控件
     */
    @Override
    protected void initLayout() {
       // pager.setVisibility(View.VISIBLE);
       // pager.setAdapter(new PagerAdapter(getChildFragmentManager()));
       // tabLayout.setupWithViewPager(pager);


    }



    @Override
    public void loadLayout() {

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    public class PagerAdapter extends FragmentPagerAdapter {


        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new FlmTwoJinglo();
                case 1:
                default:
                    return new FlmTwoBuwei();

            }

        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "经络";
                case 1:
                default:
                    return "部位";
            }

        }
    }
}
