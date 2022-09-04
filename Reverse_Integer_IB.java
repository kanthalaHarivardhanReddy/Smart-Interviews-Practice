public class Solution {
    public int reverse(long num) {
        int isneg = 1;
        if(num < 0) {isneg = -1; num = num*-1;}
        
        long ans = 0;
        while(num > 0) {
            ans = ans*10 + num%10;
            num/=10;
        }
        if(ans >= Integer.MAX_VALUE || ans <= Integer.MIN_VALUE) return 0;
        return (int)(ans*isneg);
    }
}
