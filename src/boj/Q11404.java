package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q11404 {
    private static List<List<FloydwarshallBus>> busMap;
    private static final int INF = 100 * 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cityNum = Integer.parseInt(br.readLine());
        int busNum = Integer.parseInt(br.readLine());
        busMap = new ArrayList<>();

        for(int i = 0 ; i <= cityNum; i++){
            List<FloydwarshallBus> list = new ArrayList<>();
            for(int j = 0 ; j <= cityNum; j++){
                list.add(new FloydwarshallBus(INF));
            }
            busMap.add(list);
        }

        for(int i = 1; i <= cityNum; i++)
            busMap.get(i).add(new FloydwarshallBus(0));

        for (int i = 0; i < busNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            int lowestWeight = Math.min(weight, busMap.get(start).get(end).weight);
            busMap.get(start).set(end, new FloydwarshallBus(lowestWeight));
            //busMap.get(start).set(end, weight);
        }

        floydWarshall(cityNum);

        StringBuilder sb = new StringBuilder();
        for (int start = 1; start <= cityNum; start++) {
            for (int end = 1; end <= cityNum; end++) {
                if (busMap.get(start).get(end).weight == INF) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(busMap.get(start).get(end).weight).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void floydWarshall(int cityNum) {
        // 경유 노드
        for (int transferVertex = 1; transferVertex <= cityNum; transferVertex++) {
            // 시작 노드
            for (int startVertex = 1; startVertex <= cityNum; startVertex++) {
                // 시작 노드 != 경유 노드
                if (transferVertex != startVertex) {
                    // 도착 노드
                    for (int arrvieVertex = 1; arrvieVertex <= cityNum; arrvieVertex++) {
                        // 시작노드 != 도착노드 && 도착노드 != 경유노드
                        if (startVertex != arrvieVertex && transferVertex != arrvieVertex) {
                            // 기존의 값 보다 경유한 값이 작은 경우
                            int startToArriveWeight = busMap.get(startVertex).get(arrvieVertex).weight;
                            int startToTransferWeight = busMap.get(startVertex).get(transferVertex).weight;
                            int transferToArriveWeight = busMap.get(transferVertex).get(arrvieVertex).weight;
                            if (startToArriveWeight > startToTransferWeight + transferToArriveWeight) {
                                busMap.get(startVertex).set(arrvieVertex, new FloydwarshallBus(startToTransferWeight + transferToArriveWeight));
                            }
                        }
                    }
                }
            }
        }
    }
}

class FloydwarshallBus {
    int weight;

    public FloydwarshallBus(int weight) {
        this.weight = weight;
    }
}
