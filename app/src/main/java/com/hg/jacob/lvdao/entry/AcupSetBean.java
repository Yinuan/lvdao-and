package com.hg.jacob.lvdao.entry;

/**
 * author : yinjuan
 * time： 2017/4/1 10:22
 * email：yin.juan2016@outlook.com
 * Description:x穴位治疗信息的设置
 */
public class AcupSetBean {

    private String num;  //序号
    private String acupName;//穴位名字
    private String model;//治疗的模式
    private String strength;//治疗的强度
    private String rate;//穴位治疗的频率
    private String time;//穴位治疗设置的是时间


    public AcupSetBean(String num, String acupName, String model, String strength, String rate, String time) {
        this.num = num;
        this.acupName = acupName;
        this.model = model;
        this.strength = strength;
        this.rate = rate;
        this.time = time;
    }

    public AcupSetBean(String time, String acupName, String model) {
        this.time = time;
        this.acupName = acupName;
        this.model = model;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getAcupName() {
        return acupName;
    }

    public void setAcupName(String acupName) {
        this.acupName = acupName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
