package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q16197_Recursion {
    private static int dx[] = {-1, 1, 0, 0};
    private static int dy[] = {0, 0, -1, 1};
    private static int n;
    private static int m;
    private static char map[][];
    private static int result = 11;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        map = new char[n + 2][m + 2];
        ArrayList<Coin> coins = new ArrayList<>();

        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < m + 2; j++) {
                map[i][j] = 'X';
            }
        }

        for (int i = 1; i < n + 1; i++) {
            String s[] = br.readLine().split("");
            for (int j = 1; j < m + 1; j++) {
                if (s[j - 1].charAt(0) == 'o') {
                    map[i][j] = '.';
                    coins.add(new Coin(i, j));
                } else {
                    map[i][j] = s[j - 1].charAt(0);
                }
            }
        }

        backTracking(0, coins);

        if (result == 11) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static boolean exitTwoCoins(int count, ArrayList<Coin> coins) {
        boolean one = false;
        boolean two = false;

        if (coins.get(0).x < 0 || coins.get(0).y < 0) {
            one = true;
        }

        if (coins.get(1).x < 0 || coins.get(1).y < 0) {
            two = true;
        }

        if (one && two) { //두 동전 모두 떨어짐
            return true;
        } else if (!one && !two) {
            return false;
        } else {
            result = Math.min(result, count);
            return true;
        }
    }

    static void backTracking(int count, ArrayList<Coin> coins) {
        if (count > 10) {
            return;
        }

        if (exitTwoCoins(count, coins)) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            ArrayList<Coin> temp = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                int nx = coins.get(j).x + dx[i];
                int ny = coins.get(j).y + dy[i];

                if (coins.get(j).x < 0) {
                    temp.add(new Coin(-1, -1));
                    break;
                }

                if (map[nx][ny] == '.' || map[nx][ny] == 'o') {
                    temp.add(new Coin(nx, ny));
                } else if (map[nx][ny] == 'X') { // 밖으로 나간 경우 -> -1값
                    temp.add(new Coin(-1, -1));
                } else {  //움직일 수 없을때 -> 현상태 유지
                    temp.add(new Coin(coins.get(j).x, coins.get(j).y));
                }
            }
            backTracking(count + 1, temp);
        }
    }
}

class Coin {
    int x;
    int y;

    public Coin(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
