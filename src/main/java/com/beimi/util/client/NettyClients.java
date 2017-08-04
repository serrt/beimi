package com.beimi.util.client;

import java.util.List;

import com.corundumstudio.socketio.SocketIOClient;


public class NettyClients {
	
	private static NettyClients clients = new NettyClients();
	
	private NettyGameClient gameClients = new NettyGameClient();
	private NettySystemClient systemClients = new NettySystemClient();
	
	public static NettyClients getInstance(){
		return clients ;
	}

	public void setImClients(NettyGameClient imClients) {
		this.gameClients = imClients;
	}
	public void putIMEventClient(String id , SocketIOClient userClient){
		gameClients.putClient(id, userClient);
	}
	public void removeIMEventClient(String id , String sessionid){
		gameClients.removeClient(id, sessionid);
	}
	public void sendIMEventMessage(String id , String event , Object data){
		List<SocketIOClient> userClients = gameClients.getClients(id) ;
		for(SocketIOClient userClient : userClients){
			userClient.sendEvent(event, data);
		}
	}
	
	public void setAgentClients(NettySystemClient agentClients) {
		this.systemClients = agentClients;
	}
	public void putAgentEventClient(String id , SocketIOClient agentClient){
		systemClients.putClient(id, agentClient);
	}
	public void removeAgentEventClient(String id , String sessionid){
		systemClients.removeClient(id, sessionid);
	}
	public void sendAgentEventMessage(String id , String event , Object data){
		List<SocketIOClient> agents = systemClients.getClients(id) ;
		for(SocketIOClient agentClient : agents){
			agentClient.sendEvent(event, data);
		}
	}
}
