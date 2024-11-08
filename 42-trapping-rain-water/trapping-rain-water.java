class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0; // Not enough bars to trap water
        }

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int waterTrapped = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // Update left max
                } else {
                    waterTrapped += leftMax - height[left]; // Calculate trapped water
                }
                left++; // Move left pointer inward
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // Update right max
                } else {
                    waterTrapped += rightMax - height[right]; // Calculate trapped water
                }
            right--; // Move right pointer inward
            }
        }

        return waterTrapped; // Return total trapped water
    }
}