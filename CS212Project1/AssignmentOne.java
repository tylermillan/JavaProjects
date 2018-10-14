import java.util.Scanner;

public class AssignmentOne {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		boolean running = true;
		int sum = 0;

		while (running) {	
			System.out.println("Enter a positive integer (-3 to print,-2 to reset,-1 to quit): ");

			int x = scanner.nextInt();
			if (x == -1) {
				System.out.println("Sum: "+sum);
				running = false;
			}else {
				if (x == -2) {
					sum=0;
				}else if (x==-3) {
					System.out.println("Sum: "+sum);
				}else if  (x<-3 || x==0 ) {
					
				}else {
					sum=sum+x;
				}
			}
		}

	}
}