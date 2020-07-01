package Structure_Algorithm.Structure.sparsearray;

public class SparseArrayDemo {
    public static void main(String[] args) {

        SparseArray sA = new SparseArray();

        int[][] a = new int[10][10];
        a[1][1] = 1;
        a[2][2] = 2;
        a[3][4] = 5;
        a[9][9] = 121;

        sA.showTwoDimensionArray(a);
        int [][] sparseArr = sA.twoDimensionArrIntoSparseArr(a, 0);
        sA.showTwoDimensionArray(sparseArr);
        int [][] originArr = sA.sparseIntoTwoDimensionArray(sparseArr, 0);
        sA.showTwoDimensionArray(originArr);
    }


}

class SparseArray{

    public int[][] twoDimensionArrIntoSparseArr(int[][] array, int base_value){
        int sum = 0;
        for (int[] ints : array) {
            for (int ii = 0; ii < array[0].length; ii++) {
                if (ints[ii] != base_value) {
                    sum += 1;
                }
            }
        }

        int[][] sparseArray = new int[sum+1][3];
        int index = 0;

        sparseArray[index][0] = array.length;  // 系数数组第一行记录总数组数，以及总value个数
        sparseArray[index][1] = array[0].length;
        sparseArray[index][2] = sum;

        index += 1;
        for(int i=0; i<array.length; i++){
            for(int ii=0; ii<array[i].length; ii++){
                if (array[i][ii] != base_value){
                    sparseArray[index][0] = i;
                    sparseArray[index][1] = ii;
                    sparseArray[index][2] = array[i][ii];
                    index += 1;
                }
            }
        }

        return sparseArray;
    }

    public int[][] sparseIntoTwoDimensionArray(int[][] sparseArr, int basic){
        int row = sparseArr[0][0];
        int column = sparseArr[0][1];

        int [][] arr = new int[row][column];

        if (basic != 0){
            for (int[] i:arr){
                for (int ii: i){
                    ii = basic;
                }
            }
        }

        for (int i=1; i<sparseArr.length; i++){
            arr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        return arr;
    }

    public void showTwoDimensionArray(int[][] array){
        for (int[] ints : array) {
            for (int ii = 0; ii < array[0].length; ii++) {
                System.out.print(ints[ii] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
