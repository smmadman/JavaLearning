package LeetCode.AlgorithmTest;


import java.util.Arrays;
import java.util.Scanner;

public class LangchaoTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[] array = new int[n + 2];
        
        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }
        
        array[n] = 101;
        array[n + 1] = 102;

        Arrays.sort(array);
        
        int A = 0, B = 0;
        
        int O = -1;
        int E = 0;
        
        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 == 1){
                int temp = (array[i] - O) / 2 - 1;
                if(temp > B){
                    B = temp;
                    A = O + 2;
                }
                O = array[i];                
            }else{
                int temp = (array[i] - E) / 2 - 1;
                if(temp > B){
                    B = temp;
                    A = E + 2;
                }
                E = array[i];
            }
        }

        System.out.println(A + " " + B);
    }
}
