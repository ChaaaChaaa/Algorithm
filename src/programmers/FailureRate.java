package programmers;

import java.util.*;

public class FailureRate {
    private static final double INIT_VALUE = 0.0;
    private static final int PERCENTAGE = 100;
    private static final int FAIL_USER = 1;
    private static final int NO_ONE = 0;

    public int[] solution(int N, int[] stages) {
        int[] failUsers = new int[N + 2];

        inputFailUserFromStages(failUsers,stages);

        Map<Integer, Double> failMemberForEachStage = new HashMap<>();

        calculateFailRate(N,stages,failUsers,failMemberForEachStage);

        List<Integer> sortFailRateForStage = new ArrayList<>(failMemberForEachStage.keySet());

        compareFailRateForEachStage(sortFailRateForStage,failMemberForEachStage);

        int [] answer = sortFailRateForStage.stream().mapToInt(i->i).toArray();
        return answer;

    }

    private void inputFailUserFromStages(int[] failUsers, int[] stages){
        for (int stage : stages) {
            failUsers[stage] += FAIL_USER;
        }
    }

    private double calculateFailRate(int N, int[] stages, int[] failUsers, Map<Integer, Double> failMemberForEachStage){
        double userCount = stages.length;

        for(int stageNum=1; stageNum<=N; stageNum++){
            double failRate = INIT_VALUE;
            if(failUsers[stageNum] != NO_ONE && userCount !=NO_ONE){
                failRate = (failUsers[stageNum]/userCount) * PERCENTAGE;
                userCount -= failUsers[stageNum];
            }
            failMemberForEachStage.put(stageNum,failRate);
        }
        return userCount;
    }

    private void compareFailRateForEachStage(List<Integer> sortFailRateForStage, Map<Integer, Double> failMemberForEachStage){
        Collections.sort(sortFailRateForStage, (o1, o2) -> failMemberForEachStage.get(o2).compareTo(failMemberForEachStage.get(o1)));
    }
}
