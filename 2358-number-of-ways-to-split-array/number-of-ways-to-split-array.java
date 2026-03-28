
//pure brute force have a for loop for split and then inside that two for loops one for right and one for left for sum
//time-n^2
//space-const
//below prefix sum approach
// time- o(2n)
//space-o(n)

// class Solution {
//     public int waysToSplitArray(int[] nums) {
//         int len=nums.length;
//         int result=0;
//         long[] prefix= new long[len];// as very large value when added 
//         prefix[0]=nums[0];
//         for(int i=1;i<len;i++)
//         {
//             prefix[i]=prefix[i-1]+nums[i];
//         }
//         for(int i=0;i<len-1;i++)//len-1 as we donot want right to be empty 2nd condition in ques
//         {
//             long right=prefix[len-1]-prefix[i];
//             if(prefix[i]>=right)//left>=right
//             {
//                 result++;
//             }
//         }
//         return result;
//     }
// }

//more optimized
// time-o(2n)
//space- const we donot need prefix array astotal mai say left wale ko minus kar rhe can do this way as well
class Solution {
    public int waysToSplitArray(int[] nums) {
        int len=nums.length;
        int result=0;
        long sum=0;
        for(int i=0;i<len;i++)
        {
            sum+=nums[i];
        }
        long leftsum=0;
        long rightsum=0;
        for(int i=0;i<len-1;i++)//len-1 as we donot want right to be empty 2nd condition in ques
        {
            leftsum+=nums[i];
            rightsum=sum-leftsum;
            if(leftsum>=rightsum)//left>=right
            {
                result++;
            }
        }
        return result;
    }
}
