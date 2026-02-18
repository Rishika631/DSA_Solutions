// brute force
//Time=n^2
//space=const
//i-> 0 to n-2 loop for diving string in substring
//1st inner for loop -> 0 to i-> no. of zeroes
//2nd for loop -> i+1 to n-1-> no. of ones
// class Solution {
//     public int maxScore(String s) {
//         int n=s.length();

//         int score=Integer.MIN_VALUE;
//         for(int i=0;i<=n-2;i++)
//         {
//             int zero=0;
//             int one=0;
//             for(int j=0;j<=i;j++)
//             {
//                 if(s.charAt(j)=='0')
//                 {
//                     zero++;
//                 }
//             }
//             for(int j=i+1;j<=n-1;j++)
//             {
//                 if(s.charAt(j)=='1')
//                 {
//                     one++;
//                 }
//             }
//             score=Math.max(score, zero+one);
//         }
//         return score;
//     }
// }

//2 pass soln
//calc total ones then do only one for loop and till that value check how many zeros and ones and then keep zeros and for ones on right just subtract ones from total ones 
//time=2n
//space=const

class Solution {
    public int maxScore(String s) {
        int n=s.length();
        int total_ones=0;
        int zero=0;
        int one=0;
        int score=Integer.MIN_VALUE;
        for(int i=0;i<=n-1;i++)
            {
                if(s.charAt(i)=='1')
                {
                    total_ones++;
                }
            }
        for(int i=0;i<=n-2;i++)
        {
            if(s.charAt(i)=='1')
            {
                one++;
            }else
            {
                zero++;
            }

            score=Math.max(score, zero+(total_ones-one));
        }
        return score;
    }
}