package Test;

public class Find {
    public static void main(String[] args) {

    }

    public static boolean findNumber(int[] str1, int[]str2){
        int aSize = str1.length;
        int bSize = str2.length;

        int i=0,j=0;

        while(i < aSize && j< bSize){
            if (str1[i] == str2[j]) {
                return true;
            }
            if(str1[i] > str2[j]){
                j++;
            }
            if(str1[i] < str2[j]){
                i++;
            }
        } 
        return false;
    }
}
