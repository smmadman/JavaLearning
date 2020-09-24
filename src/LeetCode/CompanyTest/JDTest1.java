package LeetCode.CompanyTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JDTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());

        for(int group = 0; group < T; group++){
            String tempStr = sc.nextLine();
            String[] MNArr = tempStr.split(" ");
            int n = Integer.parseInt(MNArr[0]);
            int m = Integer.parseInt(MNArr[1]);

            int[] startIndex = new int[2];
            int[] endIndex = new int[2];

            char[][] map = new char[n][m];
            for(int i = 0; i < n; i++){
                String str = sc.nextLine();
                for(int index = 0; index < m; index++){
                    map[i][index] = str.charAt(index);
                    if(map[i][index] == 'S'){
                        startIndex[0] = i;
                        startIndex[1] = index;
                    }else if(map[i][index] == 'E'){
                        endIndex[0] = i;
                        endIndex[1] = index;
                    }
                }
            }

            if(movingTry(startIndex, map)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    public static boolean movingTry(int[] startIndex, char[][] map){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(startIndex);

        while(!queue.isEmpty()){
            int[] tempLocation = queue.poll();
            int tempN = tempLocation[0];
            int tempM = tempLocation[1];
            if(map[tempN][tempM] == 'E') return true;

            if(tempN > 0){
                if(map[tempN - 1][tempM] != '#'){
                    int[] tempNext = new int[2];
                    tempNext[0] = tempN - 1;
                    tempNext[1] = tempM;
                    queue.add(tempNext);
                    map[tempN][tempM] = '#';
                }
            }
            if(tempN < map.length - 1){
                if(map[tempN + 1][tempM] != '#'){
                    int[] tempNext = new int[2];
                    tempNext[0] = tempN + 1;
                    tempNext[1] = tempM;
                    queue.add(tempNext);
                    map[tempN][tempM] = '#';
                }
            }
            if(tempM > 0){
                if(map[tempN][tempM - 1] != '#'){
                    int[] tempNext = new int[2];
                    tempNext[0] = tempN;
                    tempNext[1] = tempM - 1;
                    queue.add(tempNext);
                    map[tempN][tempM] = '#';
                }
            }
            if(tempM < map[0].length - 1){
                if(map[tempN][tempM + 1] != '#'){
                    int[] tempNext = new int[2];
                    tempNext[0] = tempN;
                    tempNext[1] = tempM + 1;
                    queue.add(tempNext);
                    map[tempN][tempM] = '#';
                }
            }
        }

        return false;
    }
}
