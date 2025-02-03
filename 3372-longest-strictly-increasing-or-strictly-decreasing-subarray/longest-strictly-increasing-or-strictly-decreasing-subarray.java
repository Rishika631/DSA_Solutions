//TC=2n2==O(n^2)
//SC=o(1)

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans=1;
        int temp=1;
        for(int j=0;j<nums.length;j++){//increasing
        for(int i=j;i<nums.length-1;i++)
        {
            if(nums[i]<nums[i+1])
            {
                temp++;
            }
            else break;
        }
        ans=Math.max(temp,ans);
        temp=1;
    }
    for(int j=0;j<nums.length;j++){//decreasing
        for(int i=j;i<nums.length-1;i++)
        {
            if(nums[i]>nums[i+1])
            {
                temp++;
            }
            else break;
        }
        ans=Math.max(temp,ans);
        temp=1;
    }
    return ans;
    }
}