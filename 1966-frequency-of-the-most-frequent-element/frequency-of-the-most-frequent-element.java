class Solution {
    public int maxFrequency(int[] nums, int k) {
        long sum=0;
        int start=0;
        int freq=1;
        Arrays.sort(nums);//because otherwise nums[i]*(i-start+1)-sum gives negative which can lead to wrong ans
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            while(k<(long)nums[i]*(long)(i-start+1)-(long)sum)
            {
                sum-=nums[start];
                start++;
            }
            freq=Math.max(freq,i-start+1);
        }
        return freq;
    }
}
//TC-> nlogn
//SC-> const as nums already give in ques