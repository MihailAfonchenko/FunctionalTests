package PointPackage;

import java.util.Arrays;

public class ActionManager {

    public int[] parsingMatchResult(String resultsMatch) {
        int[] arrResult = new int[3];
        var partResult = splitResult(resultsMatch);
        for (int i = 0; i < arrResult.length; i++) {
            arrResult[i] = convertToInt(partResult[i]);
        }
        return arrResult;
    }

    private String[] splitResult(String resultsMatch) {
        var result = resultsMatch.split("/");
        var r = Arrays.stream(result).mapToInt(x -> Integer.parseInt(x));
        return result;
    }

    public int convertToInt(String item) {
        return Integer.parseInt(item);
    }
}
