public class SearchRotatedArray {
//https://leetcode.com/problems/search-in-rotated-sorted-array/description/
//O(logN) solution find an

    public static int search(int[] nums, int target) {

        int length = nums.length;
        int i = 0;
        int j = length - 1;
        if (length == 0) return -1;

        while (true) {
            int index = (i + j) / 2;

            int value = nums[index];
            if (value == target) return index;

            //Using the invariant that either i - mid OR mid-j has
            //to be sorted at any point of the computation
            if (nums[j] >= value) {
                if (target > value && target <= nums[j]) i = index;
                else if (target > value && target > nums[j]) j = index;
                else j = index;
            }
            else {
                if (target < value && target >= nums[i]) j = index;
                else if (target < value && target < nums[i]) i = index;
                else i = index;
            }

            if (i + 1 == j) {
                if (nums[i] == target) return i;
                if (nums[j] == target) return j;
                return -1;
            }

            if (i == j || i >= length || j >= length) return -1;
        }

    }

    public static void main(String[] args) {
        int[] nums = {7,8,0,1,2,3,4,5};
        System.out.println(search(nums, 7));
        System.out.println(search(nums, 8));
        System.out.println(search(nums, 0));
        System.out.println(search(nums, 1));
        System.out.println(search(nums, 2));
        System.out.println(search(nums, 3));
        System.out.println(search(nums, 4));
        System.out.println(search(nums, 5));



    }
}
