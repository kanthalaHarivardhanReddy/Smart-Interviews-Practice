import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        long tc = sc.nextLong();
        StringBuilder ans = new StringBuilder();
        while(tc-- > 0) {
            long n = sc.nextLong();
            StringBuilder sb = new StringBuilder();
            if(n == 0) sb.append("0");
            while(n > 0) {
                sb.append((n&1));
                n = n>>1;
            }
            ans.append(sb.reverse().toString() + "\n");
        }
        System.out.println(ans.toString());
    }
}
