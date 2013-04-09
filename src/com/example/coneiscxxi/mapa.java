package com.example.coneiscxxi;

import com.example.menu.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class mapa extends FragmentActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapa);
		GoogleMap mapas = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
	}
}