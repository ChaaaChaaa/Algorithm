package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q14395 {
    private static final char[] OP = {'*', '+', '-', '/'};
    private static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        if(s == t){
            System.out.println(0);
            return;
        }

        System.out.println(bfs(s, t));
    }

    private static String bfs(long s, long target) {
        HashSet<Long> set = new HashSet<>();
        Queue<OperationInfo> queue = new LinkedList<>();
        queue.offer(new OperationInfo(s, new StringBuilder()));

        while (!queue.isEmpty()) {
            OperationInfo current = queue.poll();
            if (current.num == target) {
                return current.operationRecord.toString();
            }

            long pow = current.num * current.num;
            if (pow < MAX) {
                if (!set.contains(pow)) {
                    queue.offer(new OperationInfo(pow, new StringBuilder(current.operationRecord).append(OP[0])));
                    set.add(pow);
                }
            }

            long sum = current.num + current.num;
            if (sum < MAX) {
                if (!set.contains(sum)) {
                    queue.offer(new OperationInfo(sum, new StringBuilder(current.operationRecord).append(OP[1])));
                    set.add(sum);
                }
            }

            long sub = current.num - current.num;
            if (sub > 0) {
                if (!set.contains(sub)) {
                    queue.offer(new OperationInfo(sub, new StringBuilder(current.operationRecord).append(OP[2])));
                    set.add(sub);
                }
            }

            long div = current.num / current.num;
            if (div > 0) {
                if (!set.contains(div)) {
                    queue.offer(new OperationInfo(div, new StringBuilder(current.operationRecord).append(OP[3])));
                    set.add(div);
                }
            }
        }

        return "-1";
    }
}

class OperationInfo {
    long num;
    StringBuilder operationRecord;

    public OperationInfo(long num, StringBuilder operationRecord) {
        this.num = num;
        this.operationRecord = operationRecord;
    }
}
