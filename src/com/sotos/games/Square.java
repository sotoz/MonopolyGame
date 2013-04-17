package com.sotos.games;

public abstract class Square {
	protected int positionInBoard;
	protected String name;
	protected String group;
	
	abstract protected String getName();
	
	protected int getPositionInBoard(){
		return this.positionInBoard;
	}
}