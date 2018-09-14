package com.example.dovizkuru;

public class Altin {
	
	private String key;
	private String key2;
	private String alis;
	private String satis;
	private String adi;
	private String upDown;
	private String type;
	
	public Altin(){
		
	}
	
	public Altin(String key,String key2,String alis,String satis,String adi,String upDown,String type)
	{
		this.key=key;
		this.key2=key2;
		this.alis=alis;
		this.satis=satis;
		this.adi=adi;
		this.upDown=upDown;
		this.type=type;
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
	public String getKey2() {
		return key2;
	}
	public void setKey2(String key2) {
		this.key2 = key2;
	}
}
