package com.common.shy.commonutils.utils;

import android.graphics.Bitmap;
import android.view.View;

public class BitmapUtils {

    public static Bitmap ViewToBitmap(View view) {
        //开启绘图缓存
        view.setDrawingCacheEnabled(true);
        //这个方法可调可不调，因为在getDrawingCache()里会自动判断有没有缓存有没有准备好，
        //如果没有，会自动调用buildDrawingCache()
        view.buildDrawingCache();
        //获取绘图缓存 这里直接创建了一个新的bitmap
        //因为我们在最后需要释放缓存资源，会释放掉缓存中创建的bitmap对象
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache(), 0, 0, view.getMeasuredWidth(),
                view.getMeasuredHeight());
        //清理绘图缓存，释放资源
        view.destroyDrawingCache();
        return bitmap;
    }
}
