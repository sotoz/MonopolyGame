package com.sotos.games;

public class Utility extends Square{
	protected int price;

	public Utility(String name_, int price_, int position_) {
		this.name = name_;
		this.price = price_;
		this.positionInBoard = position_;
	}

	public int getPositionInBoard() {
		return this.positionInBoard;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public int getPrice() {
		return this.price;
	}

}
