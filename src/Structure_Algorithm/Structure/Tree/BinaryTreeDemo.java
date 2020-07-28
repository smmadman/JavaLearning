package Structure_Algorithm.Structure.Tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        //建立节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        //建立二叉树
        BinaryTree binaryTree = new BinaryTree(root);

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        //测试
		System.out.println("前序遍历"); // 1,2,3,5,4
		binaryTree.preOrder();

		System.out.println("中序遍历");
		binaryTree.infixOrder(); // 2,1,5,3,4

		System.out.println("后序遍历");
		binaryTree.postOrder(); // 2,5,4,3,1

        //前序遍历
        //前序遍历的次数 ：4
		System.out.println("前序遍历方式~~~");
		HeroNode resNode = binaryTree.preOrderSearch(5);
		if (resNode != null) {
			System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
		} else {
			System.out.printf("没有找到 no = %d 的英雄", 5);
		}

        //中序遍历查找
        //中序遍历3次
		System.out.println("中序遍历方式~~~");
		resNode = binaryTree.infixOrderSearch(5);
		if (resNode != null) {
			System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
		} else {
			System.out.printf("没有找到 no = %d 的英雄", 5);
		}

        //后序遍历查找
        //后序遍历查找的次数  2次
		System.out.println("后序遍历方式~~~");
		resNode = binaryTree.postOrderSearch(5);
		if (resNode != null) {
			System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
		} else {
			System.out.printf("没有找到 no = %d 的英雄", 5);
		}

    }

}

class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name){
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public HeroNode getLeft() {
        return left;
    }
    public void setLeft(HeroNode left) {
        this.left = left;
    }
    public HeroNode getRight() {
        return right;
    }
    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + "]";
    }

    //前序遍历方法：
    public void preOrder(){
        //最先输出父结点
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }

        if(this.right != null){
            this.right.preOrder();
        }
    }

    //中序遍历方法：
    public void infixOrder(){
        if(this.left != null){
            this.left.infixOrder();
        }
        //中间输出父结点
        System.out.println(this);
        if(this.right != null){
            this.right.infixOrder();
        }
    }

    //后序遍历方法：
    public void postOrder(){
        if(this.left != null){
            this.left.postOrder();
        }

        if(this.right != null){
            this.right.postOrder();
        }

        //最后输出父结点
        System.out.println(this);
    }

    public HeroNode preOrderSearch(int no){
        System.out.println("前序遍历+1次");
        if(this.no == no){//比较当前结点是不是
            return this;
        }

        HeroNode res = null;

        //1.则判断当前结点的左子节点是否为空，如果不为空，则递归前序查找
        //2.如果左递归前序查找，找到结点，则返回
        if(this.left != null){
            res = this.left.preOrderSearch(no);
        }

        if(res != null){//说明我们左子树找到
            return res;
        }

        //1.左递归前序查找，找到结点，则返回，否继续判断，
        //2.当前的结点的右子节点是否为空，如果不空，则继续向右递归前序查找
        if(this.right != null){
            res = this.right.preOrderSearch(no);
        }

        return res;
    }

    public HeroNode infixOrderSearch(int no){
        HeroNode res = null;

        if(this.left != null){
            //判断当前结点的左子节点是否为空，如果不为空，则递归中序查找
            res = this.left.infixOrderSearch(no);
        }

        if(res != null){
            return res;
        }

        System.out.println("中序遍历+1次");
        //如果找到，则返回，如果没有找到，就和当前结点比较，如果是则返回当前结点
        if(this.no == no){
            return this;
        }

        //否则继续进行右递归的中序查找
        if(this.right != null){
            res = this.right.infixOrderSearch(no);
        }

        return res;
    }

    public HeroNode postOrderSearch(int no){
        HeroNode res = null;

        if(this.left != null){
            res = this.left.postOrderSearch(no);
        }

        if(res != null){
            return res;
        }

        if(this.right != null){
            res = this.right.postOrderSearch(no);
        }

        if(res != null){
            return res;
        }

        System.out.println("后序遍历+1次");
        if(this.no == no){
            return this;
        }

        return res;
    }
}


//定义BinaryTree 二叉树
class BinaryTree {
    private HeroNode root;

    public BinaryTree(HeroNode root){
        this.root = root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

//    //删除结点
//    public void delNode(int no) {
//        if(root != null) {
//            //如果只有一个root结点, 这里立即判断root是不是就是要删除结点
//            if(root.getNo() == no) {
//                root = null;
//            } else {
//                //递归删除
//                root.delNode(no);
//            }
//        }else{
//            System.out.println("空树，不能删除~");
//        }
//    }
    //前序遍历
    public void preOrder() {
        if(this.root != null) {
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if(this.root != null) {
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //后序遍历
    public void postOrder() {
        if(this.root != null) {
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //前序遍历
    public HeroNode preOrderSearch(int no) {
        if(root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }
    //中序遍历
    public HeroNode infixOrderSearch(int no) {
        if(root != null) {
            return root.infixOrderSearch(no);
        }else {
            return null;
        }
    }
    //后序遍历
    public HeroNode postOrderSearch(int no) {
        if(root != null) {
            return this.root.postOrderSearch(no);
        }else {
            return null;
        }
    }
}
