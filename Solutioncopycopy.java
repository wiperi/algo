import java.util.HashMap;

public class Solutioncopycopy {

    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for (Character character : t.toCharArray()) {
            need.put(character, need.getOrDefault(character, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        int start = 0; // 记录最小窗口子串的起始位置
        int minLen = Integer.MAX_VALUE;
        String ret = "";

        while (right < s.length()) {
            char Rch = s.charAt(right);
            if (need.containsKey(Rch)) {
                window.put(Rch, window.getOrDefault(Rch, 0) + 1);
                if (window.get(Rch).intValue() == need.get(Rch).intValue()) { // 检查字符频次是否满足要求
                    valid++;
                }
            }
            System.out.printf("right: %c, %d to %d\n", s.charAt(right), right, right + 1); // debug
            right++;

            while (valid == need.size()) { // 所有字符频次满足要求
                if (right - left < minLen) { // 更新最小窗口子串
                    minLen = right - left;
                    start = left;
                }

                char Lch = s.charAt(left);
                if (need.containsKey(Lch)) {
                    window.put(Lch, window.get(Lch) - 1);
                    if (window.get(Lch).intValue() < need.get(Lch).intValue()) { // 检查字符频次是否满足要求
                        valid--;
                    }
                }
                System.out.printf("left: %c, %d to %d\n", s.charAt(left), left, left + 1); // debug
                left++;
            }
        }

        if (minLen != Integer.MAX_VALUE) {
            ret = s.substring(start, start + minLen);
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
