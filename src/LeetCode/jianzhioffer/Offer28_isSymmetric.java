package LeetCode.jianzhioffer;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 如果一棵二叉树和它的镜像一样，那么它是对称的。
 */

public class Offer28_isSymmetric {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root){
        return root == null ? true : recur(root.left, root.right);
    }

    public boolean recur(TreeNode L, TreeNode R){
        if(L == null && R == null) return true;
        if(L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }
}

