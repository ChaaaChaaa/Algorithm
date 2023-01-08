package fortest;

import java.util.*;

import forstudy.Q9_3;

class Edge1 implements Comparable<Edge1>{
    public int time;
    public char state;

    public Edge1(int time, char state){
        this.time = time;
        this.state = state;
    }
    @Override
    public int compareTo(Edge1 o){
        if(this.time == o.time){ return this.state-o.state; }
        else{
            return this.time - o.time;
        }
    }
}
class Q3{
    public static int solution(ArrayList<Edge1> list){
        int cnt = 0;
        int ans = Integer.MIN_VALUE;
        Collections.sort(list);
        for(Edge1 e : list){
            if(e.state == 's'){
                cnt++;
            }else{
                cnt--;
            }

            ans = Math.max(cnt, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        Q3 q9_3 = new Q3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Edge1> arrayList = new ArrayList<>();
        for(int i=0; i<n; i++){
            int timeTime = sc.nextInt();
            int endTime = sc.nextInt();
            arrayList.add(new Edge1(timeTime,'s'));
            arrayList.add(new Edge1(endTime,'e'));
        }
        System.out.println(q9_3.solution(arrayList));
    }
}
