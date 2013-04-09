package com.example.coneiscxxi;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.example.menu.R;
import com.example.coneiscxxi.Eventos;
import com.example.coneiscxxi.Inicio;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingFragmentActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

@SuppressLint("NewApi")
public class MainActivity extends SlidingFragmentActivity {
	private SlidingMenu menu;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.Theme_Sherlock_Light);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final ActionBar bar = getSupportActionBar();
		getSupportActionBar().setTitle("CONEISCXXI");
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		ActionBar.Tab frag1 = bar.newTab().setText("Inicio").setIcon(android.R.drawable.ic_btn_speak_now);
		ActionBar.Tab frag2 = bar.newTab().setText("Eventos").setIcon(android.R.drawable.ic_lock_silent_mode_off);
		ActionBar.Tab frag3 = bar.newTab().setText("Costos").setIcon(android.R.drawable.ic_input_delete);
		
		Fragment inicio = (Fragment) new Inicio();
		Fragment eventos = (Fragment) new Eventos();
		Fragment costos = (Fragment) new Costos();
		
		frag1.setTabListener(new MyTabsListener(inicio));
		frag2.setTabListener(new MyTabsListener(eventos));
		frag3.setTabListener(new MyTabsListener(costos));
		
		bar.addTab(frag1);
		bar.addTab(frag2);
		bar.addTab(frag3);
		
		setBehindContentView(R.layout.menu);
		menu = getSlidingMenu();
		menu.setShadowWidthRes(R.dimen.shadow_width);
		menu.setShadowDrawable(R.drawable.sombra);
		
		menu.setBehindOffset(60);
		menu.setFadeDegree(0.35f);
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);	
		menu.setMenu(R.layout.menu);
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowCustomEnabled(false);
		//getSupportActionBar().setSubtitle("xxi");
		
		if (savedInstanceState != null) {
            bar.setSelectedNavigationItem(savedInstanceState.getInt("tab", 0));
        }
            
        
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getSupportMenuInflater().inflate(R.menu.activity_itemlist, menu);
		return true;
	}
	
	
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case android.R.id.home:
			toggle();
			return true;
		case R.id.actualizar:
			return false;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	class MyTabsListener implements ActionBar.TabListener{
		public Fragment fragment;
		public MyTabsListener(Fragment fragment){
			this.fragment = fragment;
		}
		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			ft.replace(R.id.fragment_container, fragment);
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			
		}
		
	}
}