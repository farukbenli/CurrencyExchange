package com.example.dovizkuru;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class Genel extends Activity implements OnItemSelectedListener {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Spinner spnrAldi = (Spinner)findViewById(R.id.spinner1);
		Spinner spnrVerdi = (Spinner)findViewById(R.id.Spinner2);
		List<String> kategori = new ArrayList<String>(); 
		kategori.add("Dolar");
		kategori.add("Euro");
		kategori.add("Türk Lirasý");
		kategori.add("Altýn");
		ArrayAdapter<String> spinnerAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,kategori);
		spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spnrAldi.setAdapter(spinnerAdapter);
		spnrVerdi.setAdapter(spinnerAdapter);
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
	        Intent Doviz = new Intent(Genel.this, MainActivity.class);
	        startActivity(Doviz);
	        finish();
	            return true;
	        case R.id.Hesap:
	        	Intent Hesap = new Intent(Genel.this, Genel.class);
	        	startActivity(Hesap);
	        	finish();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

}
