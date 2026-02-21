//we have the special string so we will take the inner string see in recurssion if it gives the best string and so one and return the best one we will check the sum==0 to find the 
//special string and then keep track of index to have consecutive strings
//Time=n(for loop)+T(n-2)+sorting
//n+n-2+t(n-4)+sorting...=(n+n+..)-2(1+2+3...)+sorting=approx(n^2)
//[(1+2+3.. )->n(n+1)/2
//space-n(for list)- that is only used at one point of recursion

class Solution {
    public String makeLargestSpecial(String s) {
        List<String> specials=new ArrayList<>();
        int sum=0;
        int start=0;
        String result="";
        for(int i=0;i<s.length();i++)
        {
            sum+=(s.charAt(i)=='1')?1:-1;
            if(sum==0)
            {
                String innerstring=s.substring(start+1,i);//leaving start 1 and end 0
                specials.add("1"+makeLargestSpecial(innerstring)+"0");
                start=i+1;
            }

        }
        Collections.sort(specials, Collections.reverseOrder()); // to get in lexicographical order
        for(String str:specials)
        {
            result+=str;
        }
        return result;
    }
}