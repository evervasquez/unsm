package com.example.coneiscxxi;

import com.actionbarsherlock.app.SherlockFragment;
import com.example.menu.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Eventos extends SherlockFragment{
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
		return inflater.inflate(R.layout.activity_eventos, container,false);
	}
}
