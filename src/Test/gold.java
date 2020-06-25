package Test;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class gold {


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        BigDecimal zero_value = new BigDecimal("0");
        BigDecimal fushu  = new BigDecimal("-1");
        BigDecimal temp = null;

        while(true){//用一个循环来接受一行值
            String account_number = sc.nextLine();
            BigDecimal decimal_account=new BigDecimal(account_number);

            DecimalFormat df = new DecimalFormat("#,##0.00");
            df.setRoundingMode(RoundingMode.FLOOR);
            String m;

            switch (decimal_account.compareTo(zero_value)){
                case -1://负数
                    temp = decimal_account.multiply(fushu);
                    m = df.format(temp);
                    System.out.println("($" + m + ")");
                    break;
                default:
                    m = df.format(decimal_account);
                    System.out.println("$" + m);
                    break;
            }

        }
    }
}



