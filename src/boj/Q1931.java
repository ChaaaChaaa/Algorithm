package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfMeeting = Integer.parseInt(br.readLine());
        MeetingScheduleInfo [] meetingSchedule = new MeetingScheduleInfo[numOfMeeting];

        StringTokenizer st;

       for(int i=0; i<numOfMeeting; i++){
           st = new StringTokenizer(br.readLine());
           int startTime = Integer.parseInt(st.nextToken());
           int endTime = Integer.parseInt(st.nextToken());
           meetingSchedule[i] = new MeetingScheduleInfo(startTime,endTime);
       }

        Arrays.sort(meetingSchedule);

       int cnt = 0;
       int now = 0;
       for(MeetingScheduleInfo meeting : meetingSchedule){
           if(meeting.start<now){
               continue;
           }
           now = meeting.end;
           cnt++;
       }
        System.out.println(cnt);
    }
}

class MeetingScheduleInfo implements Comparable<MeetingScheduleInfo>{
    int start;
    int end;

    public MeetingScheduleInfo(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(MeetingScheduleInfo o) {
        if(this.end == o.end){
            return Integer.compare(start,o.start);
        }
        else {
            return Integer.compare(end,o.end);
        }
    }
}
