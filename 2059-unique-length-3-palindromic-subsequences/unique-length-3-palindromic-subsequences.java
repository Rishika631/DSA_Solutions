//SC: 2N - 2 hash sets
//TC:N2- 2 consecutive for loops

class Solution {
    public int countPalindromicSubsequence(String s) {
        int ans=0;
        HashSet<Character> uniquechars=new HashSet<>();
        for(int a=0;a<s.length();a++)
        {
            uniquechars.add(s.charAt(a));
        }
        for(char ch: uniquechars)
        {
            int first=-1;
            int last=-1;
            for(int k=0;k<s.length();k++)
            {
                if(ch==s.charAt(k))
                {
                    if(first==-1)
                    {
                        first=k;
                    }
                    else
                    {
                        last=k;
                    }
                }
            }
            HashSet<Character> between=new HashSet<>();// no need to use clear as everytome new one is defined
            if(first!=-1&& last!=-1)
            {
                for(int i=first+1;i<last;i++)
                {
                    between.add(s.charAt(i));
                }
                ans+=between.size();
            }
        }
        return ans;

    }
}