package LeetCode.AlgorithmTest;

public class BilibiliTest {
    public static void main(String[] args) {
        for(int i : SpiralMatrix(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}})){
            System.out.print(i + " ");
        }
    }

    public static int[] SpiralMatrix(int[][] matrix){

        int mR = matrix[0].length;
        int mD = matrix.length - 1;
        int indexD = 0;
        int flag = 1;
        int indexRight = 0;

        int res[] = new int[matrix.length * matrix[0].length];
        int count = 0;

        while(true){

            if(mR != 0){
                for(int i = 0; i < mR; i++){
                    System.out.println(matrix[indexD][indexRight + i * flag] + " ");
                    res[count++] = matrix[indexD][indexRight + i * flag];
                }
                indexRight += flag * (mR - 1);
                indexD += flag;
                mR--;
            }

            if(mD == 0) break;

            if(mD != 0){
                for(int j = 0; j < mD; j++){
                    System.out.println(matrix[j * flag + indexD][indexRight] + " ");
                    res[count++] = matrix[j * flag + indexD][indexRight];
                }

                indexD += flag * (mD - 1);
                indexRight += flag * (-1);
                mD--;
            }

            if(mR == 0) break;

            flag = -flag;
        }

        return res;
    }
}
