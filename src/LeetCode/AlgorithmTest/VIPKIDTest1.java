package LeetCode.AlgorithmTest;

public class VIPKIDTest1 {
    public static void main(String[] args) {
        System.out.println(parseChineseNumber("一千零一"));;
    }

    public static long parseChineseNumber(String s){
        long res = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int qianFlag = -1;
        for(int i = 0; i < s.length(); i++){
            switch (s.charAt(i)){
                case '千':
                    qianFlag = i;
                case '零':
                    if(qianFlag >= 0 && qianFlag == i - 1){
                        stringBuilder.append('0');
//                        stringBuilder.append('0');
                        qianFlag = -1;
                    }else{stringBuilder.append('0');}
                    break;
                case '一':
                    stringBuilder.append('1');
                    break;
                case '二':
                    stringBuilder.append('2');
                    break;
                case '三':
                    stringBuilder.append('3');
                    break;
                case '四':
                    stringBuilder.append('4');
                    break;
                case '五':
                    stringBuilder.append('5');
                    break;
                case '六':
                    stringBuilder.append('6');
                    break;
                case '七':
                    stringBuilder.append('7');
                    break;
                case '八':
                    stringBuilder.append('8');
                    break;
                case '九':
                    stringBuilder.append('9');
                    break;
            }
        }

        long a = 1;
        for(int i = stringBuilder.length() - 1; i >= 0; i--){
            res += (stringBuilder.charAt(i) - '0') * a;
            a *= 10;
        }

        return res;
    }
}
