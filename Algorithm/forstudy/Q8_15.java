package forstudy;

import java.util.ArrayList;
import java.util.Scanner;

class Point4 {
    int x;
    int y;

    public Point4(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Q8_15 {
    static int n, m, length, ans = Integer.MAX_VALUE;
    static int[] combination;
    static ArrayList<Point4> pizza, house;

    public void DFS(int level, int start) {
        if (level == m) {
            int sum = 0;
            for (Point4 point : house) {
                int distance = Integer.MAX_VALUE;
                for (int i : combination) { //살아남은 피자집의 조합 번호
                    distance = Math.min(distance, Math.abs(point.x - pizza.get(i).x) + Math.abs(point.y - pizza.get(i).y));
                }
                sum += distance;
            }
            ans = Math.min(ans, sum);
        }else{
            for(int i=start; i<length; i++){
                combination[level] = i;
                DFS(level+1,i+1);
            }
        }
    }

    public static void main(String[] args) {
        Q8_15 q8_15 = new Q8_15();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pizza = new ArrayList<>();
        house = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int temp = sc.nextInt();
                if (temp == 1) {
                    house.add(new Point4(i, j));
                } else if (temp == 2) {
                    pizza.add(new Point4(i, j));
                }
            }
            length = pizza.size();
            combination = new int[m];
            q8_15.DFS(0, 0);
            System.out.println(ans);
        }
    }
}
