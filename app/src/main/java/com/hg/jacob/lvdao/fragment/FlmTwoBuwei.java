package com.hg.jacob.lvdao.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.jacob.lvdao.R;
import com.hg.jacob.lvdao.adapter.UserAdapter;
import com.hg.jacob.lvdao.base.BaseFragment;
import com.hg.jacob.lvdao.entry.User;
import com.hg.jacob.lvdao.widget.ClearEditText;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * author : yinjuan
 * time： 2017/3/31 10:15
 * email：yin.juan@yuendong.com
 * Description:描述
 */
public class FlmTwoBuwei extends BaseFragment {


    @Bind(R.id.search)
    ClearEditText search;
    @Bind(R.id.list_view_buwei)
    ListView list_view_buwei;

    private UserAdapter adapter;
    private List<User> datas;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        initData();
        setCheck();

        adapter =new UserAdapter(getActivity(),datas);
        list_view_buwei.setAdapter(adapter);
        return mView;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.flm_two_buwei;
    }


    @Override
    protected void initLayout() {
        //用于初始化一控件
        Drawable leftDrawable = search.getCompoundDrawables()[0];
        if(leftDrawable!=null){
            leftDrawable.setBounds(0, 0, 60, 60);
            search.setCompoundDrawables(leftDrawable, search.getCompoundDrawables()[1], search.getCompoundDrawables()[2],
                    search.getCompoundDrawables()[3]);
        }

    }

    private void initData() {
        datas =new ArrayList<>();
        User user1 =new User(R.drawable.head,"头部");
        User user2 =new User(R.drawable.head,"面部");

        datas.add(user1);
        datas.add(user2);

    }

    private void setCheck() {
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    /**
     * 懒加载，用户可见状态运行
     */
    @Override
    public void loadLayout() {


    }




}
