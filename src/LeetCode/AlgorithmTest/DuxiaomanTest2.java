package LeetCode.AlgorithmTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DuxiaomanTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for(int group = 0; group < T; group++){
            String paraStr = sc.nextLine();
            String[] paraArr = paraStr.split(" ");
            int n = Integer.parseInt(paraArr[0]);
            int m = Integer.parseInt(paraArr[1]);

            char[][] map = new char[n][m];
            int[] startIndex = new int[2];
            for(int i = 0; i < n; i++){
                String tempStr = sc.nextLine();
                for(int ii = 0; ii < m; ii++){
                    char tempChar = tempStr.charAt(ii);
                    if(tempChar == '@'){
                        startIndex[0] = i;
                        startIndex[1] = ii;
                        tempChar = '.';
                    }
                    map[i][ii] = tempChar;
                }
            }


        }
    }

    public int move(int[] startIndex, char[][] map){
        Queue<Queue<int[]>> queue = new LinkedList<>();
        int res = Integer.MAX_VALUE;
        Queue<int[]> startQueue = new LinkedList();
        queue.add(startQueue);
        LinkedList<LinkedList<Integer>> resList = new LinkedList<>();
        LinkedList<Integer> startList = new LinkedList<>();
        startList.add(0);
        while(!queue.isEmpty()){
            Queue<int[]> tempQueue = queue.poll();
            LinkedList<Integer> preList = resList.get(resList.size() - 1);
            int countTemp = 0;
            Queue<int[]> nextQueue = new LinkedList<>();
            while(!tempQueue.isEmpty()){
                int[] curIndex = tempQueue.poll();
                if(curIndex[0] >= map.length || curIndex[1] >= map[0].length){

                }else{
                    int[] newIndex = new int[2];
                    if(map[curIndex[0]][curIndex[1]] == '.'){
                        newIndex[0] = curIndex[0] + 1;
                        newIndex[1] = curIndex[1];
                        nextQueue.add(newIndex);
                    }
                }
                LinkedList<Integer> tempList = new LinkedList<>();

                countTemp ++;
            }
        }
        return -1;
    }
}

/**
 *
 * 3
 * 3 3
 * ###
 * #@*
 * ***
 * 3 4
 * ####
 * #@.*
 * **.*
 * 3 3
 * .#.
 * #@#
 * .#.
 *
 * 1
 * 0
 * -1
 */
