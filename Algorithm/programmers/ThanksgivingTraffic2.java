package programmers;

public class ThanksgivingTraffic2 {
    public int solution(String[] lines) {
        int answer = 0;

        if(lines.length == 1)
        {
            return ++answer;
        }
        Double[] start = new Double[lines.length];
        Double[] finish= new Double[lines.length];
        int i, j, count;
        Double section;

        for( i = 0; i < lines.length; i++)
        {
            String[] arr = lines[i].split(" ");
            String[] time = arr[1].split(":");
            Double end = (Double.parseDouble(time[0]) * 3600 + Double.parseDouble(time[1]) * 60 + Double.parseDouble(time[2]));
            finish[i] = end;
            arr = arr[2].split("s");
            start[i] = end - Double.parseDouble(arr[0]) + 0.001;
        }

        for( i = 0; i< lines.length; i++)
        {
            count = 1;
            section = finish[i] + 1;
            for( j = i+1; j < lines.length; j++)
            {
                if(start[j] - section < 0)
                {
                    count++;
                }
            }
            if(answer < count)
                answer = count;
        }

        return answer;
    }
}
