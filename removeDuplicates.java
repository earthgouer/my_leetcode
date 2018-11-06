package leetcodecn;

public class removeDuplicates {



    public int removeDuplicates(int[] nums) {

        if (nums == null) return 0;
        if (nums.length == 1) return 1;
        int stactP = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[stactP]) {
                continue;
            }else{
                nums[stactP++ + 1] = nums[i];
            }
        }
        return stactP+1;
    }
}


