public class MaxArea {
//https://leetcode.com/problems/container-with-most-water/description/
//O(N) solution

    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maximal = 0;

        while (true) {
            int attempt = Math.min(height[i], height[j]) * (j - i);
            maximal = Math.max(maximal, attempt);

            if (height[i] < height[j]) i++; else j--;
            if (i > j) break;
        }

        return maximal;
    }

    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums));
    }
}
