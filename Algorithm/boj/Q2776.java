package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q2776 {
    private static final int INCLUDE = 1;
    private static final int NOT_INCLUDE = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int count = 0;
        while (testCase > count) {
            HashMap<Integer, Boolean> firstNote = new HashMap<>();


            int firstInput = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < firstInput; i++) {
                Integer key = Integer.parseInt(st.nextToken());
                firstNote.put(key, true);
            }


            int secondInput = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < secondInput; i++) {

                int secondNoteNumber = Integer.parseInt(st.nextToken());
                if (firstNote.containsKey(secondNoteNumber)) {
                    System.out.println(INCLUDE);
                } else {
                    System.out.println(NOT_INCLUDE);
                }
            }
            count++;
        }
    }
}
