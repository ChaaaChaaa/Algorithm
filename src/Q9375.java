import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Q9375 {
    public static void main(String[] args) throws IOException {

        PassionKing passionKing = new PassionKing();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputCountTC = Integer.parseInt(br.readLine());

        for (int i = 0; i < inputCountTC; i++) {
            int inputCountCloths = Integer.parseInt(br.readLine());

            for (int j = 0; j < inputCountCloths; j++) {
                String clothType = br.readLine().split(" ")[1];
                passionKing.addNumOfCloths(clothType);
            }
            int result = passionKing.multipleEachClothTypes();
            System.out.println(result);
            passionKing.initHashMap();
        }
    }
}

class PassionKing {
    private static final int baseNumCloth = 1;
    private static final int naked = 1;

    private Map<String, Integer> clothsMap = new HashMap<>();

    void addNumOfCloths(String clothType) {
        if (checkContainsKey(clothType)) {
            int numOfCloths = clothsMap.get(clothType);
            clothsMap.put(clothType, numOfCloths + baseNumCloth);
        }
        if (!checkContainsKey(clothType)) {
            clothsMap.put(clothType, baseNumCloth);
        }
    }

    private boolean checkContainsKey(String clothType) {
        return clothsMap.containsKey(clothType);
    }

    void initHashMap() {
        clothsMap.clear();
    }

    int multipleEachClothTypes() {
        int result = baseNumCloth;
        for (int cloth : clothsMap.values()) {
            result *= cloth + baseNumCloth;
        }
        return result - naked;
    }

}
