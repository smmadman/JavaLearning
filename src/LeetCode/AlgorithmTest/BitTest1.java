package LeetCode.AlgorithmTest;

import java.util.Scanner;

public class BitTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String theLine = sc.nextLine();

        String[] strs = theLine.split(" ");
        String str = strs[0];
        String LA = strs[1];
        String LB = strs[2];

        str = str.toLowerCase();
        LA = LA.toLowerCase();
        LB = LB.toLowerCase();

        char A = LA.charAt(0);
        char B = LB.charAt(0);

        int aMin = -1;
        int bMin = -1;
        int aMax = -1;
        int bMax = -1;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == A){
                if(aMin < 0){
                    aMin = i;
                }else{
                    aMax = i;
                }
            }

            if(str.charAt(i) == B){
                if(bMin < 0){
                    bMin = i;
                }else{
                    bMax = i;
                }
            }
        }

        if(aMin < 0 || bMin < 0){
            System.out.println(-1);
        }else{
            int dAB = Math.abs(aMax - bMin);
            int dBA = Math.abs(bMax - aMin);
            int dAA = Math.abs(bMin - aMin);

            int x = dAB>=dBA ? dAB : dBA;
            int y = dAA>=x ? dAA : x;
            System.out.println(y);
        }

        recurse();
    }

    public static void recurse(){

    }
}
