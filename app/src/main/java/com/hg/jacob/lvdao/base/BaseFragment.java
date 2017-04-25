package com.hg.jacob.lvdao.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;

/**
 * author : yinjuan
 * time： 2017/3/30 09:41
 * email：yin.juan@yuendong.com
 * Description:fragment基类
        */
public abstract class BaseFragment extends Fragment {

    protected View mView;//视图
    //   界面是否显示
    protected boolean isVisiable;
    //布局是否加载完成
    protected boolean isPrepared;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //构建布局
        mView = inflater.inflate(getLayoutId(), container, false);
        //黄油刀
        ButterKnife.bind(this,mView);
        //界面布局及加载初始化
        isPrepared=true;
        isPrepared=true;
        //初始化控件
        initLayout();
        //打印日记的初始化
        Logger.init().hideThreadInfo().setLogLevel(LogLevel.FULL);

        return mView;
    }

    /**
     * 加载布局文件
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 加载控件
     */

    protected abstract void initLayout();

    /**
     * 懒加载的设计
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            //碎片显示
            onVisible();
        }else {
            //不显示碎片
            onInvisiable();
        }
    }

    /**
     * 不显示碎片
     */
    private void onInvisiable() {
    }

    /**
     * 显示碎片
     */
    private void onVisible() {
        loadLayout();
    }

    /**
     * 初始化布局
     */
    public abstract void loadLayout();

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
