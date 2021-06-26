package com.example.jadwalsholat.data;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.jadwalsholat.data.dao.UserDao;
import com.example.jadwalsholat.data.model.JadwalSholatDataItem;
import com.example.jadwalsholat.data.model.JadwalSholatResponse;
import com.example.jadwalsholat.data.model.User;
import com.example.jadwalsholat.data.service.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppRepository {
    private final ApiService apiService = new ApiService();
    private  final UserDao userDao;

    public AppRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        this.userDao = db.userDao();
    }

    // -- API
    public LiveData<ArrayList<JadwalSholatDataItem>> getJadwalSholat(String address,String method,String month, String year) {
        final MutableLiveData<ArrayList<JadwalSholatDataItem>>jadwal = new MutableLiveData<>();

        Call<JadwalSholatResponse> getResponse = apiService.getApiJadwalSholat().getJadwalSholat(address, method, month, year);
        getResponse.enqueue(new Callback<JadwalSholatResponse>() {
            @Override
            public void onResponse(Call<JadwalSholatResponse> call, Response<JadwalSholatResponse> response) {
                JadwalSholatResponse jadwalSholatResponse = response.body();
                if (jadwalSholatResponse != null && jadwalSholatResponse.getData() != null) {
                    ArrayList<JadwalSholatDataItem> jadwalSholatDataItems = jadwalSholatResponse.getData();
                    jadwal.postValue(jadwalSholatDataItems);
                }
            }

            @Override
            public void onFailure(Call<JadwalSholatResponse> call, Throwable t) {

            }
        });
        return jadwal;
    }

    // -- Database
    public void register(User user){
        AppDatabase.databaseWriterExecutor.execute(()-> userDao.register(user));
    }

    public LiveData<User> login(String username, String password){
        return userDao.login(username, password);
    }
}
