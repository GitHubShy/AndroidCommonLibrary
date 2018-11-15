package com.common.shy.commonutils.dispatcher;

import com.alibaba.android.arouter.launcher.ARouter;

public class ActivityDispatcher {

    public static final String ENG_CATALOGUE_ACTIVITY = "/test/activity";

    public static final String ENG_SPELLING_ACTIVITY = "/test/SpellingActivity";

    public static void toSpellingActivity (String title) {
        ARouter.getInstance().build(ENG_SPELLING_ACTIVITY).withString("title",title).navigation();
    }
}
