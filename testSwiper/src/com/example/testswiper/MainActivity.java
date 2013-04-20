package com.example.testswiper;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	ViewPager pager;
	SimplePagerAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		pager = (ViewPager) findViewById(R.id.listView1);
		adapter = new SimplePagerAdapter(this);
		pager.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	
	class SimplePagerAdapter extends PagerAdapter {

		LayoutInflater inflater;
		private Context ctx;
		
		public SimplePagerAdapter(Context ctx) {
			this.ctx = ctx;
			inflater = (LayoutInflater) ctx.getSystemService(LAYOUT_INFLATER_SERVICE);
		}
		/* (non-Javadoc)
		 * @see android.support.v4.view.PagerAdapter#destroyItem(android.view.View, int, java.lang.Object)
		 */
		@Override
		public void destroyItem(View container, int position, Object object) {
			((ViewGroup) container).removeView((View)object);
		}

		/* (non-Javadoc)
		 * @see android.support.v4.view.PagerAdapter#instantiateItem(android.view.View, int)
		 */
		@Override
		public Object instantiateItem(View container, int position) {
			Toast.makeText(ctx, "page "+position, Toast.LENGTH_LONG).show();
			View page = inflater.inflate(R.layout.blublub, null);
			TextView titre = (TextView) page.findViewById(R.id.titre);
			titre.setText("Page "+position);
			((ViewGroup) container).addView(page, 0);
			return page;
		}

		@Override
		//nombre de pages
		public int getCount() {
			return 10;
		}

		@Override
		public boolean isViewFromObject(View v, Object ob) {
			return v == ((LinearLayout)ob);
		}
		
	}

}
