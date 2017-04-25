package com.hg.jacob.lvdao.entry;

/**
 * author : yinjuan
 * time： 2017/4/24 14:12
 * email：yin.juan2016@outlook.com
 * Description:设备信息实体类
 */
public class DeciveBean {

    private String name ;  //设备名
    private String state;   //设备状态

    public DeciveBean(String name, String state) {
        this.name = name;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
