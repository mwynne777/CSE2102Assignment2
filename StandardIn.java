import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class StandardIn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BufferedReader br = null;
		
		String userIn = "";

		try {

			String CurrentLine;

			br = new BufferedReader(new FileReader(args[0]));

			while ((CurrentLine = br.readLine()) != null) {
				userIn += " " + CurrentLine;
			}
			
			for(int i = 0; i < userIn.length(); i++){
				if(userIn.charAt(i) == '\t'){
					userIn = userIn.substring(0, i) + ' ' + userIn.substring(i+1, userIn.length());
				}
				
			}
			System.out.println("\nNumber of words:  " + countWords(userIn));
			

		} catch (IOException e) {
			//e.printStackTrace();
			Scanner sc = new Scanner(System.in);
			System.out.println("Please put your text here:");
			userIn = sc.nextLine();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
	
	public static int countWords(String input){
		
		int bAndE = 0;
		
		if(input.indexOf(' ') == 0){
			
			bAndE += 1;
			
		}
		if(input.lastIndexOf(' ') == input.length() - 1){
			
			bAndE += 1;
			
		}
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for (int index = input.indexOf(' '); index >= 0; index = input.indexOf(' ', index + 1))
			{
				al.add(index);
			    //System.out.println(index);
			}
		
		for(int x = 0; x < al.size() - 1; x++){
			
			if(al.get(x) == al.get(x + 1) - 1){
				
				al.remove(x);
				x -= 1;
				
			}
			//System.out.print(al.get(x) + " ");
			
		}
		
		return al.size() + 1 - bAndE;
		
	}

}
