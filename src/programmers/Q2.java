package programmers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Q2 {

    public String[] solution(String[] orders, int[] course) {

        HashMap<String, Integer> hashMap = new HashMap<>();
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            hashMap = test(orders[i], 2, hashMap);
        }

        for (String s : hashMap.keySet()) {
            Integer value = hashMap.get(s);

            if (hashMap.get(value) > 1) {
                arrayList.add(s);
            }
        }

        int index = 0;
        String [] answer = new String[arrayList.size()];

       for(String s : arrayList){
           answer[index] = s;
           index++;
       }

        Arrays.sort(answer);
        return answer;
    }

//    private HashMap<String, Integer> insertHashmap(HashMap<String, Integer> hashMap,String order){
//        for(int i =0; i<order.length(); i++){
//            String orderMenuKey = String.valueOf(order.charAt(i));
//            hashMap.put(orderMenuKey,1);
//        }
//    }

//    private void test(String test,int course){
//     while (!test.isEmpty()){
//         for(int i=0; i<test.length()- course+1; i++){
//            // if(i<test.length() - course+1){
//             if(test.length()>course)
//                // System.out.println(test);
//                 System.out.println(test.substring(i,i+course));
//
//         }
//         test = test.substring(1);
//     }
//    }

    private HashMap<String, Integer> test(String test, int course, HashMap<String, Integer> hashmap) {
        for (int i = 0; i < test.length() - course; i++) {
            for (int j = i + course; j < test.length() + 1; j++) {
                String key = test.substring(i, j);

                if (!hashmap.containsKey(key)) {
                    hashmap.put(key, 1);
                } else {
                    Integer value = hashmap.get(key);
                    hashmap.put(key, value++);
                }
                //System.out.println(test.substring(i,j));
            }
        }
        return hashmap;
    }

//    private void permute(String str, int l, int r) {
//        if (l == r)
//            System.out.println(str);
//        else {
//            for (int i = l; i <= r; i++) {
//                str = swap(str, l, i);
//                permute(str, l + 1, r);
//                str = swap(str, l, i);
//            }
//        }
//    }
//
//    public String swap(String a, int i, int j) {
//        char temp;
//        char[] charArray = a.toCharArray();
//        temp = charArray[i];
//        charArray[i] = charArray[j];
//        charArray[j] = temp;
//        return String.valueOf(charArray);
//    }


    public static void main(String[] args) {
        String test = "XYZ";
        Q2 q2 = new Q2();
        int n = test.length();
        // q2.permute(test, 0,n-1);
      //  q2.test(test, 2);
        String[] orders = {"XYZ", "XWY", "WXA"};
        int [] course = {2,3,4};

        q2.solution(orders,course);
    }
}
