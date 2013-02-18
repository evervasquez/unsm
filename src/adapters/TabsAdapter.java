package adapters;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;


public class TabsAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener, ActionBar.TabListener{
	private final Context mContext;
	private final ActionBar mActionBar;
	private final ViewPager mViewPager;
	private final ArrayList<TabInfo> mTabs = new ArrayList<TabInfo>();
	private final String TAG = "21st Polling:";
	
	static final class TabInfo{
		private final Class<?> clss;
		private final Bundle args;
		
		TabInfo(Class<?> _class, Bundle _args){
			clss = _class;
			args = _args;
		}
	}
	
	public TabsAdapter(SherlockFragmentActivity fa, ViewPager pager) {
		super(fa.getSupportFragmentManager());
		mContext =fa;
		mActionBar = fa.getSupportActionBar();
		mViewPager = pager;
		mViewPager.setAdapter(this);
		mViewPager.setOnPageChangeListener(this);
		// TODO Auto-generated constructor stub
	}
	
	public void addTab(ActionBar.Tab tab, Class<?> clss, Bundle args){
		TabInfo info = new TabInfo(clss, args);
		tab.setTag(info);
		tab.setTabListener(this);
		mTabs.add(info);
		mActionBar.addTab(tab);
		notifyDataSetChanged();
	}
	
	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		mActionBar.setSelectedNavigationItem(arg0);
	}
	
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		mViewPager.setCurrentItem(tab.getPosition());
		Log.v(TAG, "clicked");
		Object tag = tab.getTag();
		for(int i = 0; i<mTabs.size(); i++){
			if(mTabs.get(i) == tag){
				mViewPager.setCurrentItem(i);
			}
		}
	}
	
	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		TabInfo info = mTabs.get(arg0);
		return Fragment.instantiate(mContext, info.clss.getName(), info.args);
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mTabs.size();
	}




}
