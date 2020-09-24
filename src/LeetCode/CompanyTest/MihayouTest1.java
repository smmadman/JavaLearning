package LeetCode.CompanyTest;

import java.util.Scanner;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class MihayouTest1 {
    public static char[][] spiralOrder(int m, int n){
        if(m == 0 || n  == 0){
            return null;
        }

        char[][] matrix= new char[m][n];

        int row = m;
        int col = n;

        int count = 0;
        char tempChar = 'A';

        boolean[][] status = new boolean[row][col];
        int len = row * col;
        int x = 0, y = 0;
        while(count != len){
            while (y < col && !status[x][y] && count < len) {
                matrix[x][y] = tempChar;
                if(tempChar == 'Z') tempChar = 'A';
                else tempChar ++;
                status[x][y] = true;
                count++;
                y++;
            }
            y--;
            x++;

            while (x < row && !status[x][y] && count < len) {
                matrix[x][y] = tempChar;
                if(tempChar == 'Z') tempChar = 'A';
                else tempChar ++;
                status[x][y] = true;
                count++;
                x++;
            }
            x--;
            y--;
            while (y >= 0 && !status[x][y] && count < len) {
                matrix[x][y] = tempChar;
                if(tempChar == 'Z') tempChar = 'A';
                else tempChar ++;
                status[x][y] = true;
                count++;
                y--;
            }
            y++;
            x--;
            while (x >= 0 && !status[x][y] && count < len) {
                matrix[x][y] = tempChar;
                if(tempChar == 'Z') tempChar = 'A';
                else tempChar ++;
                status[x][y] = true;
                count++;
                x--;
            }
            x++;
            y++;
        }

        return matrix;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        char[][] matrix = spiralOrder(m, n);


        for(int i = 0; i < m; i++){
            for (int ii = 0; ii < n; ii++){
                System.out.print(matrix[i][ii] + " ");
            }
            System.out.println();
        }
    }
}

