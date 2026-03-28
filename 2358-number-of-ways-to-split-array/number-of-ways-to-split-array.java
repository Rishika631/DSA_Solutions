

class Solution {
    public int waysToSplitArray(int[] nums) {
        int len=nums.length;
        int result=0;
        long[] prefix= new long[len];
        prefix[0]=nums[0];
        for(int i=1;i<len;i++)
        {
            prefix[i]=prefix[i-1]+nums[i];
        }
        for(int i=0;i<len-1;i++)//len-1 as we donot want right to be empty 2nd condition in ques
        {
            long right=prefix[len-1]-prefix[i];
            if(prefix[i]>=right)//left>=right
            {
                result++;
            }
        }
        return result;
    }
}