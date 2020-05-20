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
}
