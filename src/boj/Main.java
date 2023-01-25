package boj;

import java.util.*;
import java.io.*;

class Main{

    private static boolean [][] visited;
    private static int [] dx ={1,-1,0,0};
    private static int [] dy = {0,0,1,-1};
    private static int n,m;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n =sc.nextInt();
        m = sc.nextInt();

        int [][] arr = new int[n][m];
        visited  = new boolean[n][m];

        for(int i=0; i<n; i++){
            String str = sc.nextLine();
            for(int j=0; j<str.length(); j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(arr);
        System.out.println(arr[n-1][m-1]);

    }

    private static void bfs(int [][] arr){
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(0,0));
        visited[0][0] = true;

        while(!q.isEmpty()){
            Position temp = q.poll();

            for(int i=0; i<4; i++){
                int nx = dx[i]+temp.x;
                int ny = dy[i]+temp.y;

                if(nx>=0 && n>nx && ny>=0 && m>ny&& !visited[nx][ny] && arr[nx][ny] == 1){
                    q.add(new Position(nx,ny));
                    visited[nx][ny]=true;
                    arr[nx][ny] = arr[temp.x][temp.y]+1;
                }
            }
        }
    }
}

class Position111{
    int x;
    int y;

    Position111(int x, int y){
        this.x=x;
        this.y=y;
    }
}