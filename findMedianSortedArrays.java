package leetcodecn;

/*
nums1 = [1, 3]
nums2 = [2]

 */


public class findMedianSortedArrays {
    public static void main(String[] args) {
        int[] num1 = {1, 2};
        int[] num2 = {3, 4};
        System.out.println(findMedianSortedArrays(num1, num2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mid = 0;
        int i = 0, j=0;
        int count = 1;
        int length = nums1.length + nums2.length;
        int midPos = length/2;
        while (i<nums1.length && j < nums2.length){
            if (nums1[i] < nums2[j] ){
                mid = nums1[i];
                i++;
            }else if (nums1[i] >= nums2[j]){
                mid = nums2[j];
                j++;
            }
            if (count == midPos){
                if (length%2 == 0){
                    int next = nums1[i]>nums2[j] ? nums1[i] : nums2[j];
                    return (mid+next)/2;
                }else{
                    int next = nums1[i]>nums2[j] ? nums1[i] : nums2[j];
                    return next;
                }
            }
            count ++;
        }
        while (i<nums1.length){
            mid = nums1[i];
            i++;
            if (count == midPos){
                if (length%2 == 0){
                    return mid;
                }else{
                    return (mid+nums1[i])/2;
                }
            }
            count ++;
        }
        while (j < nums2.length){
            mid = nums2[j];
            j++;
            if (count == midPos){
                if (length%2 == 0){
                    return mid;
                }else{
                    int next = nums2[j];
                    return (mid+next)/2;
                }
            }
            count ++;
        }
        return 0d;
    }
}
