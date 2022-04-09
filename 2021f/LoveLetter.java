import java.util.*;
public class LoveLetter {
    public static void main(String args[]) {
      String s = "aabbcc"; String t = "hkccbb";
      System.out.println(checkMessages(s, t));
    }
    
    public static boolean checkMessages(String s, String t) {
        int[] sLetters = countLetterOccurance(s);
        int[] tLetters = countLetterOccurance(t);
        Arrays.sort(sLetters); Arrays.sort(tLetters);
        return Arrays.equals(sLetters, tLetters);
    }
    
    public static int[] countLetterOccurance(String str) {
        int[] letters = new int[26]; // index is letter, value is # of occurances
        for (char c : str.toCharArray()) {
            letters[c - 'a'] += 1;
        } return letters;
    }
}
