package com.sotos.games;

public class AirportSquare extends Square {
	private static AirportSquare instance = null;

	private AirportSquare(int position_) {
		this.positionInBoard = position_;
	}

	public static AirportSquare getInstance(int position) {
		if (instance == null) {
			instance = new AirportSquare(position);
		}
		return instance;
	}

	public void setPositionOnBoard(int position) {
		// TODO Auto-generated method stub
		positionInBoard = position;
	}

	public int getPositionOnBoard() {
		return this.positionInBoard;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Airport";
	}
}
