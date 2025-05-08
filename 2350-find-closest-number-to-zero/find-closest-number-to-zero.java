class Solution {
    public int findClosestNumber(int[] nums) {
        int sub=nums[0]>0?(nums[0]-0):(0-nums[0]);
        int temp=sub;
        int res=0;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>=0)
            {
                temp=nums[i]-0;
            }
            else
            {
                temp=0-nums[i];
            }
            if(sub==temp && nums[i]>nums[res])
            {
                res=i;
            }
            if(sub>temp)
            {
                sub=temp;
                res=i;
            }
        }
        return nums[res];
    }
}