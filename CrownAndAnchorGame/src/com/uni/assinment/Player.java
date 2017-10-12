package com.uni.assinment;

public class Player {
	
	//for bug5 (1.) 
	public static final int AGELIMIT = 18;
	private String name;
	private int balance;
	private int limit;
	private int playersAge; // //for bug5 (2.)
	
	public Player(String name, int balance, int playersAge) {
		if (name == null || name .isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");
		if (balance < 0) throw new IllegalArgumentException("Balance cannot be negative");
		
		if (playersAge < AGELIMIT) throw new IllegalArgumentException("Player should be 18 years and above");
		this.name = name;
		this.balance = balance;
		this.limit = 0;
	}
		
	public String getName() { return name; }
	public int getBalance() { return balance; }
	public int getLimit() { return limit; }
	public int getPlayersAge() { return playersAge; }
	
	public void setLimit(int limit) {
		if (limit < 0) throw new IllegalArgumentException("Limit cannot be negative.");
		if (limit > balance)  throw new IllegalArgumentException("Limit cannot be greater than balance.");
		this.limit = limit;
	}

	public boolean balanceExceedsLimit() {
		return (balance > limit);
	}
	
	public boolean balanceExceedsLimitBy(int amount) {
		//for bug2 (1.) update the return conditions
		// return (balance - amount > limit);
		if (amount < 0) {
			throw new IllegalArgumentException("Bet cannot be 0 or less than 0.");
		}
		return (balance == amount)? true : (balance - amount > limit);
	}
	
	public void takeBet(int bet) {
		if (bet < 0) throw new IllegalArgumentException("Bet cannot be negative.");
		if (!balanceExceedsLimitBy(bet)) throw new IllegalArgumentException("Placing bet would go below limit.");
		balance = balance - bet;
	}
	
	public void receiveWinnings(int winnings) {
		if (winnings < 0) {
			throw new IllegalArgumentException("Winnings cannot be negative.");
		}
		
		//==== for bug1 (2.) checking the wining amount is calculating correct
		// but it does but need to change the place where it takeout the bet 
		//System.out.println("Balance = "+balance+",  wining = "+winnings);
		balance = balance + winnings;		
	}
	
	public String toString() {
		return String.format("Player: %s, Balance: %d, Limit: %d", name, balance, limit);
	}
}
