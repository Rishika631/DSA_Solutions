class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();//TC-n
        s=s.replaceAll("\\s+","");//TC-n or worst case exponential but this case n
        int right=s.length()-1;
        for(int i=0;i<s.length();i++)
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
//TC-> n^2
//SC->const or O(1)