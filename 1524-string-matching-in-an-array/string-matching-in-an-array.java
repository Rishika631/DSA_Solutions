//Brute force
//TC=2N
//SC=N
class Solution {
    public List<String> stringMatching(String[] words) {
        HashSet<String> hs=new HashSet<String>();
        String big="";
        for(int i=0;i<words.length;i++)
        {
            big=big+words[i]+"*";
            String check=big;
            check=check.replaceFirst(words[i],"");
            if(check!=null&&check.contains(words[i]))
            {
                hs.add(words[i]);
            }
        }
        big="";
        for(int i=words.length-1;i>=0;i--)
        {
            big=big+words[i];
            String check=big;
            check=check.replaceFirst(words[i],"");
            if(check!=null&&check.contains(words[i]))
            {
                hs.add(words[i]);
            }
        }
        List<String> ans=new ArrayList<String>(hs);
        return ans;
    }
}