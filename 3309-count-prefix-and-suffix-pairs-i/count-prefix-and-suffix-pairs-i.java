//TC=N2
//SC=o(1)

class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count=0;
        for(int i=0;i<words.length;i++)
        {
            for(int j=i+1;j<words.length;j++)
            {
                if(words[j].contains(words[i]))
                {
                    int n=words[i].length();
                    String prefix=words[j].substring(0,n);
                    String suffix=words[j].substring(words[j].length()-n,words[j].length());
                    if((prefix.equals(words[i]))&&(suffix.equals(words[i])))
                    {
                        count++;
                    }

                }
            }
        }
        return count;
    }
}