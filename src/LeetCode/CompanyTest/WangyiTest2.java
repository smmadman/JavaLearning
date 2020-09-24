package LeetCode.CompanyTest;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class WangyiTest2 {

    static int theRes = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strTemp = sc.nextLine();
        String[] strTempArr = strTemp.split(" ");

        int roots = Integer.parseInt(strTempArr[0]);
        int charges = Integer.parseInt(strTempArr[1]);
        LinkedPath[] pathArr = new LinkedPath[roots];

        for(int i = 0; i < pathArr.length; i++){
            pathArr[i] = new LinkedPath(i);
        }

        int[] arrs = new int[roots - 1];

        for(int i = 0; i < arrs.length; i++){
            arrs[i] = sc.nextInt();
        }

        for(int i = 1; i <= arrs.length; i++){
            pathArr[i].set.add(pathArr[arrs[i - 1]]);
            pathArr[arrs[i - 1]].set.add(pathArr[i]);
        }

        Set<LinkedPath> reached = new HashSet<>();
        recur(reached, 1, pathArr[0], charges - 1);


        System.out.println(theRes + 1);

    }

    static void recur(Set<LinkedPath> reached, int res, LinkedPath root, int charge){

        if(charge == 0)  {
            theRes = Math.max(res, theRes);
            return;
        }

        for (LinkedPath i : root.set) {
            if (!reached.contains(i)) {
                res++;
                reached.add(i);
                charge--;
                recur(reached, res, i, charge);
                reached.remove(i);
                res--;
                charge++;
            }
        }

        for (LinkedPath i : root.set) {
            charge--;
            recur(reached, res, i, charge);
            charge++;
        }
    }
}

class LinkedPath{
    int val;
    Set<LinkedPath> set = new HashSet<>();
    public LinkedPath(int the_val){
        val = the_val;
    }
}
