package com.example.dovizkuru;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter extends BaseAdapter {

	 MainActivity M;
	
    private LayoutInflater mInflater;
    private List<Doviz>     dovizListesi;
    private List<Altin> altinListesi;
 
   public Adapter(Activity activity, ArrayList<Doviz> list,ArrayList<Altin> list1) {
        mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        dovizListesi = list;
        altinListesi= list1;

    }
 
    @Override
    public int getCount() {
    	if(altinListesi==null)
       	return dovizListesi.size();
    	else
    		return altinListesi.size();
    	
   	}
 
    @Override
    public Object getItem(int position) {
        return position;
    }
 
    @Override
    public long getItemId(int position) {
        return position;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
 View satirView;
 if(altinListesi==null)
 {
        satirView = mInflater.inflate(R.layout.list_item, null);
        TextView textView = 
                (TextView) satirView.findViewById(R.id.textView1); 
        TextView textView1 = 
                (TextView) satirView.findViewById(R.id.textView2); 
        TextView textView2 = 
                (TextView) satirView.findViewById(R.id.textView3);
        TextView textView3 = 
                (TextView) satirView.findViewById(R.id.textView4); 
        TextView textView4 = 
                (TextView) satirView.findViewById(R.id.textView5); 
        ImageView imageView = 
                (ImageView) satirView.findViewById(R.id.imageView1);
 
        textView.setText("Satýþ fiyati");
        textView1.setText("Alýþ fiyati");
        textView2.setText(dovizListesi.get(position).getAlis());
        textView3.setText(dovizListesi.get(position).getSatis());
        textView4.setText(dovizListesi.get(position).getAdi());
        imageView.setImageResource(R.drawable.abc_ab_bottom_solid_dark_holo);
 }
 else{
	 satirView = mInflater.inflate(R.layout.list_item, null);
     TextView textView = 
             (TextView) satirView.findViewById(R.id.textView1); 
     TextView textView1 = 
             (TextView) satirView.findViewById(R.id.textView2); 
     TextView textView2 = 
             (TextView) satirView.findViewById(R.id.textView3);
     TextView textView3 = 
             (TextView) satirView.findViewById(R.id.textView4); 
     TextView textView4 = 
             (TextView) satirView.findViewById(R.id.textView5); 
     ImageView imageView = 
             (ImageView) satirView.findViewById(R.id.imageView1);

     textView.setText("Satýþ fiyati");
     textView1.setText("Alýþ fiyati");
     textView2.setText(altinListesi.get(position).getAlis());
     textView3.setText(altinListesi.get(position).getSatis());
     textView4.setText(altinListesi.get(position).getAdi());
     imageView.setImageResource(R.drawable.abc_ab_bottom_solid_light_holo);
 }
        return satirView;
    
 }
}