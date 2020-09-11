package LeetCode.CompanyTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SFTest2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] band = new int[n];
        int[][] client = new int[m][2];

        for(int i = 0; i < n; i++){
            band[i] = in.nextInt();
        }

        for(int i = 0; i < m; i++){
            client[i][0] = in.nextInt();
            client[i][1] = in.nextInt();
        }

        Arrays.sort(band);
        Arrays.sort(client, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[1] == b[1]){
                    return  a[0] - b[0];
                }
                return b[1] - a[1];
            }
        });

        ArrayList<Integer> array = new ArrayList<>();

        for(int i : band){
            array.add(i);
        }

        int sum = 0;

        for(int[] aClient : client){
            int money = aClient[1];
            int curBand = aClient[0];

            if(array.isEmpty()){
                continue;
            }

            if(curBand > array.get(array.size() - 1)){
                continue;
            }

            for(int i = 0; i < array.size(); i++){
                if(array.get(i) >= curBand){
                    sum += money;
                    array.remove(i);
                }
            }
        }
        System.out.println(sum);
    }
}
