//TC=2n
//SC=n

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


// ror