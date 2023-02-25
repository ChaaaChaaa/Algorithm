package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q2667 {
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static int [][] map;
    static boolean [][] visited;
    static List<Integer> countHouse;
    static int eachHouse;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        countHouse = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        char [][] tempMap = new char[n][n];

        map = new int[n][n];
        visited = new boolean[n][n];
        eachHouse = 0;

        for(int i=0; i<n; i++){
            String str = br.readLine();
            tempMap[i] = str.toCharArray();
            for(int j=0; j<n; j++){
                map[i][j] = tempMap[i][j] - '0';
            }
        }

        int cnt = countApart(n);
        System.out.println(cnt);

        Collections.sort(countHouse);

        for(Integer house : countHouse){
            System.out.println(house);
        }
    }

    public static int countApart(int n){
        int cnt = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    eachHouse = 1;
                    dfs(i,j,n);
                    countHouse.add(eachHouse);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static int dfs(int x, int y,int n){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = dx[i]+x;
            int ny = dy[i]+y;

            if(nx>=0 && ny>=0 && nx<n && ny<n && !visited[nx][ny] && map[nx][ny] == 1){
                dfs(nx,ny,n);
                eachHouse++;
            }
        }
        return eachHouse;
    }

}
