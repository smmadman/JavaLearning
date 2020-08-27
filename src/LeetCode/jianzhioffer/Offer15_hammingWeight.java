package LeetCode.jianzhioffer;

public class Offer15_hammingWeight {
    public static void main(String[] args) {
        System.out.println(hammingWeight(9));
        System.out.println(hammingWeight(0b11111111111111111111111111111101));
    }



    public static int hammingWeight(int n){
        int count = 0;
        for(int i = 0; i < 32; i++){
            if((n & 1) == 1){
                count ++;
            }
            n = n >>> 1;
        }
        return count;
    }
}
