package com.nagraj.buses;

import retrofit2.Call;
import retrofit2.http.GET;


public interface RoutesApi {
    @GET("bins/7afms")
    Call<RoutesDetail> getRoutes();


}
