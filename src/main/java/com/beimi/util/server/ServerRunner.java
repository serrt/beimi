package com.beimi.util.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.beimi.core.BMDataContext;
import com.beimi.util.server.handler.GameEventHandler;
import com.beimi.util.server.handler.SystemEventHandler;
import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;
  
@Component  
public class ServerRunner implements CommandLineRunner {  
    private final SocketIOServer server;
    private final SocketIONamespace gameSocketNameSpace ;
    private final SocketIONamespace systemSocketNameSpace ;
    
    @Autowired  
    public ServerRunner(SocketIOServer server) {  
        this.server = server;  
        gameSocketNameSpace = server.addNamespace(BMDataContext.NameSpaceEnum.GAME.getNamespace())  ;
        systemSocketNameSpace = server.addNamespace(BMDataContext.NameSpaceEnum.SYSTEM.getNamespace())  ;
    }
    
    @Bean(name="gameNamespace")
    public SocketIONamespace getGameSocketIONameSpace(SocketIOServer server ){
    	gameSocketNameSpace.addListeners(new GameEventHandler(server));
    	return gameSocketNameSpace  ;
    }
    
    @Bean(name="systemNamespace")
    public SocketIONamespace getSystemSocketIONameSpace(SocketIOServer server ){
    	systemSocketNameSpace.addListeners(new SystemEventHandler(server));
    	return systemSocketNameSpace  ;
    }
    
    public void run(String... args) throws Exception { 
        server.start();  
        BMDataContext.setIMServerStatus(true);	//IMServer 启动成功
    }  
}  