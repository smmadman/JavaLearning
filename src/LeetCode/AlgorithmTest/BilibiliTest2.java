package LeetCode.AlgorithmTest;

public class BilibiliTest2 {
    public static void main(String[] args) {

    }
    public int GetFragment (String str) {
        // write code here

        char s = str.charAt(0);
        double count = 1, d;
        for(int i = 0; i < str.length(); i++){
            if(s != str.charAt(i)){
                s = str.charAt(i);
                count++;
            }
        }

        d = str.length()/count;

        int res = new Double(d).intValue();
        return res;
    }

    public int GetFragment2 (String str) {
        if(str.length() > 2){
            int n = str.length();
            int num = 1;
            char preChar = str.charAt(0);
            for(int i = 1; i < n; i++){
                char curChar = str.charAt(i);
                if(curChar != preChar){
                    num++;
                    preChar = curChar;
                }
            }
            return n / num;
        }else{
            return 0;
        }

    }
}
