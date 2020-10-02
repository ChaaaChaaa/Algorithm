package programmers;

import java.util.LinkedList;
import java.util.Queue;

class Position{
    int x;
    int y;
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class ColoringBook2 {
    private static final int[] dx = { 0, 0, -1, 1 };
    private static final int[] dy = { -1, 1, 0, 0 };

    public int [] solution(int m, int n, int[][] picture){
        int [] answer = new int[2];
        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j] || picture[i][j] == 0){
                    continue;
                }
                answer[1] = Math.max(answer[1],bfs(picture,visited,new Position(i,j)));
                answer[0]++;
            }
        }
        return answer;
    }

    private int bfs( int[][] picture, boolean [][] visited, Position start){
        Queue<Position> queue = new LinkedList<>();
        int area = 1;
        visited[start.x][start.y] = true;
        queue.add(start);

        while (!queue.isEmpty()){

            Position position = queue.remove();

            for(int i=0; i<4; i++){

                int nx = dx[i]+position.x;
                int ny = dy[i]+position.y;

                if(0<= nx && nx<picture.length && 0<= ny&& ny<picture[0].length){
                    if(!visited[nx][ny] && picture[nx][ny] == picture[position.x][position.y]){
                        visited[nx][ny] = true;
                        queue.add(new Position(nx,ny));
                        area++;
                    }
                }
                System.out.println(queue);
            }
        }
        return area;
    }

    public static void main(String[] args){
        ColoringBook2 coloringBook = new ColoringBook2();
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int result [] = coloringBook.solution(m,n,picture);

        for(int element : result){
            System.out.print(element+",");
        }
        System.out.println();

    }
}
