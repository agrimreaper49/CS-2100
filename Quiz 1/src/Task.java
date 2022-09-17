
public class Task {
	public static void main (String [] args) {
		char [] c = new char [1000];
		int i = 4;
		boolean isFinished = false;
		while (!isFinished) {
			int b = (i % 5);
			switch (b) {
				case 0:
					switch (c[i]) {
						case 'a':
							System.out.println("a");
							break;
						case 'b':
							System.out.println("b");
							break;
						case 'c':
							System.out.println("c");
							break;
						default:
							isFinished = true;
							break;
					}
					break;
			}
			i++;
		}
	}
}
	

