package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructRaceWay {
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    private static int minValue = Integer.MAX_VALUE;
    private static int [][] map;
    private static int n;

    public static void main(String[] args) {
        int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
        System.out.println(solution(board));
    }

    public static int solution(int [][] board){
        n = board.length;
        map = board;

        bfs(0,0,0,-1);
        return minValue;
    }

    private static void bfs(int x, int y, int sum, int vector){
        Queue<RoadPosition> queue = new LinkedList<>();
        queue.add(new RoadPosition(x,y,sum,vector));
        map[0][0] = 1;

        while (!queue.isEmpty()){
            RoadPosition roadPosition = queue.poll();
            if(roadPosition.x == n-1 && roadPosition.y == n-1){// 도착점에 도달한 경우
                if(minValue > roadPosition.sum){
                    minValue = roadPosition.sum;
                }
                continue;
            }

            for(int i=0; i<4; i++){
                int nx = roadPosition.x+dx[i];
                int ny = roadPosition.y+dy[i];

                if(nx >= 0 && nx<n && ny >=0 && ny<n && map[nx][ny] != 1){
                    int nextFieldSum = 0;

                    if(roadPosition.vector == -1 || roadPosition.vector == i){
                        nextFieldSum = roadPosition.sum+100;
                        // 처음 시작이거나 방향 같은 경우 -> 직선
                    }
                    else{
                        nextFieldSum = roadPosition.sum+600; // 직선 + 코너
                    }

                    if(map[nx][ny] == 0){
                        map[nx][ny] = nextFieldSum;
                        queue.add(new RoadPosition(nx,ny,nextFieldSum,i));
                    }
                    else if(map[nx][ny] >= nextFieldSum){
                        // 이미 방문한 경우, 비용이 더 작은 값으로 갱신
                        map[nx][ny] = nextFieldSum;
                        queue.add(new RoadPosition(nx,ny,nextFieldSum,i));
                    }
                }
            }
        }
    }
}

class RoadPosition{
    int x,y;
    int sum; int vector;
    public RoadPosition(int x, int y, int sum, int vector){
        this.x = x;
        this.y = y;
        this.sum =sum;
        this.vector =vector;
    }
}
