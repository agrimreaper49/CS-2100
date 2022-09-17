import java.util.Arrays;

public class RobotZookeeper {
	private int monkeyScore;
	private int lionScore;
	private int elephantScore;
	public int getMonkeyScore() {
		return monkeyScore;
	}
	public void setMonkeyScore(int score) {
		monkeyScore = score;
	}
	public int getLionScore() {
		return lionScore;
	}
	public void setLionScore(int score) {
		lionScore = score;
	}
	public int getElephantScore() {
		return elephantScore;
	}
	public void setElephantScore(int score) {
		elephantScore = score;
	}
	public Food feedAnimal(Animal animal) {
		if (animal.equals(Animal.LION)) {
			return Food.MEAT;
		} else if (animal.equals(Animal.MONKEY)) {
			return Food.FRUIT;
		}
		//For Elephant
		return Food.LEAVES;
	}
	public Toy entertainAnimal(Animal animal) {
		if (animal.equals(Animal.ELEPHANT)) {
			return Toy.HAT;
		} else if (animal.equals(Animal.MONKEY)) {
			return Toy.BALL;
		} 
		//For Lion
		return Toy.BOX;
	}
	public Attention showAttention(Animal animal) {
		if (animal.equals(Animal.ELEPHANT)) {
			return Attention.SCRATCHES;
		} else if (animal.equals(Animal.LION)) {
			return Attention.PETS;
		}
		//For Monkey
		return Attention.TALKING;
	}
	public Animal handleRequests(AnimalNeed elephantNeed, AnimalNeed lionNeed, 
			AnimalNeed monkeyNeed) {
//		if (getLionScore() == getMonkeyScore() && getLionScore() == getElephantScore()) {
//			setLionScore(getLionScore() + 1);
//			return Animal.LION;
//		} else if (getLionScore() > getMonkeyScore() && getMonkeyScore() < getElephantScore()) {
//			setMonkeyScore(getMonkeyScore() + 1);
//			return Animal.MONKEY;
//		} else if (getMonkeyScore() > getLionScore() && getLionScore() < getElephantScore()) {
//			setLionScore(getLionScore() + 1);
//			return Animal.LION;
//		} else if (getLionScore() > getElephantScore() && getElephantScore() < getMonkeyScore() ) {
//			setElephantScore(getElephantScore() + 1);
//			return Animal.ELEPHANT;
//		} else if (getLionScore() == getElephantScore() && getMonkeyScore() < getLionScore()) {
//			setMonkeyScore(getMonkeyScore() + 1);
//			return Animal.MONKEY;
//		} else if (getElephantScore() == getMonkeyScore() && getLionScore() < getElephantScore()) {
//			setLionScore(getLionScore() + 1);
//			return Animal.LION;
//		} else if (getLionScore() == getMonkeyScore() && getElephantScore() < getLionScore()) {
//			setElephantScore(getElephantScore() + 1);
//			return Animal.ELEPHANT;
//		}
//		setLionScore(getLionScore() + 1);
//		return Animal.LION;
		int [] scores = new int [3];
		scores[0] = getElephantScore();
		scores[1] = getMonkeyScore();
		scores[2] = getLionScore();
		Arrays.sort(scores);
		if (scores[0] == getElephantScore()) {
			setElephantScore(getElephantScore() + 1);
			return Animal.ELEPHANT;
		} else if (scores[0] == getMonkeyScore()) {
			setMonkeyScore(getMonkeyScore() + 1);
			return Animal.MONKEY;
		} else {
			setLionScore(getLionScore() + 1);
			return Animal.LION;
		}
		
		
	}
}
enum Animal {
	LION, ELEPHANT, MONKEY; 
}
enum AnimalNeed {
	FOOD, TOYS, ATTENTION
}
enum Food {
	FRUIT, LEAVES, MEAT;
}
enum Toy {
	BALL, HAT, BOX;
}
enum Attention {
	SCRATCHES, PETS, TALKING;
}
