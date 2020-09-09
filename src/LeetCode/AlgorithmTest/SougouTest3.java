package LeetCode.AlgorithmTest;

//public class SougouTest3 {
//    public long getPasswordCount (String password) {
//        // write code here
//
//        int n = password.length();
//        int[] arr = new int[password.length()];
//        for(int i = 0; i < n; i++){
//            arr[i] = (int)(password.charAt(i) - '0');
//        }
//
//        boolean isSame = false;
//
//        for(int i = 0; i <= 9; i++){
//            if(i != arr[0]){
//                isSame = false;
//            }else{
//                isSame = true;
//            }
//            recur(i, 1, arr, isSame);
//        }
//        System.out.println(res);
//    }
//
//    public void recur(int curInt, int index, int[] arr, boolean flag){
//        if(index == arr.length){
//            if(!flag){
//                res++;
//            }
//            return;
//        }
//
//        boolean oldflag = flag;
//
//        int newInt = (curInt + arr[index])/2;
//        if (flag) {
//
//            if(newInt != arr[index]){
//                flag = false;
//            }
//        }
//
//        recur(newInt, index + 1, arr, flag);
//
//        if((curInt + arr[index]) % 2 == 1){
//            if(oldflag){
//                if(newInt + 1 != arr[index]){
//                    oldflag = false;
//                }
//            }
//            recur(newInt +1, index + 1, arr, oldflag);
//
//        }
//    }
//}
