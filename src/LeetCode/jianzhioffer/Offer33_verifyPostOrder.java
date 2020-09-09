package LeetCode.jianzhioffer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class Offer33_verifyPostOrder {

}

class verifyPostOrder{

    /**
     * 递归分治解决
     * @param postOrder
     * @return
     */
    public boolean solution1(int[] postOrder){
        return recur(postOrder, 0, postOrder.length - 1);
    }

    boolean recur(int[] postOrder, int i, int j){
        if(i >= j){
            return true;
        }

        int p = i;
        while(postOrder[p] < postOrder[j]){
            p++;
        }

        int m = p;
        while(postOrder[p] > postOrder[j]){
            p++;
        }

        return p == j && recur(postOrder, i, m - 1)
                && recur(postOrder, m, j - 1);
    }
}
