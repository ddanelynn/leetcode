import java.util.*;

public class BookDraft {
    String[] pages;
    HashMap<String, HashSet<Integer>> wordPagesDict;
    // ArrayList<HashMap<String, HashSet<Integer>>> wordPositions;

    public BookDraft(String[] pages) {
        this.pages = pages;
        this.wordPagesDict = new HashMap<>();
        // this.wordPositions = new ArrayList<>();
        for (int i = 0; i < pages.length; i++) {
            this.initializePage(pages[i], i);
        }
    }

    public void initializePage(String page, int pageNum) {
        String[] words = page.split("[\\p{Punct}\\s]+");
        // wordPositions.add(new HashMap<>());
        // int position = 0;
        for (String word : words) {
            if (wordPagesDict.containsKey(word)) {
                wordPagesDict.get(word).add(pageNum);
            } else {
                HashSet<Integer> pageNums = new HashSet<>();
                pageNums.add(pageNum);
                wordPagesDict.put(word, pageNums);
            }
            // initializePositions(word, position, pageNum);
            // position++;
        }

    }

    // public void initializePositions(String word, int position, int pageNum) {
    // if (wordPositions.get(pageNum).containsKey(word)) {
    // wordPositions.get(pageNum).get(word).add(position);
    // } else {
    // HashSet<Integer> arr = new HashSet<>();
    // arr.add(position);
    // wordPositions.get(pageNum).put(word, arr);
    // }
    // }

    public String getPage(int num) {
        return this.pages[num];
    }

    public ArrayList<Integer> getPages(String word) {
        if (wordPagesDict.containsKey(word)) {
            return new ArrayList<>(wordPagesDict.get(word));
        } else {
            return new ArrayList<>();
        }
    }

    public ArrayList<Integer> getPagesFromPhrases(String phraseString) {
        ArrayList<Integer> pageNums = new ArrayList<>();
        for (int i = 0; i < pages.length; i++) {
            String[] page = pages[i].split("[\\p{Punct}\\s]+");
            String[] phrase = phraseString.split("[\\p{Punct}\\s]+");
            if (findPattern(page, phrase)) {
                pageNums.add(i);
            }
        }
        return pageNums;
    }

    public static boolean findPattern(String[] page, String[] phrase) {
        int i = 0;
        int j = 0;

        int[] lps = constructLPS(phrase);

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

    public static int[] constructLPS(String[] phrase) {
        int[] lps = new int[phrase.length];

        int i = 1;
        int len = 0;

        lps[0] = 0;

        // b a b c c a b c d a
        // 0 0 1 0 0 0 1 0 0 0
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

    // public ArrayList<Integer> getPagesFromPhrasesSlow(String phrase) {
    // HashSet<Integer> pages = new HashSet<>();
    // HashSet<Integer> currPages = new HashSet<>();
    // HashSet<Integer> prevPages = new HashSet<>();
    // String[] words = phrase.split("\\s+");

    // if (words.length == 1) {
    // return getPages(phrase);
    // }

    // prevPages = wordPagesDict.containsKey(words[0]) ? wordPagesDict.get(words[0])
    // : new HashSet<>();
    // currPages = wordPagesDict.containsKey(words[1]) ? wordPagesDict.get(words[1])
    // : new HashSet<>();

    // if (words.length == 2) {
    // return new ArrayList<>(processDuplicates(prevPages, currPages, words[1],
    // words[0]));
    // }

    // if (words.length > 2) {
    // String prevWord = words[1];
    // pages = processDuplicates(prevPages, currPages, words[1], words[0]);
    // for (int i = 2; i < words.length; i++) {
    // currPages = wordPagesDict.containsKey(words[i]) ? wordPagesDict.get(words[i])
    // : new HashSet<>();
    // pages = processDuplicates(pages, currPages, words[i], prevWord);
    // prevWord = words[i];
    // }
    // }
    // return new ArrayList<>(pages);
    // }

    // public HashSet<Integer> processDuplicates(HashSet<Integer> hs1,
    // HashSet<Integer> hs2, String currWord,
    // String prevWord) {
    // HashSet<Integer> duplicates = new HashSet<>();
    // for (int num : hs1) {
    // if (hs2.contains(num)) {
    // boolean isConnected = false;
    // for (int position : wordPositions.get(num).get(prevWord)) {
    // if (wordPositions.get(num).get(currWord).contains(position + 1)) {
    // isConnected = true;
    // }
    // }
    // if (isConnected) {
    // duplicates.add(num);
    // }
    // }
    // }

    // return duplicates;
    // }

    public static void main(String[] args) {
        String[] pages = new String[] {
                "hello I am Tom, I like apples apples and oranges.",
                "hello I am Cindy, I like oranges.",
                "hello I am Amy, I like apples.",
                "hello I am Lucy, I like blueberries and oranges.",
                "hello I am Jaryl I like coconut.",
                "hello I am Jaryll I like coconut.",
        };
        BookDraft book = new BookDraft(pages);
        ArrayList<Integer> pageArr = book.getPages("oranges");
        ArrayList<Integer> phraseArr = book.getPagesFromPhrases("apples apples");
        System.out.println(pageArr);
        System.out.println(phraseArr);

        String[] test = new String[] { "b", "a", "b", "c", "c", "a", "b", "c", "d", "a" };
        // int[] lps = constructLPS(test);

    }
}