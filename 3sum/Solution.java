// https://en.wikipedia.org/wiki/3SUM
// Ignored duplicate solutions to speed up
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        int n, start, end, a, b, c;
        n = nums.length;
        for (int i = 0; i <= n - 3; i++) {
            a = nums[i];
            start = i + 1;
            end = n - 1;
            while (start < end) {
                b = nums[start];
                c = nums[end];
                if (a + b + c == 0) {
                    result.add(Arrays.asList(a, b, c));
                    // Ignore duplicate solutions
                    do {start++;} while (start < end && nums[start] == nums[start - 1]);
                    do {end--;} while (start < end && nums[end] == nums[end + 1]);
                } else if (a + b + c > 0) {
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