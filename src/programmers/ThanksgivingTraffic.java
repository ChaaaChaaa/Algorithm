package programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ThanksgivingTraffic {
    public int solution(String[] lines) {
        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss.SSS");
        Date[] endDate = new Date[lines.length];
        Date[] startDate = new Date[lines.length];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < lines.length; i++) {
            try {
                String[] line = lines[i].split(" ");
                String dateStr = line[0] + " " + line[1];
                int procMilli = (int) (Double.parseDouble(line[2].substring(0, line[2].length() - 1)) * -1000);
                endDate[i] = format.parse(dateStr);
                startDate[i] = addMilli(endDate[i], procMilli + 1);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < endDate.length; i++) {
            int maxTemp = 0;
            long endTime1 = endDate[i].getTime();
            long findMilli = addMilli(endDate[i], 1000).getTime();

            for (int j = 0; j < startDate.length; j++) {
                long startTime = startDate[j].getTime();
                long endTime2 = endDate[j].getTime();
                if ((findMilli - startTime) <= 0) {
                    continue;
                }
                if (isIncludeEndValue(startTime, endTime1, findMilli) || isIncludeStartValue(endTime2, endTime1, findMilli)
                ) {
                    maxTemp++;
                }
            }
            max = Math.max(max, maxTemp);
        }
        return max;
    }

    private boolean isIncludeEndValue(long startTime, long endTime1, long findMilli) {
        if ((endTime1 - startTime) <= 0 && (findMilli - startTime) > 0) {
            return true;
        }
        return false;
    }

    private boolean isIncludeStartValue(long endTime2, long endTime1, long findMilli) {
        if ((endTime1 - endTime2) <= 0 && (findMilli - endTime1) > 0) {
            return true;
        }
        return false;
    }


    private Date addMilli(Date date, int proMilli) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MILLISECOND, proMilli);
        return c.getTime();
    }

    public static void main(String[] args) {
        ThanksgivingTraffic thanks = new ThanksgivingTraffic();
//      String[] s = {"2016-09-15 01:00:04.001 2.0s","2016-09-15 01:00:07.000 2s"};
//       String[] s = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
        String[] s = {"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"};
        System.out.println(thanks.solution(s));
    }
}
