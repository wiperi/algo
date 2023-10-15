import java.util.HashMap;

/**
 * Solution
 */
public class Solution {

    public static boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        if (s2Len < s1Len)
            return false;

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (Character character : s1.toCharArray()) {
            need.put(character, need.getOrDefault(character, 0) + 1);
        }
        System.out.println(need); // debug

        int left = 0, right = 0;
        int valid = 0;
        while (right < s2Len) {
            char Rch = s2.charAt(right);
            right++;
            if (need.containsKey(Rch)) { // extend right side
                window.put(Rch, window.getOrDefault(Rch, 0) + 1);
                System.out.println("window updated: " + window); // debug
                if (window.get(Rch).equals(need.get(Rch))) {
                    valid++;
                }
            }

            int len = right - left;
            while (len >= s1Len) {
                if (valid == need.size()) {
                    return true;
                }
                char Lch = s2.charAt(left);
                left++;
                len = right - left;
                if (need.containsKey(Lch)) { // shrink left side
                    if (window.get(Lch).equals(need.get(Lch))) {
                        valid--;
                    }
                    window.put(Lch, window.getOrDefault(Lch, 0) - 1);
                    System.out.println("window shrinked: " + window); // debug
                }
            }

        }
        return false;
    }

    public static boolean checkInclusion1(String t, String s) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
    
        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }
    
            // 判断左侧窗口是否要收缩
            while (right - left >= t.length()) {
                // 在这里判断是否找到了合法的子串
                if (valid == need.size())
                    return true;
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        // 未找到符合条件的子串
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "wab"));
        System.out.println(checkInclusion1("ab", "wab"));

    }
}