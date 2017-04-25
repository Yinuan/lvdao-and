package com.hg.jacob.lvdao.entry;

/**
 * author : yinjuan
 * time： 2017/4/1 16:30
 * email：yin.juan2016@outlook.com
 * Description:常用方案实体类
 */
public class MethodBean {

    private String name;//方案名
    private String work;//方案适应症

    public MethodBean(String name, String work) {
        this.name = name;
        this.work = work;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
}

