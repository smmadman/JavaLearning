package LeetCode.CompanyTest;

import java.util.Scanner;

public class ZhongxinTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++){
            b[i] = sc.nextInt();
        }

        int bIndex = 0;
        int res = 0;
        for(int i = 0; i < n; i++){
            while(bIndex < n && a[i] > b[bIndex]){
                bIndex ++;
            }
            res += bIndex;
        }
        System.out.println(res);
    }
}
