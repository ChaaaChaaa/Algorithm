package programmers;

import java.util.Arrays;

public class ShuttleBus {
    public String calcTime(int HH, int MM, int interval) {
        if (MM + interval >= 60) {
            return (HH + 1) + ":" + (MM + interval % 60);
        } else {
            return (HH) + ":" + (MM + interval);
        }
    }

    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        Arrays.sort(timetable);

        int idx = 0;
        int busHH = 9;
        int busMM = 0;

        for (int i = 0; i < n; ++i) {
            int in = 0;
            while (in != m && idx < timetable.length) {
                String[] time = timetable[idx].split(":");
                int crewHH = Integer.parseInt(time[0]);
                int crewMM = Integer.parseInt(time[1]);

                if (crewHH < busHH || (crewHH == busHH && crewMM <= busMM)) {
                    answer = timetable[idx];
                    ++idx;
                    ++in;
                } else {
                    break;
                }
            }

            if (in < m) {
                answer = String.format("%02d", busHH) + ":" + String.format("%02d", busMM);
            } else if (in == m) {
                String[] time = answer.split(":");
                int ansHH = Integer.parseInt(time[0]);
                int ansMM = Integer.parseInt(time[1]);

                if (ansMM < 1) {
                    System.out.println(ansMM);
                    answer = String.format("%02d", ansHH-1) + ":" + String.format("%02d", 59);
                } else {
                    answer = String.format("%02d", ansHH) + ":" + String.format("%02d", ansMM-1);                }
            }

            String[] time = calcTime(busHH, busMM, t).split(":");
            busHH = Integer.parseInt(time[0]);
            busMM = Integer.parseInt(time[1]);
        }
        return answer;
    }


    public static void main(String[] args) {
        //String s[] = {"10:00", "10:00", "10:02", "10:03"};
       // String s[] = {"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};
       // String s[] = {"00:01", "00:01", "00:01", "00:01", "00:01"};
        //String s[] = {"23:59"};
      //  String [] s = {"09:10", "09:09", "08:00"};
       String [] s ={"10:00", "10:00", "10:00", "10:00"};
        ShuttleBus shuttleBus = new ShuttleBus();
        System.out.println(shuttleBus.solution(2, 60, 2, s));
    }
}
