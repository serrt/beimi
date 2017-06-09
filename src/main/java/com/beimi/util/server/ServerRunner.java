package com.beimi.util.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.beimi.core.BMDataContext;
import com.beimi.util.server.handler.IMEventHandler;
import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;
  
@Component  
public class ServerRunner implements CommandLineRunner {  
    private final SocketIOServer server;
    private final SocketIONamespace imSocketNameSpace ;
    
    @Autowired  
    public ServerRunner(SocketIOServer server) {  
        this.server = server;  
        imSocketNameSpace = server.addNamespace(BMDataContext.NameSpaceEnum.IM.getNamespace())  ;
    }
    
    @Bean(name="imNamespace")
    public SocketIONamespace getIMSocketIONameSpace(SocketIOServer server ){
    	imSocketNameSpace.addListeners(new IMEventHandler(server));
    	return imSocketNameSpace  ;
    }
    
    public void run(String... args) throws Exception { 
        server.start();  
        BMDataContext.setIMServerStatus(true);	//IMServer 启动成功
    }  
}  