package leetcodecn;

import java.util.Arrays;
import java.util.HashMap;

/*
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
 */
public class twoSum {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        System.out.println(Arrays.toString(new twoSum().twoSum1(nums, target)));
    }
    public int[] twoSum1(int[] nums, int target) {
        HashMap map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {                     //不能和自身相加
            if (map.containsKey(target-nums[i])){
                if (i == (int)map.get(target-nums[i])){
                    continue;
                }
                int[] res = {i, (int)map.get(target-nums[i])};
                return res;
            }
        }
        int[] res = {-1, -1};
        return res;
    }

    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length-1; i++) {
            int temp = nums[i];
            for (int j = i+1; j < length; j++) {
                if (nums[i] + nums[j] == target){
                    int[] arr = {i, j};
                    return arr;
                }
            }
        }
        int[] res = {-1, -1};
        return res;
    }
}
