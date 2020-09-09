package LeetCode.AlgorithmTest;


import java.util.Arrays;
import java.util.Scanner;

public class XiechengTest {
    public static void main(String[] args) {
        Test();
    }

    public static void Test(){
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String[] str_arr = str.split(" ");

        char[][] char_arr = new char[str_arr.length][];

        for(int i = 0; i < char_arr.length; i++){
            char_arr[i] = new char[str_arr[i].length()];
        }

        for(int i = 0; i < char_arr.length; i++) {
            for (int ii = 0; ii < str_arr[i].length(); ii++) {
                char_arr[i][ii] = str_arr[i].charAt(ii);
            }
            Arrays.sort(char_arr[i]);
        }

        int depth = char_arr.length;

        test2("", char_arr, 0, false);
    }

    public static void test2(String str, char[][] arr, int depth, boolean flag){

        if(depth == arr.length){
            if(flag){
                System.out.println(str + "--circular dependency");
                return;
            }else{
                System.out.println(str);
                return;
            }
        }

        for(int i = 0; i < arr[depth].length; i++){
            if(flag){
                test2(str + arr[depth][i], arr, depth + 1, flag);
            }else{
                boolean theFlag = false;
                for(int j = 0; j < str.length(); j++){
                    if(arr[depth][i] == str.charAt(j)){
                        theFlag = true;
                    }
                }

                test2(str + arr[depth][i], arr, depth + 1, theFlag);
            }

        }
    }
}
