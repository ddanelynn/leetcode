public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        } 
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            } else {
                return s.substring(0, 1);
            }
        }

        int oddStartingIndex = 0;
        int oddLength = 1;
        int evenStartingIndex = 0;
        int evenLength = 1;

        int curr = 1;
        
        // odd case
        while (curr < s.length() - 1) {
            int prev = curr - 1;
            int next = curr + 1;
            if (s.charAt(prev) == s.charAt(next)) {
                int tempLength = 3;
                int tempStartingIndex = prev;
        
                int increment = 1;
                while (prev - increment >= 0 && next + increment < s.length()) {
                    if (s.charAt(prev - increment) == s.charAt(next + increment)) {
                        tempLength += 2;
                        tempStartingIndex = prev - increment;
                        increment++;
                    } else {
                        break;
                    }
                }
                if (tempLength > oddLength) {
                    oddLength = tempLength;
                    oddStartingIndex = tempStartingIndex;
                }
            }
            curr++;
        }

        // even case
        curr = 0;
        while (curr < s.length() - 1) {
            int next = curr + 1;
            if (s.charAt(curr) == s.charAt(next)) {
                int tempLength = 2;
                int tempStartingIndex = curr;
        
                int increment = 1;
                while (curr - increment >= 0 && next + increment < s.length()) {
                    if (s.charAt(curr - increment) == s.charAt(next + increment)) {
                        tempLength += 2;
                        tempStartingIndex = curr - increment;
                        increment++;
                    } else {
                        break;
                    }
                }
                if (tempLength > evenLength) {
                    evenLength = tempLength;
                    evenStartingIndex = tempStartingIndex;
                }
            }
            curr++;
        }
        String resultString = "";
        if (oddLength > evenLength) {
            resultString = s.substring(oddStartingIndex, oddStartingIndex + oddLength);
        } else {
            resultString = s.substring(evenStartingIndex, evenStartingIndex + evenLength);
        }
        return resultString;
    }

    public static void main(String args[]) {
        System.out.println(longestPalindrome("aaaa"));
    }
}