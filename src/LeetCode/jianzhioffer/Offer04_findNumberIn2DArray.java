package LeetCode.jianzhioffer;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

public class Offer04_findNumberIn2DArray {

    public static void main(String[] args) {

        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};

        System.out.println(findNumberIn2DArray(matrix, 5));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int n = matrix.length; // 行
        int m = matrix[0].length; // 列

        int index_n = 0;
        int index_m = 0;

        for(int i = 0; i < n; i++){
            if(matrix[i][m - 1]  == target){
                return true;
            } else if(matrix[i][m-1]  >= target){
                index_n = i;
                break;
            }
        }

        for(int i = 0; i < m; i++){
            if(matrix[n - 1][i]  == target){
                return true;
            } else if(matrix[n - 1][i]  >= target){
                index_m = i;
                break;
            }
        }

        for(int j = index_n; j < n; j ++){
            for(int k = index_m; k < m; k ++){
                if(target == matrix[j][k]){
                    return true;
                }
            }
        }

        return false;
    }
}
