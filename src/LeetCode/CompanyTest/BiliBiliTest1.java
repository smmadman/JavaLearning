package LeetCode.CompanyTest;

import java.util.LinkedList;
import java.util.Queue;

public class BiliBiliTest1 {
    public static void main(String[] args) {

    }

    public static int GetMaxConsecutiveOnes (int[] arr, int k) {
        // write code here
        int max = 0;
        int curLength = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 1){
                curLength ++;
            }else{
                if(queue.size() < k){
                    curLength ++;
                }else {
                    int preZero = queue.poll();
                    curLength = i - preZero;
                }
                queue.add(i);
            }
            max = Math.max(curLength, max);
        }
        return max;
    }


}
