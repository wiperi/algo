import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 创建记录元素频率的哈希表
        HashMap<Integer, Integer> valToFreq = new HashMap<>();
        for (int i : nums) {
            valToFreq.put(i, valToFreq.getOrDefault(i, 0) + 1);
        }

        // 将哈希表条目加入优先队列，以频率为优先级排序
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((entry1, entry2) -> {
            // 队列按照键值对中的值（元素出现频率）从小到大排序
            return entry1.getValue().compareTo(entry2.getValue());
        });
        int n = 0;
        for (Map.Entry<Integer, Integer> entry : valToFreq.entrySet()) {
            if (n++ < k) {
                pq.add(entry);
            } else {
                if (entry.getValue() > pq.peek().getValue()) {
                    pq.poll();
                    pq.add(entry);
                }
            }
        }
        
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = pq.poll().getKey();
        }
        return ret;
    }
}