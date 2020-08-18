package AlgorithmTest;

public class FenzhiDiguiTest{
    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        System.out.println(cuttingRope(100));
        Long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) / 1000 + "s");
    }

    public static int cuttingRope(int n){
        if(n == 2) return 1;
        int res = -1;

        for(int i = 1; i < n; i++){
            res = Math.max(res, Math.max(i * cuttingRope(n - 1), i * (n - 1)));
        }
        return res;
    }
}
