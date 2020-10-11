package programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class CompressLZW_2 {
    public int[] solution(String str) {
        HashMap<String, Integer> hashMap = initSectorNumber();
        ArrayList<Integer> arrayList = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        int lastSize = 27;

        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(str.charAt(i));
            if (!hashMap.containsKey(stringBuilder.toString())) {
                String key = stringBuilder.toString();
                hashMap.put(key, lastSize++);
                stringBuilder.setLength(stringBuilder.length() - 1);
                System.out.println(stringBuilder.toString());
                arrayList.add(hashMap.get(stringBuilder.toString()));
                stringBuilder.setLength(0);
                i--;
            }
        }

        if (stringBuilder.length() > 0) {
            String key = stringBuilder.toString();
            arrayList.add(hashMap.get(key));
        }
        int[] answer = convertArrayListToIntArray(arrayList);
        return answer;
    }

    private HashMap initSectorNumber() {
        HashMap<String, Integer> dictionary = new HashMap<>();
        for (int i = 1; i < 27; i++) {
            dictionary.put(String.valueOf((char) (i + 64)), i);
        }
        return dictionary;
    }

    private int[] convertArrayListToIntArray(ArrayList<Integer> arrayList) {
        int[] answer = new int[arrayList.size()];
        int index = 0;
        for (int element : arrayList) {
            answer[index] = element;
            index++;
        }
        return answer;
    }

    public static void main(String[] args) {
        CompressLZW_2 compressLZW = new CompressLZW_2();
        String msg = "KAKAO";

        for (int element : compressLZW.solution(msg)) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
