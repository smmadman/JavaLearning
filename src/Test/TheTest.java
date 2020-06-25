package Test;

public class TheTest {
    public static void main(String[] args) {
        String str1 = new String("5a as df 5a sd fe tg 5a tf wf wf 5a");

        String[] splited_str1 = str1.split("5b");

        for (int i = 0; i < splited_str1.length; i++) {
            System.out.println(splited_str1[i]);
        }
    }

}
