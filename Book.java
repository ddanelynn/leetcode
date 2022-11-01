import java.util.*;

public class Book {
    String[] pages;
    HashMap<String, HashSet<Integer>> wordPagesDict;

    public Book(String[] pages) {
        this.pages = pages;
        this.wordPagesDict = new HashMap<>();
        for (int i = 0; i < pages.length; i++) {
            initializePage(pages[i], i);
        }
    }

    public void initializePage(String page, int num) {
        String[] words = page.split("[\\p{Punct}\\s]+");
        for (String word : words) {
            if (wordPagesDict.containsKey(word)) {
                wordPagesDict.get(word).add(num);
            } else {
                HashSet<Integer> pageNumSet = new HashSet<>();
                pageNumSet.add(num);
                wordPagesDict.put(word, pageNumSet);
            }
        }
    }

    public String getPage(int num) {
        return this.pages[num];
    }

    public HashSet<Integer> getPages(String word) {
        if (wordPagesDict.containsKey(word)) {
            return wordPagesDict.get(word);
        } else {
            return new HashSet<>();
        }
    }

    public HashSet<Integer> getPagesFromPhrase(String phrase) {
        HashSet<Integer> pageNums = new HashSet<>();

        String[] phraseArr = phrase.split("[\\p{Punct}\\s]+");
        for (int i = 0; i < pages.length; i++) {
            String[] pageArr = pages[i].split("[\\p{Punct}\\s]+");
            if (findPattern(pageArr, phraseArr)) {
                pageNums.add(i);
            }
        }
        return pageNums;
    }

    public boolean findPattern(String[] page, String[] phrase) {
        int[] lps = constructLPS(phrase);
        int i = 0;
        int j = 0;

        // a a b c a b
        // b c

        while (i < page.length - 1 && j < phrase.length - 1) {
            if (page[i].equals(phrase[j])) {
                i++;
                j++;
            }

            if (!page[i].equals(phrase[j])) {
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

    public int[] constructLPS(String[] phrase) {
        int[] lps = new int[phrase.length];
        // a b c c a b c d a
        // 0 0 0 0 1 2 3 0 1

        lps[0] = 0;
        int i = 1;
        int len = 0;

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

    public static void main(String[] args) {
        String[] pages = new String[] {
                "hello I am Tom, I like apples apples and oranges.",
                "hello I am Cindy, I like oranges.",
                "hello I am Amy, I like apples.",
                "hello I am Lucy, I like blueberries and oranges.",
                "hello I am Jaryl I like coconut.",
                "hello I am Jaryll I like coconut.",
                "hi b a hi b c c a b c d a",
        };
        Book book = new Book(pages);
        HashSet<Integer> pageArr = book.getPages("oranges");
        HashSet<Integer> phraseArr = book.getPagesFromPhrase("b a b c c a b c d a");
        System.out.println(pageArr);
        System.out.println(phraseArr);

    }
}
