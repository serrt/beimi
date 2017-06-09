package com.beimi.util.server.handler;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.beimi.util.client.NettyClients;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;

public class IMEventHandler     
{  
	protected SocketIOServer server;
	
    @Autowired  
    public IMEventHandler(SocketIOServer server)   
    {  
        this.server = server ;
    }  
    
    @OnConnect  
    public void onConnect(SocketIOClient client)  
    {  
    	try {
			String user = client.getHandshakeData().getSingleUrlParam("userid") ;
			
			if(!StringUtils.isBlank(user)){
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }  
      
    //添加@OnDisconnect事件，客户端断开连接时调用，刷新客户端信息  
    @OnDisconnect  
    public void onDisconnect(SocketIOClient client)  
    {  
    	String user = client.getHandshakeData().getSingleUrlParam("userid") ;
		if(user!=null){
			NettyClients.getInstance().removeIMEventClient(user , client.getSessionId().toString());
		}
    }  
}  