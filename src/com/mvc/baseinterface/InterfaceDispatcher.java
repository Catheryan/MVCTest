package com.mvc.baseinterface;

public class InterfaceDispatcher {
	IEventInterface iEventInterface;
	//添加监听器
	public void addEventListener(IEventInterface iEventInterface){
		this.iEventInterface =iEventInterface;
	}
	//给监听事件添加事件
	public void fireOut(int event, String data){
		iEventInterface.onEvent(event, data);
	}
}
