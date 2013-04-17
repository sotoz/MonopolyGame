package com.sotos.games;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class FacadeGame {
	private ArrayList<Player> listOfPlayers = new ArrayList<Player>();
	private HashMap<Integer, Square> board = new HashMap<Integer, Square>();
	Utility fuel;
	Utility electricity;

	private int howManyRounds;

	public FacadeGame(int numberOfPlayers, int howManyRounds,
			String fileWithProperties) throws IOException {
		// first load the properties file
		try {
			System.out.println("Welcome to Monopoly Bored Game : Supermarket");

			FileReader fr = new FileReader(fileWithProperties);
			BufferedReader br = new BufferedReader(fr);

			// Read the first line. and initialise the board
			String row = br.readLine();

			while (row != null) {
				String[] dataArray = row.split(",");
				Property p = new Property(dataArray[0],
						Integer.parseInt(dataArray[1]),
						Integer.parseInt(dataArray[2]),
						Integer.parseInt(dataArray[3]), dataArray[4], true);
				board.put(Integer.parseInt(dataArray[1]), p);
				row = br.readLine();
			}
			// Close the file once all data has been read.
			br.close();

			// Add start on the board
			board.put(0, StartSquare.getInstance(0));

			// Add the utilities on the board
			fuel = new Utility("Fuel", 150, 9);
			electricity = new Utility("Electricity", 150, 21);
			board.put(9, fuel);
			board.put(21, electricity);

			// Add Airport
			board.put(12, AirportSquare.getInstance(12));

			// Add jail and go to jail square on the board
			board.put(6, JailSquare.getInstance(6));			
			board.put(18, GotoJailSquare.getInstance(18));

			// Add coincidence and providence card squares
			board.put(3, new CardSquare("coincidence", 3));
			board.put(15, new CardSquare("providence", 15));

			System.out.println("Board has " + board.size()
					+ " squares in play.");
			// get how many rounds we want to play
			this.howManyRounds = howManyRounds;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File " + fileWithProperties
					+ " not found. Please check file exists and try again");
			e.printStackTrace();
			System.exit(1);
		} catch (NumberFormatException nfe) {
			System.out.println("Some problem reading the contents of the file "
					+ fileWithProperties);
			nfe.printStackTrace();
			System.exit(1);
		}

		// create the players

		for (int i = 1; i <= numberOfPlayers; i++) {
			System.out.print("Add player number " + i + " : ");
			String name = "Default player " + i;
			try {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(System.in));
				name = reader.readLine();
				Player pl = new Player(name, 1500);
				listOfPlayers.add(pl);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// start the game
		this.start();
	}

	private void start() {
		System.out.println("Players are :");
		for (int i = 0; i < this.listOfPlayers.size(); i++) {
			System.out.println(listOfPlayers.get(i).toString());
		}

		for (int i = 1; i <= this.howManyRounds; i++) {

			System.out.println("Round no: " + String.valueOf(i));

			for (int j = 0; j < this.listOfPlayers.size(); j++) {
				// current player
				Player currentPlayer = listOfPlayers.get(j);
				String currentPlayerName = currentPlayer.getName();
				int currentPlayersPosition = currentPlayer.getCurrentPosition();

				System.out.println();
				System.out.println("Current player is " + currentPlayerName
						+ " and his current position is "
						+ board.get(currentPlayersPosition).getName());

				// Current player rolls
				int roll = Die.getInstance().throwDie();
				System.out.println(currentPlayerName + " rolls "
						+ String.valueOf(roll));

				int newPlayersPosition;

				// Current player lands on a square
				// Check if player lands or passes start
				if (currentPlayersPosition + roll == 23) {
					newPlayersPosition = 0;
					System.out.println(currentPlayerName
							+ " lands on Start. He gets 200 euro.");
					currentPlayer.addMoney(200);
				} else if (currentPlayersPosition + roll > 23) {
					newPlayersPosition = ((currentPlayersPosition + roll) - 23) - 1;
					System.out.println(currentPlayerName
							+ " passes Start. He gets 200 euro.");
					currentPlayer.addMoney(200);
				} else {
					newPlayersPosition = currentPlayersPosition + roll;
				}
				currentPlayer.setCurrentPosition(newPlayersPosition);

				System.out.println(currentPlayerName + " has "
						+ currentPlayer.getMoney());
				System.out.println(currentPlayerName + " goes to square : "
						+ board.get(newPlayersPosition).getName());

				
				System.out.println("current square position "+ board.get(newPlayersPosition).getPositionInBoard());
				switch (board.get(newPlayersPosition).getPositionInBoard()) {
				case 3:
					System.out.println(currentPlayerName + " LANDED ON THE coincidence");
					break;
				case 15:
					System.out.println(currentPlayerName + " LANDED ON THE providence");
					break;
				case 9:
				case 21:
					System.out.println(currentPlayerName + " LANDED ON A UTILITY");
					// current player decides if he wants to buy
					break;
				case 12:
					System.out.println(currentPlayerName + " LANDED ON THE AIRPORT");
					break;	
				case 6:
					System.out.println(currentPlayerName + " LANDED ON THE JAIL");
					break;					
				case 18:
					System.out.println(currentPlayerName + " LANDED ON GO TO JAIL");
					GotoJailSquare.getInstance(18).doAction(currentPlayer);
					break;
				case 0:
					System.out.println(currentPlayerName + " LANDED ON THE START");
					break;
				default:
					System.out.println(currentPlayerName + " LANDED ON a single property");
					// current player decides if he wants to buy
					break;
				}

				

				System.out.println();
			}// go to next player

			System.out.println("---------End of Round--------");
			System.out.println();
		}
	}

}
