import java.io.*;
import java.util.*;
public class Young_Physicist_CF {
	public static void main(String[] args) {

		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tc = sc.nextInt();
		int[] arr = new int[3];
		while(tc-- > 0) {
			arr[0] += sc.nextInt();
			arr[1] += sc.nextInt();
			arr[2] += sc.nextInt();
		}
		if(arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == 0) 
			System.out.println("YES");
		else 
			System.out.println("NO");
	}
}
