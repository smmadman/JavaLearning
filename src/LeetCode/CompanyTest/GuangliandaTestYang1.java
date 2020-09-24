package LeetCode.CompanyTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GuangliandaTestYang1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            long[] arr = new long[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);
            long len1 = 0;
            long len2 = 0;
            Set<Long> set =  new HashSet<>();
            Set<Long> set1 = new HashSet<>();
            boolean flag = false;
            for1:
            for(int i = n - 1; n > 0; i--){
                if(!set.add(arr[i])){
                    len1 = arr[i];
                    for2:
                    for(int j = i; j >= 0; j--){
                        if(!set1.add(arr[j])){
                            len2 = arr[j];
                            flag = true;
                            break for1;
                        }
                    }
                }
            }
            if(flag == false) System.out.println(-1);
            else{
                System.out.println(len1 * len2);
            }

        }
        sc.close();
    }
}
