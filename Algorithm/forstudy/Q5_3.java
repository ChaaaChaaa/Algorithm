package forstudy;

import java.util.Scanner;
import java.util.Stack;

public class Q5_3 {
    public int solution(int[][] board, int[] moves) {
       int ans = 0;
       Stack<Integer> stack = new Stack<>();
       for(int move : moves){
           for(int i=0; i<board.length; i++){
               if(board[i][move-1] != 0){
                   int temp =board[i][move-1];
                   board[i][move-1] = 0;
                   if(!stack.isEmpty() && stack.peek() == temp){
                       ans +=2;
                       stack.pop();
                   }else{
                       stack.push(temp);
                   }
                   break;
               }
           }
       }
        return ans;
    }

    public static void main(String[] args) {
        Q5_3 q53 = new Q5_3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = sc.nextInt();
        }
        System.out.println(q53.solution(board, moves));
    }
}
