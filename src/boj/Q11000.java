package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q11000 {
    private static ClassInfo[] classInfos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        classInfos = new ClassInfo[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startInput = Integer.parseInt(st.nextToken());
            int endInput = Integer.parseInt(st.nextToken());
            classInfos[i] = new ClassInfo(startInput, endInput);
        }

        Arrays.sort(classInfos);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(classInfos[0].end);

        for(int i=1; i<n; i++){
            if(priorityQueue.peek() <= classInfos[i].start){
                priorityQueue.poll();
            }
            priorityQueue.add(classInfos[i].end);
        }

        System.out.println(priorityQueue.size());
    }
}

class ClassInfo implements Comparable<ClassInfo> {
    int start;
    int end;

    ClassInfo(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(ClassInfo o) {
        if (this.start == o.start) {
            return Integer.compare(this.end, o.end);
        }
        return Integer.compare(this.start, o.start);
    }
}
