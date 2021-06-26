package com.example.jadwalsholat.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class JadwalSholatResponse{

	@SerializedName("code")
	private int code;

	@SerializedName("data")
	private ArrayList<JadwalSholatDataItem> data;

	@SerializedName("status")
	private String status;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setData(ArrayList<JadwalSholatDataItem> data){
		this.data = data;
	}

	public ArrayList<JadwalSholatDataItem> getData(){
		return data;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"JadwalSholatResponse{" + 
			"code = '" + code + '\'' + 
			",data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}