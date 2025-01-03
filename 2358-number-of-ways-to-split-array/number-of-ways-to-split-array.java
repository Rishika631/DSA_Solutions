//TC=2n
//SC=n for prefix array 

class Solution {
    public int waysToSplitArray(int[] nums) {
        int count=0;
        long[] prefix=new long[nums.length];
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            prefix[i]=prefix[i-1]+nums[i];
        }
        for(int j=0;j<nums.length-1;j++)
        {
            long left=prefix[j];
            long right=prefix[nums.length-1]-prefix[j];
            if(left>=right)
            {
                count++;
            }
        }
        return count;
    }
}
// [-10,-4,-8,-7]
// [-10,-14,-22,-29]