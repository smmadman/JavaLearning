package LeetCode.jianzhioffer;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class Offer_29spiralOrder {
    public static void main(String[] args) {
        int[][] matrix= new int[][] {{1,2,3},{4,5,6},{7,8,9}};

        int[] theArray = spiralOrder(matrix);

        for(int i : theArray){
            System.out.print(i + " ");
        }
    }

    public static int[] spiralOrder(int[][] matrix){
        int a = matrix.length;
        int b = matrix[0].length;
        boolean[][] matrixMap = new boolean[a+2][b+2];
        int index = 0;

        for(int i = 0; i <= a; i++){
            matrixMap[i][0] = true;
            matrixMap[i][b + 1] = true;
        }

        for(int i = 0; i <= b; i++){
            matrixMap[0][i] = true;
            matrixMap[a + 1][i] = true;
        }

        int[] theArray = new int[a * b];

        goStep(matrix, 0, 0, matrixMap, theArray, 0, 0);

        return theArray;

    }

    public static void goStep(int[][] matrix, int i, int j, boolean[][] matrixMap, int[] theArray, int index, int turnFlag){
        if(turnFlag == 0){ // go right
            matrixMap[i + 1][j + 1] = true;
            theArray[index] = matrix[i][j];
            index++;
            if(matrixMap[i + 1][j + 1 + 1]){// go next
                if(matrixMap[i + 1][j] && matrixMap[i + 1 + 1][j + 1] && matrixMap[i][j + 1]){
                    return;
                }
                goStep(matrix, i + 1, j, matrixMap, theArray, index, 1);
            }else{
                goStep(matrix, i, j + 1, matrixMap, theArray, index, 0);
            }
        }

        if(turnFlag == 1){ // go down
            matrixMap[i + 1][j + 1] = true;
            theArray[index] = matrix[i][j];
            index++;
            if(matrixMap[i + 1 + 1][j + 1]){// go next
                if(matrixMap[i + 1][j] && matrixMap[i + 1][j + 1 + 1] && matrixMap[i][j + 1]){
                    return;
                }
                goStep(matrix, i, j - 1, matrixMap, theArray, index, 2);
            }else{
                goStep(matrix, i + 1, j, matrixMap, theArray, index, 1);
            }
        }

        if(turnFlag == 2){ // go left
            matrixMap[i + 1][j + 1] = true;
            theArray[index] = matrix[i][j];
            index++;
            if(matrixMap[i + 1][j]){// go next
                if(matrixMap[i + 1 + 1][j + 1] && matrixMap[i + 1][j + 1 + 1] && matrixMap[i][j + 1]){
                    return;
                }
                goStep(matrix, i - 1, j, matrixMap, theArray, index, 3);
            }else{
                goStep(matrix, i, j - 1, matrixMap, theArray, index, 2);
            }
        }

        if(turnFlag == 3){ // go up
            matrixMap[i + 1][j + 1] = true;
            theArray[index] = matrix[i][j];
            index++;
            if(matrixMap[i][j + 1]){// go next
                if(matrixMap[i + 1 + 1][j + 1] && matrixMap[i + 1][j + 1 + 1] && matrixMap[i + 1][j]){
                    return;
                }
                goStep(matrix, i, j + 1, matrixMap, theArray, index, 0);
            }else{
                goStep(matrix, i - 1, j, matrixMap, theArray, index, 3);
            }
        }
    }
}
