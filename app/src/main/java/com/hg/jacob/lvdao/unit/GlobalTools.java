package com.hg.jacob.lvdao.unit;

import android.content.Context;
import android.widget.Toast;

import com.hg.jacob.lvdao.widget.anima.LoadingDialogProgress;

/**
 * author : yinjuan
 * time： 2017/4/24 10:13
 * email：yin.juan2016@outlook.com
 * Description:单列模式，减少内存开销
 */
public class GlobalTools {

    /**
     * 构造方法描述:私有构造方法
     * @param
     */
    private GlobalTools() {
    }

    /**
     * 构造方法描述:获取实例
     *
     * @return 返 回 类 型:Utils
     */
    public static GlobalTools getInstance() {
        return SingletonHolder.instance;
    }


    private static class SingletonHolder {
        private static GlobalTools instance = new GlobalTools();

    }


    private LoadingDialogProgress progress;//动画
    /**
     * 构造方法描述:动画加载获取实例
     *
     * @return 返 回 类 型:LoadingDialogProgress
     */
    public LoadingDialogProgress showDailog(Context context, String content)
    {
        progress = LoadingDialogProgress.show(context,content+"..." , true, null);

        return progress;
    }

    private Toast toast = null;

    /**
     * @方法说明：用于控制同一Toast不重复弹出（提示时间较短）
     * @参数详解：context 上下文引用；hint 内容
     * @作者：StriveDoby
     */
    public void getShortToastByString(Context context, String hint) {
        if (toast == null) {
            toast = Toast.makeText(context, hint, Toast.LENGTH_SHORT);
        } else {
            toast.setText(hint);
            toast.setDuration(Toast.LENGTH_SHORT);
        }

        toast.show();
    }

    /**
     * @方法说明：用于控制同一Toast不重复弹出（提示时间较长）
     * @参数详解：context 上下文引用；hint 内容
     * @作者：StriveDoby
     */
    public void getLongToastByString(Context context, String hint) {
        if (toast == null) {
            toast = Toast.makeText(context, hint, Toast.LENGTH_LONG);
        } else {
            toast.setText(hint);
            toast.setDuration(Toast.LENGTH_LONG);
        }

        toast.show();
    }

    /**
     * @方法说明：字面上的意思
     * @参数详解：type,选择Toast显示时间长短;context,上下文引用;hint,Toast内容
     * @作者：StriveDoby
     */
    public void showToast(int type, Context context, String hint) {
        if (type == 0) {
            getShortToastByString(context, hint);
        } else {
            getLongToastByString(context, hint);
        }
    }
}
