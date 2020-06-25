package Test;

import java.util.ArrayList;

public class ConvertTest {

    public static void main(String[] args) {
        System.out.println(NumberLetter("adsZfjuiwjfZhfuawefuisjfiwfjZs;"));

    }

    public static String NumberLetter(String str){
        StringBuilder Sb = new StringBuilder(str);

        int index = 0;

        while((index = Sb.indexOf("Z",index)) != -1){
            Sb.insert(index+1, "S");
            index += 2;
        }

        index = 0;

        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> breakPoint = new ArrayList<Integer>();



        for(int i = 0; i < Sb.length(); i++){
            if(NumberCharJudge(Sb.charAt(i))){
                a.add(i);
            }
        }


        for(int i = 0; i < a.size() - 1; i++){
            if(a.get(i+1) - a.get(i) != 0){
                breakPoint.add(i);
            }
        }

        boolean B_flag = false;
        int[][] arrSE = new int[a.size()][2];
        int index0 = 0;
        int index1 = 0;
        arrSE[index0][index1] = a.get(0);
        index1++;

        for(int i = 1; i < a.size() - 1; i++){
            if(a.get(i+1) - a.get(i) == 1 && a.get(i) - a.get(i-1) == 1){
                continue;
            }
            else if((a.get(i) - a.get(i-1) == 1 && a.get(i+1) - a.get(i) != 1) ||
                    (a.get(i) - a.get(i-1) != 1 && a.get(i+1) - a.get(i) == 1)){
                arrSE[index0][index1] = i;
                index1 ++;
                if(index1 == 2){
                    index0 ++;
                    index1 = 0;
                }
            }
        }




        return Sb+"";
    }

    public static boolean NumberCharJudge(char a){
        if(a >= 48 && a <= 57){
            return true;
        }
        else{
            return false;
        }
    }

}
