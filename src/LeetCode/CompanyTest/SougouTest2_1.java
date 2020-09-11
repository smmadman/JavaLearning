package LeetCode.CompanyTest;

public class SougouTest2_1 {

    public int getHouses (int t, int[] xa) {
        if(xa.length == 0){
            return 0;
        }

        int res = 2;

        double[] doublexa = new double[xa.length];

        for(int i = 0; i < xa.length; i++){
            doublexa[i] = xa[i];
        }

        double preLoc = doublexa[0] + doublexa[1]/2;
        for(int i = 1; i < doublexa.length / 2; i++){
            double curIndex = doublexa[i * 2];
            double curLength = doublexa[i * 2 + 1];
            double curLoc = curIndex - curLength / 2 ;
            double curX = curLoc - preLoc;
            preLoc  = curLoc + curLength;
            if(curX > t){
                res += 2;
            }else if(curX == t){
                res += 1;
            }
        }

        return res;
    }
}
