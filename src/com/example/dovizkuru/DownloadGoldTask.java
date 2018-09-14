package com.example.dovizkuru;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.util.Log;

public class DownloadGoldTask extends AsyncTask<String,Void,String>{

	public interface GetGoldResponseCallback{
		void goldLoadingFinished(String response);
	}
	
	GetGoldResponseCallback getGoldResponseCallback;
	
	public DownloadGoldTask(GetGoldResponseCallback getGoldResponseCallback) {
		this.getGoldResponseCallback = getGoldResponseCallback;
	}
	 @Override
	    protected String doInBackground(String... urls) {
		 Log.d("URL", urls[0]);
		 String url = urls[0];
	      String response = "";

	        DefaultHttpClient client = new DefaultHttpClient();
	        HttpGet httpGet = new HttpGet(url);
	        try {
	          HttpResponse execute = client.execute(httpGet);
	          InputStream content = execute.getEntity().getContent();

	          BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
	          String s = "";
	          while ((s = buffer.readLine()) != null) {
	            response += s;
	          }

	        } catch (Exception e) {
	          e.printStackTrace();
	        }

	      Log.d("URL", "RESPONSE: "+response);
	      return response;
	       }
   @Override
	   protected void onPostExecute(String result) {
	   getGoldResponseCallback.goldLoadingFinished(result);
	    
	    }
	}
