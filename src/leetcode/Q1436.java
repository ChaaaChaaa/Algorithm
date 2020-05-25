package leetcode;

import java.util.*;

public class Q1436 {
    public static void main(String[] args) {

        ArrayList<String> testA = new ArrayList<>();
        testA.add("B");
        testA.add("C");
        ArrayList<String> testB = new ArrayList<>();
        testB.add("D");
        testB.add("B");
        ArrayList<String> testC = new ArrayList<>();
        testC.add("C");
        testC.add("A");


        List<List<String>> testD = new ArrayList<List<String>>();
        testD.add(testA);
        testD.add(testB);
        testD.add(testC);


        Iterator<List<String>> it = testD.iterator();
        while (it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println(destCity(testD));

    }

    public static String destCity(List<List<String>> paths) {

        if (paths.size() == 0 || paths == null) {
            return "";
        }

        Map<String, String> map = new HashMap<>();
        for(List<String> path : paths){
            map.put(path.get(0), path.get(1));
        }
        for(String city : map.values()){
            if(!map.containsKey(city)){
                return city;
            }
        }
        return "";
    }
}
