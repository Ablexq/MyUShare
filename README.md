# MyUShare



第三方登录、分享

[友盟接口文档](http://dev.umeng.com/sdk_integate/android_sdk/android_common_guide)

[Android使用友盟集成QQ、微信、微博等第三方登录](https://www.jianshu.com/p/80d6f399f75b)

[Android使用友盟集成QQ、微信、微博等第三方分享](https://www.jianshu.com/p/eeb378b99bf3)

[Android友盟统计的集成与使用（包含多渠道打包配置）](https://www.jianshu.com/p/e4da2f477cd8)

问题：

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















