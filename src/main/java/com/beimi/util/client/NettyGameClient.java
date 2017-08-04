package com.beimi.util.client;

import java.util.List;

import com.corundumstudio.socketio.SocketIOClient;
import com.google.common.collect.ArrayListMultimap;

public class NettyGameClient implements NettyClient{
	
	private ArrayListMultimap<String, SocketIOClient> gameClientsMap = ArrayListMultimap.create();
	
	public List<SocketIOClient> getClients(String key){
		return gameClientsMap.get(key) ;
	}
	
	public void putClient(String key , SocketIOClient client){
		gameClientsMap.put(key, client) ;
	}
	
	public void removeClient(String key , String id){
		List<SocketIOClient> keyClients = this.getClients(key) ;
		for(SocketIOClient client : keyClients){
			if(client.getSessionId().toString().equals(id)){
				keyClients.remove(client) ;
				break ;
			}
		}
		if(keyClients.size() == 0){
			gameClientsMap.removeAll(key) ;
		}
	}
}
