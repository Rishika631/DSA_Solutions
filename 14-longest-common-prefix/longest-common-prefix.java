class Solution {    
    public String longestCommonPrefix(String[] strs) {
        String ans="";
        int start=0;
        int minlen=Integer.MAX_VALUE;
        for(String s:strs)
       {
        if(minlen>s.length())
        {
            minlen=s.length();
        }
       }
       while(start<minlen)
       {
       char currChar=strs[0].charAt(start);
       for(String s:strs)
       {
        if(currChar!=s.charAt(start))
        {
            return ans;
        }
       }
       ans=ans+currChar;
       start++;
       }
       return ans;
    }
}
//TC-> O(str.length()*minlen string size)
//SC->const