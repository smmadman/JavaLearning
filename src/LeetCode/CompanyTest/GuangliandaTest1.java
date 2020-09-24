package LeetCode.CompanyTest;

import java.util.*;

public class GuangliandaTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<Long, Long> map = new HashMap<>();
        Set<Long> set = new HashSet<>();
        Set<Long> set4 = new HashSet<>();

        for(int i = 0; i < n; i++){
            Long temp = sc.nextLong();
            if(!map.containsKey(temp)){
                map.put(temp, 1L);
            }else{
                Long tempInt = map.get(temp);
                if(tempInt == 1){
                    set.add(temp);
                }else if(tempInt == 3){
                    set4.add(temp);
                }
                map.put(temp, tempInt + 1);
            }
        }
        int N = set.size();
        int N4 = set4.size();
        Long[] arr4 = new Long[N4];
        Long[] arr = new Long[N];
        Long area1 = 0L;
        Long area4 = 0L;
        if(N < 2 && N4 == 0) {
            System.out.println(-1);
            return;
        }

        if(N >= 2){
            Iterator iterator = set.iterator();
            int count = 0;
            while(iterator.hasNext()){
                arr[count++] = (Long) iterator.next();
            }
            Arrays.sort(arr);
            area1 = arr[set.size() - 1] * arr[set.size() - 2];
        }

        if (N4 != 0) {
            Iterator iterator4 = set4.iterator();
            int count4 = 0;
            while(iterator4.hasNext()){
                arr4[count4++] = (Long) iterator4.next();
            }
            Arrays.sort(arr4);
            area4 = arr4[N4 - 1] * arr4[N4 - 1];
        }

        System.out.println(Math.max(area1, area4));
    }
}
