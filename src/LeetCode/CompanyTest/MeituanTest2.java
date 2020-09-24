package LeetCode.CompanyTest;

import java.util.Scanner;

public class MeituanTest2 {
    public static void main(String[] args) {
        int[] index = new int[2];
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String[] strArr = str.split(" ");
        int n = Integer.parseInt(strArr[0]); // n row
        int m = Integer.parseInt(strArr[1]); // m col
        int p = Integer.parseInt(strArr[2]); // p score
        int q = Integer.parseInt(strArr[3]); // q cost

        char[][] map = new char[n][m];

        for(int i = 0; i < n; i++){
            String strTemp = sc.nextLine();
            for(int ii = 0; ii < strTemp.length(); ii++){
                char tempChar = strTemp.charAt(ii);
                map[i][ii] = tempChar;
                if(tempChar == 'S'){
                    index[0] = i;
                    index[1] = ii;
                }
            }
        }

        String movingCommand = sc.nextLine();
        int scoreSum = 0;

        for(int i = 0; i < movingCommand.length(); i++){
            scoreSum += move(movingCommand.charAt(i), map, index, p, q);
        }
        System.out.println(scoreSum);
    }

    public static int move(char command, char[][] map, int[] index, int score, int cost){
        int[] newIndex = new int[2];
        int scoreRes = 0;
        switch (command){
            case 'S':
                newIndex[0] = index[0] + 1;
                newIndex[1] = index[1];

                if(newIndex[0] < 0 || index[0] >= map.length || newIndex[1] < 0 || index[1] >= map[1].length) break;
                else if(map[newIndex[0]][newIndex[1]] == '#'){
                    break;
                }else if(map[newIndex[0]][newIndex[1]] == '+'){
                    index[0] = newIndex[0];
                    index[1] = newIndex[1];
                }else if(map[newIndex[0]][newIndex[1]] == 'O'){

                    scoreRes += score;
                    map[newIndex[0]][newIndex[1]] = '+';

                    index[0] = newIndex[0];
                    index[1] = newIndex[1];
                }else if(map[newIndex[0]][newIndex[1]] == 'X'){
                    scoreRes -= cost;
                    map[newIndex[0]][newIndex[1]] = '+';

                    index[0] = newIndex[0];
                    index[1] = newIndex[1];
                }else if(map[newIndex[0]][newIndex[1]] == 'S'){
                    map[newIndex[0]][newIndex[1]] = '+';
                    index[0] = newIndex[0];
                    index[1] = newIndex[1];
                }

                break;
            case 'W':
                newIndex[0] = index[0] - 1;
                newIndex[1] = index[1];

                if(newIndex[0] < 0 || index[0] >= map.length || newIndex[1] < 0 || index[1] >= map[1].length) break;
                else if(map[newIndex[0]][newIndex[1]] == '#'){
                    break;
                }else if(map[newIndex[0]][newIndex[1]] == '+'){
                    index[0] = newIndex[0];
                    index[1] = newIndex[1];
                }else if(map[newIndex[0]][newIndex[1]] == 'O'){

                    scoreRes += score;
                    map[newIndex[0]][newIndex[1]] = '+';

                    index[0] = newIndex[0];
                    index[1] = newIndex[1];
                }else if(map[newIndex[0]][newIndex[1]] == 'X'){

                    scoreRes -= cost;
                    map[newIndex[0]][newIndex[1]] = '+';

                    index[0] = newIndex[0];
                    index[1] = newIndex[1];
                }else if(map[newIndex[0]][newIndex[1]] == 'S'){
                    map[newIndex[0]][newIndex[1]] = '+';
                    index[0] = newIndex[0];
                    index[1] = newIndex[1];
                }

                break;
            case 'A':
                newIndex[0] = index[0];
                newIndex[1] = index[1] - 1;

                if(newIndex[0] < 0 || index[0] >= map.length || newIndex[1] < 0 || index[1] >= map[1].length) break;
                else if(map[newIndex[0]][newIndex[1]] == '#'){
                    break;
                }else if(map[newIndex[0]][newIndex[1]] == '+'){
                    index[0] = newIndex[0];
                    index[1] = newIndex[1];
                }else if(map[newIndex[0]][newIndex[1]] == 'O'){

                    scoreRes += score;
                    map[newIndex[0]][newIndex[1]] = '+';

                    index[0] = newIndex[0];
                    index[1] = newIndex[1];
                }else if(map[newIndex[0]][newIndex[1]] == 'X'){

                    scoreRes -= cost;
                    map[newIndex[0]][newIndex[1]] = '+';

                    index[0] = newIndex[0];
                    index[1] = newIndex[1];
                }else if(map[newIndex[0]][newIndex[1]] == 'S'){
                    map[newIndex[0]][newIndex[1]] = '+';
                    index[0] = newIndex[0];
                    index[1] = newIndex[1];
                }

                break;
            case 'D':
                newIndex[0] = index[0];
                newIndex[1] = index[1] + 1;

                if(newIndex[0] < 0 || index[0] >= map.length || newIndex[1] < 0 || index[1] >= map[1].length) break;
                else if(map[newIndex[0]][newIndex[1]] == '#'){
                    break;
                }else if(map[newIndex[0]][newIndex[1]] == '+'){
                    index[0] = newIndex[0];
                    index[1] = newIndex[1];
                }else if(map[newIndex[0]][newIndex[1]] == 'O'){

                    scoreRes += score;
                    map[newIndex[0]][newIndex[1]] = '+';

                    index[0] = newIndex[0];
                    index[1] = newIndex[1];
                }else if(map[newIndex[0]][newIndex[1]] == 'X'){

                    scoreRes -= cost;
                    map[newIndex[0]][newIndex[1]] = '+';

                    index[0] = newIndex[0];
                    index[1] = newIndex[1];
                }else if(map[newIndex[0]][newIndex[1]] == 'S'){
                    map[newIndex[0]][newIndex[1]] = '+';
                    index[0] = newIndex[0];
                    index[1] = newIndex[1];
                }

                break;
        }

        return scoreRes;
    }
}
