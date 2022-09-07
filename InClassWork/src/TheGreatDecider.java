import java.util.Random;

public class TheGreatDecider {

	public static void main(String[] args) {
		int playerOneHitPoints = 10;
		int playerTwoHitPoints = 10;
		
		Random dice = new Random();
		while (playerOneHitPoints > 0 && playerTwoHitPoints > 0) {
			//do combat
			System.out.println("New Round... FIGHT!");
			
			int playerOneToHitRoll = dice.nextInt(20) + 1; //Roll a number between 1 and 20 (including ends)
			
			System.out.println("Player one hit roll " + playerOneToHitRoll);
			int damage = 0;
			if (playerOneToHitRoll > 20) {
				System.out.println("Critical Hit");
				damage = dice.nextInt(8) + 1;
				damage += dice.nextInt(8) + 1;
				
			} else if (playerOneToHitRoll > 12) {
				System.out.println("Hit");
			} else if (playerOneToHitRoll == 1) {
				System.out.println("Critical Fumble");
			} else {
				System.out.println("Player one missed");
			}
			playerTwoHitPoints -= damage;
			
			
			
			int playerTwoHitRoll = dice.nextInt(20) + 1; //Roll a number between 1 and 20 (including ends)
			
			System.out.println("Player two hit roll " + playerTwoHitRoll);
			int odamage = 0;
			if (playerTwoHitRoll > 20) {
				System.out.println("Critical Hit");
				odamage = dice.nextInt(8) + 1;
				odamage += dice.nextInt(8) + 1;
				
			} else if (playerTwoHitRoll > 12) {
				System.out.println("Hit");
			} else if (playerTwoHitRoll == 1) {
				System.out.println("Critical Fumble");
			} else {
				System.out.println("Player two missed");
			}
			playerOneHitPoints -= damage;
		}
	}

}
