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

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] req = new int[26];
        for (String word : words2) {
            int[] cur = new int[26];
            for (char c : word.toCharArray()) {
                cur[c - 'a']++;
                req[c - 'a'] = Math.max(req[c - 'a'], cur[c - 'a']);
            }
        }
        
        List<String> ans = new ArrayList<>();
        for (String word : words1) {
            int[] cur = new int[26];
            for (char c : word.toCharArray()) cur[c - 'a']++;
            
            boolean isValid = true;
            for (int i = 0; i < 26; i++) {
                if (cur[i] < req[i]) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) ans.add(word);
        }
        
        return ans;
    }
}