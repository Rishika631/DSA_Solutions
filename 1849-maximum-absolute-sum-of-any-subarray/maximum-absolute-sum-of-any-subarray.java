// brute force have two for loops and check all possible value and give max sum
// Time - o(n^2)
//Space- const

// kandane's algo
//time- o(n) one for loop
// space- const
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        
        // absolute donot ignore negative
        // abosolute so have min and max subarray sum as abs karne pr -ve can be big also

        int len=nums.length;
        int maxSubarraySum=nums[0];
        int currMaxSubarraySum=nums[0];
        int minSubarraySum=nums[0];
        int currMinSubarraySum=nums[0];

        for(int i=1;i<len;i++)
        {
            currMaxSubarraySum= Math.max(nums[i], currMaxSubarraySum+nums[i]);
            maxSubarraySum=Math.max(maxSubarraySum, currMaxSubarraySum);
            currMinSubarraySum= Math.min(nums[i], currMinSubarraySum+nums[i]);
            minSubarraySum=Math.min(minSubarraySum, currMinSubarraySum);
        }
        return Math.max(Math.abs(maxSubarraySum), Math.abs(minSubarraySum));

    }
}