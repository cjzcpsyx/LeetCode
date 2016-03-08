// https://en.wikipedia.org/wiki/3SUM
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n, start, end, a, b, c, result, min, sum, diff;
        n = nums.length;
        min = Integer.MAX_VALUE;
        result = 0;
        for (int i = 0; i <= n - 3; i++) {
            a = nums[i];
            start = i + 1;
            end = n - 1;
            while (start < end) {
                b = nums[start];
                c = nums[end];
                sum = a + b + c;
                diff = Math.abs(sum - target);
                if (diff == 0) return sum;
                if (diff < min) {
                    min = diff;
                    result = sum;
                    // Ignore duplicate solutions
                    do {start++;} while (start < end && nums[start] == nums[start - 1]);
                    do {end--;} while (start < end && nums[end] == nums[end + 1]);
                }
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
            // Ignore duplicate solutions
            while (i < n - 2 && nums[i] == nums[i + 1]) i++;
        }
        return result;
    }
}