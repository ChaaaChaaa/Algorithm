package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q16937 {
    private static int mapRow;
    private static int mapCol;
    private static List<Sticker> stickers;
    private static Sticker[] stickerPosition;
    private static int result = Integer.MIN_VALUE;
    public static int numOfStickers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        mapCol = Integer.parseInt(st.nextToken());
        mapRow = Integer.parseInt(st.nextToken());

        numOfStickers = Integer.parseInt(br.readLine());

        stickerPosition = new Sticker[numOfStickers];
        stickers = new ArrayList<>();

        for (int i = 0; i < numOfStickers; i++) {
            st = new StringTokenizer(br.readLine());
            int stickerCol = Integer.parseInt(st.nextToken());
            int stickerRow = Integer.parseInt(st.nextToken());
            stickers.add(new Sticker(stickerCol, stickerRow));
        }

        backTracking(0, 0);

        if (result == Integer.MIN_VALUE) {
            result = 0;
        }

        System.out.println(result);
    }

    private static void backTracking(int currentDepth, int cnt) {
        if (cnt >= 2) {

            int h1 = stickerPosition[0].stickerCol;
            int w1 = stickerPosition[0].stickerRow;

            int h2 = stickerPosition[1].stickerCol;
            int w2 = stickerPosition[1].stickerRow;

            if (stickerPosition[0].area() + stickerPosition[1].area() <= result)
                return;

            validationInMap(h1, w1, h2, w2);
            validationInMap(h1, w1, w2, h2);
            validationInMap(w1, h1, h2, w2);
            validationInMap(w1, h1, w2, h2);

            return;
        }

        for (int i = currentDepth; i < numOfStickers; i++) {
            stickerPosition[cnt] = stickers.get(i);
            backTracking(i + 1, cnt + 1);
        }
    }

    public static void validationInMap(int h1, int w1, int h2, int w2) {
        if (h1 > mapCol || h2 > mapCol || w1 > mapRow || w2 > mapRow)
            return;

        if (h1 - 1 >= mapCol - h2 && w1 - 1 >= mapRow - w2) {
            return;
        }
        result = stickerPosition[0].area() + stickerPosition[1].area();
    }
}

class Sticker {
    int stickerRow;
    int stickerCol;

    Sticker(int stickerCol, int stickerRow) {
        this.stickerCol = stickerCol;
        this.stickerRow = stickerRow;
    }

    public int area() {
        return stickerRow * stickerCol;
    }
}

