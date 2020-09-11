package LeetCode.AlgorithmTest;

import java.util.Arrays;
import java.util.Scanner;

public class YangZhongxingTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }
        int[][] command = new int[m][2];
        for(int i = 0; i < m; i++){
            command[i][0] = sc.nextInt();
            command[i][1] = sc.nextInt();
        }

        int sum = 0;
        int nn = 0;

        while(sum < n){
            nn += 1;
            sum += Math.pow(2, nn - 1);
        }// 二叉树 nn 层；

        int index = 0;

        int[][] theArr =new int[nn][];
        for(int i = 0; i < nn; i++){ // 将节点放入 nn 层中，第nn层是有2 ^ nn - 1 个数字的数组
            theArr[i] = new int[(int) Math.pow(2, i)];
            for(int ii = 0; ii < theArr[i].length; ii++){
                if(index >= array.length){
                    continue;
                }
                theArr[i][ii] = array[index];
                index++;
            }
        }

        for(int i = 0; i < m; i++){ // 执行操作
            if(command[i][0] == 1){ // 1 x 操作

                int sumTemp = 0;
                int nnTemp = 0;

                while(sumTemp < command[i][1]){ // 定位此节点
                    nnTemp += 1;
                    sumTemp += Math.pow(2, nnTemp - 1);
                }// 定位此操作数节点

                int faIndex =  command[i][1] - (int) Math.pow(2, nnTemp - 1);

                if(nnTemp== theArr.length) continue;
                else{
                    int leftIndex = (faIndex + 1) * 2 - 2;
                    int rightIndex = leftIndex + 1;

                    int[] tempArr = new int[3];
                    tempArr[0] = theArr[nnTemp - 1][faIndex];
                    tempArr[1] = theArr[nnTemp][leftIndex];
                    tempArr[2] = theArr[nnTemp][rightIndex];

                    Arrays.sort(tempArr);
                    theArr[nnTemp - 1][faIndex] = tempArr[2];
                    theArr[nnTemp][leftIndex] = tempArr[1];
                    theArr[nnTemp][rightIndex] = tempArr[0];
                }
            }else{ // 2 x 操作
                for(int ii : theArr[command[i][1] - 1]){
                    if(ii > 0){
                        System.out.print(ii + " ");
                    }
                }

                System.out.println();
            }
        }

    }
}
