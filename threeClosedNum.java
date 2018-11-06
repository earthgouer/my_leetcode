package leetcodecn;

import java.util.Arrays;

public class threeClosedNum {



    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closed = nums[0] + nums[1] + nums[nums.length - 1];

        for (int i = 0; i < nums.length - 2; i++) {
            int start = i+1;
            int end = nums.length-1;
            int sumTwo =  target - nums[i];


            while (end > start){
                int sum = nums[i] + nums[start] + nums[end];
                if (sum > target){
                     end --;
                }else {
                    start ++;
                }
                if (Math.abs(sum- target) < Math.abs(closed - target)){
                    closed = sum;
                }
            }
        }
        return closed;
    }
}
