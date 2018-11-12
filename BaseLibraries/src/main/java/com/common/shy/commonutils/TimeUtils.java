package com.common.shy.commonutils;

public class TimeUtils {

    private String TAG = "TimeUtils";

    private long beginTime;
    private long endTime;
    private long timeInterval;

    public void beginRecording() {
        beginTime = System.currentTimeMillis();
    }

    public void endRecording() {
        endTime = System.currentTimeMillis();
        timeInterval = (endTime - beginTime);
        Logger.e(TAG, "timeInterval=" + timeInterval);
    }
}
