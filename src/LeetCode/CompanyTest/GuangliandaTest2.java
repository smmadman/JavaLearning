package LeetCode.CompanyTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GuangliandaTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        float chargeRemain = (float) n;

        Map<Float, Integer> map = new HashMap<>();
        float[] costArr = new float[m];
        for(int i = 0; i < m; i++){
            float tempFloat = sc.nextFloat();
            int relaxTemp = sc.nextInt();
            costArr[i] = tempFloat;
            map.put(tempFloat, relaxTemp);
        }

        Arrays.sort(costArr);

        int max = 0;

        for(int i = 0; i < m; i++){
            if(costArr[i] <= chargeRemain){
                max += map.get(costArr[i]);
                chargeRemain = chargeRemain - costArr[i];
            }

        }
        System.out.println(max);
    }
}
