package Test;

public class Test111 {
    public static void main(String[] args) {
//        int sum1 = 0;
//        int sum = 0;
//        for(int i = 1 ; i <= 108; i++){
//            if(i % 4 == 0 && i % 6 == 0){
//                sum1 += i;
//            }
//            if(i % 4 != 0 && i % 6 != 0){
//                sum+=i;
//            }
//        }
//        System.out.println(sum + sum1);
        System.out.println(Test222());

    }

    public static int Test222(){
        try{
            int a = 1/0;
            return 3;
        }catch (java.lang.Exception e){
            e.printStackTrace();
            return 1;
        }finally {
            return 2;
        }
    }
}
