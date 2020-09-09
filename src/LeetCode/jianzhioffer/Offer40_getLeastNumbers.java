package LeetCode.jianzhioffer;

import java.util.Arrays;

public class Offer40_getLeastNumbers {

    public static void main(String[] args) {
        int[] res = getLeastNumbers(new int[]{0, 1, 2, 1}, 2);
        for(int i : res){
            System.out.println(i);
        }
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0 || arr.length == 0){
            return new int[0];
        }

        int[] res = new int[k];

        for(int i = 0; i < res.length; i++){
            res[i] = arr[i];
        }
        Arrays.sort(res);

        for(int i = k; i < arr.length; i++){
            if(arr[i] < res[k - 1]){
                res[k - 1] = arr[i];
            }
            Arrays.sort(res);
        }
        return res;
    }


}
