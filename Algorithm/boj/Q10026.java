package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10026 {
    private static int n;
    private static char[][] map;
    private static boolean[][] visited;
    private static int normalPerson;
    private static int abnormalPerson;

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = line.charAt(j);
            }
        }

       for(int i=0; i<n; i++){
           for(int j=0; j<n; j++){
               if(!visited[i][j]){
                   bfs(i,j,map[i][j],map,visited);
                   normalPerson++;
               }
           }
       }

       for(int i=0; i<n; i++){
           for(int j=0; j<n; j++){
               if(map[i][j] == 'G'){
                   map[i][j] = 'R';
               }
           }
       }

       visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    bfs(i,j,map[i][j],map,visited);
                    abnormalPerson++;
                }
            }
        }

        System.out.println(normalPerson + " " + abnormalPerson);
    }

    private static void bfs(int r, int c, char color, char[][] map, boolean[][] visited) {
       visited[r][c] = true;
       for(int i=0; i<4; i++){
           int nr = r+dr[i];
           int nc = c+dc[i];

           if(nr>=0 && nc>= 0 && nr<n && nc<n){
               if(map[nr][nc] == color && !visited[nr][nc]){
                   bfs(nr,nc,color,map,visited);
               }
           }
       }
    }
}
