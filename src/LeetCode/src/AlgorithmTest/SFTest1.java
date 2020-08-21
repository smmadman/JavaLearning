package LeetCode.src.AlgorithmTest;

import java.util.Scanner;

public class SFTest1 {

    static int MaxGold = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int missionCount = scanner.nextInt();

        int[][] missArray = new int[missionCount][3];

        for(int i = 0; i < missionCount; i++){
            for(int j = 0; j < 3; j++){
                missArray[i][j] = scanner.nextInt();
            }
        }

        int curMissionGlod = 0;

        for (int i = 0; i < missionCount; i++) {
            reGold(missArray,0, curMissionGlod);
        }

        System.out.println(MaxGold);
    }

    public static boolean judge(int[] cur, int[] next){
        if(next[0] > cur[1]) {
            return true;
        }else{
            return false;
        }
    }

    public static boolean judgeAfter(int[][] missArray, int curMission){
        if(curMission == missArray.length - 1){
            return false;
        } else if(curMission < missArray.length - 1){
            boolean flag = true;
            for(int i = curMission + 1; i < missArray.length; i++){
                flag = flag & judge(missArray[curMission], missArray[i]);
            }

            return flag;
        }
        return true;
    }

    public static void reGold(int[][] missArray, int curMission, int curMissionGold){
        curMissionGold += missArray[curMission][2];

        MaxGold = Math.max(MaxGold, curMissionGold);

        for(int i = curMission + 1; i < missArray.length; i++){
            if(judge(missArray[curMission], missArray[i])){
                reGold(missArray, i, curMissionGold);
            }
        }
    }
}
