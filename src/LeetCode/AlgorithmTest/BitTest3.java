package LeetCode.AlgorithmTest;

import java.util.Scanner;

public class BitTest3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int N = sc.nextInt();

        int xa = sc.nextInt();
        int ya = sc.nextInt();
        int xb = sc.nextInt();
        int yb = sc.nextInt();
        int xc = sc.nextInt();
        int yc = sc.nextInt();

        for(int i = 0; i < N; i++){
            int da = ((b * xb) % 1000000007 + (c * xc) % 1000000007) % 1000000007;
            int db = ((a * xa) % 1000000007 + (c * yc) % 1000000007) % 1000000007;
            int dc = ((a * ya) % 1000000007 + (b * yb) % 1000000007) % 1000000007;

            a = (a % 1000000007 + da % 1000000007) % 1000000007;
            b = (b % 1000000007 + db % 1000000007) % 1000000007;
            c = (c % 1000000007 + dc % 1000000007) % 1000000007;
        }

        System.out.println("" + a + ' ' + b + ' ' + c);
    }


}
