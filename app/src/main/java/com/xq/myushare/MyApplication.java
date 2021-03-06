package com.xq.myushare;

import android.app.Application;

import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 *
 */

public class MyApplication extends Application {

    {
        PlatformConfig.setWeixin("wx967daebe835fbeac", "25937a3df443a3d21c70219e1778fd2e");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        UMShareAPI.get(this);
        Config.DEBUG = true;
    }


}
