import java.util.*;

// Name: Agrim Sharma
// Computing ID: hws7ug
// Homework: MinMax Homework 1b

public class MinMax {
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		int [] arr = new int [scan.nextInt()];
//		int [] arr = {33, 33, 1};
		int i = 0;
		while (i < arr.length) {
			int x = scan.nextInt();
			arr[i] = x;
			i++;
		}
		System.out.println(secondMax(arr));
		System.out.println(secondMin(arr));
	}
	public static int secondMax(int [] numbers) {
		int highest = numbers[0];
		int secondHighest = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
		      if (numbers[i] > highest) {
		    	  secondHighest = highest;
		    	  highest = numbers[i];
		      } else if ((highest > numbers[i] && numbers[i] > secondHighest)
		    		  || (secondHighest == highest)) {
		    	  secondHighest = numbers[i];
		      }
		}
		return secondHighest;
	}
	public static int secondMin(int [] numbers) {
		int lowest = numbers[0];
		int secondLowest = numbers[0];
		for (int num : numbers) {
			if (num < lowest) {
				secondLowest = lowest;
				lowest = num;
			} else if ((lowest < num && num < secondLowest) 
					|| (secondLowest == lowest)) {
				secondLowest = num;
			}
		}
		return secondLowest;
	}
}
