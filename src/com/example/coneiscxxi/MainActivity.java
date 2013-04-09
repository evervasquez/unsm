package com.example.coneiscxxi;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.example.menu.R;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingFragmentActivity;
import android.annotation.SuppressLint;
import adapters.TabsAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

@SuppressLint("NewApi")
public class MainActivity extends SlidingFragmentActivity {
	private ViewPager mViewPager;
	private TabsAdapter mTabsAdapter;
	private SlidingMenu menu;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.Theme_Sherlock_Light);
		super.onCreate(savedInstanceState);
		
		getSupportActionBar().setTitle("CONEISCXXI");

		mViewPager = new ViewPager(this);
		mViewPager.setId(R.id.pager);
		setContentView(R.layout.mapa);
		
		final ActionBar bar = getSupportActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		mTabsAdapter = new TabsAdapter(this, mViewPager);
		mTabsAdapter.addTab(bar.newTab().setText("Inicio"), Inicio.class, null);
		mTabsAdapter.addTab(bar.newTab().setText("Descubre"), Descubre.class, null);
		mTabsAdapter.addTab(bar.newTab().setText("Cuenta"), mapa.class, null);
		
		//mTabsAdapter.onTabSelected(this, bar.)
		
		setBehindContentView(R.layout.menu);
		menu = getSlidingMenu();
		menu.setShadowWidthRes(R.dimen.shadow_width);
		menu.setShadowDrawable(R.drawable.sombra);
		
		menu.setBehindOffset(60);
		menu.setFadeDegree(0.35f);
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);	

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowCustomEnabled(false);
		//getSupportActionBar().setSubtitle("xxi");
		
		
            
        
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
			return onOptionsItemSelected(item);
		}
	}

}