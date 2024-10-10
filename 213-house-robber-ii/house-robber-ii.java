class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(robLinear(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                        robLinear(Arrays.copyOfRange(nums, 1, nums.length)));
    }
    private int robLinear(int[] houses) {
        int prevNoRob = 0; // Max money when not robbing current house
        int prevRob = 0;   // Max money when robbing current house

        for (int currentHouseValue : houses) {
            int tempPrevNoRob = Math.max(prevNoRob, prevRob);
            prevRob = prevNoRob + currentHouseValue; // Rob current house
            prevNoRob = tempPrevNoRob; // Update for next iteration
        }
        return Math.max(prevNoRob, prevRob); // Return max of both scenarios
    }
}