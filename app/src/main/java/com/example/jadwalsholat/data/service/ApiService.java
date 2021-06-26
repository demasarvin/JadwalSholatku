package com.example.jadwalsholat.data.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private Retrofit retrofit;

    /* Setting awal Retrofit dan set BASE_URL
     * Untuk BASE_URL jika bisa https
     * karena retrofit hanya menerima request dari https
     */
    public ApiEndPoint getApiJadwalSholat() {
        String BASE_URL = "https://api.aladhan.com/";
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiEndPoint.class);
    }
}
