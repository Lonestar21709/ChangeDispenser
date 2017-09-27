package Version2;



import java.util.InputMismatchException;

import java.util.Scanner;

public class App {
	
	public static void main(String [] args){
		
		run();
	}//end of main
	
	
	
	
	public static void run(){
		
		
		double change;
		Scanner sc = new Scanner(System.in);
		int run =0, run2 = 0;
		//initial values
		double coin1 = 25, coin2 = 10, coin3 = 5, coin4 = 1; 
		//create instance of Coin Class
		AnyCoin coins = new AnyCoin(coin1, coin2, coin3, coin4);
		//Example
		System.out.println("--Change Dispenser--");
		System.out.println("Test Trial Run");
		change = 4.43;
		coins.changeDispenser(change);
		boolean success = false;
		
		do{//catch one
			try{
				//Ask for user input
				System.out.println("Would you like to enter a new amount?");
				System.out.print("1 for yes, 2 to quit: ");
				run = sc.nextInt();
				success = true;
				}catch(InputMismatchException  e){
					System.out.println("Input is not valid number\n ");	
				}
				sc.nextLine();
			
		}while(!success);//catch one
		
		//If input is 1, run program
		while(run == 1){
			do{ //catch two
				success = false;
				try{
					System.out.print("Enter new amount: $");
					change = sc.nextDouble();
					//check amount entered is valid
					while(!checkValue(change)){
						System.out.println("Invalid Entry: Enter an amount greater than 0: ");
						change = sc.nextDouble();
					}
					success = true;
				}catch(InputMismatchException  e){
					System.out.println("Input is not valid number\n ");
				}
				sc.nextLine();
			}while(!success); //catch two
			
			do{//catch three
				success = false;
				try{
					//ask user if they want to change coin denomination
					System.out.println("Would you like to change a coin denomination? 1:yes, 2:no" );
					run2 = sc.nextInt();
					success = true;
				}catch(InputMismatchException  e){
					System.out.println("Input is not valid number\n ");
				}
//				System.out.println("Press enter");
				sc.nextLine();
			}while(!success); //catch three
			
			
		while(run2 == 1){ //coin denomination loop 
			do{//catch four
				success = false;
				
				try{
					//Display
					int input;
					double newValue;
					System.out.println("--Change Denominator--");
					System.out.println("Coin 1: " + coins.getCoin1() + ", Coin 2: " + coins.getCoin2() + ", Coin 3: " + coins.getCoin3() + ", Coin 4: " + coins.getCoin4());
					System.out.print("Enter the coin number you wish to replace(1-4): ");
					input = sc.nextInt();
					
					//check input
					while(!checkInput(input)){
						System.out.println("Invalid Entry: Enter a number between 1-4");
						input = sc.nextInt();
						checkInput(input);
					}
					//
					System.out.print("Enter new denomination Coin " + input +": ");
					newValue = sc.nextDouble();
					//check input, allow 0
					while(!checkValue(newValue)){
						System.out.println("Invalid Entry: Enter a denomination greater than 0: " );
						newValue = sc.nextDouble();
					}
					
					run2 = coins.changeDenom(input, newValue);
					//if 2 is returned, it was a success
					if(run2 == 2)break;
					System.out.println("Enter 1 to retry, 2 to back out: ");
					run2 = sc.nextInt();

					success = true;
					}catch(InputMismatchException  e){
					System.out.println("Input is not valid number, restarting Change Denominator\n ");
					}
					sc.nextLine();
				}while(!success); //catch four
			}//end of while - run2
			
		//run change dispenser
		coins.changeDispenser(change);
			
		
		//ask user for another
		System.out.println("Would you like to enter a new amount? ");
		System.out.println("1 for yes, 2 to quit: ");
			run = sc.nextInt();
		}//end of while - run
	
		
		System.out.println("Program Terminated!");
	
	}//end of run
		

	public static boolean checkValue(double value){
		if(value <= 0){
			return false;
		}
		else{
			return true;
		}
	}
	public static boolean checkInput(int input){
		if(input == 1){
			return true;
		}
		else if(input == 2){
			return true;
		}
		else if(input == 3){
			return true;
		}
		else if(input == 4){
			return true;
		}
		return false;
	}
}//end of App
