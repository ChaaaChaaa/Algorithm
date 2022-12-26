package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MatchCardPair {
    static Map<Integer, List<KakaoPosition>> targets = new HashMap<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer = Integer.MAX_VALUE;

    private static KakaoPosition pressCtrlAndArrow(int[][] board, int dir, KakaoPosition position) {
        KakaoPosition result = new KakaoPosition(position.x, position.y, position.moveCnt);
        while (true) {
            int nx = result.x + dx[dir];
            int ny = result.y + dy[dir];
            if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) {
                break;
            }
            result.x = nx;
            result.y = ny;
            if (board[nx][ny] != 0) {
                break;
            }
        }
        result.moveCnt += 1;
        return result;
    }

    private static int bfs(int[][] board, KakaoPosition start, KakaoPosition target) {
        Queue<KakaoPosition> queue = new LinkedList<>();
        queue.add(new KakaoPosition(start.x, start.y, 0));

        while (!queue.isEmpty()) {
            KakaoPosition current = queue.poll();
            if (current.x == target.x && current.y == target.y) {
                return current.moveCnt;
            }

            for (int i = 0; i < 4; i++) {
                KakaoPosition next = pressCtrlAndArrow(board, i, current);
                queue.add(next);
            }
        }
        return -1;
    }

    private static int[][] copyBoard(int[][] board) {
        int[][] copied = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                copied[i][j] = board[i][j];
            }
        }
        return copied;
    }

    private static int getShortDist(List<Integer> sequenceOfPermutations, int[][] board, KakaoPosition start) {
        int totalCnt = 0;
        int[][] copied = copyBoard(board);
        KakaoPosition currentPosition = new KakaoPosition(start.x, start.y, 0);

        for (int current : sequenceOfPermutations) {
            int minCnt = Integer.MAX_VALUE;
            KakaoPosition deleteF = new KakaoPosition(0, 0, 0);
            KakaoPosition deleteS = new KakaoPosition(0, 0, 0);

            for (int i = 0; i <= 1; i++) { //양쪽순서 모두 확인하기 위해서
                int cnt = 0;
                List<KakaoPosition> targetList = targets.get(current);
                KakaoPosition firstPosition = targetList.get(i);
                KakaoPosition secondPosition = targetList.get((i + 1) % 2);
                cnt += bfs(copied, currentPosition, new KakaoPosition(firstPosition.x, firstPosition.y, 0));
                cnt += bfs(copied, firstPosition, new KakaoPosition(secondPosition.x, secondPosition.y, 0));

                if (cnt < minCnt) {
                    minCnt = cnt;
                    deleteF = firstPosition;
                    deleteS = secondPosition;
                }
            }
            minCnt += 2;
            copied[deleteF.x][deleteF.y] = 0;
            copied[deleteS.x][deleteS.y] = 0;
            currentPosition = new KakaoPosition(deleteS.x, deleteS.y, 0);
            totalCnt += minCnt;
        }
        return totalCnt;
    }

    private static void selectTargets(List<Integer> sequenceOfPermutations, int[][] board, int x, int y) {
        if (sequenceOfPermutations.size() == targets.size()) {
            answer = Math.min(answer, getShortDist(sequenceOfPermutations, board, new KakaoPosition(x, y, 0)));
            return;
        }

        for (Integer cardNum : targets.keySet()) { //순열로 카드번호 저장(백트래킹)
            if (sequenceOfPermutations.contains(cardNum)) {
                continue;
            }
            sequenceOfPermutations.add(cardNum);
            selectTargets(sequenceOfPermutations, board, x, y);
            sequenceOfPermutations.remove(cardNum);
        }
    }

    private static void registerTargets(int[][] board) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != 0) {
                    if (targets.containsKey(board[i][j])) {
                        targets.get(board[i][j]).add(new KakaoPosition(i, j, 0));
                    } else {
                        List<KakaoPosition> insertList = new ArrayList<>();
                        insertList.add(new KakaoPosition(i, j, 0));
                        targets.put(board[i][j], insertList);
                    }
                }
            }
        }
    }

    public static int solution(int[][] board, int x, int y) {
        registerTargets(board);
        selectTargets(new ArrayList<>(), board, x, y);
        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{1, 0, 0, 3}, {2, 0, 0, 0}, {0, 0, 0, 2}, {3, 0, 1, 0}};
        int r = 1;
        int c = 0;
        System.out.println(solution(board, r, c));
    }
}

class KakaoPosition {
    int x, y;
    int moveCnt;

    KakaoPosition(int x, int y, int moveCnt) {
        this.x = x;
        this.y = y;
        this.moveCnt = moveCnt;
    }
}
