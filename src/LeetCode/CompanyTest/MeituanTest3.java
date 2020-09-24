package LeetCode.CompanyTest;

import java.util.Scanner;

public class MeituanTest3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String strTemp = sc.nextLine();
        String[] strArr = strTemp.split(" ");
        int SLength = Integer.parseInt(strArr[0]);
        int PLength = Integer.parseInt(strArr[0]);
        String s = sc.nextLine();
        String p = sc.nextLine();

        if(PLength > SLength){
            System.out.println(false);
        }

        int sum = 0;

        int SIndex = 0;
        int PIndex = 0;
        while(SIndex < s.length() && PIndex < p.length()){
            if(s.charAt(SIndex) == p.charAt(PIndex)){
                sum += SIndex + 1;
                SIndex ++;
                PIndex ++;
            }else{
                SIndex++;
            }
        }
        if(PIndex == p.length()){
            System.out.println("Yes");
            System.out.println(sum);
        }else{
            System.out.println("No");
        }
    }
}
