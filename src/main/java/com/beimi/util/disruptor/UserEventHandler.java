package com.beimi.util.disruptor;

import com.beimi.util.event.UserDataEvent;
import com.lmax.disruptor.EventHandler;

public class UserEventHandler implements EventHandler<UserDataEvent>{

	@SuppressWarnings("unchecked")
	@Override
	public void onEvent(UserDataEvent arg0, long arg1, boolean arg2)
			throws Exception {
		if(arg0.getDbRes()!=null){
			arg0.getDbRes().save(arg0.getEvent()) ;
		}
		if(arg0.getEsRes()!=null){
			arg0.getEsRes().save(arg0.getEvent()) ;
		}
	}
}
