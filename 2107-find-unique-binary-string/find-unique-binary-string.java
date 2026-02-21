class Solution {
    public void backtrack(String[] nums, StringBuilder str, String[] result)
    {
        if(str.length()==nums.length)
        {
            for(int i=0;i<nums.length;i++)
            {
                if(str.toString().equals(nums[i]))
                {
                    return;
                }
            }
            result[0]=str.toString();
            return;
        }
        for(int i=0;i<=1;i++)
        {
            if(result[0].length()==nums.length)
            {
                break;
            }
            str.append(i);
            backtrack(nums,str,result);
            str.deleteCharAt(str.length()-1);

        }
    }
    
    
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder str=new StringBuilder();
        String[] result={""};
        backtrack(nums,str, result);
        return result[0];

    }
}