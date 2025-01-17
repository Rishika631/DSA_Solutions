//TC=n as second loop is 26 so fixed so const time complexity
//SC=1 as 26 array is fixed size so const
//annabelle------odd= 1----- this means that min number of palindrome strings using all chars of s is no. of unique chars present like unique chars se upar wali values k k strings we can form 
//annabdelle-----odd=2------ 
//xor is same walo k 0 diff walo k 1
//for toggle back we will have to use xor operator
//Integrer.bitCount(oddcount)---to count set(1 bit) in binary value

class Solution {
    public boolean canConstruct(String s, int k) {
        int count=0;
        int[] letter=new int[26];
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            letter[ch-'a']++;
        }
        for(int j=0;j<26;j++)
        {
            if(letter[j]%2!=0)
            {
                count++;
            }
            if(count>k || s.length()<k)
            {
                return false;
            }
        }
        return true;
        
    }
}


