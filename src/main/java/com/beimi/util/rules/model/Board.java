package com.beimi.util.rules.model;

/**
 * 牌局，用于描述当前牌局的内容 ， 
 * 1、随机排序生成的 当前 待起牌（麻将、德州有/斗地主无）
 * 2、玩家 手牌
 * 3、玩家信息
 * 4、当前牌
 * 5、当前玩家
 * 6、房间/牌桌信息
 * 7、其他附加信息
 * 数据结构内存占用 78 byte ， 一副牌序列化到 数据库 占用的存储空间约为 78 byt， 数据库字段长度约为 20
 *
 * @author iceworld
 *
 */
public class Board implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private byte[] cards;	//4个Bit描述一张牌，麻将：136+2/2 = 69 byte ; 扑克 54/2 = 27 byte 
	private Player[] players;//3~10人(4 byte)
	private int room ;		//房间ID（4 byte）
	private byte info ;		//复合信息 ，当前牌（4 Bit）， 当前玩家 （4 Bit）(1 byte)
	private byte order ;	//序号
	
	public byte[] getCards() {
		return cards;
	}
	public void setCards(byte[] cards) {
		this.cards = cards;
	}
	public Player[] getPlayers() {
		return players;
	}
	public void setPlayers(Player[] players) {
		this.players = players;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public byte getInfo() {
		return info;
	}
	public void setInfo(byte info) {
		this.info = info;
	}
	public byte getOrder() {
		return order;
	}
	public void setOrder(byte order) {
		this.order = order;
	}
}
