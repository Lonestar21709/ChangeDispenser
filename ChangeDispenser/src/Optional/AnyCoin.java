package Optional;

public class AnyCoin {
	private double coin1;
	private double coin2;
	private double coin3;
	private double coin4;
	
	public AnyCoin(double coin1, double coin2, double coin3, double coin4) {
		this.coin1 = coin1;
		this.coin2 = coin2;
		this.coin3 = coin3;
		this.coin4 = coin4;
	}
	
	public double getCoin1() {
		return coin1;
	}

	public double getCoin2() {
		return coin2;
	}

	public double getCoin3() {
		return coin3;
	}

	public double getCoin4() {
		return coin4;
	}

	
	public int changeDenom(int newCoin, double value){
		System.out.println(newCoin);
		if(newCoin == 1){
			this.coin1 = value;
			return 2;
		}
		else if(newCoin == 2){
			this.coin2 = value;
			return 2;
		}
		else if(newCoin == 3){
			this.coin3 = value;
			return 2;
		}
		else if(newCoin == 4){
			this.coin4 = value;
			return 2;
		}
		return 1;
		
		
		
	}
	
	public double changeDispenser(double change) {
//		if(change <= 0){
//			System.out.println("Amount Entered: $" + change);
//			System.out.println("Error, value must be greater than 0");
//			System.out.println("");
//			return -1;
//		}
		
		double calc_change = Math.round(change * 100);
		double change_left = 0;
		
		//Coin One
		double coin1_count = Math.floor(calc_change / coin1);
		change_left = calc_change - (coin1 * coin1_count);
		
		//reset calc_change with new value
		calc_change = change_left;
		//Coin Two
		double coin2_count = Math.floor(change_left / coin2);
		change_left = calc_change - (coin2 * coin2_count);
		
		//reset calc_change with new value
		calc_change = change_left;
		
		//Coin Three
		double coin3_count = Math.floor(change_left / coin3);
		change_left = calc_change - (coin3 * coin3_count);
		
		//reset calc_change with new value
		calc_change = change_left;
		//Coin Four
		double coin4_count = Math.floor(change_left / coin4);
		change_left = calc_change - (coin4 * coin4_count);
		
		
		//////////////////////////////
		System.out.println("--Change Dispensed--");
		System.out.println("Amount Entered: $" + change);
		System.out.println("Coin 1 Value: " +this.coin1 + ", Coins returned: "+ coin1_count); 
		System.out.println("Coin 2 Value: " +this.coin2 + ", Coins returned: "+ coin2_count); 
		System.out.println("Coin 3 Value: " +this.coin3 + ", Coins returned: "+ coin3_count); 
		System.out.println("Coin 4 Value: " +this.coin4 + ", Coins returned: "+ coin4_count); 
		
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
