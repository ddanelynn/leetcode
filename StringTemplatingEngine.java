import java.util.*;

public class StringTemplatingEngine {
    public static String fillTemplate(String s, HashMap<String, String> m, char escape) {
        Stack<Integer> brackets = new Stack<>();
        StringBuffer sbKey = new StringBuffer();
        StringBuffer sbResult = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<' && (i == 0 || s.charAt(i - 1) != escape)) {
                brackets.add(i);
                sbResult.append(sbKey.toString());
                sbKey.delete(0, sbKey.length());
                sbKey.append(s.charAt(i));
            } else if (!brackets.isEmpty()) {
                if (s.charAt(i) == '>' && s.charAt(i - 1) != escape) {
                    if (sbKey.length() > 0 && m.containsKey(sbKey.toString().substring(1))) {
                        sbResult.append(m.get(sbKey.toString().substring(1)));
                    } else {
                        sbResult.append(sbKey.toString());
                        sbResult.append('>');
                    }
                    sbKey.delete(0, sbKey.length());
                    brackets.pop();
                } else if (s.charAt(i) == '>' && s.charAt(i - 1) == escape) {
                    sbResult.append(sbKey.toString().substring(1, sbKey.length() - 1));
                    sbResult.append('>');
                    sbKey.delete(0, sbKey.length());
                    brackets.pop();
                } else {
                    sbKey.append(s.charAt(i));
                }
            } else if (s.charAt(i) != escape) {
                sbResult.append(s.charAt(i));
            }
        }
        return sbResult.toString();
    }

    public static void main(String[] args) {
        String s = "Hello ;my name is <firstname> <lastname> child of ;<father;>";
        HashMap<String, String> m = new HashMap<>();
        m.put("firstname", "Luke");
        m.put("lastname", "Skywalker");
        m.put("father", "Anakin");
        System.out.println(fillTemplate(s, m, ';'));
    }
}