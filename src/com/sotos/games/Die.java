package com.sotos.games;

import java.util.Random;

public class Die {
	private static Die instance = null;

	private Die() {
	}

	public static Die getInstance() {
		if (instance == null) {
			instance = new Die();
		}
		return instance;
	}

	public int throwDie() {
		Random rand = new Random();
		int x = rand.nextInt(5) + 1;
		return x;
	}
}
