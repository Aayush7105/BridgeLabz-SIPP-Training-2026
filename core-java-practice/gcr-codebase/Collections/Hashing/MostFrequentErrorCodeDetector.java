package Collections.Hashing;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentErrorCodeDetector {
    public static int mostFrequentErrorCode(int[] codes) {
        Map<Integer, Integer> freq = new HashMap<>();
        int bestCode = codes[0], bestCount = 0;
        for (int code : codes) {
            int count = freq.merge(code, 1, Integer::sum);
            if (count > bestCount) {
                bestCount = count;
                bestCode = code;
            }
        }
        return bestCode;
    }

    public static void main(String[] args) {
        int[] codes = {500, 404, 500, 502, 500, 404, 404, 404};
        System.out.println(mostFrequentErrorCode(codes));
    }
}
