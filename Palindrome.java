import java.util.Scanner;

public class Palindrome{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a test subject:" );
		String input = in.nextLine();
		String inputtrimmed = input.trim();
		System.out.println("Output: " + ispal(inputtrimmed));
		//call the checking method here and give inputtrimmed as parameter
	}
	public static String ispal(String in){
		int length = in.length();
		String out = "false";
		//if((length % 2) == 0){
			int counterFirst = 0;
			int counterLast = counterFirst+1;
			int counterFirstEnd = length;
			int counterFirstEnd1 = length-1;
			int val = 0;
			while(counterLast<=(length/2)){
				
				if((in.substring(counterFirst, counterLast)).equals(in.substring(counterFirstEnd1,counterFirstEnd))){
					counterFirst++;
					counterLast++;
					counterFirstEnd--;
					counterFirstEnd1--;
					val++;
				}
				else{
					return "false";
				}
			}
			if(val == length/2){
				return "true";
			}
		//}
		/*if((length % 2) == 1){
			int counterFirst = 0;
			int counterLast = counterFirst+1;
			int counterFirstEnd = length;
			int counterFirstEnd1 = length-1;
			int val = 0;
			while(counterLast<=(length/2)){
				//System.out.println("test");
				if((in.substring(counterFirst, counterLast)).equals(in.substring(counterFirstEnd1,counterFirstEnd))){
					counterFirst++;
					counterLast++;
					counterFirstEnd--;
					counterFirstEnd1--;
					val++;
				}
				else{
					return "false";
				}
			}
			if(val == length/2){
				return "true";
			}
		}*/
		return "false";
	}
	
}