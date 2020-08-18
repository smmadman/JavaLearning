package Test;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.SimpleFormatter;

public class JunitTest {
    public static void main(String[] args) {

    }

    @Test
    public void Test1(){
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer("abc");
        System.out.println(sb1.length());
        System.out.println(sb2.length());
    }

    @Test
    public void Test2() throws ParseException {
        Date date = new Date();
        String date_str = "2011-10-19 23:22:21";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datestr = simpleDateFormat.format(date);//将date日期以指定形式转换为字符串

        date = simpleDateFormat.parse(date_str); // 将字符串以指定形式转换为date日期

        System.out.println(datestr);
        System.out.println(date);
    }
}
