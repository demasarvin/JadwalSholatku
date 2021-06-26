package com.example.jadwalsholat.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jadwalsholat.R;
import com.example.jadwalsholat.data.model.JadwalSholatDataItem;

import java.util.ArrayList;

public class JadwalSholatAdapter extends RecyclerView.Adapter<JadwalSholatAdapter.ViewHolder> {

    private ArrayList<JadwalSholatDataItem> jadwalSholatDataItemArrayList = new ArrayList<>();

    public JadwalSholatAdapter() {
    }

    public void setData(ArrayList<JadwalSholatDataItem> jadwalSholatDataItems) {
        jadwalSholatDataItemArrayList.clear();
        jadwalSholatDataItemArrayList.addAll(jadwalSholatDataItems);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public JadwalSholatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_jadwal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalSholatAdapter.ViewHolder holder, int position) {

        // Get tanggal dan hari
        String tanggal = jadwalSholatDataItemArrayList.get(position).getDate().getReadable();
        String hari = jadwalSholatDataItemArrayList.get(position).getDate().getGregorian().getWeekday().getEn();

        // Set TextView dengan value dari ArrayList
        holder.tvTanggal.setText(hari + ", " + tanggal);
        holder.tvJamImsak.setText(jadwalSholatDataItemArrayList.get(position).getTimings().getImsak());
        holder.tvJamShubuh.setText(jadwalSholatDataItemArrayList.get(position).getTimings().getFajr());
        holder.tvJamDzuhur.setText(jadwalSholatDataItemArrayList.get(position).getTimings().getDhuhr());
        holder.tvJamAshar.setText(jadwalSholatDataItemArrayList.get(position).getTimings().getAsr());
        holder.tvJamMaghrib.setText(jadwalSholatDataItemArrayList.get(position).getTimings().getMaghrib());
        holder.tvJamIsya.setText(jadwalSholatDataItemArrayList.get(position).getTimings().getIsha());
    }

    @Override
    public int getItemCount() {
        return jadwalSholatDataItemArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTanggal, tvJamImsak, tvJamShubuh, tvJamDzuhur, tvJamAshar, tvJamMaghrib, tvJamIsya;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Inisialisasi TextView
            tvTanggal = itemView.findViewById(R.id.item_list_jadwal_tv_tanggal);
            tvJamImsak = itemView.findViewById(R.id.item_list_jadwal_tv_jam_imsak);
            tvJamShubuh = itemView.findViewById(R.id.item_list_jadwal_tv_jam_shubuh);
            tvJamDzuhur = itemView.findViewById(R.id.item_list_jadwal_tv_jam_dzuhur);
            tvJamAshar = itemView.findViewById(R.id.item_list_jadwal_tv_jam_ashar);
            tvJamMaghrib = itemView.findViewById(R.id.item_list_jadwal_tv_jam_maghrib);
            tvJamIsya = itemView.findViewById(R.id.item_list_jadwal_tv_jam_isya);
        }
    }
}
