```java
public class TwoSum {
    // solution-1  O(n^2)
    public int[] solution1(int[] nums, int target) {
        int[] res = new int[]{0,0};
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return res;
    }

    //hashtable  solution-2
    public int[] solution2(int[] nums, int target) {
        int[] res = new int[]{0,0};
        Map<Integer,Integer> container = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer integer = container.get(target - nums[i]);
            if (integer != null) {
                return new int[]{i,integer};
            }
            container.put(nums[i],i);
        }
        return res;
    }
}
```
# 解析
> 思考一下 solution-1 如何在进行优化？\
  我们在分析算法的复杂度时，通常从 “时间复杂度” 和 “空间复杂度” 这两个方向进行分析 
>- 我们先尝试按照时间复杂度这个方向来进行分析
>- 数组具有特点为：乱序，元素不相同
>- 按照时间优化思维，我们要在尽可能少的扫描次数里面拿到结果，
> 

