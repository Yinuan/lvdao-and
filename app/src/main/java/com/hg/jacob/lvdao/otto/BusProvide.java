package com.hg.jacob.lvdao.otto;

import com.squareup.otto.Bus;

/**
 * author : yinjuan
 * time： 2017/3/29 10:12
 * email：yin.juan@yuendong.com
 * Description:bus事件单列
 */
public final class BusProvide {

    //静态的，私有的Bus实例
    private static final Bus bus =new Bus();



    //公开的静态的获取单列
    public static Bus getInstance(){
        return bus;
    }

   //类的构造
    private BusProvide(){}
}
