class Solution {
    public int maxAscendingSum(int[] nums) {
        int ans=0;
        int tempSum=0;
        if(nums.length==1)
        {
            return nums[0];
        }
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]<nums[i+1])
            {
                tempSum+=nums[i];
            }
            else
            {
                ans=Math.max(tempSum+nums[i], ans);
                tempSum=0;
            }
        }
        if(nums[nums.length-1]>nums[nums.length-2])
        {
            tempSum+=nums[nums.length-1];
            ans=Math.max(ans,tempSum);
        }
        return ans;
    }
}

//10    20  30  5   10  50
//10    30  0   5   15  65