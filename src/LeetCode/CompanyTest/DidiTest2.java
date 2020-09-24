package LeetCode.CompanyTest;

import java.util.*;

public class DidiTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int groups = Integer.parseInt(sc.nextLine());

        for(int group = 0; group < groups; group++){
            String valueString = sc.nextLine();
            String[] valueStrArr = valueString.split(" ");

            int n = Integer.parseInt(valueStrArr[0]);
            int m = Integer.parseInt(valueStrArr[1]);
            int k = Integer.parseInt(valueStrArr[2]);

            if(n < m - 1){
                System.out.println("No");
                break;
            }

            Map<Integer, List<Integer>> map = new HashMap<>();

            for(int i = 0; i < m; i++){
                String tempStr = sc.nextLine();
                String[] tempStrArr = tempStr.split(" ");
                if(Integer.parseInt(tempStrArr[2]) > k) continue;
                else{
                    int islandA = Integer.parseInt(tempStrArr[0]);
                    int islandB = Integer.parseInt(tempStrArr[1]);

                    if(!map.containsKey(islandA)){
                        List tempList = new ArrayList<Integer>();
                        tempList.add(islandB);
                        map.put(islandA, tempList);
                    }else{
                        map.get(islandA).add(islandB);
                    }

                    if(!map.containsKey(islandB)){
                        List tempList = new ArrayList<Integer>();
                        tempList.add(islandA);
                        map.put(islandB, tempList);
                    }else{
                        map.get(islandB).add(islandA);
                    }
                }
            }

            if(map.size() == 0) {
                System.out.println("No");
                break;
            }


            Set<Integer> set = new HashSet<>();
            for(int i = 1; i <= n; i++) set.add(i);
            Queue<int[]> queue = new LinkedList<>();

            int[] rootA = new int[2];
            Set set2 = map.keySet();
            if(set2.size() == 0)
            {
                System.out.println("No");
                break;
            }
            Iterator it = set2.iterator();
            int tempppp = 0;
            while(it.hasNext()){
                tempppp = (int)it.next();
                break;
            }
            rootA[0] = tempppp;
            rootA[1] = tempppp;
            queue.add(rootA);
            while(!queue.isEmpty()){
                int[] root = queue.poll();
                if(set.contains(root[1])) set.remove(root[1]);

                List<Integer> list = map.get(root[1]);

                if(list.size() != 0){
                    for(Integer i : list){
                        if(i == root[0]) continue;
                        if(i == root[1]) continue;

                        int[] temp2 = new int[2];
                        temp2[0] = root[1];
                        temp2[1] = i;
                        queue.add(temp2);
                    }
                }
            }

            if(set.size() == 0) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
