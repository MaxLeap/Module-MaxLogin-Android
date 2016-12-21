package com.maxleap.sample.login;

import android.app.Application;

import com.maxleap.MLUser;
import com.maxleap.MaxLeap;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

/**
 * Created by xupanpan on 12/16/16.
 */
public class MyApplication extends Application {

    public static final String APP_ID = "58536be0d63c0800074d3334";
    public static final String API_KEY = "N3FqcmRWMVllVTFwcHdoR3Z3TnFQdw";

    @Override
    public void onCreate() {
        super.onCreate();
        MaxLeap.Options options = new MaxLeap.Options();
        options.appId = APP_ID;
        options.clientKey = API_KEY;
        options.enableAnonymousUser = false;
        options.serverRegion = MaxLeap.REGION_CN;
        MaxLeap.setLogLevel(MaxLeap.LOG_LEVEL_VERBOSE);//设置log输出的等级
        MaxLeap.initialize(this, options);

        MLUser.registerSubclass(LoginUser.class);


        initImageLoader();
    }

    private void initImageLoader() {

        ImageLoaderConfiguration mImageLoaderConfiguration = new ImageLoaderConfiguration.Builder(this)

                .diskCache(new UnlimitedDiskCache(getExternalCacheDir()))
                .diskCacheExtraOptions(480, 800, null)
                .diskCacheSize(100 * 1024 * 1024)
                .diskCacheFileCount(500)
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())

                .memoryCacheExtraOptions(480, 800)
                .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024))
                .memoryCacheSize(8 * 1024 * 1024)

                .threadPoolSize(5)

                .threadPriority(Thread.NORM_PRIORITY - 2)

                .denyCacheImageMultipleSizesInMemory()

                .tasksProcessingOrder(QueueProcessingType.LIFO)

                .defaultDisplayImageOptions(DisplayImageOptions.createSimple())

                .imageDownloader(new BaseImageDownloader(this, 10 * 1000, 60 * 1000))

                .imageDecoder(new BaseImageDecoder(false))

                .build();

        ImageLoader.getInstance().init(mImageLoaderConfiguration);// 全局初始化此配置

    }

}
