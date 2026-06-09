
class Solution {

    public long maxTotalValue(int[] nums, int k) {
        int min = nums[0], max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        return (max - min) * k;
    }
}
