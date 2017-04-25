package com.hg.jacob.lvdao.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jacob.lvdao.R;
import com.hg.jacob.lvdao.base.BaseActivity;
import com.hg.jacob.lvdao.fragment.MusicPT;
import com.hg.jacob.lvdao.fragment.MusicSL;

import butterknife.Bind;

public class MusicCureActivity extends BaseActivity {

    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.pager)
    ViewPager pager;
    @Bind(R.id.back_text)
    TextView backText;
    @Bind(R.id.back_btn)
    LinearLayout backBtn;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.add_method)
    TextView addMethod;
    @Bind(R.id.add_method_iv)
    ImageView addMethodIv;
    @Bind(R.id.back_layout)
    RelativeLayout backLayout;
    @Bind(R.id.lauou_s)
    LinearLayout lauouS;
    @Bind(R.id.activity_music_cure)
    LinearLayout activityMusicCure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();

    }

    private void initView() {
        //显示添加按钮
        addMethod.setVisibility(View.VISIBLE);
        addMethod.setText("选择穴位");
        //返回按钮
        title.setText("开始治疗");
        // backText.setBackgroundResource(R.drawable.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        pager.setVisibility(View.VISIBLE);
        pager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(pager);

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_music_cure;
    }


    public class PagerAdapter extends FragmentPagerAdapter {


        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new MusicPT();
                case 1:
                default:
                    return new MusicSL();

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
                    return "普通模式";
                case 1:
                default:
                    return "音乐模式";
            }

        }
    }
}
