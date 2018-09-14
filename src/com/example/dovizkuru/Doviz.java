package com.example.dovizkuru;

public class Doviz {

	public static   Doviz selectedVeri;
	private String adi;
	private String alis;
	private String satis;
	private String key;
	private String type;
	private String upDown;
	private String oran;
public Doviz(){
		
	}
	public Doviz(String adi,String alis,String satis,String key,String type,String upDown,String oran)
	{
		this.adi=adi;
		this.alis=alis;
		this.satis=satis;
		this.key=key;
		this.type=type;
		this.upDown=upDown;
		this.oran=oran;
	}
	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	public String getAlis() {
		return alis;
	}
	public void setAlis(String alis) {
		this.alis = alis;
	}
	public String getSatis() {
		return satis;
	}
	public void setSatis(String satis) {
		this.satis = satis;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUpDown() {
		return upDown;
	}
	public void setUpDown(String upDown) {
		this.upDown = upDown;
	}
	public String getOran() {
		return oran;
	}
	public void setOran(String oran) {
		this.oran = oran;
	}
	
}
