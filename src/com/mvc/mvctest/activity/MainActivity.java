package com.mvc.mvctest.activity;

import com.mvc.baseinterface.IEventInterface;
import com.mvc.contants.Events;
import com.mvc.model.MvcModelController;
import com.mvc.mvctest.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity implements IEventInterface {
	TextView text;
	private MvcModelController mManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViews();
	}
	
	private void findViews(){
		text =(TextView) findViewById(R.id.text);
	}
	private void setListener(){
		//绑定底部event事件
		mManager =new MvcModelController(this);
		mManager.addEventListener(this);
		mManager.loadData();
	}
	@Override
	public void onEvent(int event, String param) {
		switch (event) {
		case Events.CONTENT_LOADED:
			text.setText(param);
			break;
		case Events.CONTENT_READ_ERROR:
			
			break;
		case Events.CONTENT_WRITE_ERROR:

			break;

		default:
			break;
		}
	}

}
