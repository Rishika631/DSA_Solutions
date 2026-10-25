class Solution {
    public boolean rotateString(String s, String goal) {
        int len=s.length();
        boolean ans=false;
        if(len!=goal.length())
        {
            return false;
        }
        for(int i=0;i<len;i++)
        {
            if(s.charAt(0)==goal.charAt(i))
            {
                for(int j=0;j<len;j++)
                {
                    if(s.charAt(j)!=goal.charAt((i+j)%len))
                    {
                        ans=false;
                        break;
                    }
                    if(j==len-1)
                    {
                        return true;
                    }
                }
            }
        }
        return ans;
    }
}
//TC->O(n2)
//SC->O(1)