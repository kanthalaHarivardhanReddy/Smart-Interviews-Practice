import java.io.*;
import java.util.*;

public class Solution {
    private static void bsfloor(int[] arr, int[] qr) {
        StringBuilder sb = new StringBuilder();
        for(int q: qr) {
            int ans = Integer.MIN_VALUE;
            int low = 0, hi = arr.length-1;
            while(low <= hi) {
                int mid = low +(hi-low)/2;
                if(arr[mid] <= q) {
                    ans = arr[mid];
                    low = mid+1;
                }
                else hi = mid-1;
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n; i++)
            arr[i] = sc.nextInt();
        int q = sc.nextInt();
        int[] qr = new int[q];
        for(int i = 0;i < q; i++) qr[i] = sc.nextInt();
        Arrays.sort(arr);
        bsfloor(arr, qr);
    }
}
