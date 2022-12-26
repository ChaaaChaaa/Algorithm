package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FailureRate2 {
    public static void main(String[] args) {
        int n = 5;
        int [] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        System.out.println(Arrays.toString(solution(n,stages)));
    }

    public static int[] solution(int N, int[] stages) {
        int [] stageFailUserCount = countStage(N,stages);

        List<Stage> failRateList = calFailRate(N,stageFailUserCount,stages);

        int [] result = new int[N];
        for(int i=0; i<N; i++){
            result[i] = failRateList.get(i).id;
        }
        return result;
    }

    private static int [] countStage(int N, int[] stages){
        int [] stageFailUserCount = new int[N+2];
        for(int stage : stages){
            stageFailUserCount[stage]+=1;
        }
        return stageFailUserCount;
    }

    private static List<Stage> calFailRate(int N,int [] stageFailUserCount, int[] stages){
        List<Stage> failRateList = new ArrayList<>();
        int allPlayers = stages.length;
        int remainPlayers = allPlayers;

        for(int id=1; id<=N; id++){
            double failure =(double)stageFailUserCount[id]/remainPlayers;
            remainPlayers -= stageFailUserCount[id];

            Stage stage = new Stage(id,failure);
            failRateList.add(stage);
        }

        Collections.sort(failRateList, Collections.reverseOrder());

        return failRateList;
    }
}

class Stage implements Comparable<Stage> {
    public int id;
    public double failure;

    public Stage(int id_, double failure_) {
        id = id_;
        failure = failure_;
    }

    @Override
    public int compareTo(Stage o) {
        if (failure < o.failure ) {
            return -1;
        }
        if (failure > o.failure ) {
            return 1;
        }
        return 0;
    }
}
