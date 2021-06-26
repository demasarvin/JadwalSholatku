package com.example.jadwalsholat.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jadwalsholat.R;
import com.example.jadwalsholat.data.model.JadwalSholatDataItem;
import com.example.jadwalsholat.ui.adapter.JadwalSholatAdapter;
import com.example.jadwalsholat.ui.viewmodel.JadwalSholatViewModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

public class JadwalSholatFragment extends Fragment {

    private JadwalSholatAdapter jadwalSholatAdapter;
    private RecyclerView recyclerViewJadwalSholat;
    private JadwalSholatViewModel jadwalSholatViewModel;

    public JadwalSholatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jadwal_sholat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Setting Adapter untuk RecyclerView dengan membawa data Jadwal Sholat
        jadwalSholatAdapter = new JadwalSholatAdapter();
        jadwalSholatAdapter.notifyDataSetChanged();

        recyclerViewJadwalSholat = view.findViewById(R.id.fragment_jadwal_sholat_rv);
        recyclerViewJadwalSholat.setHasFixedSize(true);
        recyclerViewJadwalSholat.setLayoutManager(new LinearLayoutManager(getActivity()));

        jadwalSholatViewModel = new ViewModelProvider(this).get(JadwalSholatViewModel.class);

        /* Set parameter utk query API
         * parameter terdiri dari :
         * 1. address = isi dengan alamat yang diinginkan
         * 2. method = metode perhitungan, default value = 2
         * 3. month = bulan yang ingin dicari
         * 4. year = tahun yang ingin dicari
         */

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+7"));
        String address = "Semarang";
        String method = "2";
        String current_month = String.valueOf(calendar.get(Calendar.MONTH)+1);
        String current_year = String.valueOf(calendar.get(Calendar.YEAR));

        jadwalSholatViewModel.getJadwalSholat(address,method,current_month,current_year)
                .observe(getViewLifecycleOwner(), new Observer<ArrayList<JadwalSholatDataItem>>() {
                    @Override
                    public void onChanged(ArrayList<JadwalSholatDataItem> jadwalSholatDataItems) {
                        if (jadwalSholatDataItems != null) {
                            jadwalSholatAdapter.setData(jadwalSholatDataItems);
                        }
                    }
                });

        recyclerViewJadwalSholat.setAdapter(jadwalSholatAdapter);
    }
}
