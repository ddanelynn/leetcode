import java.util.*;

public class ValidAnagram {

  public static void main(String[] args) {
    String s = "rat";
    String t = "cat";
    System.out.println(isAnagram(s, t));
  }

  public static boolean isAnagram(String s, String t) {
      HashMap<Character, Integer> hm = new HashMap<>();
      for (int i = 0; i < s.length(); i++) {
        if (hm.containsKey(s.charAt(i))) {
          hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
        } else {
          hm.put(s.charAt(i), 1);
        }
      }

      for (int i = 0; i < t.length(); i++) {
        if (hm.containsKey(t.charAt(i)) && hm.get(t.charAt(i)) > 1) {
          hm.put(t.charAt(i), hm.get(t.charAt(i)) - 1);
        } else if (hm.containsKey(t.charAt(i)) && hm.get(t.charAt(i)) == 1) {
          hm.remove(t.charAt(i));
        } else {
          return false;
        }
      }

      if (hm.size() > 0) {
        return false;
      } else {
        return true;
      }

    //   if(s.length() != t.length()){
    //     return false;
    // }
    
    // // Step 2: Create a character frequency array
    // int[] arr = new int[26];
    
    // // Step 3: Increment frequency of string s characters
    // for(int i=0;i<s.length();i++){
    //     int ascii = s.charAt(i) - 'a';
    //     arr[ascii] += 1;
    // }
    
    // // Step 4: Decrement frequency of string t characters
    // for(int i=0;i<t.length();i++){
    //     int ascii = t.charAt(i) - 'a';
    //     arr[ascii] -= 1;
    // }
    
    // // Step 5: If strings are anagrams, all elements in array should be 0
    // for(int i=0;i<arr.length;i++){
    //     if(arr[i] != 0){
    //         return false;
    //     }
    // }
    
    // return true;

    
  }
}