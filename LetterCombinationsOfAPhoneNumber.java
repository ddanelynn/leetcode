import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    List<String> result = new ArrayList<>();
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    char[] c;
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return result;
        c = digits.toCharArray();
        backtrack(0, "");
        return result;
    }

    public void backtrack(int start, String s) {
        if (start == c.length) {
            result.add(s);
            return;
        }

        int digit = c[start] - '0';
        String val = map[digit];

        for (int i = 0; i < val.length(); i++) {
            backtrack(start + 1, s + val.charAt(i));
        }
    }
}
