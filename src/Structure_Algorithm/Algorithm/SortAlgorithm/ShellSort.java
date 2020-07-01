package Structure_Algorithm.Algorithm.SortAlgorithm;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {5, 6, 2, 7, 8, 6, 2, 2, 6, 78, 9, 5, 1, 3};

        int[] arr2 = shellSort2(arr);

        for(int ele:arr2){
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static int[] shellSort(int[] arr){
        int temp = 0;
        for(int gap = arr.length / 2; gap > 0; gap /= 2){
            for(int i = gap; i < arr.length; i++){
                for(int j = i-gap; j >= 0; j -= gap){
                    if(arr[j] > arr[j + gap]){  //小冒泡对每组排序
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }

        return arr;
    }

    public static int[] shellSort2(int[] arr){
        for(int gap = arr.length / 2; gap > 0; gap /= 2){
            for(int i = gap; i < arr.length; i++){
                int j = i;
                int temp = arr[j];
                if(arr[j] < arr[j-gap]){
                    while(j - gap >= 0 && temp < arr[j - gap]){ //插入排序
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }
}
