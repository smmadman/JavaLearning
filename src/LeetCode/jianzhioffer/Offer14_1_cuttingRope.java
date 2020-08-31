package LeetCode.jianzhioffer;

public class Offer14_1_cuttingRope {
    public static void main(String[] args) {

    }

    /**
     * 数学推导结论：
     * ① 当所有绳段长度相等时，乘积最大。
     * ② 最优的绳段长度为 3，3 。
     * @param n
     * @return
     */
    public static int cuttingRopeTest(int n){
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }


}
