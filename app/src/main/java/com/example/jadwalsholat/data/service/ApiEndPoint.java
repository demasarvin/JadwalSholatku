package com.example.jadwalsholat.data.service;

import com.example.jadwalsholat.data.model.JadwalSholatResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiEndPoint {
    // Request API dengan method GET dengan 4 parameter (address, method, month, year)
    @GET("v1/calendarByAddress")
    Call<JadwalSholatResponse> getJadwalSholat(
            @Query("address") String address,
            @Query("method") String method,
            @Query("month") String month,
            @Query("year") String year
    );
}
