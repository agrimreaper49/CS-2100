
public class FourFunctions {
	public static void main (String [] args) {
		int [] arr = {6, 5, 6 , 6, 6, 5, 5,5};
		System.out.println(mode(arr));
	}
	public static int evenSumSplit(int [] numbers) {
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}
		if (sum % 2 != 0) {
			return -1;
		}
		int currentSum = 0;
		for (int i = 0; i < numbers.length; i++) {
			currentSum += numbers[i];
			if (currentSum == (sum / 2)) {
				return i;
			}
		}
		return -1;
	}
	public static boolean just8and9(int [] numbers) {
		for (int num : numbers) {
			if (num != 8 || num != 9) {
				return false;
			}
		}
		return true;
	}
	public static int countRuns(int [] numbers) {
		int numRuns = 0;
		boolean inRun = false;
		for (int i = 1; i < numbers.length; i++) {
			int previous = numbers[i - 1];
			int current = numbers[i];
			if (previous == current) {
				if (!inRun) {
					inRun = true;
					numRuns++;
				}
			} else {
				if (inRun) {
					inRun = false;
				}
			}
		}
		return numRuns;
	}
	public static int sum67(int [] numbers) {
		boolean sixSeen = false;
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (sixSeen) {
				if (numbers[i] == 7) {
					sixSeen = false;
				}
			} else if (numbers[i] == 6) {
				sixSeen = true;
			} else {
				sum += numbers[i];
			}
		}
		return sum;
	}
	public static int mode(int [] numbers) {
		int [] nums = new int [numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if (numbers[i] == numbers[j] && i != j) {
						nums[i]++;
				}
			}
		}
		int highest = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > highest) {
				highest = nums[i];
			}
		}
		if (highest <= 0) {
			return numbers[0];
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == highest) {
				return numbers[i];
			}
		}
		//SHOULD NEVER BE REACHED
		return -1;
	}
}
