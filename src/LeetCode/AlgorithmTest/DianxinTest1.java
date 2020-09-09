package LeetCode.AlgorithmTest;

public class DianxinTest1 {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            for(int ii = 0; ii < 10; ii++){
                for(int iii = 0; iii < 10; iii++){
                    for(int iiii = 0; iiii < 10; iiii++){
                        int abcd = i * 1000 + ii * 100 + iii * 10 + iiii;
                        int bcda = ii * 1000 + iii * 100 + iiii * 10 + i;

                        if(abcd + bcda == 8888){
                            System.out.println(i +" "+ ii +" "+ iii +" "+ iiii);
                        }
                    }
                }
            }
        }
    }
}
