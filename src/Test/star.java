package Test;

import java.util.Scanner;

public class star {
    public static void main(String[] args) {
        int lucky_star_account = 0;
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据

        int star_number = scan.nextInt();

        int[][] points = new int[star_number][2];

        for(int i=1; i<=star_number; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();

            points[i-1][0] = x;
            points[i-1][1] = y;
        }

        int star_around = 0;

        for (int[] point: points){

            if(point[0] == 1000 || point[0] == -1000 || point[1] == 1000 || point[1] == -1000){
                continue; //在边上，pass
            }
            else{
                for (int[] point2: points){
                    if (point2[0] == point[0]){//如横坐标相等
                        if(point2[1] - point[1] == 1 || point2[1] - point[1] == -1 ){
                            star_around ++;
                        }
                    }else if(point2[1] == point[1]){//如纵坐标相等
                        if(point2[0] - point[0] == 1 || point2[0] - point[0] == -1 ){
                            star_around ++;
                        }
                    }
                    if(star_around == 4){
                        lucky_star_account++;
                    }

                }
            }
        }

        scan.close();
        System.out.println(lucky_star_account);
    }
}