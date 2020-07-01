package Structure_Algorithm.Algorithm.Search;

import java.util.ArrayList;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(binarySearch(arr, 0, arr.length-1, 7));

        int arr2[] = {1, 1, 1, 1, 1, 1, 1, 1, 9, 10};
        System.out.println(binarySearch2(arr2, 0, arr.length-1, 1));
    }

    /**
     * 二分查找：需要数组有序
     * 使用递归
     * 若有多个相同值返回最接近中间的
     * @param arr
     * @param left
     * @param right
     * @param find_value
     * @return
     */
    public static int binarySearch(int arr[], int left, int right, int find_value){
        int mid_index = (left + right) / 2;
        int mid_value = arr[mid_index];

        if (left > right) {
            return -1;
        }

        if(find_value > mid_value){
            return binarySearch(arr, mid_index + 1, right, find_value);
        }else if(find_value < mid_value){
            return binarySearch(arr, left, mid_index - 1, find_value);
        }else{
            return mid_index;
        }
    }

    /**
     * 二分查找2：需要数组有序
     * 使用递归
     * 若有多个相同值返回列表,若无则返回空列表
     * @param arr
     * @param left
     * @param right
     * @param find_value
     * @return
     */
    public static ArrayList<Integer> binarySearch2(int arr[], int left, int right, int find_value){
        int mid_index = (left + right) / 2;
        int mid_value = arr[mid_index];

        if (left > right) {
            return new ArrayList<Integer>();
        }

        if(find_value > mid_value){
            return binarySearch2(arr, mid_index + 1, right, find_value);
        }else if(find_value < mid_value){
            return binarySearch2(arr, left, mid_index - 1, find_value);
        }else{
            ArrayList<Integer> resultIndex = new ArrayList<>();

            int temp = mid_index - 1;
            while(true){
                if(temp < 0 || arr[temp] != find_value ){
                    break;
                }
                resultIndex.add(temp);
                temp -= 1;
            }

            temp = mid_index + 1;
            while(true){
                if(temp > arr.length - 1 || arr[temp] != find_value){
                    break;
                }
                resultIndex.add(temp);
                temp += 1;
            }
            return resultIndex;
        }
    }
}
