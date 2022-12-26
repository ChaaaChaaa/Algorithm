package forstudy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point1{
    public int x,y;
    Point1(int x,int y){
        this.x = x;
        this.y = y;
    }
}
public class Q8_11 {
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int[][] board,distance;
    public void BFS(int x, int y){
        Queue<Point1> queue = new LinkedList<>();
        queue.offer(new Point1(x,y));
        board[x][y] = 1;
        while (!queue.isEmpty()){
            Point1 temp = queue.poll();
            for(int i=0; i<4; i++){
                int nx = dx[i]+temp.x;
                int ny = dy[i]+temp.y;
                if(nx>=1 && nx<=7 && ny>=1 && ny<=7 && board[nx][ny] == 0){
                    board[nx][ny] = 1;
                    queue.offer(new Point1(nx,ny));
                    distance[nx][ny] =distance[temp.x][temp.y]+1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Q8_11 q8_11 = new Q8_11();
        Scanner sc = new Scanner(System.in);
        distance = new int[8][8];
        for(int i=1; i<=7; i++){
            for(int j=1; j<=7; j++){
                board[i][j] = sc.nextInt();
            }
        }
        q8_11.BFS(1,1);
        if(distance[7][7] == 0){
            System.out.println(-1);
        }else{
            System.out.println(distance[7][7]);
        }
    }
}
