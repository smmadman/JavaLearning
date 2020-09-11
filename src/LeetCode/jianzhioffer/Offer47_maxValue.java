package LeetCode.jianzhioffer;

import java.util.LinkedList;
import java.util.Queue;

public class Offer47_maxValue {
    public static void main(String[] args) {

    }

    public static int maxValue(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(j == 0 && i == 0) continue;
                else if(i == 0) grid[i][j] += grid[i][j - 1];
                else if(j == 0) grid[i][j] += grid[i - 1][j];
                else{
                    grid[i][j]  += Math.max(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }

        return grid[m - 1][n - 1];
    }
}
