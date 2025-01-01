class Solution {
    public int maxScore(String s) {
    int totalones=0;
    int max=0;
    int zeroes=0;
    int ones=0;
        for (int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
            {
            totalones++;
            }
        }
        for(int j=0;j<s.length()-1;j++)
        {
            if(s.charAt(j)=='0')
            {
                zeroes++;
            }
            else
            {
            ones++;
            }
            int score=zeroes+(totalones-ones);
            if(max<score)
            {
            max=score;
            }
            score=0;

        }
        return max;
        }
}
//time complexity o(2n)
//space complexity o(1)