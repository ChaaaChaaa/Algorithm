package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q797 {
    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        //int [][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
        System.out.println(allPathsSourceTarget(graph));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);
        dfs(graph, 0, res, path);
        return res;
    }

    private static void dfs(int[][] graph, int index, List<List<Integer>> res, List<Integer> path) {
        if (index == graph.length - 1) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int nextNode : graph[index]) {
            path.add(nextNode);
            dfs(graph, nextNode, res, path);
            path.remove(path.size() - 1);
        }
    }
}