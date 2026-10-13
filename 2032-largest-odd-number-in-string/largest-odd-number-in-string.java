class Solution {
    public String largestOddNumber(String num) {
        int start=0;
        int last=num.length()-1;
        String ans="";
        while(start<=last)
        {
            if(num.charAt(start)=='0')
            {
                start++;
            }
            else if((int)(num.charAt(last))%2==0)
            {
                last--;
            }
            else
            {
                return num.substring(start,last+1);
            }
        }
        return ans;
    }
}
//TC-> o(n)
//SC-> const