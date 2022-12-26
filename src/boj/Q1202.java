package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numOfJewelry = Integer.parseInt(st.nextToken());
        int numOfBag = Integer.parseInt(st.nextToken());

        JewelryInfo[] jewelryInfos = new JewelryInfo[numOfJewelry];
        //BagInfo[] bagInfos = new BagInfo[numOfBag];
        int [] bags = new int[numOfBag];

        for (int i = 0; i < numOfJewelry; i++) {
            st = new StringTokenizer(br.readLine());
            int inputWeight = Integer.parseInt(st.nextToken());
            int inputPrice = Integer.parseInt(st.nextToken());
            jewelryInfos[i] = new JewelryInfo(inputWeight, inputPrice);
        }

        for (int i = 0; i < numOfBag; i++) {
            //int inputWeight = Integer.parseInt(br.readLine());
            bags[i] =Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewelryInfos);
        Arrays.sort(bags);

        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        long ans = 0;

        for (int i = 0, j = 0; i < numOfBag; ++i) {
            // 현재 가방의 무게보다 작거나 같은 보석을 모두 우선순위 큐에 넣음.
            while (j < numOfJewelry && (jewelryInfos[j].jewelryWeight <= bags[i])) {
                queue.offer(jewelryInfos[j++].jewelryPrice);
            }

            if (!queue.isEmpty()) {
                ans += queue.poll();
            }
        }

        System.out.println(ans);
    }
}

class JewelryInfo implements Comparable<JewelryInfo> {
    int jewelryWeight;
    int jewelryPrice;

    JewelryInfo(int jewelryWeight, int jewelryPrice) {
        this.jewelryWeight = jewelryWeight;
        this.jewelryPrice = jewelryPrice;
    }

    @Override
    public int compareTo(JewelryInfo o) {
        return Integer.compare(o.jewelryWeight, jewelryWeight);
    }
}
//
//class BagInfo implements Comparable<BagInfo> {
//    int bagWeight;
//
//    BagInfo(int bagWeight) {
//        this.bagWeight = bagWeight;
//    }
//
//    @Override
//    public int compareTo(BagInfo o) {
//        return Integer.compare(bagWeight, o.bagWeight);
//    }
//}
