import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static class TreeNode{
        int data;
        TreeNode right, left;
        TreeNode(int data) {
            this.data = data;
        }
    }
    
    private static TreeNode insertInBST(TreeNode root, int data) {
        if(root == null) return new TreeNode(data);
        
        if(root.data < data) 
            root.right = insertInBST(root.right, data);
        else 
            root.left = insertInBST(root.left, data);
        return root;
    }
    
    static TreeNode root;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0;i < n; i++) arr[i] = sc.nextInt();
            
        }
        System.out.print(sb.toString());
    }
}
