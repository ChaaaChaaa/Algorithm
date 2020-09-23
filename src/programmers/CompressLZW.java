package programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class CompressLZW {
    public int[] solution(String s) {
        int[] answer;
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<String, Integer> map =initSectorNumber();

        for (int i = 0; i < s.length(); i++) {
            int j;
            boolean flag = false;
            System.out.println(" 1 s.length() - i + 1 : "+(s.length() - i +1)+" s.length() : "+s.length()+" i :"+i);
            for (j = 1; j < s.length() - i + 1; j++) {
                String cmp = s.substring(i, i + j);
                System.out.println("2 i : "+i+" j : "+j+" s.substring(i, i + j) : "+s.substring(i, i + j));
                String cur = s.substring(i, i + j - 1);
                System.out.println("3 i : "+i+" j : "+j+" s.substring(i, i + j - 1) : "+s.substring(i, i + j - 1));
                if (!map.containsKey(cmp)) {
                    list.add(map.get(cur));
                    map.put(cmp, map.size() + 1);
                    flag = true;
                    break;
                }
            }
            if (!flag) list.add(map.get(s.substring(i)));
            i += j - 2;
        }
        answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }


    private HashMap initSectorNumber() {
        HashMap<String, Integer> dictionary = new HashMap<>();
        for (int i = 1; i < 27; i++) {
            dictionary.put(String.valueOf((char) (i + 64)), i);
        }

        return dictionary;
    }


    public static void main(String[] args) {
        CompressLZW compressLZW = new CompressLZW();
        String msg = "KAKAO";

        for (int element : compressLZW.solution(msg)) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}





