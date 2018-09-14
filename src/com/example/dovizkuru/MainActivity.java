package com.example.dovizkuru;


import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.dovizkuru.DownloadDovizTask.GetDovizResponseCallback;
import com.example.dovizkuru.DownloadGoldTask.GetGoldResponseCallback;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
public class MainActivity extends Activity implements GetDovizResponseCallback, GetGoldResponseCallback {

	ArrayList<Doviz> dovizList;
	ArrayList<Altin> altinList;
	Adapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ilkekran);
		final String url="http://api.doviz.com/list/C";
		final String uurl="http://api.doviz.com/list/G";
		altinList = new ArrayList<Altin>();
		dovizList=new ArrayList<Doviz>();
		Button btnupt=(Button) findViewById(R.id.buttonGnc);
		Button btnAltin=(Button) findViewById(R.id.Altin );
		Button btnDoviz=(Button) findViewById(R.id.Doviz);
btnupt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new DownloadDovizTask(MainActivity.this).execute(url);
				new DownloadGoldTask(MainActivity.this).execute(uurl);
			}
		});
btnAltin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new DownloadGoldTask(MainActivity.this).execute(uurl);
			}
		});
btnDoviz.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		new DownloadDovizTask(MainActivity.this).execute(url);
	
	}
});
		
		
		
		
	}
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.Kur:
	        Intent Doviz = new Intent(MainActivity.this, MainActivity.class);
	        startActivity(Doviz);
	        finish();
	            return true;
	        case R.id.Hesap:
	        	Intent Hesap = new Intent(MainActivity.this, Genel.class);
	        	startActivity(Hesap);
	        	finish();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	
	}
	
	
	@Override
	public void goldLoadingFinished(String response)   {
		// TODO Auto-generated method stub
	
		ArrayList<String> list=new ArrayList<String>();
		JSONArray jsonArrayGold;
		try {
			JSONObject jObj = new JSONObject(response);
				jsonArrayGold = jObj.getJSONArray("value");
				
				for (int i = 0; i < jsonArrayGold.length(); i++) {
					
					Altin altin = new Altin();
					
					JSONObject jsonObject = jsonArrayGold.getJSONObject(i);
					altin.setAdi(jsonObject.getString("adi"));	
					altin.setAlis(jsonObject.getString("alis"));
					altin.setSatis(jsonObject.getString("satis"));
					altin.setKey(jsonObject.getString("key"));
					altin.setKey2(jsonObject.getString("key2"));
					altin.setType(jsonObject.getString("type"));
					altin.setUpDown(jsonObject.getString("upDown"));
					list.add(altin.getAdi());
					list.add(altin.getAlis());
					list.add(altin.getSatis());
					altinList.add(altin);
								
				}		
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		ListView listview =(ListView) findViewById(R.id.listView1);
		adapter = new Adapter(this,null,altinList);
		listview.setAdapter(adapter);
		
	}
	@Override
	public void dovizLoadingFinished(String response) {
		// TODO Auto-generated method stub
		ArrayList<String> list1=new ArrayList<String>();
		JSONArray jsonArrayDoviz;
		try {
			JSONObject jObj = new JSONObject(response);
			jsonArrayDoviz = jObj.getJSONArray("value");
				
				for (int i = 0; i < jsonArrayDoviz.length(); i++) {
					
					Doviz doviz = new Doviz();
					
					JSONObject jsonObject = jsonArrayDoviz.getJSONObject(i);
					doviz.setAdi(jsonObject.getString("adi"));	
					doviz.setAlis(jsonObject.getString("alis"));
					doviz.setSatis(jsonObject.getString("satis"));
					doviz.setKey(jsonObject.getString("key"));
					doviz.setOran(jsonObject.getString("oran"));
					doviz.setType(jsonObject.getString("type"));
					doviz.setUpDown(jsonObject.getString("upDown"));
					list1.add(doviz.getAdi());
					list1.add(doviz.getAlis());
					list1.add(doviz.getSatis());
					dovizList.add(doviz);
								
				}		
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		ListView listview =(ListView) findViewById(R.id.listView1);
		adapter = new Adapter(this,dovizList,null);
		listview.setAdapter(adapter);
}
}