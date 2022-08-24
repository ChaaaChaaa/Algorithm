package inflearn;

import java.util.Scanner;

public class Q59 {
    //중복순열, 채점지원x
    /*
    1부터 n까지 번호가 적힌 구슬이 있습니다. 이 중 중복을 허락하여 m번을 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
    자연수 n과 m이 주어짐
     */
    static int[] pm;
    static int n, m;

    public void DFS(int level) {
        if (level == m) {
            for (int x : pm) {
                System.out.print(x + " ");
                System.out.println();
            }
        } else {
            for (int i = 1; i <= n; i++) { //두가닥이 아니라 n가닥을 나감 for문이 도는것
                pm[level] = i;
                DFS(level + 1);

            }
        }
    }

    public static void main(String[] args){
        Q59 q59 = new Q59();
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        pm = new int[m];
        q59.DFS(0);
    }
}
