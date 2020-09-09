package LeetCode.AlgorithmTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class XiechengTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String  ss = sc.nextLine();

        String[] arr = ss.split(" ");
        if(arr.length != 0){
            HashSet<Character> set = new HashSet<>();
            ArrayList<Character> array = new ArrayList<>();
            recur(array, arr,set);
        }
    }

    public static void recur(ArrayList<Character> array, String[] arr, HashSet<Character> set){
        int curLen = array.size();

        if(curLen == arr.length){
            StringBuilder builder = new StringBuilder();

            for(char c : array){
                builder.append(c);
            }
            if(curLen > set.size()){
                builder.append("--circular dependency");
            }
            System.out.println(builder.toString());
            return;
        }
        char[] charArr = arr[curLen].toCharArray();
        for(char curC : charArr){
            ArrayList<Character> newArray = new ArrayList<>(array);
            HashSet<Character> newSet = new HashSet<>(set);
            newArray.add(curC);
            newSet.add(curC);
            recur(newArray, arr, newSet);
        }
    }
}
