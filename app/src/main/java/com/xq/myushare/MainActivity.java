package com.xq.myushare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.xq.myushare.umeng.AuthorUtil;
import com.xq.myushare.umeng.Defaultcontent;
import com.xq.myushare.umeng.ShareUtils;

public class MainActivity extends AppCompatActivity {

    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*--------------------------------分享-----------------------------------------------*/
    public void qq(View view) {
        ShareUtils.shareWeb(this, Defaultcontent.url, Defaultcontent.title
                , Defaultcontent.text, Defaultcontent.imageurl, R.mipmap.icon_logo_share, SHARE_MEDIA.QQ
        );
    }

    public void weiXin(View view) {
        ShareUtils.shareWeb(this, Defaultcontent.url, Defaultcontent.title
                , Defaultcontent.text, Defaultcontent.imageurl, R.mipmap.icon_logo_share, SHARE_MEDIA.WEIXIN
        );
    }

    public void weixinCircle(View view) {
        ShareUtils.shareWeb(this, Defaultcontent.url, Defaultcontent.title
                , Defaultcontent.text, Defaultcontent.imageurl, R.mipmap.icon_logo_share, SHARE_MEDIA.WEIXIN_CIRCLE
        );
    }

    public void sina(View view) {
        ShareUtils.shareWeb(this, Defaultcontent.url, Defaultcontent.title
                , Defaultcontent.text, Defaultcontent.imageurl, R.mipmap.icon_logo_share, SHARE_MEDIA.SINA
        );
    }

    public void Qzone(View view) {
        ShareUtils.shareWeb(this, Defaultcontent.url, Defaultcontent.title
                , Defaultcontent.text, Defaultcontent.imageurl, R.mipmap.icon_logo_share, SHARE_MEDIA.QZONE
        );
    }


    /*--------------------------------第三方登录-----------------------------------------------*/
    public void qqLogin(View view) {
        AuthorUtil.authorization(this, SHARE_MEDIA.QQ);
    }

    public void weiXinLogin(View view) {
        AuthorUtil.authorization(this, SHARE_MEDIA.WEIXIN);
    }

    public void sinaLogin(View view) {
        AuthorUtil.authorization(this, SHARE_MEDIA.SINA);
    }

    /*--------------------------------QQ与新浪分享回调---------------------------------------------*/
    /*QQ与新浪不需要添加Activity，但需要在使用QQ分享或者授权的Activity中，添加：*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
