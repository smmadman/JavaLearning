package LeetCode.CompanyTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AiqiyiTest3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String[] strArr = str.split(" ");
        int[] arr = new int[strArr.length];
        if(arr.length < 3){
            return;
        }

        for(int i = 0; i < strArr.length; i++){
            arr[i] = Integer.parseInt(strArr[i]);
        }

        Arrays.sort(arr);
        List<int[]> res = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= 0) break;

            if(i > 0){
                if(arr[i] == arr[i - 1]) continue;
            }

            int left = i + 1;
            int right = arr.length - 1;

            while(left < right){
                if(arr[i] + arr[left] + arr[right] == 0){
                    res.add(new int[]{arr[i], arr[left], arr[right]});
                    while(left < right && arr[left] == arr[left + 1])
                        left++;
                    while(left < right && arr[right] == arr[right - 1])
                        right--;
                }else if(arr[i] + arr[left] + arr[right] > 0){
                    right--;
                }else{
                    left++;
                }
            }
        }

        for(int i = 0; i < res.size(); i++){
            int[] theRes = res.get(i);
            for(int ii : theRes){
                System.out.print(theRes + " ");
            }
            System.out.println();
        }
    }
}
