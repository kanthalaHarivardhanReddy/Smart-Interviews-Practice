import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0) {
            int n = sc.nextInt();
            BigInteger bi = new BigInteger("0");
            for(int i = 0; i < n; i++) 
                bi = bi.add(new BigInteger(sc.nextLong()+""));
            System.out.println(bi.toString());
        }
    }
}
