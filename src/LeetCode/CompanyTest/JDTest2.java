package LeetCode.CompanyTest;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JDTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            String s = sc.nextLine();

            Pattern pattern = Pattern.compile("[^0123456789][123][0-9]{3}[^0123456789]");
            Matcher matcher = pattern.matcher(s);

            while(matcher.find()){
                System.out.print(matcher.group().substring(1,5));
            }
        }

    }
}
