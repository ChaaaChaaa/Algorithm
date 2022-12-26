package leetcode;

public class Q79 {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }


    public static boolean exist(char[][] board, String word) {
        int n = board[0].length;
        int m = board.length;

        boolean[][] visited = new boolean[m][n];

        if (m == 0) {
            return false;
        }


        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (dfs(board, 0, word, visited, y, x)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int currentDepth, String word, boolean[][] visited, int y, int x) {
        if(board[y][x] != word.charAt(currentDepth)){
            return false;
        }
//        if (currentDepth == w.length) return true;
//        if (board[y][x] != w[currentDepth]) return false;

        System.out.println(currentDepth);
        if (currentDepth == word.length()-1) {
            //이미 board 내에 word와 일치하는 글자 탐색에 성공한 것이므로 true를 반환한다.
            return true;
        }

       // board[y][x] ^= 256;
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if (ny >= board.length || ny < 0 || nx >= board[0].length || nx < 0|| visited[ny][nx] == true) {
                continue;
            }


            if (dfs(board, currentDepth+1,word,visited,ny,nx)) {
                return true;
            }
        }
        visited[y][x] = false;
       // board[y][x] ^= 256;
        return false;
    }
}
