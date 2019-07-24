package com.test.test.retrofit;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class NewHttpClients {

    private static final String TYPE_ITEM_CONTENT_TYPE = "Content-Type";

    private NewHttpClients() {
        throw new IllegalAccessError("Utility class");
    }

    public static OkHttpClient getOkHttpClient() {
        try {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();

//            Con Java8 seria asi ↓↓
//            builder.addInterceptor(chain -> {
//              ...
//            });
            /*builder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    Request.Builder requestBuilder;
                    requestBuilder = original.newBuilder().method(original.method(), original.body());
                    requestBuilder.header(TYPE_ITEM_CONTENT_TYPE, "application/json");
                    return chain.proceed(requestBuilder.build());
                }
            });*/


            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);

            return builder.build();
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e);
        }
    }
}


