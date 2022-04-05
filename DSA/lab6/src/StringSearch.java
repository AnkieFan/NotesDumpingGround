import java.util.ArrayList;
import java.util.List;

public class StringSearch {

    public static int[] patternMatch(String text, String pattern) {
        // Return an array of indices representing the first indices of the matched
        // pattern in the String
        List<Integer> result = new ArrayList<>();

        // You choose which algorithm you'd prefer to implement here (don't use brute-force)
        int localIndex = text.indexOf(pattern);
        int index = localIndex;

        while (localIndex != -1) {
            result.add(index);
            text = text.substring(localIndex + 1);
            localIndex = text.indexOf(pattern);
            index += localIndex + 1;
        }
        // If the pattern does not exist in the string, return an empty array
        int[] results = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            results[i] = result.get(i);
        }

        return results;
    }

}
