package jianzhioffer;

public class Offer10_1_fibonacci {
    public static void main(String[] args) {

    }
}

class Solutionfib {
    public int fib(int n) {  //递归消耗时间以及空间太多，不适用
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}