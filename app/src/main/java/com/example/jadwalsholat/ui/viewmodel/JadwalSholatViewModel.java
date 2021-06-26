package com.example.jadwalsholat.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.jadwalsholat.data.AppRepository;
import com.example.jadwalsholat.data.model.JadwalSholatDataItem;
import com.example.jadwalsholat.data.model.JadwalSholatResponse;
import com.example.jadwalsholat.data.service.ApiService;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JadwalSholatViewModel extends AndroidViewModel {
    protected AppRepository repository;
    private ApiService apiMain;
    private MutableLiveData<ArrayList<JadwalSholatDataItem>> listJadwalSholatMutableLiveData = new MutableLiveData<>();

    public JadwalSholatViewModel(@NonNull @NotNull Application application) {
        super(application);
        this.repository = new AppRepository(application);
    }

    public LiveData<ArrayList<JadwalSholatDataItem>> getJadwalSholat(String address,String method,String month, String year){
        return repository.getJadwalSholat(address, method, month, year);
    }
}
