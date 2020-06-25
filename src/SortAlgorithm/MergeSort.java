package SortAlgorithm;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2, 1, 8, 6, 9, 7, 5, 10, 3, 4, 48};
        int[] temp = new int[arr.length];

        mergeSort(arr, 0, arr.length - 1, temp);

        for(int ele: arr){
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp){
        if(left < right){
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);

            merge(arr, left, mid, right, temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp){
        int i = left;
        int j = mid + 1;
        int t = 0;

        while(i <= mid && j <= right){ //左右两边填充到数组，直到一边结束
            if(arr[i] < arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else{
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        while(i <= mid){ //把剩余数据的一边的数据依次全部填充到temp
            temp[t] = arr[i];
            t++;
            i++;
        }

        while(j <= right){
            temp[t] = arr[j];
            t++;
            j++;
        }

        // 将temp数组的元素拷贝到arr，tips：并不是每次都拷贝所有arr，前几次合并可能只是拷贝部分arr
        t = 0;
        int tempLeft = left;
        while(tempLeft <= right){
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
