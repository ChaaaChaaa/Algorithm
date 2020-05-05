package programmers;


import java.util.Stack;

public class PickUpDolls {
    private static final int POP2ELEMENTS = 2;
    private static final int NONE_ELEMENT = 0;
    private static final int RESET = 0;
    private static final int TO_LINE_UP = 1;

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}};

        int[] moves = new int[]{1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(solution(board, moves));
    }

    private static int solution(int[][] board, int[] moves) {

        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {

                if (board[i][move - TO_LINE_UP] == NONE_ELEMENT) {
                    continue;
                }

                if ((!stack.empty()) && (stack.peek() == board[i][move - 1])) {
                    stack.pop();
                    answer += POP2ELEMENTS;
                } else {
                    stack.push(board[i][move - TO_LINE_UP]);
                }

                board[i][move - TO_LINE_UP] = RESET;
                break;
            }
        }
        return answer;
    }

}
