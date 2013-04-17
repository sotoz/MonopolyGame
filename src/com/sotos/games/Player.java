package com.sotos.games;

import java.util.ArrayList;

public class Player {
	private boolean inJail;
	private int money;
	private String name;
	private int currentPosition;
	private ArrayList<Property> properties;
	
	public Player(String name, int money){
		this.money = money;
		this.name = name;
		this.inJail = false;
		this.currentPosition = 0;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getCurrentPosition(){
		return this.currentPosition;
	}
	
	public void setCurrentPosition(int cp){
		this.currentPosition = cp;
	}
	
	public void addMoney(int mon){
		this.money += mon;
	}
	
	public void deductMoney(int mon){
		this.money -= mon;
	}
	
	public int getMoney(){
		return this.money;
	}
	
	public void addPropertyToPlayer(Property p){
		this.properties.add(p);
	}
	
	public void goInJail(){
		this.inJail = true;
	}
	
	public boolean leaveJail(boolean paid) throws Exception{
		if (this.inJail == false){
			throw new Exception("PlayerNotInJail");
		}
		if (paid && this.money > 50){
			this.deductMoney(50);
			this.inJail = false;
		}else{
			throw new Exception("NotEnoughMoneyToLeaveJail");
		}
		return true;	
	}
}
