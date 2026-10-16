class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] alphat=new char[256];
        char[] alphas=new char[256];
        for(int i=0;i<s.length();i++)
        {
            if(alphas[s.charAt(i)-'\u0000']!='\u0000' && t.charAt(i)!=alphas[s.charAt(i)-'\u0000'])
            {
                return false;
            }
            else
            {
                alphas[s.charAt(i)-'\u0000']=t.charAt(i);
            }
        }
        for(int i=0;i<t.length();i++)
        {
            if(alphat[t.charAt(i)-'\u0000']!='\u0000' && s.charAt(i)!=alphat[t.charAt(i)-'\u0000'])
            {
                return false;
            }
            else
            {
                alphat[t.charAt(i)-'\u0000']=s.charAt(i);
            }
        }
        return true;
    }
}
//TC->o(n)
//SC->const as char array const