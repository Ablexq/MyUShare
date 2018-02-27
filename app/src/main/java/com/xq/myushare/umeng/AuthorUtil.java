package com.xq.myushare.umeng;

import android.app.Activity;
import android.util.Log;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

/**
 * 授权登录工具类
 */

public class AuthorUtil {

    private static String TAG = AuthorUtil.class.getSimpleName();

    //授权
    public static void authorization(Activity activity, SHARE_MEDIA share_media) {
        UMShareAPI.get(activity).getPlatformInfo(activity, share_media, new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {
                Log.d(TAG, "onStart===" + "授权开始");
            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                Log.d(TAG, "onComplete===" + "授权完成");

                //sdk是6.4.4的,但是获取值的时候用的是6.2以前的(access_token)才能获取到值,未知原因
                String uid = map.get("uid");
                String openid = map.get("openid");//微博没有
                String unionid = map.get("unionid");//微博没有
                String access_token = map.get("access_token");
                String refresh_token = map.get("refresh_token");//微信,qq,微博都没有获取到
                String expires_in = map.get("expires_in");
                String name = map.get("name");
                String gender = map.get("gender");
                String iconurl = map.get("iconurl");

                Log.e(TAG, "uid===" + uid +
                        "\n,openid=" + openid +
                        "\n,unionid=" + unionid +
                        "\n,access_token=" + access_token +
                        "\n,refresh_token=" + refresh_token +
                        "\n,expires_in=" + expires_in +
                        "\n,name=" + name +
                        "\n,gender=" + gender +
                        "\n,iconurl=" + iconurl
                );
                //拿到信息去请求登录接口。。。
            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                Log.d(TAG, "onError===" + "授权失败");
            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {
                Log.d(TAG, "onCancel===" + "授权取消");
            }
        });
    }
}