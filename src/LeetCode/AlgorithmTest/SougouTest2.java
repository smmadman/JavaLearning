package LeetCode.AlgorithmTest;

public class SougouTest2 {

    public static int getSolutions(int t, int[] xa){

        double tt = t;
        double[] aa = new double[xa.length];

        for(int i = 0; i < xa.length; i++){
            aa[i] = xa[i];
        }

        if(xa.length == 1){
            return 2;
        }

        double tmp = 0;
        int count = 0;
        double middle = 0;

        for(int i = 0; i < xa.length; i++){
            if((i+3) < xa.length){
                middle = (xa[i + 1] + xa[i + 3]) / 2;
                tmp = (xa[i + 2] - xa[i]) - middle;

                if(tmp > t){
                    count += 2;
                }else if(tmp == t){
                    count += 1;
                }
            }
        }
        System.out.println(count + 2);
        return count + 2;
    }
}
