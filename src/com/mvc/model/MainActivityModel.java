package com.mvc.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.content.Context;

import com.mvc.baseinterface.InterfaceDispatcher;
import com.mvc.contants.Events;
/**
 * 需要将自己的model  操作归类
 * @author haier
 *
 */
public class MainActivityModel extends InterfaceDispatcher{
	Context context;
	private String mData;
	public MainActivityModel(Context context) {
		this.context=context;
	}
	public void loadData() {
		try {
			FileInputStream fis = context.openFileInput("1.txt");
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			mData = new String(buffer);
			fis.close();
		} catch (FileNotFoundException e) {
			fireOut(Events.CONTENT_READ_ERROR, "read error: FileNotFoundException");
		} catch (IOException e) {
			fireOut(Events.CONTENT_READ_ERROR, "read error: IOException");
		}
		
		fireOut(Events.CONTENT_LOADED, mData);
	}
}
