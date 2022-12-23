package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1987 {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static int r,c;
    private static boolean[] alphabetVisit = new boolean[26];
    private static int[][] map;
    private static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];

        for(int i=0; i<r; i++){
            String str = br.readLine();
            for(int j=0; j<c; j++){
                map[i][j] = str.charAt(j)-'A';
            }
        }
        dfs(0,0,0);
        System.out.println(result);
    }

    private static void dfs(int row, int col, int count){
        if(alphabetVisit[map[row][col]]){
            result = Math.max(result,count);
            return;
        }

        alphabetVisit[map[row][col]] = true;
        for(int i=0; i<4; i++){
            int nx = dx[i]+row;
            int ny = dy[i]+col;

            if(isBoundary(nx,ny)){
                dfs(nx,ny,count+1);
            }
        }
        alphabetVisit[map[row][col]] = false;
    }

    private static boolean isBoundary(int row, int col){
        return (row>=0 && row<r) && (col>=0 && col<c);
    }
}


