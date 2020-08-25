package LeetCode.jianzhioffer;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class Offer27_mirrorTree {
    public static void main(String[] args) {

    }

    public static TreeNode mirrorTree(TreeNode root){
        if(root == null) return null;
        TreeNode temp = root.left;

        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);

        return root;
    }
}
