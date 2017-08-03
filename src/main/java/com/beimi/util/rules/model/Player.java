package com.beimi.util.rules.model;

public class Player implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private byte[] cards ;	//玩家手牌，顺序存储 ， 快速排序（4个Bit描述一张牌，玩家手牌 麻将 13+1/2 = 7 byte~=long）
	private byte info ;		//复合信息存储，用于存储玩家位置（2^4,占用4个Bit，最大支持16个玩家）（是否在线1个Bit），是否庄家/地主（1个Bit），是否当前出牌玩家（1个Bit）（是否机器人1个Bit）
	private byte[] played ;	//杠碰吃胡

	public byte[] getCards() {
		return cards;
	}

	public void setCards(byte[] cards) {
		this.cards = cards;
	}

	public byte getInfo() {
		return info;
	}

	public void setInfo(byte info) {
		this.info = info;
	}

	public byte[] getPlayed() {
		return played;
	}

	public void setPlayed(byte[] played) {
		this.played = played;
	}
}
