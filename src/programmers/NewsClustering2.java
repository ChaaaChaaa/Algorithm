package programmers;

import java.util.ArrayList;

public class NewsClustering2 {
    private int solution(String str1, String str2) {
        str1 = str1.replaceAll("[^a-zA-Z]", "#").toLowerCase();
        str2 = str2.replaceAll("[^a-zA-Z]", "#").toLowerCase();

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        insetArrayList(str1, list1);
        insetArrayList(str2, list2);

        int interSet, unionSet;

        ArrayList<String> clone = (ArrayList<String>) list2.clone();
        ArrayList<String> temp = new ArrayList<>();

        for (String s : list1) {
            if (clone.contains(s)) {
                temp.add(s);
                clone.remove(s);
            }
        }

        interSet = temp.size();
        unionSet = list1.size() + list2.size() - interSet;

        int answer;

        if (interSet == 0 && unionSet == 0) {
            answer = 65536;
        } else {
            answer = (int) (((double) interSet / (double) unionSet) * 65536);
        }

        return answer;
    }

    private void insetArrayList(String str, ArrayList<String> arrayList) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (!str.substring(i, i + 2).contains("#"))
                arrayList.add(str.substring(i, i + 2));
        }
    }


    public static void main(String[] args) {

        NewsClustering2 newsClustering2 = new NewsClustering2();

        String str1 = "handshake";
        String str2 = "shake hands";

        int result = newsClustering2.solution(str1, str2);

        System.out.println(result);
    }
}
