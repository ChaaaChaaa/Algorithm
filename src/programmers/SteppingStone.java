package programmers;

import java.util.Arrays;

public class SteppingStone {
    public int solution(int[] stones, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int stone : stones){
            max = Math.max(max,stone);
            min = Math.min(min,stone);
        }
        return binarySearch(min,max,stones,k);
    }

    public int binarySearch(int min, int max, int[] stones, int k){
        if(min == max){
            return min;
        }
        while (min<max){
            int mid = min +(max-min)/2;
            if(go(mid,stones,k)){
                min = mid+1;
            }
            else {
                max = mid;
            }
        }
        return min-1;
    }

    public boolean go(int mid, int[] stones, int k){
        int zero = 0;
        for(int stone : stones){
            if(stone - mid <0){
                zero++;
            }
            else {
                zero =0;
            }
            if(zero == k){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int [] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        SteppingStone steppingStone = new SteppingStone();
        System.out.println(steppingStone.solution(stones,k));
    }
}
