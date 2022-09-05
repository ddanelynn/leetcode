import java.util.*;

public class EncodeAndDecodeStrings {
    public String encode(List<String> strs) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(String.valueOf(s.length()) + "#" + s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        // write your code here
        List<String> decoded = new ArrayList<>();
        int start = 0;
        int index = 0;
        while (index < str.length()) {
            if (str.charAt(index) == '#') {
                int digits = Integer.parseInt(str.substring(start, index));
                decoded.add(str.substring(index + 1, index + 1 + digits));
                start = index + digits + 1;
                index = start;
            }
            index++;
        }
        return decoded;
    }
}
