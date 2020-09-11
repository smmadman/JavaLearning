package LeetCode.CompanyTest;

import java.util.Scanner;

public class BitTest2 {
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
            int da = b * xb + c * xc;
            int db = a * xa + c * yc;
            int dc = a * ya + b * yb;

            a = (a % 1000000007 + da % 1000000007) % 1000000007;
            b = (b % 1000000007 + db % 1000000007) % 1000000007;
            c = (c % 1000000007 + dc % 1000000007) % 1000000007;
        }

        System.out.println("" + a + ' ' + b + ' ' + c);
    }
}
