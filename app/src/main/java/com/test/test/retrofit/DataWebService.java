package com.test.test.retrofit;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.test.models.Todo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataWebService extends DataStrategy {
    private ApiService apiService;
    private String TAG_FAILURE = "FAILURE_CALL";

    public DataWebService() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(NewHttpClients.getOkHttpClient())
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public static boolean isCodeOK(int code) {
        return code >= 200 & code < 300;
    }


    @Override
    public void getTodos(int id, final InteractDispatcherObject interactDispatcherObject) {
        apiService.getTodos(id)
                .enqueue(new Callback<Todo>() {
                    @Override
                    public void onResponse(Call<Todo> call, Response<Todo> response) {
                        interactDispatcherObject.response(response.code(), response.body());
                    }

                    @Override
                    public void onFailure(Call<Todo> call, Throwable throwable) {
                        Log.e(TAG_FAILURE, "onFailure: getTodos - " + throwable.getMessage());
                        interactDispatcherObject.fail();
                    }
                });
    }

}