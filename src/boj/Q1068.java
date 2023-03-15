package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Q1068 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int deleteNode = sc.nextInt();

        List<Integer> nodes = new ArrayList<>();
        List<List<Integer>> children = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        int rootNode = 0, result = 0;

        for (int i = 0; i < n; i++) {
            nodes.add(sc.nextInt());
        }

        for (int i = 0; i < n; i++) {
            children.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int now = nodes.get(i);
            if (now == -1) {
                rootNode = i;
            } else if (i != deleteNode) {
                children.get(now).add(i); //현재 노드 n의 부모 노드 nodes.get(n)가 가리키는 자식 리스트에 n을 추가하는 작업을 수행
            }
        }

        if (deleteNode != rootNode) {
            queue.add(rootNode);
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (children.get(now).size() == 0) {
                result++;
            } else {
                for (int next : children.get(now)) {
                    queue.add(next);
                }
            }
        }

        System.out.println(result);
    }
}


