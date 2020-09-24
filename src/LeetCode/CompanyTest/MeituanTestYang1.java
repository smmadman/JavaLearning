package LeetCode.CompanyTest;

import java.util.Scanner;

public class MeituanTestYang1 {
    static int n;
    static int m;
    static int p;
    static int q;
    static char[][] map;
    static int ans = 0;
    static String route;
    static int x, y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        p = sc.nextInt();
        q = sc.nextInt();
        sc.nextLine();
        map = new char[n][m];
        for(int i = 0; i < n; i++){
            char[] temp = sc.nextLine().toCharArray();
            for(int j = 0; j < m; j++){
                map[i][j] = temp[j];
            }
        }

        route = sc.nextLine();
        help();
        System.out.println(ans);
    }

    static void help(){
        look:
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 'S'){
                    x = i;
                    y = j;
                    break look;
                }
            }
        }

        for(char c : route.toCharArray()){
            move(c);
        }
    }

    static void move(char c){
        if(c == 'W'){
            if(x > 0 && x < n && map[x - 1][y] != '#'){
                x--;
                cal();
            }
        }else if(c == 'A'){
            if(y > 0 && y < m && map[x][y - 1] != '#'){
                y--;
                cal();
            }
        }
        else if(c == 'S'){
            if(x >= 0 && x < n - 1 && map[x + 1][y] != '#'){
                x++;
                cal();
            }
        }
        else if(c == 'D'){
            if(x >= 0 && y < m -1 && map[x][y + 1] != '#'){
                y++;
                cal();
            }
        }
    }

    static void cal(){
        if(map[x][y] == 'O'){
            ans += p;
            map[x][y] = '+';
        }else if(map[x][y] == 'X'){
            ans -= q;
            map[x][y] = '+';
        }
    }
}
