package programmers;

import java.util.Arrays;
import java.util.LinkedList;

public class WallInspection {
    static int Nsize;
    static int[] weakPoint;
    static LinkedList<Integer> weekExpand;
    static boolean[] checked;
    static int result = Integer.MAX_VALUE;

    public static int solution(int n, int[] week, int[] dist) {
        int answer = 0;
        Nsize = 0;
        weakPoint = week.clone();
        Arrays.sort(dist);
        checked = new boolean[dist.length];

        weekExpand = new LinkedList<>();
        for (int i = 0; i < weakPoint.length; i++) {
            weekExpand.add(weakPoint[i]);
        }

        for (int i = 0; i < weakPoint.length; i++) {
            weekExpand.add(weakPoint[i] + Nsize);
        }

        int count = 0;
        LinkedList<Integer> linkedList = new LinkedList<>();
        makePermutation(0, count, linkedList, dist);
        if (result == Integer.MAX_VALUE) {
            answer -= 1;
        } else {
            answer = result;
        }
        return answer;
    }

    private static void makePermutation(int index, int count, LinkedList<Integer> linkedList, int[] dist) {
        if (count == dist.length) {
            deterPossible(linkedList);
            return;
        }
        for (int i = 0; i < dist.length; i++) {
            if (!checked[i]) {
                checked[i] = true;
                linkedList.add(dist[i]);
                makePermutation(i, count + 1, linkedList, dist);
                linkedList.removeLast();
                checked[i] = false;
            }
        }
    }

    private static void deterPossible(LinkedList<Integer> friendLists) {
        for (int i = 0; i < weakPoint.length; i++) {
            int index = 0;
            int startPoint = weekExpand.get(i);
            boolean mark = false;

            for (int j = i; j < i + weakPoint.length; j++) {
                if (weekExpand.get(j) - startPoint > friendLists.get(index)) {
                    startPoint = weekExpand.get(j);
                    index++;

                    if (index == friendLists.size()) {
                        mark = true;
                        break;
                    }
                }
            }
            if (!mark) {
                result = Math.min(result, index + 1);
            }
            return;
        }
    }

    public static void main(String[] args) {
        int n = 12;
        int[] weak = {1, 5, 6, 10};
        int[] dist = {1, 2, 3, 4};

        int answer = solution(n, weak, dist);
        System.out.println(answer);
    }
}
