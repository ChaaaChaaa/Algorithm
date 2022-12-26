package programmers;

import java.util.PriorityQueue;
import java.util.Queue;

public class ShuttleBus2 {
    public String solution(int n, int t, int m, String[] timeTable){
        Queue<Integer> crewTime = new PriorityQueue<>();
        for(String time : timeTable){
            String[] splitTime = time.split(":");
            crewTime.add(Integer.parseInt(splitTime[0])*60+ Integer.parseInt(splitTime[1]));
        }
        int busTime = 9*60;
        int last = 0;
        for(int bus = 0; bus<n; bus+= 1){
            int seat = m ;
            int lastTime = 0;
            while (!crewTime.isEmpty()){
                if(crewTime.peek() <= busTime&&seat > 0){
                    seat -= 1;
                    lastTime = crewTime.poll();
                }
                else {
                    break;
                }
            }
            if(bus != n-1){
                if(crewTime.isEmpty()){
                    last = busTime+(n-bus)*t;
                    break;
                }
                busTime += t;
            }
            else {
                if(seat>0){
                    last = busTime;
                }
                else {
                    last= lastTime-1;
                    break;
                }
            }
        }
        return String.format("%02d",last/60)+":"+String.format("%02d",last%60);
    }

    public static void main(String[] args) {
        ShuttleBus2 shuttleBus = new ShuttleBus2();
        //String s[] = {"08:00","08:01","08:03"};
       // System.out.println(shuttleBus.solution(1,1,5, s));

        //  String [] s = {"09:10", "09:09", "08:00"};
        //  System.out.println(shuttleBus.solution(2,10,2, s));

//        String [] s = {"09:00", "09:00", "09:00","09:00"};
//        System.out.println(shuttleBus.solution(2,1,2, s));


//        String s[] = {"00:01", "00:01", "00:01", "00:01", "00:01"};
//        System.out.println(shuttleBus.solution(1,1,5, s));

//        String s[] = {"23:59"};
//        System.out.println(shuttleBus.solution(1,1,1, s));

//        String s[] = {"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};
//        System.out.println(shuttleBus.solution(10,60,45, s));



        String [] s ={"10:00", "10:00", "10:00", "10:00"};
        System.out.println(shuttleBus.solution(10,60,45, s));


    }
}
