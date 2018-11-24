package com.common.shy.basemodule.dispatcher;

import com.alibaba.android.arouter.launcher.ARouter;

public class ActivityDispatcher {

    public static final String ENG_CATALOGUE_ACTIVITY = "/test/activity";

    public static final String ENG_SPELLING_ACTIVITY = "/test/SpellingActivity";

    public static final String ENG_DATA_BINDING_ACTIVITY = "/test/DataBindingActivity";

    public static void toSpellingActivity (String title) {
        ARouter.getInstance().build(ENG_SPELLING_ACTIVITY).withString("title",title).navigation();
    }

    public static void toCatalogueActivity () {
        ARouter.getInstance().build(ENG_CATALOGUE_ACTIVITY).navigation();
    }

    public static void toDataBindingActivity () {
        ARouter.getInstance().build(ENG_DATA_BINDING_ACTIVITY).navigation();
    }
}
