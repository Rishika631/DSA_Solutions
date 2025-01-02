//Brute Force
//TC=n2
//SC=const as ans is given in ques
// class Solution {
//     public int[] vowelStrings(String[] words, int[][] queries) {
//         int[] ans=new int[queries.length];
//         for(int i=0;i<queries.length;i++)
//         {
//             int start=queries[i][0];
//             int end=queries[i][1];
//             for(int j=start;j<=end;j++)
//             {
//                 int len=words[j].length();
//                 if((words[j].charAt(0)=='a'||words[j].charAt(0)=='e'||words[j].charAt(0)=='i'||words[j].charAt(0)=='o'||words[j].charAt(0)=='u')&&(words[j].charAt(len-1)=='a'||words[j].charAt(len-1)=='e'||words[j].charAt(len-1)=='i'||words[j].charAt(len-1)=='o'||words[j].charAt(len-1)=='u'))
//                 {
//                     ans[i]++;
//                 }
//             }

//         }
//         return ans;
//     }
// }
// [0,1,2,3,4]// normal array
// [0,1,1,2,3,4]// prefix array is always jo normal array ka number hai usko chod like array=a[1] then prefix array will have a[0] only not a[1]

//TC=2n
//SC=n as ans wala is output given
class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefix=new int[words.length+1];
        int[] ans=new int[queries.length];
        prefix[0]=0;
        for(int i=0;i<words.length;i++)
        {
            int len=words[i].length();
            if((words[i].charAt(0)=='a'||words[i].charAt(0)=='e'||words[i].charAt(0)=='i'||words[i].charAt(0)=='o'||words[i].charAt(0)=='u')&&(words[i].charAt(len-1)=='a'||words[i].charAt(len-1)=='e'||words[i].charAt(len-1)=='i'||words[i].charAt(len-1)=='o'||words[i].charAt(len-1)=='u'))
                {
                    prefix[i+1]=prefix[i]+1;
                }
            else
            {
                prefix[i+1]=prefix[i];
            }
        }
        for(int j=0;j<queries.length;j++)
        {
            int start=queries[j][0];
            int end=queries[j][1];
            ans[j]=prefix[end+1]-prefix[start];
        }
        return ans;
        }
}

// best approach
//TC=2n
//SC=n as ans wala is output given
// class Solution {
//     public int[] vowelStrings(String[] words, int[][] queries) {
//         int n = words.length;
//         int[] count = new int[n + 1]; // Prefix array to store cumulative counts of vowel strings
        
//         // Constructing the prefix array
//         for (int i = 0; i < n; i++) {
//             if (isVowelString(words[i])) { // Efficient modular check
//                 count[i + 1]++; // Increment if the word is a vowel string
//             }
//         }
        
//         // Accumulating counts for prefix sum
//         for (int i = 1; i <= n; i++) {
//             count[i] += count[i - 1]; // Add the previous count for cumulative sum
//         }
        
//         // Processing the queries
//         int[] res = new int[queries.length];
//         int i = 0; // Result array index
//         for (int[] q : queries) { // Enhanced for-loop improves readability and avoids manual indexing
//             int l = q[0];
//             int r = q[1];
//             res[i++] = count[r + 1] - count[l]; // Difference in prefix sums gives the result for the range
//         }
        
//         return res; // Return the result array
//     }
    
//     // Helper method to check if a string starts and ends with a vowel
//     public boolean isVowelString(String str) {
//         return isVowel(str.charAt(0)) && isVowel(str.charAt(str.length() - 1)); // Clear separation of concerns
//     }
    
//     // Helper method to check if a character is a vowel
//     public boolean isVowel(char ch) {
//         return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'; // Compact and efficient
//     }
// }

