package com.mvc.model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;





import com.mvc.baseinterface.IEventInterface;
import com.mvc.baseinterface.InterfaceDispatcher;
import com.mvc.contants.Events;

import android.content.Context;

public class MvcModelController extends InterfaceDispatcher{
	MainActivityModel mainActivityModel;
	Context mContext;
	public MvcModelController(Context context) {
		this.mContext =context;
		mainActivityModel= new MainActivityModel(context);
	}
	public void changeData(String text){
		try {
			FileOutputStream fos = mContext.openFileOutput("1.txt", 0);
			fos.write(text.getBytes());
			fos.close();
 		} catch (FileNotFoundException e) {
			fireOut(Events.CONTENT_WRITE_ERROR, "write error: FileNotFoundException");
		} catch (IOException e) {
			fireOut(Events.CONTENT_WRITE_ERROR, "write error: IOException");
		}
		
		loadData();
	}
	public void loadData() {
		mainActivityModel.loadData();
	}
	@Override
	public void addEventListener(IEventInterface iEventInterface) {
		mainActivityModel.addEventListener(iEventInterface);
		super.addEventListener(iEventInterface);
	}
}
