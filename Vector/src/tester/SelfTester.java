package tester;

public class SelfTester {
	public static void main (String [] args) {
		vector.Vector<Integer> studList = new vector.Vector<Integer>(10);
		for (int i = 0; i < studList.size(); i++) {
			studList.insertAtTail((int)(Math.random() * 5));
		}
		for (int i = 0; i < studList.size(); i++) {
			System.out.println(studList.get(i));
		}
	}	
}
