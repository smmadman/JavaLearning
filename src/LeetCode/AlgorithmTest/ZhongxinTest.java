package LeetCode.AlgorithmTest;

import java.util.Scanner;

public class ZhongxinTest {
    public static void main(String[] args) {

    }

    public static int nixudui(){
        Scanner sc = new Scanner(System.in);

        int count = 0;

        int n = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];
        int[] ab = new int[2 * n];

        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            ab[i] = a[i];
        }

        for(int i = 0; i < n; i++){
            b[i] = sc.nextInt();
            ab[i + n] = b[i];
        }

        int temp = 0;

        for(int i = 0; i < ab.length - 1; i++){
            for(int j = i + 1; j < ab.length; j++){
                if(ab[j] < ab[i]){
                    count ++;
                    temp = ab[i];
                    ab[i] = ab[j];
                    ab[j] = ab[i];
                }
            }
        }

        return count;
    }


}
