package com.sotos.games;

public class JailSquare extends Square {
	private static JailSquare instance = null;

	private JailSquare(int position_) {
		this.positionInBoard = position_;
	}

	public static JailSquare getInstance(int position) {
		if (instance == null) {
			instance = new JailSquare(position);
		}
		return instance;
	}

	protected String getName() {
		// TODO Auto-generated method stub
		return "Jail";
	}

	public int getPositionInBoard() {
		return this.positionInBoard;
	}

}
