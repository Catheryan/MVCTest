package com.mvc.baseinterface;

public class InterfaceDispatcher {
	IEventInterface iEventInterface;
	//��Ӽ�����
	public void addEventListener(IEventInterface iEventInterface){
		this.iEventInterface =iEventInterface;
	}
	//�������¼�����¼�
	public void fireOut(int event, String data){
		iEventInterface.onEvent(event, data);
	}
}
