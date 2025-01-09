//TC=n*m as startswith will still compare chars
//SC=1
class Solution {
    public int prefixCount(String[] words, String pref) {
        int count=0;
        for(int i=0;i<words.length;i++)
        {
            if(words[i].startsWith(pref))
            {
                count++;
            }
        }
        return count;
    }
}