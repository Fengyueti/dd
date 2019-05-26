package com.bw.lib_net.net;

import android.os.Environment;

import com.bw.lib_net.api.Api;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {

    private final OkHttpClient okHttpClient;
    private final Retrofit retrofit;
    private static RetrofitUtils mInstance;

    public RetrofitUtils() {
        // 缓存目录
        File file = new File(Environment.getExternalStorageDirectory(), "a_cache");
        // 缓存大小
        int cacheSize = 10 * 1024 * 1024;

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .cache(new Cache(file, cacheSize)) // 配置缓存
                //.addInterceptor(new HeaderInterceptor())
                .addNetworkInterceptor(new NetCacheInterceptor())
                .addNetworkInterceptor(loggingInterceptor)
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .build();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Api.BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static RetrofitUtils getmInstance() {
        if (mInstance == null) {
            synchronized (RetrofitUtils.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitUtils();
                }
            }
        }
        return mInstance;
    }

    public <T> T create(Class<T> tClass) {
        return retrofit.create(tClass);
    }
}
