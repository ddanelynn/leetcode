import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
  public static int lengthOfLongestSubstring(String s) {
    if (s.length() == 0) {
      return 0;
    }

    Hashtable<Character, Integer> ht = new Hashtable<>();
    int lengthCount = 0;
    int longestLength = 0;
    int firstIndex = 0;

    for (int i = 0; i < s.length(); i++) {
      if (ht.containsKey(s.charAt(i)) && ht.get(s.charAt(i)) >= firstIndex) {
        longestLength = Math.max(longestLength, lengthCount);
        lengthCount = i - ht.get(s.charAt(i)) - 1;
        firstIndex = ht.get(s.charAt(i)) + 1;
      }
      lengthCount++;
      ht.put(s.charAt(i), i);
      // System.out.println("lengthCount: " + lengthCount);
      // System.out.println(ht);
    }

    return Math.max(longestLength, lengthCount);
  }

  public static void main(String args[]) {
    System.out.println(lengthOfLongestSubstring("bbtablud"));
  }
}
