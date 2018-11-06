package leetcodecn;

public class maxArea {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(new maxArea().solve(height));
    }


    /*
        双指针法
     */

    public int solve(int[] height){
        int l = 0, r = height.length-1;
        int area = 0;
        while (l<r){
            int low = Math.min(height[l], height[r]);
            area = Math.max(area, (r-l)* low);
            if (height[l] <= height[r]) l++;
            else r--;
        }
        return area;
    }


/*
    暴力破解
 */
    public int maxArea(int[] height){
        int area = 0;
        for (int i = 0; i < height.length-1; i++) {
            for (int j = i+1; j < height.length; j++) {
                int high = Math.min(height[i], height[j]);
                area = Math.max(area, high*(j-i));
            }
        }
        return area;
    }
}
