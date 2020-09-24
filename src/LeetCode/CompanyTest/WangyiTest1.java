package LeetCode.CompanyTest;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WangyiTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String strTemp = sc.nextLine();
        String[] strTempArr = strTemp.split(" ");

        int m = Integer.parseInt(strTempArr[0]);//节点个数
        int n = Integer.parseInt(strTempArr[1]);//边个数

        TreeNode[] treeArr = new TreeNode[m];
        int count = 1;
        for(int i = 0; i < m; i++){
            treeArr[i] = new TreeNode(i + 1);
        }
        for(int i = 0; i < n; i++){
            String str = sc.nextLine();
            String[] strArr = str.split(" ");
            int parIndex = Integer.parseInt(strArr[0]) - 1;
            int sonIndex = Integer.parseInt(strArr[2]) - 1;

            if("right".equals(strArr[1])){
                treeArr[parIndex].right = treeArr[sonIndex];
            }else if("left".equals(strArr[1])){
                treeArr[parIndex].left = treeArr[sonIndex];
            }
        }

        int res = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeArr[0]);
        while(!queue.isEmpty()){
            TreeNode tempNode = queue.poll();

            if(judge(tempNode)) res++;
            else{
                if(tempNode.left != null) queue.add(tempNode.left);
                if(tempNode.right != null) queue.add(tempNode.right);
            }
        }

        System.out.println(res);

    }

    static boolean judge(TreeNode root){
        if(root.right == null || root.left == null) return false;
        if(root.right.right == null && root.right.left == null && root.left.right == null && root.left.left == null) return true;
        return false;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}