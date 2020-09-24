package LeetCode.CompanyTest;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class VivoTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        char[] chars = str.toCharArray();
        int i = 0;
        int j = chars.length - 1;

        while(i < j){
            if(chars[i] != chars[j]){
                if(isPal(chars, i + 1, j)){
                    for(int ii = 0; ii < chars.length; ii++){
                        if(ii == i) continue;
                        System.out.print(chars[ii]);
                    }
                    System.out.println();
                    return;
                }else if(isPal(chars, i, j - 1)){
                    for(int ii = 0; ii < chars.length; ii++){
                        if(ii == j) continue;
                        System.out.print(chars[ii]);
                    }
                    System.out.println();
                    return;
                }else{
                    System.out.println(false);
                    return;
                }

            }
        }

    }

    static boolean isPal(char[] chars, int Bindex, int Eindex){
        while(Bindex < Eindex){
            if(chars[Bindex] != chars[Eindex]){
                return false;
            }else{
                Bindex ++;
                Eindex --;
            }
        }
        return true;
    }

}

