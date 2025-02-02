//TC=3n----O(n)
//SC=n as array

class Solution {
    public boolean check(int[] nums) {
        int[] b=new int[nums.length];
        int x=0;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i+1]<nums[i])
            {
                x=i+1;
                break;
            }
        }
        for(int j=0;j<nums.length;j++)
        {
           b[j]=nums[(j+x)%nums.length];
        }
        for(int j=0;j<b.length-1;j++)
        {
           if(b[j]>b[j+1])
           {
            return false;
           }
        }
        return true;
    }
}