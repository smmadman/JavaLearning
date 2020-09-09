package LeetCode.AlgorithmTest;


import java.util.*;

public class BaiduTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int GroutCount = sc.nextInt();

        for(int i = 0; i < GroutCount; i++){ // 对于每组测试数据
            int nCow = sc.nextInt(); // 奶牛数量
            int m = sc.nextInt(); // m个特性

            int[] resArray = new int[nCow];
//            for(int j = 1; j <= nCow; j++){
//                set.add(j);
//            }

            for(int ii = 0; ii < m; ii++){//对于每个特性
                int K = sc.nextInt(); //区间个数
//                Set<Integer> setK = new HashSet<>();
                for(int iii = 0; iii < K; iii++){ // 对于特性中每个区间
                    int low = sc.nextInt();
                    int hight = sc.nextInt();



                    for(int iiii = low; iiii < hight + 1; iiii++){
                        resArray[iiii - 1] ++;
                    }
                }// 区间整合为一个

//                List<Integer> judge= new ArrayList<>();

//                for(int  integer : set){
//                    if(!setK.contains(integer)){
//                        judge.add(integer);
//                    }
//                }
//
//                for(int i1 : judge){
//                    if(set.contains(i1)) set.remove(i1);
//                }
            }

            List<Integer> result = new LinkedList<>();

            for(int jjj = 0; jjj < resArray.length; jjj++){
                if(resArray[jjj] == m){
                    result.add(jjj + 1);
                }
            }

            System.out.println(result.size());

            for(int aa:result){
                System.out.print(aa + " ");
            }
            System.out.println();
        }
    }
}
