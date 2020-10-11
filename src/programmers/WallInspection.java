package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WallInspection {
    int w[],d[];
    int max = Integer.MAX_VALUE;
    List<int[]> list = new ArrayList<>();

    int solution(int n, int[] weak, int[] dist){

        int weakSize = weak.length;
        int distSize = dist.length;
        w = new int[2*weakSize];

        int ret = max;

        for(int i=0; i<weakSize; i++){
            w[i] = weak[i];
            w[i+weakSize] = w[i]+n;
        }

        Arrays.sort(dist);
        permutation(0,new int[distSize], new boolean[distSize],distSize);

        for(int i=0; i<weakSize; i++){
            for(int j=0; j<list.size(); j++){
                ret = Math.min(ret,inject(i,list.get(j),weakSize));
            }
        }

        if(ret == max){
            return  -1;
        }

        else {
            return ret;
        }

    }

    int inject(int s, int[] friends,int weakSize){
        int p =0, i,a;
        for(i =0; i<friends.length; i++){
            a = w[s+p];
            while (p<weakSize && w[s+p] <= a+friends[i]){
                p++;
            }
            if(p==weakSize){
                return i+1;
            }
        }
        return max;
    }

    void permutation(int depth, int[] make, boolean[] use,int distSize){
        if(depth == distSize){
            int [] tmp = new int[distSize];
            for(int i=0; i<distSize; i++){
                tmp[i] = make[i];
            }
            list.add(tmp);
            return;
        }
        for(int i=0; i<distSize; i++){
            make[depth] = d[i];
            if(!use[i]){
                use[i] = true;
                permutation(depth+1,make,use,distSize);
                use[i] =false;
            }
        }
    }


    public static void main(String[] args) {
        int n = 12;
        int[] weak = {1, 5, 6, 10};
        int[] dist = {1, 2, 3, 4};
        WallInspection wallInspection = new WallInspection();
        int answer = wallInspection.solution(n, weak, dist);
        System.out.println(answer);
    }
}
