package boj;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Q1414 {
    static int n;
    static int [] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0;
        n= sc.nextInt();
        char [][] map = new char[n][n];

        for(int i=0; i<n; i++){
            map[i] = sc.next().toCharArray();
        }

        distance = new int[n+1];

        for(int i=1; i<=n; i++){
            distance[i] = i;
        }

        Queue<KruscalNode> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if('a' <= map[i][j] && map[i][j] <= 'z'){
                    total += map[i][j] - 96;
                    pq.offer(new KruscalNode(i+1,j+1,map[i][j]-96));
                }else if('A' <= map[i][j] && map[i][j] <='Z'){
                    total += map[i][j] - 38;
                    pq.add(new KruscalNode(i+1,j+1,map[i][j]-38));
                }
            }
        }

        int size = pq.size();
        int cycleNode = 1;
        int result = 0;

        for(int i=0; i<size; i++){
            KruscalNode kruscalNode = pq.poll();
            int nx = find(kruscalNode.start);
            int ny = find(kruscalNode.end);

            if(nx != ny){
                cycleNode++;
                result += kruscalNode.cost;
                union(kruscalNode.start,kruscalNode.end);
            }
        }

        if(cycleNode != n){ //가장 적은 비용으로 모든 노드를 통과하기 위해서는 모든 노드를 연결하는 최소 사이클의 개수가 입력된 노드의 개수와 같아야함
            System.out.println(-1);
        }else{
            System.out.println(total-result);
        }
    }

    static int find(int x){
        if(distance[x] == x){
            return x;
        }
        return distance[x] = find(distance[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x<y){
            distance[y] = x;
        }else {
            distance[x] = y;
        }
    }
}


