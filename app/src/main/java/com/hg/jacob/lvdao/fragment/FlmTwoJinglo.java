package com.hg.jacob.lvdao.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.jacob.lvdao.R;
import com.hg.jacob.lvdao.adapter.UserAdapter;
import com.hg.jacob.lvdao.base.BaseFragment;
import com.hg.jacob.lvdao.entry.User;
import com.hg.jacob.lvdao.widget.ClearEditText;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import okhttp3.Call;
import okhttp3.Response;

/**
 * author : yinjuan
 * time： 2017/3/30 10:42
 * email：yin.juan@yuendong.com
 * Description:经咯
 */
public class FlmTwoJinglo extends BaseFragment {


    @Bind(R.id.search)
    ClearEditText search;
    @Bind(R.id.list_view)
    ListView listView;


    private UserAdapter adapter;
    private List<User> datas;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        //初始化数据
        initdatas();
        //点击事件
        initcheck();

        adapter =new UserAdapter(getActivity(),datas);
        listView.setAdapter(adapter);
        return mView;
    }

    private void initcheck() {
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

    private void initdatas() {

        datas =new ArrayList<>();
        User user1 =new User(R.drawable.head,"足阳明胃经");
        User user2 =new User(R.drawable.head,"手少阴心经");
        User user3 =new User(R.drawable.head,"大力金刚经");

        datas.add(user1);
        datas.add(user2);
        datas.add(user3);

        Loa();

    }
    private void Loa(){
        Log.d("--","-onSuccess-");
        OkHttpUtils.post("http://192.168.1.21:8080/forms/FrmApplicationInterface.applicationSearch")
                .params("mer","haha")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Log.d("--","-onSuccess-"+s);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        Log.d("--","-onError-"+e);
                    }
                });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.flm_two_jinglo;
    }

    @Override
    protected void initLayout() {
        Drawable leftDrawable = search.getCompoundDrawables()[0];
        if(leftDrawable!=null){
            leftDrawable.setBounds(0, 0, 60, 60);
            search.setCompoundDrawables(leftDrawable, search.getCompoundDrawables()[1], search.getCompoundDrawables()[2],
                    search.getCompoundDrawables()[3]);
        }
    }

    @Override
    public void loadLayout() {

    }
}
