package LeetCode.jianzhioffer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WanmeiTest4 {
    public static void main(String[] args) {
        System.out.println(getDuiShu());
    }
    static int getDuiShu(){
        Scanner sc = new Scanner(System.in);
        String tempStr = sc.nextLine();
        String[] info = tempStr.split(" ");
        int A = Integer.parseInt(info[0]);
        int B = Integer.parseInt(info[1]);
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        int[] arrA = new int[A];
        int[] arrB = new int[B];

        for(int i = 0; i < A; i++){
            String tempA = sc.nextLine();
            String[] infoA = tempA.split(" ");
            map1.put(Integer.parseInt(infoA[0]), Integer.parseInt(infoA[1]));
            arrA[i] = Integer.parseInt(infoA[0]);
        }
        for(int i = 0; i < B; i++){
            String tempB = sc.nextLine();
            String[] infoB = tempB.split(" ");
            map2.put(Integer.parseInt(infoB[0]), Integer.parseInt(infoB[1]));
            arrB[i] = Integer.parseInt(infoB[0]);
        }

        int count = 0;
        for(int i = 0; i < arrA.length; i++){
            for(int j = 0; j < arrB.length; j++){
                if(arrA[i] > arrB[j]) count += map1.get(arrA[i]) * map2.get(arrB[j]);
            }
        }
        return count;
    }
}
