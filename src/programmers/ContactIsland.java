package programmers;

import java.util.PriorityQueue;

public class ContactIsland {
    private static PriorityQueue<IslandNode> pq = new PriorityQueue<>();
    private static int[] root;

    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};

//        int n =5;
//        int[][] costs = {{1,2,1},{1,3,1},{1,4,2},{2,5,3},{3,4,2},{4,5,3}}
//        //7 나와야함

//        int n = 3;
//        int [][] costs = {{1,2,2},{1,3,1},{2,3,1}};
//        //2
    }

    public static int solution(int n, int[][] costs) {
        int result = 0;

        root = new int[n + 1];

        for (int i = 0; i < n; i++) {
            root[i] = i;
        }

        for (int i = 0; i < n; i++) {
            int start = costs[i][0];
            int end = costs[i][1];
            int cost = costs[i][2];

            pq.add(new IslandNode(start, end, cost));
        }

        for (int i = 0; i < n; i++) {
            IslandNode current = pq.poll();

            int islandA = find(current.start);
            int islandB = find(current.end);

            if(islandA == islandB){
                continue;
            }

            union(islandA, islandB);
            result += current.cost;
        }

        System.out.println(result);

        return result;
    }

    private static int find(int island) {
        if (root[island] == island) {
            return island;
        }
        root[island] = find(root[island]);
        return root[island];
    }

    private static void union(int islandA, int islandB) {
        int rootA = find(islandA);
        int rootB = find(islandB);

        if (rootA != rootB) {
            root[rootA] = rootB;
        }
    }
}

class IslandNode implements Comparable<IslandNode> {
    int start;
    int end;
    int cost;

    IslandNode(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(IslandNode o) {
        return Integer.compare(cost, o.cost);
    }
}
