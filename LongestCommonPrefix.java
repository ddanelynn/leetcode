public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder common = new StringBuilder(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            for (int x = 0; x < common.length(); x++) {
                if ((strs[i].length() == x) || (common.charAt(x) != strs[i].charAt(x))) 
                    common.delete(x, common.length());
            }
        }
        return common.toString();
    }
}
