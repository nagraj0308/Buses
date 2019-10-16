package com.nagraj.buses;

import android.util.Log;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ModelActivity implements InterfaceClass.ForModel {
    public static final String BASE_URL = "https://api.myjson.com/";
    private static Retrofit retrofit = null;


    @Override
    public void doSomething(final OnFinishedListener onFinishedListener) {


        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RoutesApi apiService = retrofit.create(RoutesApi.class);
        Call<RoutesDetail> call = apiService.getRoutes();
        call.enqueue(new Callback<RoutesDetail>() {
            @Override
            public void onResponse(Call<RoutesDetail> call, Response<RoutesDetail> response) {
                if (response.code() == 200) {


                    onFinishedListener.setRoutesData(response.body().getRoutes());
                } else {

                    Log.e("hi", "Error");
                }

            }

            @Override
            public void onFailure(Call<RoutesDetail> call, Throwable t) {
                Log.e("TAG", t.getMessage(), t);

            }

        });
    }

   
}
