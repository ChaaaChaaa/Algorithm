package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q16948 {
    private static final int[] dx = {-2,-2,0,0,2,2};
    private static final int[] dy = {-1,1,-2,2,-1,1};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sx = sc.nextInt();
        int sy = sc.nextInt();
        int ex = sc.nextInt();
        int ey = sc.nextInt();

        int[][] distance = new int[n][n];

        for(int i=0; i<n; i++){
            Arrays.fill(distance[i],-1);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(sx);
        queue.add(sy);
        distance[sx][sy] = 0;

        while (!queue.isEmpty()){
            int x = queue.remove();
            int y = queue.remove();

            for(int k=0; k<6; k++){
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if(distance[nx][ny] == -1){
                        queue.add(nx);
                        queue.add(ny);
                        distance[nx][ny] = distance[x][y]+1;
                    }
                }
            }
        }
        System.out.println(distance[ex][ey]);
    }
}
