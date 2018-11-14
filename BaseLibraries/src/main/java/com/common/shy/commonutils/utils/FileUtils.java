package com.common.shy.commonutils.utils;

import android.content.Context;
import android.graphics.Bitmap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtils {

    /**
     * Copy a file from asserts to SD card
     *
     * @param assertFileName
     * @param destinationPath
     */
    public static boolean assetsToSD(String assertFileName, String destinationPath, Context context) {
        File file = new File(destinationPath);
        if (!file.exists()) {
            if (!file.mkdirs()) {
                return false;
            }
        }
        try {
            InputStream inputStream = context.getAssets().open(assertFileName);
            File outFile = new File(file, assertFileName);
            FileOutputStream fileOutputStream = new FileOutputStream(outFile);
            byte[] buffer = new byte[1024];
            int byteRead;
            while (-1 != (byteRead = inputStream.read(buffer))) {
                fileOutputStream.write(buffer, 0, byteRead);
            }
            inputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void bitmapToFile(Bitmap src, File file) {
        try {// 写入图片
            FileOutputStream fos = new FileOutputStream(file);
            src.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
