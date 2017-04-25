package com.hg.jacob.lvdao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.jacob.lvdao.R;
import com.hg.jacob.lvdao.adapter.PartAdapter;
import com.hg.jacob.lvdao.base.BaseFragment;
import com.hg.jacob.lvdao.entry.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * author : yinjuan
 * time： 2017/3/28 10:22
 * email：yin.juan@yuendong.com
 * Description:描述
 */
public class FragmentThree extends BaseFragment {


    @Bind(R.id.list_view)
    ListView listView;

    private PartAdapter adapter;
    private List<User> datas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        initData();
        setOnclick();
       // adapter =new PartAdapter(getActivity(),datas);
       // listView.setAdapter(adapter);
        return mView;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_three;
    }

    @Override
    protected void initLayout() {
        //用于初始化控件

    }

    private void setOnclick() {
    }

    private void initData() {
        datas =new ArrayList<>();
        User user1 =new User(R.drawable.head,"内科");
        User user2 =new User(R.drawable.head,"皮肤科");
        User user3 =new User(R.drawable.head,"妇科");
        User user4 =new User(R.drawable.head,"骨伤科");


        datas.add(user1);
        datas.add(user2);
        datas.add(user3);
        datas.add(user4);
    }

    @Override
    public void loadLayout() {
        //懒加载


    }



}
