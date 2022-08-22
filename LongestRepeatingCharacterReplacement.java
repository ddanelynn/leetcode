import java.util.*;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int maxF = 0;
        int left = 0;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (hm.containsKey(s.charAt(i))) {
                hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
            } else {
                hm.put(s.charAt(i), 1);
            }
            maxF = Math.max(maxF, hm.get(s.charAt(i)));

            while (i - left + 1 - maxF > k) {
                hm.put(s.charAt(left), hm.get(s.charAt(left)) - 1);
                left++;
            }

            result = Math.max(i - left + 1, result);
        }

        return result;
    }
}
