import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static int BS(int[] arr,int key, int lo, int hi, boolean isfloor) {
        int ans = -1;
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if(arr[mid] == key) {
                ans = mid;
                if(isfloor) {
                    lo = mid+1;
                }
                else {
                    hi = mid-1;
                }
            }
            else if(arr[mid] < key) {
                lo = mid+1;
            } 
            else hi = mid-1;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        int q = sc.nextInt();
        int[] qr = new int[q];
        for(int i = 0;i < q; i++) qr[i] = sc.nextInt();
        
        for(int ele: qr) {
            int floorKey = BS(arr,ele, 0, n-1, true);
            int ceilKey = BS(arr, ele, 0, n-1, false);
            if(floorKey != -1 || ceilKey != -1)
                System.out.println(floorKey - ceilKey+1);
            else System.out.println(0);
        }
    }
}


// Solution 5 - using the compressed and frequency list 

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        int q = sc.nextInt();
        int[] qr = new int[q];
        for(int i = 0;i < q; i++) qr[i] = sc.nextInt();
        
        List<Integer> comp = new ArrayList<>();
        List<Integer> freq = new ArrayList<>();
        
        for(int i = 0;i < n; i++) {
            int ind = freq.size()-1;
            if(ind != -1 && arr[i] == comp.get(ind)) {
                freq.set(ind, freq.get(ind)+1);
            }
            else {
                comp.add(arr[i]);
                freq.add(1);
            }
        }
        
        for(int ele: qr) {
            int ind = BS(comp, ele);
            if(ind != -1 ) System.out.println(freq.get(ind));
            else System.out.println(0);
        }
    }
    private static int BS(List<Integer> comp, int key) {
        int ans = -1, lo = 0, hi = comp.size()-1;
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if(comp.get(mid) == key) {
                return mid;
            }
            else if(comp.get(mid) < key) {
                lo = mid+1;
            }
            else hi = mid-1;
        }
        return ans;
    }
}
