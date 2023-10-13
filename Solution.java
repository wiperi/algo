public class Solution {
    public int trap1(int[] height) {
        int len = height.length;
        int maxVolume = 0;
        int cur = 0, scout = 0;
        while (cur < len) {
            int curVolume = 0;
            for (scout = cur + 1; scout <= len; scout++) {
                if (scout == len) {
                    cur++;
                    break;
                } else if (height[scout] < height[cur]) {
                    // accumulate current volume
                    curVolume += height[cur] - height[scout];
                    cur = scout;
                } else if (height[scout] >= height[cur]) {
                    // claim current volume
                    maxVolume += curVolume;
                    cur = scout;
                    break;
                }
            }
        }
        return maxVolume;
    }

    public int trap2(int[] height) {
        int len = height.length;
        int maxVolume = 0;
        int cur = 0, scout = 0;
        while (cur < len) {
            int curVolume = 0;
            for (scout = cur + 1; scout < len; scout++) {
                if (height[scout] < height[cur]) {
                    // accumulate current volume
                    curVolume += height[cur] - height[scout];
                } else if (height[scout] >= height[cur]) {
                    // claim current volume
                    maxVolume += curVolume;
                    break;
                }
            }

            // 如果scout越界，我们只知道cur位置无法作为左边界盛水，
            // 但是我们不知道cur到右界中间有没有可以盛水的坑，因此如果scout越界，cur只移动一格。
            if (scout == len) {
                cur++; // the lowest one
                scout = cur + 1;
                while (scout < len && height[scout] < height[cur]) {
                    scout++;
                }
                if (scout < len) {
                    for (int i = scout - 1; i >= cur; i--) {
                        maxVolume += height[scout] - height[i];
                    }
                    cur = scout;
                }
            } else {
                cur = scout;
            }
        }
        return maxVolume;
    }

    public static int trap(int[] height) {
        int len = height.length;
        int maxVolume = 0;
        int cur = 0, scout = 0;
        while (cur < len) {
            int curVolume = 0;
            for (scout = cur + 1; scout < len; scout++) {
                if (height[scout] < height[cur]) {
                    // accumulate current volume
                    curVolume += height[cur] - height[scout];
                } else if (height[scout] >= height[cur]) {
                    // claim current volume
                    maxVolume += curVolume;
                    break;
                }
            }

            // 如果scout越界，我们只知道cur位置无法作为左边界盛水，
            // 但是我们不知道cur到右界中间有没有可以盛水的坑，因此如果scout越界，cur只移动一格。
            if (scout == len) {
                cur++; // the lowest one
                // search larest from the right
                int localHighestHeight = 0;
                int localHighestIndex = cur;
                for (int i = len - 1; i >= cur; i--) {
                    if (height[i] > localHighestHeight) {
                        localHighestHeight = height[i];
                        localHighestIndex = i;
                    }
                }
                for (int i = localHighestIndex - 1; i >= cur; i--) {
                    maxVolume += localHighestHeight - height[i];
                }
                cur = localHighestIndex;
            } else {
                cur = scout;
            }
        }
        return maxVolume;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 4, 1, 2 };
        System.out.println(trap(arr));
    }
}