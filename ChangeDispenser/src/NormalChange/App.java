package NormalChange;

import java.util.Scanner;

public class App {
	
	public static void main(String [] args){
		
		run();
		
	}
	
	
	public static void run(){
		//variables
		double change = 0;
		Scanner sc = new Scanner(System.in);
		int run, run2;
		//default coin values
		double coin1 = 25, coin2 = 10, coin3 = 5, coin4 = 1;
		
		//Example
		System.out.println("Change Dispenser");
		System.out.println("Test Trial Run");
		change = 4.33;
		changeDispenser(change, coin1, coin2, coin3, coin4);
		
		///////////////////////////
		System.out.println("Would you like to enter a new amount?");
		System.out.print("1 for yes, 2 to quit: ");
		run = sc.nextInt();
		
		while(run == 1){
			System.out.print("Enter amount of Change: ");
			change = sc.nextDouble();
			//ask user if they want to change coin denomination
			
			System.out.println("Would you like to change a coin denomination? 1 for yes, 2 for no" );
			run2 = sc.nextInt();
			while(run2 == 1){
				double input;
				System.out.println("Enter exact value of coin to replace(enter 2 to quit): ");
				System.out.println("Coin 1: " + coin1 + ", Coin 2: " + coin2 + ", Coin 3: " + coin3 + ", Coin 4: " + coin4);
				input = sc.nextDouble();
				if(input == coin1){coin1 = input;}
				else if(input == coin2){coin2 = input;}
				else if(input == coin3){coin3 = input;}
				else if(input == coin4){coin4 = input;}
				
				System.out.println("Incorrect Value, must restart query");
				System.out.println("Enter 1 to retry, 2 to back out: ");
				run2 = sc.nextInt();
				
				
			}
			changeDispenser(change, coin1, coin2, coin3, coin4);
			
			
			//ask user for another
			System.out.println("Would you like to enter a new amount? ");
			System.out.println("1 for yes, 2 to quit: ");
			run = sc.nextInt();
		}
		
		
		System.out.println("");
		System.out.println("Program Terminated");
		
		
	}
	public static double changeDenom(double coin, double newCoin){

		newCoin = coin;
		return newCoin;
	}
	public static double changeDispenser(double change, double coin1, double coin2, double coin3, double coin4){
		
		//check 
		if(change <= 0){
			System.out.println("Amount Entered: $" + change);
			System.out.println("Error, value must be greater than 0");
			System.out.println("");
			return -1;
		}
		//convert number to a whole number
		double calc_change = Math.round(change * 100);
		double change_left = 0;
		
		//Coin 1
		double quarter_count = Math.floor(calc_change / 25);
		change_left = calc_change - (25 * quarter_count);
		
		//reset calc_change with new value
		calc_change = change_left;
		//Coin 2
		double dime_count = Math.floor(change_left / 10);
		change_left = calc_change - (10 * dime_count);
		
		//reset calc_change with new value
		calc_change = change_left;
		
		//Coin 3
		double nickel_count = Math.floor(change_left / 5);
		change_left = calc_change - (5 * nickel_count);
		
		//reset calc_change with new value
		calc_change = change_left;
		
		//Coin 4
		double penny_count = Math.floor(change_left / 1);
		change_left = calc_change - (penny_count);
		
		//////////////////////////////
		System.out.println("Amount Entered: $" + change);
		System.out.println("Quarters: " + quarter_count + " Dimes: " + dime_count + " Nickels: " + nickel_count + " Pennies: " + penny_count);
		System.out.println("");
		
		/////////////////////////////
		//Check for remaining change
		if(change_left > 0){
			System.out.println("Could not convert all change");
			change_left = change_left / 100;
			System.out.println("Change Remaining: $" + change_left);
		}
		System.out.println("");
		/////////////////////////////
		return change;
		
	}
}
