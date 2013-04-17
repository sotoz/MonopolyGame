package com.sotos.games;

public class CardSquare extends Square {
	private String type;
	
	public CardSquare(String type, int position_) {
		this.type = type;
		this.positionInBoard = position_;
	}

	protected int getPositionOnBoard() {
		return this.positionInBoard;
	}

	protected String getName() {
		// TODO Auto-generated method stub
		return this.type;
	}

}
