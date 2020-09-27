package programmers;

import java.util.*;

public class BadUsers {
    static boolean checked[];
    static Set<String> answerSet;

    public int solution(String[] user_id, String[] banned_id) {
        checked = new boolean[user_id.length];
        answerSet = new HashSet<>();
        dfs(0, user_id, banned_id);
        int answer = answerSet.size();
        return answer;
    }

    private void dfs(int cnt, String[] user_id, String[] banned_id) {
        if (cnt == banned_id.length) {
            String s = "";
            for (int i = 0; i < checked.length; i++) {
                if (checked[i]) {
                    s += i;
                }
            }
            answerSet.add(s);
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (!checked[i] && check(user_id[i], banned_id[cnt])) {
                checked[i] = true;
                dfs(cnt + 1, user_id, banned_id);
                checked[i] = false;
            }
        }
    }

    private boolean check(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) {
            return false;
        }
        for (int i = 0; i < userId.length(); i++) {
            if (bannedId.charAt(i) == '*') {
                continue;
            } else if (userId.charAt(i) != bannedId.charAt(i)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
//        String[] banned_id = {"fr*d*", "abc1**"};
        String[] banned_id = {"*rodo", "*rodo", "******"};
        //  String [] banned_id = {"fr*d*", "*rodo", "******", "******"};


        BadUsers badUsers = new BadUsers();
        System.out.println(badUsers.solution(user_id, banned_id));
    }
}
