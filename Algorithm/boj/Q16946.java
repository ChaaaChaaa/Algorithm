//package boj;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Q16946 {
//    private static int[][] map;
//    private static boolean[][][] visit;
//    private static Queue<PositionBreakWall> queue;
//    private static int[] dx = {-1, 1, 0, 0};
//    private static int[] dy = {0, 0, -1, 1};
//    private static int n, m;
//    private static int result = -1;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//
//        map = new int[n][m];
//        visit = new boolean[n][m][2];
//        queue = new LinkedList<>();
//
//        for (int i = 0; i < n; i++) {
//            String input = br.readLine();
//            for (int j = 0; j < m; j++) {
//                map[i][j] = input.charAt(j) - '0';
//            }
//        }
//
//        queue.add(new PositionBreakWall(0,0,1,0));
//        System.out.println(bfs());
//    }
//}
