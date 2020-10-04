package LeetCode.CompanyTest;

import java.util.Scanner;

public class WangyihuyuTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t = 0; t < T; t++){
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] queryArr = new int[M][2];
            for(int i = 0; i < M; i++){
                queryArr[i][0] = sc.nextInt();
                queryArr[i][1] = sc.nextInt();
            }

            int[][] res = new int[N][N];

            if(N != 1){
                res = buildArray(N);

                for(int j = 0; j < res.length; j++){
                    for(int jj = 0; jj < res[0].length; jj++){
                        System.out.print(jj + " ");
                    }
                    System.out.println();
                }
            }


            for(int i = 0; i < M; i++){
                if(N == 1){
                    System.out.println(1);
                }else{
                    System.out.println(res[queryArr[i][0]][queryArr[i][1]]);
                }
            }
        }
    }

    static int[][] buildArray(int N) {
        int[][] res  = new int[N][N];
        boolean[][] map = new boolean[N + 2][N + 2];

        for(int i = 0; i < map.length; i++){
            map[i][0] = true;
            map[i][map[0].length - 1] = true;
        }

        for(int i = 0; i < map[0].length; i++){
            map[0][i] = true;
            map[map.length - 1][i] = true;
        }

        move(0, 0, 1, N * N, res, map, 1, true);

        return res;
    }

    /**
     *
     * @param cur_step 当前步
     * @param sum_step 总步数
     * @param res
     * @param map
     * @param turn  当前方向 1:向右走 2：向下走 3：向左走 4：向上走
     * @param count 当前顺序 true:顺时针 false:逆时针
     */
    static void move(int cLX,int cLY, int cur_step, int sum_step, int[][] res, boolean[][] map, int turn, boolean count){
        res[cLX][cLY] = cur_step;
        map[cLX + 1][cLY + 1] = true;

        if(cur_step == sum_step){
            return;
        }

        if(count){ // 顺时针
            switch (turn){
                case 1:
                    if(!map[cLX + 1][cLY + 2]){
                        move(cLX , cLY + 1, cur_step + 1, sum_step, res, map, 1, count);
                    }else{
                        move(cLX + 1, cLY, cur_step + 1, sum_step, res, map, 2, count);
                    }
                    break;
                case 2:
                    if(!map[cLX + 2][cLY + 1]){
                        move(cLX + 1, cLY, cur_step + 1, sum_step, res, map, 2, count);
                    }else{
                        move(cLX, cLY - 1, cur_step + 1, sum_step, res, map, 3, count);
                    }
                    break;
                case 3:
                    if(!map[cLX + 1][cLY]){
                        move(cLX, cLY - 1, cur_step + 1, sum_step, res, map, 3, count);
                    }else{
                        move(cLX - 1, cLY, cur_step + 1, sum_step, res, map, 4, count);
                    }
                    break;
                case 4:
                    if(!map[cLX][cLY + 1]){
                        move(cLX - 1, cLY, cur_step + 1, sum_step, res, map, 4, count);
                    }else{
                        move(cLX, cLY + 1, cur_step + 1, sum_step, res, map, 2, (!count));
                    }
                    break;
            }

        }else{ // 逆时针
            switch (turn){
                case 1:
                    if(!map[cLX + 1][cLY + 2]){
                        move(cLX , cLY + 1, cur_step + 1, sum_step, res, map, 1, count);
                    }else{
                        move(cLX - 1, cLY, cur_step + 1, sum_step, res, map, 4, count);
                    }
                    break;
                case 2:
                    if(!map[cLX + 2][cLY + 1]){
                        move(cLX + 1, cLY, cur_step + 1, sum_step, res, map, 2, count);
                    }else{
                        move(cLX, cLY + 1, cur_step + 1, sum_step, res, map, 1, count);
                    }
                    break;
                case 3:
                    if(!map[cLX + 1][cLY]){
                        move(cLX, cLY - 1, cur_step + 1, sum_step, res, map, 3, count);
                    }else{
                        move(cLX + 1, cLY, cur_step + 1, sum_step, res, map, 1, (!count));
                    }
                    break;
                case 4:
                    if(!map[cLX][cLY + 1]){
                        move(cLX - 1, cLY, cur_step + 1, sum_step, res, map, 4, count);
                    }else{
                        move(cLX, cLY - 1, cur_step + 1, sum_step, res, map, 3, count);
                    }
                    break;
            }
        }
    }
}
