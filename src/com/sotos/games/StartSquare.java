package com.sotos.games;

public class StartSquare extends Square {
	private static StartSquare instance = null;

	private StartSquare(int position) {
		this.positionInBoard = position;
	}

	public static StartSquare getInstance(int position) {
		if (instance == null) {
			instance = new StartSquare(position);
		}
		return instance;
	}

	public int getPositionOnBoard() {
		return this.positionInBoard;
	}

	protected String getName() {
		// TODO Auto-generated method stub
		return "Start";
	}

}
