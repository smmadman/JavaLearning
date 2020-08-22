package LeetCode.jianzhioffer;

public class Offer15_hammingWeight {
    public static void main(String[] args) {
        System.out.println(hammingWeight(9));
    }

    public static int hammingWeight(int i){
        int a = 1;
        int res = 0;
        if(i == 0){
            return 0;
        }
        int temp = 0;
        while(i > 0){
            temp = i & a;
            if(temp == 0){

            }else{
                res++;
            }

            i = i >> 1;
        }

        return res;
    }
}
