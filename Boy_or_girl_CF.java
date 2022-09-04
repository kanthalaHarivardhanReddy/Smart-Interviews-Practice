import java.io.*;
import java.util.*;
public class Boy_Or_Girl_CF {
	public static void main(String[] args) {
// 		try{
// 			System.setIn(new FileInputStream("input.txt"));
// 			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
// 		}
// 		catch(Exception e) {
// 			System.err.println(e);
// 		}

		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String name = sc.next();
		Set<Character> set = new HashSet<>();
		for(char ch: name.toCharArray()) {
			set.add(ch);
		}
		if((set.size()&1) == 0) System.out.print("CHAT WITH HER!");
		else System.out.print("IGNORE HIM!");
	}
}
