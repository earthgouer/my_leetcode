package leetcodecn;

import java.util.ArrayList;
import java.util.List;

public class subSet {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = new subSet().subsets(nums);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums == null){
            return res;
        }
        List<Integer> temp;
        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                temp = res.get(j);
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        return res;
    }
}
