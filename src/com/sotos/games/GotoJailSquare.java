package com.sotos.games;

public class GotoJailSquare extends Square {
	private static GotoJailSquare instance = null;
	
	private GotoJailSquare(int position_) {
		this.positionInBoard = position_;
	}

	public static GotoJailSquare getInstance(int position) {
		if (instance == null) {
			instance = new GotoJailSquare(position);
		}
		return instance;
	}
	
	public int getPositionInBoard(){
		return this.positionInBoard;
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return "Go to Jail";
	}

	public void doAction(Player p){
		p.goInJail();
	}

}
