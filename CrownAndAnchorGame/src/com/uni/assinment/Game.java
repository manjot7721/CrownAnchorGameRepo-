package com.uni.assinment;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Game {

	private List<Dice> dice;
	private List<DiceValue> values;
	
	public Game(Dice die1, Dice die2, Dice die3) {
		if (die1 == null || die2 == null || die3 == null) throw new IllegalArgumentException("Dice cannot be null.");
		dice = new ArrayList<Dice>();
		dice.add(die1);
		dice.add(die2);
		dice.add(die3);
		values = new ArrayList<DiceValue>();
	}

	public List<DiceValue> getDiceValues() {
		values.clear();
		for (Dice d : dice) {
			values.add(d.getValue());
		}
		return Collections.unmodifiableList(values);
	}	
	
	public int playRound(Player player, DiceValue pick, int bet ) {		
		if (player == null) throw new IllegalArgumentException("Player cannot be null.");
		if (pick == null) throw new IllegalArgumentException("Pick cannot be negative.");
		if (bet < 0) throw new IllegalArgumentException("Bet cannot be negative.");
		
		//for bug1 (3.) Changing the bet taking place
		//player.takeBet(bet);
		    
		int matches = 0;
		for ( Dice d : dice) {
			d.roll();
			if (d.getValue().equals(pick)) { 
				matches += 1;
			}
		}
		
		int winnings = matches * bet;
		
		//==== for bug1 ( 1.) checking the wining amount and matches are calculating correct
		System.out.println("win amount = "+winnings);
		System.out.println("win matches = "+matches);
		if (matches > 0) {			
			player.receiveWinnings(winnings);
		} else {
			//for bug1 (4.) Update the bet taking place
			// only if they player lost the game otherwise unless we shouldn't take the bet
			player.takeBet(bet);
		}
        return winnings;		
	}
	
}
