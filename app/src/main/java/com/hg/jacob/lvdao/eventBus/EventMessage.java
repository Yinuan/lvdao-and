package com.hg.jacob.lvdao.eventBus;

/**
 * author : yinjuan
 * time： 2017/3/29 14:46
 * email：yin.juan@yuendong.com
 * Description:描述
 */
public class EventMessage {

    private   String message;

    public EventMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
