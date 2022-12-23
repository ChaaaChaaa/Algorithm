package programmers;

import java.util.LinkedList;


public class Cache {
    private static final int HIT = 1;
    private static final int MISS = 5;

    public int solution(int cacheSize, String[] cities) {

        if (cacheSize == 0) {
            return MISS * cities.length;
        }


        LinkedList<String> cache = new LinkedList<>();
        int answer = 0;

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toUpperCase();
            System.out.print(cities[i]+" , ");
            if (cache.remove(city)) {
                cache.addFirst(city);
                answer += HIT;
            } else {
                int currentSize = cache.size();
                if (currentSize == cacheSize) {
                    cache.pollLast();
                }
                cache.addFirst(city);
                answer += MISS;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Cache cache = new Cache();

       int cacheSize = 3;
       String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
       cache.solution(cacheSize,cities);
    }
}
