import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> need = new HashMap<>(); // ch -> times it duplicate times
        for (Character character : p.toCharArray()) {
            need.put(character, need.getOrDefault(character, 0) + 1);
        }
        printMap(need);
        
        HashMap<Character, Integer> window = new HashMap<>();

        ArrayList<Integer> ret = new ArrayList<>();
        int left = 0, right = 0;
        while (right <= s.length() - p.length()) {
            char ch = s.charAt(right);
            if (need.containsKey(ch)) {
                for (int i = 0; i < p.length(); i++) {
                    window.put(s.charAt(right + i), window.getOrDefault(s.charAt(right + i), 0) + 1);
                }

                System.out.println("compare 2");
                printMap(window);
                printMap(need);
                if (window.equals(need)) {
                    ret.add(right);
                }
            }
            window.clear();
            right++;
        }
        return ret;
    }

    public static void printMap(HashMap<Character, Integer> map) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        for (Integer integer : findAnagrams(s, p)) {
            System.out.println(integer);
        }
    }
}
