package com.common.shy.basemodule.dispatcher;

import com.alibaba.android.arouter.launcher.ARouter;

public class ActivityDispatcher {

    public static final String ENG_CATALOGUE_ACTIVITY = "/eng/activity";

    public static final String ENG_SPELLING_ACTIVITY = "/eng/SpellingActivity";

    public static final String ENG_DATA_BINDING_ACTIVITY = "/eng/DataBindingActivity";

    public static final String INTER_SERVICE_FIRST_ACTIVITY = "/interview/FirstActivity";

    public static final String INTER_SERVICE_SECOND_ACTIVITY = "/interview/SecondActivity";

    public static void toSpellingActivity (String title) {
        ARouter.getInstance().build(ENG_SPELLING_ACTIVITY).withString("title",title).navigation();
    }

    public static void toCatalogueActivity () {
        ARouter.getInstance().build(ENG_CATALOGUE_ACTIVITY).navigation();
    }

    public static void toDataBindingActivity () {
        ARouter.getInstance().build(ENG_DATA_BINDING_ACTIVITY).navigation();
    }
    public static void toServiceFirstActivity () {
        ARouter.getInstance().build(INTER_SERVICE_FIRST_ACTIVITY).navigation();
    }
    public static void toServiceSecondActivity () {
        ARouter.getInstance().build(INTER_SERVICE_SECOND_ACTIVITY).navigation();
    }
}
