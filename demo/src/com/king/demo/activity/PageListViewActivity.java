package com.king.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.king.demo.R;
import com.king.demo.adapter.PageListViewAdapter;
import com.king.demo.request.DemoPageReuqest;
import com.king.refresh.widget.PageAndRefreshListView;

public class PageListViewActivity extends Activity {

	private PageAndRefreshListView mListView;
	private PageListViewAdapter mAdapter;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_page_and_refresh);
		mListView = (PageAndRefreshListView) findViewById(R.id.demo_page_list);
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		button4 = (Button) findViewById(R.id.button4);
		textView = (TextView) findViewById(R.id.text);

		setListener();

		// 调用setAdapter()方法，自动请求第一页数据
		mAdapter = new PageListViewAdapter(this, new DemoPageReuqest());
		mListView.setAdapter(mAdapter);
	}

	private void setListener() {
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				textView.setText("只用分页");
				mListView.setPageDemandingEnable(true);
				mListView.setRefreshable(false);
			}
		});
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				textView.setText("只用刷新");
				mListView.setPageDemandingEnable(false);
				mListView.setRefreshable(true);
			}
		});
		button3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				textView.setText("下拉刷新,分页加载");
				mListView.setPageDemandingEnable(true);
				mListView.setRefreshable(true);
			}
		});
		button4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				textView.setText("刷新分页都禁用");
				mListView.setPageDemandingEnable(false);
				mListView.setRefreshable(false);
			}
		});
		
	}
	
}
