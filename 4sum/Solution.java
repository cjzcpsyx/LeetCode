// Similar to 3Sum Problem, but now with 4 numbers and need one more loop tire
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        int n, start, end, a, b, c, d;
        n = nums.length;
        for (int i = 0; i <= n - 4; i++) {
            // skip duplicate a
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            a = nums[i];
            for (int j = i + 1; j <= n - 3; j++) {
                // skip duplicate b
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                b = nums[j];
                start = j + 1;
                end = n - 1;
                while (start < end) {
                    c = nums[start];
                    d = nums[end];
                    if (a + b + c + d == target) {
                        result.add(Arrays.asList(a, b, c, d));
                        do {start++;} while (start < end && nums[start] == nums[start - 1]);
                        do {end--;} while (start < end && nums[end] == nums[end + 1]);
                    } else if (a + b + c + d > target) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        return result;
    }
}