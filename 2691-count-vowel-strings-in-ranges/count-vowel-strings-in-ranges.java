//brute force
//time-n^2- two for loops
//space=const as ans mentioned in question

// class Solution {
//     public int[] vowelStrings(String[] words, int[][] queries) {
//         int n=queries.length;
//         int ans[]=new int[n];
//         for(int i=0;i<n;i++)
//         {
//             int count=0;
//             for(int j=queries[i][0];j<=queries[i][1];j++){
//                 int len=words[j].length();
//                 if("aeiouAEIOU".indexOf(words[j].charAt(0))!=-1 && "aeiouAEIOU".indexOf(words[j].charAt(len-1))!=-1)
//                 {
//                     count++;
//                 }
//             }
//             ans[i]=count;
//         }
//         return ans;
//     }
// }

//optimised 

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n=queries.length;
        int ans[]=new int[n];
        int prefix[]=new int[words.length];

        prefix[0]=("aeiouAEIOU".indexOf(words[0].charAt(0))!=-1 && "aeiouAEIOU".indexOf(words[0].charAt(words[0].length()-1))!=-1)?1:0;


        for(int i=1;i<words.length;i++)
        {
            int len=words[i].length();
            if("aeiouAEIOU".indexOf(words[i].charAt(0))!=-1 && "aeiouAEIOU".indexOf(words[i].charAt(len-1))!=-1)
            {
                prefix[i]=prefix[i-1]+1;
            }
            else
            {
                prefix[i]=prefix[i-1];
            }
        }
        for(int i=0;i<n;i++)
        {
            int start=queries[i][0]==0?0:prefix[queries[i][0]-1];
            int end=prefix[queries[i][1]];
            ans[i]=end-start;
        }
        return ans;
    }
}