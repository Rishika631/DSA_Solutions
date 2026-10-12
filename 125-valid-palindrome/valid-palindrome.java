// class Solution {
//     public boolean isPalindrome(String s) {
//         // s=s.toLowerCase(); no new str created to copy it
//         int start=0;
//         int last=s.length()-1;
//         while(start<=last)
//         {
//             if(!Character.isLetterOrDigit(s.charAt(start)))
//             {
//                 start++;
//             } else if(!Character.isLetterOrDigit(s.charAt(last)))
//             {
//                 last--;
//             }
//             else
//             {
//                 if(Character.toLowerCase(s.charAt(start))!=Character.toLowerCase(s.charAt(last)))//O(1) or string lower case ek sath n no impact much in TC but better if do it with char 
//                 {
//                     return false;
//                 }
//                 start++;
//                 last--;
//             }
//         }
//         return true;
//     }
// }
//TC->O(n)
//SC->const

class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();//TC-n
        s=s.replaceAll("\\s+","");//TC-n or worst case exponential but this case n
        int right=s.length()-1;
        for(int i=0;i<s.length() && i<=right;i++)
        {
            if(Character.isLetterOrDigit(s.charAt(i)) && Character.isLetterOrDigit(s.charAt(right)))
            {
            if(s.charAt(i)!=s.charAt(right))
            {
                return false;
            }
            right--;
            }
            else if(Character.isLetterOrDigit(s.charAt(i)) && !Character.isLetterOrDigit(s.charAt(right)))//Character.isLetterOrDigit(s.charAt(i)) tc is O(1)
            {
                while(!Character.isLetterOrDigit(s.charAt(right)))
                {
                    right--;
                }
            if(s.charAt(i)!=s.charAt(right))
            {
                return false;
            }
            right--;
            }
        }
        return true;
    }
}
// //TC-> n( as inner while loop does not reset each time so it is basically n+n)
// //SC->const or O(1)