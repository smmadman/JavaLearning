package Test;
import java.util.Scanner;

public class baowen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();

        String start_flag = "5a";

        boolean starts_flag = str1.startsWith("5a");
        boolean end_flag = str1.endsWith("5a");
        if (starts_flag && end_flag) {//整个字符串是以5a开头并且以5a结尾
            String[] splited_str = str1.split("5a"); //以5a分割字符串并保存在splited_str[]中，其中且数组中开头第一个和最后一个都为空

            boolean[] flag_array = new boolean[splited_str.length - 2];

            for (int i = 1; i < splited_str.length - 1; i++) {

                if(judge_wrong_escape(splited_str[i])){
                    flag_array[i-1] = true;
                    continue;
                }

                int esp_times = escape_time(splited_str[i]);

                int str_number = ((splited_str[i].length() - 1) / 2 - 1) - esp_times;
                String length_hex = splited_str[i].substring(splited_str[i].length() - 3, splited_str[i].length() - 1);
                String number_str = Integer.toHexString(str_number);
                if (number_str.equalsIgnoreCase(length_hex)) {//每个子字符串中的最后数据长度位的数字等于数据长度
                    continue;
                }else{
                    flag_array[i-1] = true;
                }

            }

            int number = 0;
            for(boolean a: flag_array){
                if(!a){
                    number++;
                }
            }

            System.out.print("5a");

            for (int i=0; i<number; i++){
                if(!flag_array[i]){
                    System.out.println(splited_str[i+1]);
                }
            }

            System.out.print("5a");

        } else {//整个字符串不是以5a开头 || 不以 5a 结束

        }
    }

    public static boolean judge_wrong_escape(String str) {//判断是是否有非法转义字符
        String[] splited_str = str.split("5b");//按5b分割字符串
        if (splited_str.length <= 1) {//没有5b
            return false;
        } else {
            for (int i = 1; i < splited_str.length; i++) {//
                if (splited_str[i].length() < 3) {
                    return true;
                } else {
                    String start_str = splited_str[i].substring(1, 3);
                    if (start_str.equals("bb") || start_str.equals("ba")) {
                        return false;
                    } else {
                        return true;
                    }

                }
            }
            return true;
        }
    }

    public static int escape_time(String str){
        int esp_times = 0;

        String find_str1 = "5b ba";
        String find_str2 = "5b bb";

        int index = 0;
        while(str.indexOf(find_str1, index) != -1){
            esp_times += 1;
            index += find_str1.length();
        }
        while(str.indexOf(find_str2, index) != -1){
            esp_times += 1;
            index += find_str2.length();
        }

        return esp_times;
    }
}
