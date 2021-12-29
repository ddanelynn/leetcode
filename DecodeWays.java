import java.util.Arrays;

public class DecodeWays {
    public static int numDecodings(String s) {

        if (s.length() <= 1) {
            if (s.equals("0")) {
                return 0;
            }
            return s.length();
        }

        int[] dp = new int[s.length()];
        if (s.charAt(s.length() - 1) == '0') {
            dp[s.length() - 1] = 0;
        } else {
            dp[s.length() - 1] = 1;
        }

        if (s.charAt(s.length() - 2) == '2' && s.charAt(s.length() - 1) <= '6') {
            dp[s.length() - 2] = 1 + dp[s.length() - 1];
        } else if (s.charAt(s.length() - 2) == '1') {
            dp[s.length() - 2] = 1 + dp[s.length() - 1];
        } else if (s.charAt(s.length() - 2) == '0') {
            dp[s.length() - 2] = 0;
        } else {
            dp[s.length() - 2] = dp[s.length() - 1];
        }
        
        if (dp.length > 2) {
            for (int i = s.length() - 3; i >= 0; i--) {
                if ((s.charAt(i) == '2' && s.charAt(i + 1) <= '6') || s.charAt(i) == '1') {
                    dp[i] = dp[i + 1] + dp[i + 2];
                } else if (s.charAt(i) == '0') {
                    dp[i] = 0;
                } else {
                    dp[i] = dp[i + 1];
                }
            }
        }

        for (int i: dp) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        return dp[0];
    }

    public static void main(String[] args) {
        char a = '1';
        char b = '2';
        System.out.println(numDecodings("226"));
    }
}
