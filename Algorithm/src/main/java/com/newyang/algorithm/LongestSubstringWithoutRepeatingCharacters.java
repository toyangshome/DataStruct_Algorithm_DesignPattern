package com.newyang.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }

    public int solution2(String s) {
        if (s.length() <= 1) return s.length();
        Set<Character> set = new HashSet<>();

        int start = 0;
        int end = 1;
        int max = 1;
        set.add(s.charAt(start));
        for (int i = end; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
            } else {
                while (s.charAt(start) == s.charAt(i) && start < i) {
                    start++;
                }
            }
            max = Integer.max(max,i-start);
        }
        return max;
    }

    public static void main(String[] args) {
        String testStr = "pwwkew";
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(testStr));
        System.out.println(longestSubstringWithoutRepeatingCharacters.solution2(testStr));
    }
}
