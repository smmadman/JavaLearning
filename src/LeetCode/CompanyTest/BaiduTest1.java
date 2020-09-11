package LeetCode.CompanyTest;

import java.util.Scanner;

public class BaiduTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int count_5 = 0;
        int count_0 = 0;

        for(int i = 0; i < n; i++){
            int temp = sc.nextInt();
            if(temp == 5) count_5++;
            if(temp == 0) count_0++;
        }

        if(count_0 == 0 || count_0 < 9) {
            System.out.println(-1);
        }else{
            int x = count_5 / 9;
            for(int i = 0; i < x; i++){
                System.out.print("555555555");
            }

            for(int i = 0; i < count_0; i++){
                System.out.print("0");
            }

        }
    }
}
