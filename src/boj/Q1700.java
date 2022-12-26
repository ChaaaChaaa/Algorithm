package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int concentricNum = Integer.parseInt(st.nextToken());
        int electricNum = Integer.parseInt(st.nextToken());

        int[] concentricArr = new int[concentricNum];
        int[] electricArr = new int[electricNum];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < electricNum; i++) {
            electricArr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        HashSet<Integer> hashSet = new HashSet<>();

        for (int tryInput = 0; tryInput < electricNum; tryInput++) {
            if (hashSet.contains(electricArr[tryInput])) {
                continue;
            }
            if (hashSet.size() == concentricNum) {
                int index = -1, latestValue = 0;
                for (int temp : hashSet) {
                    int latestIndex = 101;

                    for (int k = tryInput; k < electricNum; k++) {
                        if (temp == electricArr[k]) {
                            latestIndex = k;
                            break;
                        }
                    }

                    if (latestIndex == 101) {
                        latestValue = temp;
                        break;
                    } else {
                        if (latestIndex > index) {
                            index = latestIndex;
                            latestValue = electricArr[latestIndex];
                        }
                    }
                }
                hashSet.remove(latestValue);
                result++;
            }
            hashSet.add(electricArr[tryInput]);
        }
        System.out.println(result);
    }
}
