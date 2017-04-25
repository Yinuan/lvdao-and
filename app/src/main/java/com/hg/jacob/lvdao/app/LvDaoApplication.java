package com.hg.jacob.lvdao.app;

import android.app.Application;
import android.content.Context;

import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.cache.CacheEntity;

/**
 * author : yinjuan
 * time： 2017/3/30 09:32
 * email：yin.juan@yuendong.com
 * Description:Application类。全局的初始化
 */
public class LvDaoApplication extends Application{

    //上下文
    private static Context context;
    //类对象
    private static LvDaoApplication app =null;

    @Override
    public void onCreate() {
        super.onCreate();
        context =getApplicationContext();
        app=this;
        OkhttpInit();
    }

    public static LvDaoApplication getInstance(){

        return app;
    }

    /**初始化OKHttp**/
    private void  OkhttpInit()
    {
        //必须调用初始化
        OkHttpUtils.init(this);

        //以下都不是必须的，根据需要自行选择,一般来说只需要 debug,缓存相关,cookie相关的 就可以了
        OkHttpUtils.getInstance()

                //打开该调试开关,控制台会使用 红色error 级别打印log,并不是错误,是为了显眼,不需要就不要加入该行
                //.debug("OkHttpUtils")

                //如果使用默认的 60秒,以下三行也不需要传
                .setConnectTimeout(20000)               //全局的连接超时时间
                .setReadTimeOut(20000)                  //全局的读取超时时间
                .setWriteTimeOut(20000)                 //全局的写入超时时间

                //可以全局统一设置缓存模式,默认就是Default,可以不传,具体其他模式看 github 介绍 https://github.com/jeasonlzy0216/
                // .setCacheMode(CacheMode.DEFAULT)

                //可以全局统一设置缓存时间,默认永不过期,具体使用方法看 github 介绍
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE);
        // .setCacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST);

        //如果不想让框架管理cookie,以下不需要
//                .setCookieStore(new MemoryCookieStore())    //cookie使用内存geg缓存（app退出后，cookie消失）
        //  .setCookieStore(new PersistentCookieStore());     //cookie持久化存储，如果cookie不过期，则一直有效

        //可以添加全局拦截器,不会用的千万不要传,错误写法直接导致任何回调不执行
//                .addInterceptor(new Interceptor() {
//                    @Override
//                    public Response intercept(Chain chain) throws IOException {
//                        return chain.proceed(chain.request());
//                    }
//                })
    }
}
