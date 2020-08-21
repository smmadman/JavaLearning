package LeetCode.src.AlgorithmTest;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 *
 */

public class DFS_BFSTest {
    public static int sum(int m, int n){
        int sum = 0;

        while(m != 0){
            sum += m % 10;
            m /= 10;
        }

        while(n != 0){
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}

class DFSTest{ //深度优先
    public int movingCount(int m, int n, int k){
        boolean[][] visited = new boolean[m][n];

        return dfs(0, 0, m, n, k, visited);
    }

    public int dfs(int i, int j, int m, int n, int k, boolean[][] visited){
        if(i >= m || j >= n || k < DFS_BFSTest.sum(i, j) || visited[i][j]){
            return 0;
        }

        visited[i][j] = true;

        return 1 + dfs(i + 1, j, m, n, k, visited) + dfs(i, j + 1, m, n, k, visited);
    }
}

class BFSTest{ // 广度优先 使用while+队列
    public int movingCount(int m, int n, int k){
        boolean[][] visited = new boolean[m][n];

        int res = 0;

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0});

        while(queue.size() != 0){
            int[] x = queue.poll();
            int i = x[0];
            int j = x[1];

            if(i >= m || j >= n || k < DFS_BFSTest.sum(i, j) || visited[i][j]){
                continue;
            }

            visited[i][j] = true;
            res ++;
            queue.add(new int[] {i+1, j});
            queue.add(new int[] {i, j+1});
        }
        return res;
    }

    public int sum(int m, int n){
        int sum = 0;

        while(m != 0){
            sum += m % 10;
            m /= 10;
        }

        while(n != 0){
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}
