import java.util.Scanner;


public class Checksum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args.length == 0){
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter an integer:");
			String userString = (sc.next());
			System.out.println(verifyNumber(userString));
		}else{
			
			System.out.println(verifyNumber(args[0]));
			
		}

	}

	public static String verifyNumber(String s){
		
		int total = 0;
		
		if(s.length() == 10){
			
			System.out.println("Integer inputted is of correct length");
			for(int i = 0; i < s.length(); i++){
				
				if(i%2 == 0){
					
					total += Character.getNumericValue(s.charAt(i));
					
				}else{
					
					int doubled  = Character.getNumericValue(s.charAt(i))*2;
					if(doubled >= 10){
						
						String doubledString = Integer.toString(doubled);
						total = total + Character.getNumericValue(doubledString.charAt(0)) + Character.getNumericValue(doubledString.charAt(1));
						
					}else{
						total += doubled;
					}
					
				}
				
			}
			int difference = total % 10;
			return s + Integer.toString(10-difference);
			
		}else{
			
			System.out.println("Integer inputted is NOT of correct length.");
			return "Not a valid entry";
		}
		
		
	}
	
}
