package LeetCode.CompanyTest;

import java.util.*;

public class GuangliandaTest3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Set<Integer> res = new LinkedHashSet<>();
        for(int i = 0; i < arr.length; i++){
            setChange(res, arr[i]);
        }

        Iterator<Integer> it = res.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
            if(it.hasNext()) System.out.println(" ");
        }
    }

    public static void setChange(Set<Integer> set, Integer i){
        if(!set.add(i)){
            set.remove(i);
            setChange(set, i << 1);
        }
    }
}
