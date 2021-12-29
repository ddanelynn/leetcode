public class ReverseString {

    public static void main(String[] args) {
        char[] s = new char[] {'h','e','l','l','o'};
        reverseString(s);
        for (char letter: s) {
            System.out.println(letter);
        }
    }

    public static void reverseString(char[] s) {
        char[] copy = new char[s.length];

        for (int i = 0; i < s.length; i++) {
            copy[i] = s[i];
        }

        for (int i = 0; i < s.length; i++) {
            s[i] = copy[s.length - 1 - i];
        }
        
    }
}
