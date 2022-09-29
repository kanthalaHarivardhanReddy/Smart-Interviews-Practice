import java.io.*;
import java.util.*;

public class Solution {
    private static boolean diffwithk(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        for(int ele: arr) {
            if(set.contains(k+ele) || set.contains(ele-k)) return true;
            set.add(ele);
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i < n;i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(diffwithk(arr, k));
        }
    }
}
