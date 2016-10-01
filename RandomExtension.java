import java.util.Random;
import java.util.Scanner;


public class RandomExtension extends Random{

	
	public static void main(String[] args) {
		
		int n;
		Double sig;
		
		if(args.length == 0){
			Scanner  sc = new Scanner(System.in);
			System.out.println("Input N:");
			n = sc.nextInt();
			System.out.println("Input sigma");
			sig = sc.nextDouble();
		}else{
			n = Integer.parseInt(args[0]);
			sig = Double.parseDouble(args[1]);
		}
		
		System.out.println(maxwellBoltzman(n, sig));
		
	}

	public static double maxwellBoltzman(int num, double sig){
		
		Random r = new Random();
		
		double one = r.nextGaussian()*sig;
		double two = r.nextGaussian()*sig;
		double three = r.nextGaussian()*sig;
		
		return Math.pow(one+two+3, 2);
		
		
	}
	
}
