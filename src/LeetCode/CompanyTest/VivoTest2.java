package LeetCode.CompanyTest;

import java.util.*;

public class VivoTest2 {

    public static void main(String[] args) {
        System.out.println(compileSeq("1,2,-1,1"));
    }
    public static String compileSeq (String input) {
        // write code here

        char s = input.charAt(0);
        char e = input.charAt(input.length() - 1);
        input = input.trim();
        String[] strings = input.split(",");

        int[] arr = new int[strings.length];
        for(int i = 0; i < strings.length; i++){
            arr[i] = Integer.parseInt(strings[i]);
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                map.get(arr[i]).add(i);
            }else{
                List<Integer> listTemp = new LinkedList();
                listTemp.add(i);
                map.put(arr[i], listTemp);
            }
        }

        int[] resArr = new int[arr.length];
        int resIndex = 0;

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(map.get(-1));
        while(!queue.isEmpty()){
            List<Integer> listTemp = queue.poll();
            for(int i = listTemp.size() - 1; i >= 0; i--){
                int temp = listTemp.get(i);
                resArr[resIndex] = temp;
                resIndex ++;

                if(map.get(temp)!= null){
                    queue.add(map.get(temp));
                }
            }
        }

        String res = "";
        for(int a: resArr){
            res += a;
        }

        return res;

    }
}
