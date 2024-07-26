import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		int key = scanner.nextInt();
		String resultString = Encrypt(string,key);
		System.out.println(resultString);
		
	}

	public static String Encrypt(String string, int key) {
		StringBuilder s1 = new StringBuilder(string);
		for(int i=0;i<s1.length();i++)
		{
			
			char c = s1.charAt(i);
			if(c == ' ')
			{
				continue;
			}
			else {
			int k = ((c-'a'+key)%26);
			s1.setCharAt(i, (char) ((char)'a'+k));
			}
		}
		
		
		
		return s1.toString();
	}

}
