import java.util.*;

public class MinimumWindowSubstring {
    // doesn't pass one test case for some reason, can't debug
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> needMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (needMap.containsKey(t.charAt(i))) {
                needMap.put(t.charAt(i), needMap.get(t.charAt(i)) + 1);
            } else {
                needMap.put(t.charAt(i), 1);
            }
        }

        int needMapSize = needMap.size();

        HashMap<Character, Integer> haveMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            haveMap.put(t.charAt(i), 0);
        }
        String minSubString = null;
        int start = 0;
        int end = 0;
        int haveCharCount = 0;

        while (end < s.length()) {
            char currChar = s.charAt(end);
            if (haveMap.containsKey(currChar)) {
                haveMap.put(currChar, haveMap.get(currChar) + 1);
                if (haveMap.get(currChar) == needMap.get(currChar)) {
                    haveCharCount++;
                }
            }

            while (haveCharCount == needMapSize) {
                String subS = s.substring(start, end + 1);
                if (minSubString == null || subS.length() < minSubString.length()) {
                    minSubString = subS;
                }
                char leftChar = s.charAt(start);
                if (haveMap.containsKey(leftChar)) {
                    haveMap.put(leftChar, haveMap.get(leftChar) - 1);
                    if (haveMap.get(leftChar) < needMap.get(leftChar)) {
                        haveCharCount--;
                    }
                }
                start++;
            }
            end++;
        }

        if (minSubString == null) {
            return "";
        }

        return minSubString;
    }

    public static void main(String[] args) {

    }
}
