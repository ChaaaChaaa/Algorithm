package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q2580 {
    static int[][] map = new int[9][9];

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
    }

    static void dfs(int row, int col) {
        if(col == 9){
            dfs(row+1,0);
            return;
        }

        if(row == 9){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    sb.append(map[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            System.exit(0);
        }

        if(map[row][col] == 0){
            for(int i=1; i<=9; i++){
                if(isCheck(row,col,i)){
                    map[row][col] = i;
                    dfs(row,col+1);
                }
            }
            map[row][col] = 0;
            return;
        }
        dfs(row,col+1);
    }

    public static boolean isCheck(int row, int col, int value){
        for(int i=0; i<9; i++){
            if(map[row][i] == value){
                return false;
            }
        }

        for(int i=0; i<9; i++){
            if(map[i][col] == value){
                return false;
            }
        }

        int setRow = (row/3)*3;
        int setCol = (col/3)*3;

        for(int i=setRow; i<setRow+3; i++){
            for(int j=setCol; j<setCol+3; j++){
                if(map[i][j] == value){
                    return false;
                }
            }
        }
        return true;
    }
}

