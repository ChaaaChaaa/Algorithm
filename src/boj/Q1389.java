package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1389 {
    static List<List<Integer>> map;
    static int INF = 5001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        map = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                list.add(INF);
            }
            map.add(list);
        }

        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            map.get(a).set(b,1);
            map.get(b).set(a,1);
        }

        fw(n);

        int result = INF;
        int index = -1;

        for (int i = 1; i <= n; i++) {
            int total = 0;
            for (int j = 1; j <= n; j++) {
                total += map.get(i).get(j);
            }

            if (result > total) {
                result = total;
                index = i;
            }
        }

        System.out.println(index);
    }


    private static void fw(int n) {
        for (int startV = 1; startV <= n; startV ++) {
            for (int tempV= 1; tempV <= n; tempV++) {
                if (tempV != startV) {
                    for (int endV = 1; endV <= n; endV++) {
                        int startToEnd = map.get(startV).get(endV);
                        int startToTemp = map.get(startV).get(tempV);
                        int tempToEnd = map.get(tempV).get(endV);
                        if (startToEnd > startToTemp + tempToEnd) {
                            map.get(startV).set(endV, startToTemp + tempToEnd);
                        }
                    }
                }
            }
        }
    }
}
