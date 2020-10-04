package LeetCode.jianzhioffer;

import java.util.Scanner;

public class WanmeiTest3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long m = sc.nextLong();
        long n = sc.nextLong();
        long ans = cal(m, n);
        System.out.println(ans);
    }
    static long cal(long m, long n){
        if(n <= 0){
            return 0;
        }
        if(m == 0 || n == 1){
            return 1;
        }
        long ans;
        if(n > m){
            ans = cal(m, m);
        }else{
            ans = cal(m, n - 1) + cal(m - n, n);
        }
        return ans;
    }
}
