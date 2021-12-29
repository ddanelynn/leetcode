import java.util.*;

import javax.print.attribute.standard.Finishings;

public class WordBreak {
  public static void main(String[] args) {
    List<String> wordDict = new ArrayList<>();
    wordDict.add("dd");
    wordDict.add("ad");
    wordDict.add("da");
    wordDict.add("b");

    System.out.println(wordBreak("ddadddbdddadd", wordDict));
  }
  public static boolean wordBreak(String s, List<String> wordDict) {
    // boolean result = false; 
    // Set<String> unique = new HashSet<>();
    // Queue<String> q = new LinkedList<>();
    // q.add(s);
    // unique.add(s);

    // while (!q.isEmpty()) {
    //   String currS = q.poll();
    //   for (String word: wordDict) { 
    //     if (currS.indexOf(word) == 0) {
    //         String newS = currS.replaceFirst(word, "");
    //         if (newS.replaceAll(" ", "").equals("")) {
    //           result = true;
    //           break;
    //         }
    //         if (!unique.contains(newS)) {
    //           unique.add(newS);
    //           q.add(newS);
    //         }
    //     }
    //   }
    //   if (result) {
    //     break;
    //   }
    // }
    // return result;

    boolean[] dp = new boolean[s.length() + 1];
    Arrays.fill(dp, false);
    dp[s.length()] = true;

    for (int i = s.length() - 1; i >= 0; i--) {
      for (String word: wordDict) { 
        if (i + word.length() <= s.length() && s.substring(i).indexOf(word) == 0) {
          dp[i] = dp[i + word.length()];
        }
        if (dp[i]) {
          break;
        }
      }
    }
    return dp[0];
  }
}
