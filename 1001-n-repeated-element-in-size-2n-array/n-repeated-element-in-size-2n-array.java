class Solution {
    public int repeatedNTimes(int[] nums) {
        int n=nums.length/2;
        int ans=0;
        for(int i=0;i<=n;i++)
        {
            int count=0;
            for(int j=0;j<n+2;j++)
            {
                if(nums[i]==nums[j])
                {
                    count++;
                }
            }
            if(count>1)
            {
                ans=nums[i];
                break;
            }
        }
        return ans;
    }
}