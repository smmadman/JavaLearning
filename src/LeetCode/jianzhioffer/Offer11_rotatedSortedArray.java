package LeetCode.jianzhioffer;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
 *

 */
public class Offer11_rotatedSortedArray {
}

class SolutionMinArray {
    public int minArray(int[] numbers) { //二分法探测探针
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else j--; // 如果相同向左移动
        }
        return numbers[i];
    }

}
