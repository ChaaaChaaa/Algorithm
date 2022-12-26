package programmers;

import java.util.Arrays;

public class ADInsert {
    public static void main(String[] args) {
//        String play_time = "02:03:55";
//        String adv_time = "00:14:15";
//        String [] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};

        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String [] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};

        System.out.println(solution(play_time,adv_time,logs));
    }

    public static String solution(String play_time, String adv_time, String[] logs) {
        int playTime = timeToSecond(play_time);
        int advTime = timeToSecond(adv_time);
        int[] playCnt = new int[100*3600];

        for (String log : logs) {
            String[] tempInfo = log.split("-");
            int startPlayTime = timeToSecond(tempInfo[0]);
            int endPlayTime = timeToSecond(tempInfo[1]);

           for(int i=startPlayTime; i<endPlayTime; ++i){
               playCnt[i] += 1;
           }
        }

       long currSum = 0;
        for(int i=0; i<advTime; ++i){
            currSum += playCnt[i];
        }

        long maxSum = currSum;
        int maxIndex = 0;

        for(int i=advTime; i<playTime; i++){
            //앞에 구한 값에 이전 마지막값을 빼고 이후 마지막값을 더한다
            System.out.println("currSum : "+currSum+" playCnt[i] : "+playCnt[i]+" i : "+i+" advTime : "+advTime+" i-advTime : "+(i-advTime)+" playCnt[i-advTime] : "+playCnt[i-advTime]);
            currSum = currSum-playCnt[i]-playCnt[i-advTime];
            if(currSum > maxSum){
                maxSum = currSum;
                maxIndex = i-advTime+1;
            }
        }

        int hour = maxIndex/3600;
        int minute = maxIndex/60 %60;
        int second = maxIndex%60;

        return String.format("%02d:%02d:%02d",hour,minute,second);
    }

    private static int timeToSecond(String str) { //초로 모두 바꿔줌
        int[] parse = Arrays.stream(str.split(":")).mapToInt(Integer::parseInt).toArray();
        int hour = parse[0] * 60 * 60;
        int minute = parse[1] * 60;
        int second = parse[2];
        return hour + minute + second;
    }
}
