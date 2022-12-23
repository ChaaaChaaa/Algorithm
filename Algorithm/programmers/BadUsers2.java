package programmers;

import java.util.HashSet;
import java.util.Set;

public class BadUsers2 {
   Set<Integer> set = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
       int n = banned_id.length;
       for(int i=0; i<n; i++){
           banned_id[i] = banned_id[i].replace("*",".");
       }
       dfs(0,user_id,banned_id,0);
       return set.size();
    }

    public void dfs(int index, String[] user_id, String[] banned_id, int visited) {
        int n = banned_id.length;
        int m = user_id.length;

        if(index == n){
            set.add(visited);
            return;
        }
        for(int i=0; i<m; i++){
            if((visited&(1<<i)) != 0 || !user_id[i].matches(banned_id[index])){
                continue;
            }
            System.out.println("1 : "+visited+" , "+i);
            visited |= (1<<i);
            System.out.println("2 : "+visited+" , "+i);
            dfs(index+1,user_id,banned_id,visited);
            System.out.println("3 : "+visited+" , "+i);
            visited &= ~(1<<i);
            System.out.println("4 : "+visited+" , "+i);
        }
    }

    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
//        String[] banned_id = {"fr*d*", "abc1**"};
        String[] banned_id = {"*rodo", "*rodo", "******"};
        //  String [] banned_id = {"fr*d*", "*rodo", "******", "******"};


        BadUsers2 badUsers = new BadUsers2();
        System.out.println(badUsers.solution(user_id, banned_id));
    }
}
