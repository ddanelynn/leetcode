public class PalindromicSubstrings {
    public static int countSubstrings(String s) {
        int count = s.length();

        if (s.length() < 2) {
            return count;
        }

        // odd
        int curr = 1;
        while (curr < s.length() - 1) {
            int prev = curr - 1;
            int next = curr + 1;
            int increment = 0;
            while (prev - increment >= 0 && next + increment < s.length() && s.charAt(prev - increment) == s.charAt(next + increment)) {
                count++;
                increment ++;
            }
            curr++;
       
        }

        // even
        int curr2 = 1;
        while (curr2 < s.length()) {
            int prev = curr2 - 1;
            int increment = 0;
            while (prev - increment >= 0 && curr2 + increment < s.length() && s.charAt(prev - increment) == s.charAt(curr2 + increment)) {
                count++;
                increment ++;
            }
            curr2++;
        }
        return count;
    }

    public static void main (String args[]) {
        System.out.println(countSubstrings("aaa"));
    }
}
