//first keep track of curr and prev count so whenever value switches just update prev with curr and curr with 1 and take min of both values before updating and add that to result as for consecutive string it will take min of both the values 
class Solution {
    public int countBinarySubstrings(String s) {
        int prevCount=0;
        int currCount=1;
        int result=0;
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)==s.charAt(i-1))
            {
                currCount++;
            }
            else
            {
                result+=Math.min(prevCount,currCount);
                prevCount=currCount;
                currCount=1;
            }
        }
        return result+Math.min(prevCount,currCount);// last one will be left as as just ++ no adding to result
    }
}