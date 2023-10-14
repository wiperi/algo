import java.util.HashMap;
import java.util.Map;

class Solution {
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int min = Integer.MIN_VALUE;
        while (right < s.length()) {
            char ch = s.charAt(right);
            window.put(ch, right);

        }
    }
}