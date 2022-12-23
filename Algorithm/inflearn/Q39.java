package inflearn;

import java.util.Scanner;
import java.util.Stack;

public class Q39 {
    public int q39(int[][] board, int[] moves){
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for(int pos:moves){
            for(int i=0; i<board.length; i++){
                if(board[i][pos-1] != 0) //인형발견
                {
                    int dollNumber = board[i][pos-1];
                    board[i][pos-1] = 0; //인형가져왔으니 0으로 만든다.
                    if(!stack.isEmpty() && dollNumber == stack.peek()){
                        ans+=2;
                        stack.pop();
                    }
                    else{
                        stack.push(dollNumber);
                    }
                    break; //한번 처리후 나가도록
                }
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Q39 q39 = new Q39();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] moves = new int[m];
        for(int i=0; i<m; i++){
            moves[i] = sc.nextInt();
        }
        System.out.println(q39.q39(board,moves));
    }
}
