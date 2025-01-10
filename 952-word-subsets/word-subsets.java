// //Brute force ------ TLE
// //TC=n3
// //SC=n
// class Solution {
//     public List<String> wordSubsets(String[] words1, String[] words2) {
//         int counter=1;
//         String[] words11=Arrays.copyOf(words1, words1.length);
//         List<String> ans=new ArrayList<String>();
//         for(int i=0;i<words1.length;i++)
//         {
//             words11[i]=words1[i];
//             for(int j=0;j<words2.length;j++)
//             {
//                 char[] arr=words2[j].toCharArray();
//                 for(int k=0;k<arr.length;k++)
//                 {
//                 String s=Character.toString(arr[k]);
//                 if(words11[i].contains(s))
//                 {
//                     words11[i]=words11[i].replaceFirst(s,"*");
//                 }
//                 else
//                 {
//                     counter=0;
//                     break;
//                 }
//                 }
//                 words11[i]=words1[i];
//             }
//             if(counter==1)
//             {
//                 ans.add(words1[i]);
//             }
//             counter=1;
//         }
//         return ans;

        
//     }
// }
// for this approach we just take from all the substring words how many times a char is max called like in one substring how many times a single char is used and is that the max count of that char for one substring
// [ee, eeeo]
//so for this it does not matter in which substring e is there not we just need to know that the max amount of times e is occuring for a substring from all substring is equal to or grester than the no. of times e is occuring in the words1 string.
//TC=n2---- words2.length(26+m(max length string of words2))+words1.length(26+m(max length string of words1))
//SC=n
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        boolean flag=true;
        List<String> ans=new ArrayList<String>();
        int[] req=new int[26];
        for(String substring: words2)
        {
            int[] curr=new int[26];
            char[] arr=substring.toCharArray();
            for(char ch:arr)
            {
                curr[ch-'a']++;
            }
            for(int i=0;i<26;i++)
            {
                req[i]=Math.max(curr[i],req[i]);
            }

        }

        for(String words: words1)
        {
            int[] curr=new int[26];
            char[] arr=words.toCharArray();
            for(char ch:arr)
            {
                curr[ch-'a']++;
            }
            for(int i=0;i<26;i++)
            {
                if(curr[i]<req[i])
                {
                    flag=false;
                    break;
                }
            }
            if(flag)
            {
                ans.add(words);
            }
            flag=true;

        }
        return ans;
    }
}