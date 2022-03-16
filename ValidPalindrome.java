public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        System.out.println(s);
        int len = s.length() % 2 == 0 ? s.length()/2 : s.length()/2 + 1;
        // 8: 0 1 2 3 < 4
        // 9: 0 1 2 3 4 < 5
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main (String[] args) {
        String s = "race a car";
        System.out.println(isPalindrome(s));
    }
}
