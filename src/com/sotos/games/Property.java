package com.sotos.games;

public class Property extends PurchableSquare {

	protected Property(String name_, int position_, int price_, int rent_,
			String group_, boolean available_) {
		super(name_, available_, price_, rent_);
		// TODO Auto-generated constructor stub
		this.name = name_;
		this.available = available_;
		this.price = price_;
		this.rent = rent_;
		this.positionInBoard = position_;
		this.group = group_;
	}

	@Override
	protected int getRent() {
		return this.rent;
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public int getPositionInBoard(){
		return this.positionInBoard;
	}
}
