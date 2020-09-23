package programmers;

import java.util.*;

public class Q222 {
    public String[] solution(String[] orders, int[] course) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < orders.length; i++) {
            orders[i] = sort(orders[i]);
        }


        ArrayList<String> arrayList = new ArrayList<>();


        for (int i = 0; i < course.length; i++) {
            int num = course[i];

            for (String s : orders) {
                String[] test = convertArray(s);
                String[] answer = combinations(test, num, 0, new String[num], hashMap);
            }
        }

        HashMap<String, Integer> hashMap2 = new HashMap<>();

        for(int i=0; i<course.length; i++){
            Object maxEntry = Collections.max(hashMap.entrySet(), Map.Entry.comparingByValue()).getKey();

            for(String s : hashMap.keySet()){
                Integer value = hashMap.get(s);
                if(s.length() == course[i]){
                    if(value == hashMap.get(maxEntry)){
                        arrayList.add(s);
                    }
                }

            }
        }

//        for (String s : hashMap.keySet()) {
//            Integer value = hashMap.get(s);
//            for(int num : course){
//                if (s.length() == num) {
//                    hashMap2.put(s,value);
//                }
//
//            }
//
//        }
//
//        for(String s : hashMap2.keySet()){
//            arrayList.add(s);
//        }


        String[] answer = new String[arrayList.size()];
        int index = 0;

        for (String s : arrayList) {
            answer[index] = s;
            index++;
        }

        Arrays.sort(answer);
        return answer;

    }


    private HashMap<String, Integer> countHashMap(HashMap<String, Integer> hashMap) {
       // HashMap<String, Integer> compareHashMap = new HashMap<>();

       // compareHashMap.put("MaxKey", 0);
       // compareHashMap.put("MaxValue", 1);
        int maxValue = 1;

        for (String key : hashMap.keySet()) {
            Integer value = hashMap.get(key);

            if (value > maxValue) {
                maxValue = value;
            }
        }

        System.out.println(maxValue);

        for(String key : hashMap.keySet()){
            Integer value = hashMap.get(key);
            if(value.equals(maxValue)){
                hashMap.put(key,maxValue);
            }
        }


        return hashMap;
    }





    private String sort(String order) {
        char[] c = order.toCharArray();
        Arrays.sort(c);
        String test = new String(c);
        return test;
    }

    private String[] convertArray(String s) {
        String[] arr = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.substring(i, i + 1);
        }
        return arr;
    }

    String[] combinations(String[] arr, int len, int startPosition, String[] result, HashMap<String, Integer> hashMap) {

        if (len == 0) {
            String test2 = "";
            for (String s : result) {
                test2 += s;
            }
            Integer value = hashMap.get(test2);

            if (value == null) {
                hashMap.put(test2, 1);
            } else {
                hashMap.put(test2, ++value);
            }
            return result;
        }
        for (int i = startPosition; i <= arr.length - len; i++) {
            result[result.length - len] = arr[i];
            combinations(arr, len - 1, i + 1, result, hashMap);
        }
        return result;
    }


    public static void main(String[] args) {
        String test = "XYZ";
        Q222 q2 = new Q222();
        int n = test.length();
        // q2.permute(test, 0,n-1);
        //  q2.test(test, 2);
//        String[] orders = {"XYZ", "XWY", "WXA"};
//        int[] course = {2, 3, 4};

         String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = {2, 3, 5};
//
//        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//        int [] course = {2,3,4};


        for (String s : q2.solution(orders, course)) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
