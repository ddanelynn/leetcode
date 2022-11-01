public class KMP {
    public static boolean findPattern(String[] page, String[] phrase) {
        int i = 0;
        int j = 0;

        int[] lps = constructLPS(phrase);

        while (i < page.length - 1 && j < phrase.length - 1) {
            if (page[i] == phrase[j]) {
                i++;
                j++;
            }
            if (page[i] != phrase[j]) {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
        }

        if (j == phrase.length - 1) {
            return true;
        }

        return false;
    }

    public static int[] constructLPS(String[] phrase) {
        int[] lps = new int[phrase.length];

        int i = 1;
        int len = 0;

        lps[0] = 0;

        while (i < phrase.length) {
            if (phrase[i].equals(phrase[len])) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }

        return lps;
    }
}
