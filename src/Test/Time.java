package Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Time {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);

        String string = sc.nextLine();

        int i=0;
        int len = string.length();
        while(string.charAt(i)!= '|'){
            i++;
        }
        String str1 = string.substring(0, i);
        String str2 = string.substring(i+1, len);

        String[] s1 = str1.split(" ");
        int[] nums1 = new int[s1.length];
        for(int j=0; j<nums1.length;j++){
            nums1[j] = Integer.parseInt(s1[j]);
        }
        String[] s2 = str2.split(" ");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse(s1[0] + "-" + s1[1] + "-" + s1[2]);
        Date endDate = sdf.parse(s2[0] + "-" + s2[1] + "-" + s2[2]);
        long betweenDate = (endDate.getTime() - startDate.getTime())/(60*60*24*1000);
        int day = (int) betweenDate;
        int week = Integer.parseInt(s1[3]);
        week = ((week + day) % 7);
        week = week == 0 ? 7 : week; //week = (week == 0) ? 7 : week;
        System.out.println(week);
    }
}
