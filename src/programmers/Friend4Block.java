package programmers;

import java.util.*;

class PointFriend4Block{
    int x, y;
    public PointFriend4Block(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
       if(!(o instanceof Point)){
           return false;
       }
       Point point = (Point)o;
       return this.x == point.x && this.y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
public class Friend4Block {

    private static final  int[] dx = {1,1,0};
    private static final  int[] dy = {0,1,1};

   private void Find4Block(Set<PointFriend4Block> rmlist, char[][] charBoard, PointFriend4Block start){
       int nx, ny;
       List<PointFriend4Block> list = new ArrayList<>();
       list.add(new PointFriend4Block(start.x,start.y));

       for(int i=0; i<3; i++){
           nx = dx[i] + start.x;
           ny = dy[i] + start.y;

           if(0<= nx && nx< charBoard.length && 0 <= ny && ny< charBoard[0].length){
               if(charBoard[start.x][start.y] == charBoard[nx][ny]){
                   list.add(new PointFriend4Block(nx,ny));
               }
               else {
                   break;
               }
           }
           if(list.size() == 4){
               for(PointFriend4Block point : list){
                   if(!rmlist.contains(point)){
                       rmlist.add(point);
                   }
               }
           }
       }
    }

    private void break4Block(Set<PointFriend4Block> rmlist, char[][] charBoard){
        Iterator<PointFriend4Block> iterator = rmlist.iterator();
        while (iterator.hasNext()){
            PointFriend4Block currentPoint = iterator.next();
            charBoard[currentPoint.x][currentPoint.y] = '.';
        }
        rmlist.clear();
    }

    private void downBlock(char[][] charBoard){
       Queue<Character> queue = new LinkedList<>();
       for(int y=0; y<charBoard[0].length; y++){
           for(int x=0; x<charBoard.length; x++){
               if(charBoard[x][y] != '.'){
                   queue.offer(charBoard[x][y]);
               }
           }
           int index = 0;

           while (!queue.isEmpty()){
               charBoard[index++][y] = queue.poll();
           }

           for(int i= index; i<charBoard.length; i++){
               charBoard[i][y] = '.';
           }
       }
    }

    public int solution(int m, int n, String[] board){
       int answer =0;
       Set<PointFriend4Block> rmlist = new HashSet<>();
       char[][] charBoard = new char[m][n];
       boolean canBreak = true;

       for(int i=0; i<m; i++){
           charBoard[i] = board[m-i-1].toCharArray();
       }
       while (canBreak){
           canBreak = false;
           for(int x =0; x<m; x++){
               for(int y=0; y<n; y++){
                   if(charBoard[x][y] == '.'){
                       continue;
                   }
                   Find4Block(rmlist,charBoard,new PointFriend4Block(x,y));
               }
           }

           if(!rmlist.isEmpty()){
               canBreak = true;
               answer += rmlist.size();
               break4Block(rmlist,charBoard);
               downBlock(charBoard);
           }
       }
       return answer;
    }

    public static void main(String[] args){
       Friend4Block friend4Block = new Friend4Block();
//       int m = 4;
//       int n = 5;
//       String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};

        int m = 6;
        int n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
       int result = friend4Block.solution(m,n,board);
        System.out.println(result);
    }
}
