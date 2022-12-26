package forstudy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point3{
    int x;
    int y;

    public Point3(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Q8_14 {
    static int ans = 0,n;
    static int [] dx = {-1,-1,-1,1,1,1,0,0};
    static int [] dy = {0,1,-1,0,1,-1,-1,1};
    Queue<Point3> queue = new LinkedList<>();
    public void BFS(int x, int y, int[][] board){
        queue.add(new Point3(x,y));
        while (!queue.isEmpty()){
            Point3 point3 = queue.poll();
            for(int i=0; i<8; i++){
                int nx = point3.x+dx[i];
                int ny = point3.y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny] == 1){
                    board[nx][ny] = 0;
                    queue.add(new Point3(nx,ny));
                }
            }
        }
    }

    public void solution(int[][]board){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 1){
                    ans++;
                    board[i][j] = 0; //바다로 만든다.
                    BFS(i,j,board);
                }
            }
        }
    }

    public static void main(String[] args){
        Q8_13 q8_13 = new Q8_13();
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        q8_13.solution(arr);
        System.out.println(ans);
    }
}
