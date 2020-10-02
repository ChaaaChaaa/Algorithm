package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Q1261_Deque {
    private static final int[] dy = {0, 0, -1, 1};
    private static final int[] dx = {-1, 1, 0, 0};
    private static int n, m;
    private static int[][] map;


    private void bfs(int x, int y, int[][] distance,boolean[][] visited) {
        ArrayDeque<Pair> deque = new ArrayDeque<>();
        deque.add(new Pair(x,y));
        visited[x][y] = true;
        distance[x][y] =0;

        while (!deque.isEmpty()){
            Pair pair = deque.remove();
            for(int i=0; i<4; i++){
                int nx = dx[i]+pair.x;
                int ny = dy[i]+pair.y;

                if(0<=nx && nx<n && 0<= ny && ny<m && !visited[nx][ny]){
                    if(map[nx][ny] == 0){
                        deque.addFirst(new Pair(nx,ny));
                        distance[nx][ny] = distance[pair.x][pair.y];
                    }
                    else if(map[nx][ny] == 1){
                        deque.addLast(new Pair(nx,ny));
                        distance[nx][ny] = distance[pair.x][pair.y]+1;
                    }
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        Q1261_Deque queue2 = new Q1261_Deque();

        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);

        map = new int[n][m];
        int[][] distance = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            String number = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = number.charAt(j)-'0';
            }
        }

        queue2.bfs(0,0,distance,visited);
        System.out.println(distance[n-1][m-1]);
    }
}
