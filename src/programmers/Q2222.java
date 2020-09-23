//package programmers;
//
//import java.util.HashMap;
//
//public class Q2222 {
//    private static final int INCREASE_COUNT = 1;
//
//    public String[] solution(String[] orders, int[] course) {
//
//        for (String order : orders) {
//
//        }
//    }
//
//
//
//
//    private int getCourseNum(int[] course) {
//        for(int element : course){
//
//        }
//    }
//
//
//    void backTracking(int order, int index, int selectCourse, String[] orders) {
//        HashMap<String, Integer> hashMap = new HashMap<>();
//        if (order == selectCourse) {
//            for (String orderSequence : orders) {
//                Integer value = hashMap.getOrDefault(order, 0);
//                hashMap.put(orderSequence, ++value);
//            }
//
//            return;
//        }
//
//        for(String s : orders){
//            orders[index] = s;
//            backTracking(index + INCREASE_COUNT, s + INCREASE_COUNT,selectCourse,orders);
//        }
//
//    }
//}
