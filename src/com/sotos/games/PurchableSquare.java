package com.sotos.games;

public abstract class PurchableSquare extends Square {

	protected boolean available;
	protected Player owner;
	protected int price;
	protected int rent;

	protected PurchableSquare(String name_, boolean available_, int price_, int rent_) {
		this.available = available_;
		this.price = price_;
		this.rent = rent_;
		this.name = name_;
	}

	abstract protected int getRent();

	protected int getPrice(){
		return this.price;
	}

	protected Player getOwner() {
		return this.owner;
	}

	protected void setOwner(Player p) {
		this.owner = p;
	}

	protected boolean isAvailable(){
		if (this.owner != null)
			this.available = false;
		else
			this.available = true;
	
		return this.available;
	}
}
