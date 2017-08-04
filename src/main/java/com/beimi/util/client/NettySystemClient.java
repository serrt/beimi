package com.beimi.util.client;

import java.util.List;

import com.corundumstudio.socketio.SocketIOClient;
import com.google.common.collect.ArrayListMultimap;

public class NettySystemClient implements NettyClient{
	
	private ArrayListMultimap<String, SocketIOClient> systemClientsMap = ArrayListMultimap.create();
	
	public List<SocketIOClient> getClients(String key){
		return systemClientsMap.get(key) ;
	}
	
	public void putClient(String key , SocketIOClient client){
		systemClientsMap.put(key, client) ;
	}
	
	public void removeClient(String key , String id){
		List<SocketIOClient> keyClients = this.getClients(key) ;
		for(SocketIOClient client : keyClients){
			if(client.getSessionId().equals(id)){
				keyClients.remove(client) ;
				break ;
			}
		}
		if(keyClients.size() == 0){
			systemClientsMap.removeAll(key) ;
		}
	}
}
