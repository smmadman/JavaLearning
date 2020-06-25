package Test;

import java.util.Scanner;

public class Ludeng {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String Line1 = sc.nextLine();
        String Line2 = sc.nextLine();

        String[] stations = Line1.split(",");
        String[] lights = Line2.split(",");


        int[] stations_int = new int[stations.length];
        int[] lights_int = new int[lights.length];

        for(int i=0; i<stations.length;i++){
            stations_int[i] = Integer.parseInt(stations[i]);
        }

        for(int i=0; i<lights.length;i++){
            lights_int[i] = Integer.parseInt(lights[i]);
        }

        for(int i=0;i<=1000;i++){
            if(allStationJudge(stations_int, lights_int, i)){
                System.out.println(i);
                break;
            }
        }
    }

    public static boolean judge_light(int station, int light, int lightRange){
        if(light - lightRange <= station && station <= light + lightRange){
            return true;
        }else{
            return false; }

    }

    public static boolean allStationJudge(int[] stations, int[] lights, int lightRange){
        boolean coverFlag = true;

        for(int station:stations){
            boolean perFlag = false;
            for(int light:lights){
                if(judge_light(station, light, lightRange)){
                    perFlag |= true;
                }
            }
            coverFlag &= perFlag;
        }
        return coverFlag;
    }
}
