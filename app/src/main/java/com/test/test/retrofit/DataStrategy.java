package com.test.test.retrofit;

import com.test.test.models.Todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Esta clase es el esqueleto para alamcenar todas las peticiones http de la app.
 */
public abstract class DataStrategy {

    //region Metodos de llamada
    public abstract void getTodos(int id, InteractDispatcherObject interactDispatcherObject);

    //endregion

    //region Conversores/Parsers
    public interface InteractDispatcherObject<T> {
        void response(int code, T object);

        void fail();
    }

    public interface InteractDispatcherListObject<T> {
        void response(int code, List<T> object);

        void fail();
    }

    public interface InteractDispatcherGeneric {
        void response(int code, String message);
    }
    //endregion

    public interface ApiService {

        @GET("todos/{id}")
        Call<Todo> getTodos(@Path("id") int id);
    }
}
