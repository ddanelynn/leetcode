import java.util.*;

public class ReplaceString {
    static HashMap<String, String> wordMap = new HashMap<>();

    public static void initMap() {
        wordMap.put("firstname", "Luke");
        wordMap.put("father", "Mike");
    }

    public static String replace(String input, char escape) {
        String result = "";
        Stack<Integer> brackets = new Stack<>();
        int curr = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '<') {
                brackets.add(i);
            }
            if (input.charAt(i) == '>') {
                if (!brackets.isEmpty()) {
                    result += input.substring(curr, brackets.peek());
                    String wordKey = input.substring(brackets.pop() + 1, i);
                    if (wordMap.containsKey(wordKey)) {
                        result += wordMap.get(wordKey);
                    } else {
                        result += "<" + wordKey + ">";
                    }
                    curr = i + 1;
                }
            }
        }
        result += input.substring(curr, input.length());
        return result;
    }

    public static String replace2(String input, char escape) {
        StringBuffer sbResult = new StringBuffer();
        StringBuffer sbKey = new StringBuffer();
        Stack<Integer> brackets = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '<') {
                brackets.add(i);
                sbResult.append(sbKey.toString());
                sbKey.delete(0, sbKey.length());
                sbKey.append(String.valueOf(input.charAt(i)));

            } else if (!brackets.isEmpty()) {
                if (input.charAt(i) == '>') {
                    if (sbKey.length() > 0 && wordMap.containsKey(sbKey.toString().substring(1))) {
                        sbResult.append(wordMap.get(sbKey.toString().substring(1)));
                    } else {
                        sbResult.append(sbKey.toString());
                        sbResult.append(">");
                    }
                    brackets.pop();
                    sbKey.delete(0, sbKey.length());
                } else {
                    sbKey.append(String.valueOf(input.charAt(i)));
                }
            } else {
                sbResult.append(String.valueOf(input.charAt(i)));
            }
        }
        return sbResult.toString();
    }

    public static void main(String[] args) {
        initMap();
        String input1 = "I am <<firstname>>, son of ;<father;>.";
        String input2 = "I am <<firstname, son of <father>.";
        String input3 = "I am <firstname!>, son of <father>.";
        String input4 = "I am <firstname>, son> of <father>>>.";
        System.out.println(replace2(input1, ';'));
        System.out.println(replace2(input2, ';'));
        System.out.println(replace2(input3, ';'));
        System.out.println(replace2(input4, ';'));
    }
}
