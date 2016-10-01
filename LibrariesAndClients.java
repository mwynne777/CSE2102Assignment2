import java.util.Random;
import java.util.Scanner;


public class LibrariesAndClients {

	
	public static void main(String[] args) {
		
		int randomNumbers;
		
		if(args.length == 0){
			
			Scanner sc = new Scanner(System.in);
			System.out.println("How many random numbers would you like to generate?");
			randomNumbers = sc.nextInt();
			
		}else{
			
			randomNumbers = Integer.parseInt(args[0]);
			
		}
		
		Random r = new Random();
		
		for(int i = 0; i < randomNumbers; i++){
			System.out.println("\nIteration Number" + (i+1) + ":\n");
			System.out.println("Using nextInt(): " + r.nextInt());
			System.out.println("Using nextBoolean():  " + r.nextBoolean());
			System.out.println("Using nextFloat():  " + r.nextFloat());
			System.out.println("Using nextGaussian(): " + r.nextGaussian());
			System.out.println("Using nextLong():  " + r.nextLong());

			
		}
		
	}

}
