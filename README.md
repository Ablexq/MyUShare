# MyUShare



第三方登录、分享

[友盟接口文档](http://dev.umeng.com/sdk_integate/android_sdk/android_common_guide)

[Android使用友盟集成QQ、微信、微博等第三方登录](https://www.jianshu.com/p/80d6f399f75b)

[Android使用友盟集成QQ、微信、微博等第三方分享](https://www.jianshu.com/p/eeb378b99bf3)

[Android友盟统计的集成与使用（包含多渠道打包配置）](https://www.jianshu.com/p/e4da2f477cd8)


[安卓友盟第三方登录与分享(集成工具：较旧版本)](https://blog.csdn.net/qq_34536167/article/details/78704756)

#  集成

参考：

[Android友盟分享集成与走过的坑（集成工具：较新版本）](https://blog.csdn.net/weihua_li/article/details/81184613)

### 下载友盟SDK

https://developer.umeng.com/sdk/android

### 下载集成工具

https://developer.umeng.com/tools

请注意，在你下载SDK的同时集成工具就会在你下载的文件夹中，切记不要移动他的位置，保证它和SDK在同一级目录下。


### 使用集成工具把友盟SDK集成，自动生成UMLibrary，并项目中引用这个library

### 权限及组件

applicationId的包名下新建wxapi包，并新建WXEntryActivity类继承WXCallbackActivity

```
<!--微信：-->
<activity
    android:name=".wxapi.WXEntryActivity"
    android:configChanges="keyboardHidden|orientation|screenSize"
    android:exported="true"
    android:screenOrientation="portrait"
    android:theme="@android:style/Theme.Translucent.NoTitleBar" />
```

### 初始化及平台appkey

去各个平台申请注册，获得各平台appKey，然后设置各个平台的appKey
```
{
    PlatformConfig.setWeixin("wx967daebe835fbeac", "25937a3df443a3d21c70219e1778fd2e");
    PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
    PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
}
```

```
UMConfigure.setLogEnabled(true);
UMConfigure.init(this, "AppKey", "umeng", UMConfigure.DEVICE_TYPE_PHONE, "");
```

### 到此为止，全部配置完成



# 问题：

```
 AndroidRuntime: FATAL EXCEPTION: Thread-5
 Process: com.xq.myushare, PID: 9665
java.lang.NoClassDefFoundError: Failed resolution of: Lcom/umeng/commonsdk/statistics/common/DeviceConfig;
at com.umeng.socialize.utils.DeviceConfig.getDeviceId(DeviceConfig.java:156)
at com.umeng.socialize.net.base.SocializeRequest.getBaseQuery(SocializeRequest.java:304)
 at com.umeng.socialize.net.base.SocializeRequest.buildParams(SocializeRequest.java:194)
at com.umeng.socialize.net.base.SocializeRequest.toGetUrl(SocializeRequest.java:187)
at com.umeng.socialize.net.utils.UClient.openUrlConnection(UClient.java:249)
at com.umeng.socialize.net.utils.UClient.httpGetRequest(UClient.java:206)
at com.umeng.socialize.net.utils.UClient.execute(UClient.java:72)
at com.umeng.socialize.net.base.SocializeClient.execute(SocializeClient.java:33)
at com.umeng.socialize.net.RestAPI.queryShareId(RestAPI.java:11)
at com.umeng.socialize.UMShareAPI$a.a(Unknown Source)
at com.umeng.socialize.UMShareAPI$a.doInBackground(Unknown Source)
at com.umeng.socialize.common.QueuedWork$UMAsyncTask$1.run(QueuedWork.java:141)
at java.lang.Thread.run(Thread.java:776)
Caused by: java.lang.ClassNotFoundException: Didn't find class "com.umeng.commonsdk.statistics.common.DeviceConfig" on path: DexPathList[[zip file "/data/app/com.xq.myushare-2/base.apk", zip file "/data/app/com.xq.myushare-2/split_lib_dependencies_apk.apk", zip file "/data/app/com.xq.myushare-2/split_lib_slice_0_apk.apk", zip file "/data/app/com.xq.myushare-2/split_lib_slice_1_apk.apk", zip file "/data/app/com.xq.myushare-2/split_lib_slice_2_apk.apk", zip file "/data/app/com.xq.myushare-2/split_lib_slice_3_apk.apk", zip file "/data/app/com.xq.myushare-2/split_lib_slice_4_apk.apk", zip file "/data/app/com.xq.myushare-2/split_lib_slice_5_apk.apk", zip file "/data/app/com.xq.myushare-2/split_lib_slice_6_apk.apk", zip file "/data/app/com.xq.myushare-2/split_lib_slice_7_apk.apk", zip file "/data/app/com.xq.myushare-2/split_lib_slice_8_apk.apk", zip file "/data/app/com.xq.myushare-2/split_lib_slice_9_apk.apk"],nativeLibraryDirectories=[/data/app/com.xq.myushare-2/lib/arm64, /system/lib64, /vendor/lib64, /system/vendor/lib64, /product/lib64]]
at dalvik.system.BaseDexClassLoader.findClass(BaseDexClassLoader.java:56)
at java.lang.ClassLoader.loadClass(ClassLoader.java:380)
at java.lang.ClassLoader.loadClass(ClassLoader.java:312)
at com.umeng.socialize.utils.DeviceConfig.getDeviceId(DeviceConfig.java:156)?
at com.umeng.socialize.net.base.SocializeRequest.getBaseQuery(SocializeRequest.java:304)?
at com.umeng.socialize.net.base.SocializeRequest.buildParams(SocializeRequest.java:194)?
at com.umeng.socialize.net.base.SocializeRequest.toGetUrl(SocializeRequest.java:187)?
at com.umeng.socialize.net.utils.UClient.openUrlConnection(UClient.java:249)?
at com.umeng.socialize.net.utils.UClient.httpGetRequest(UClient.java:206)?
at com.umeng.socialize.net.utils.UClient.execute(UClient.java:72)?
at com.umeng.socialize.net.base.SocializeClient.execute(SocializeClient.java:33)?
at com.umeng.socialize.net.RestAPI.queryShareId(RestAPI.java:11)?
at com.umeng.socialize.UMShareAPI$a.a(Unknown Source)?
at com.umeng.socialize.UMShareAPI$a.doInBackground(Unknown Source)?
at com.umeng.socialize.common.QueuedWork$UMAsyncTask$1.run(QueuedWork.java:141)?
at java.lang.Thread.run(Thread.java:776)?
```
原因：

缺少umeng-common-1.4.3.jar 


QQ、微信、新浪微博等appkey,需要到相应的开发者平台注册账号、注册应用信息获取。
----











