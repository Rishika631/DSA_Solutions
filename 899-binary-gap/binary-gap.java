class Solution {
    public int binaryGap(int n) {
        String str=Integer.toBinaryString(n);
        int len=str.length();
        int result=Integer.MIN_VALUE;
        int i=0;
        int start=0;//only works if not leading zeroes
        while(i<len)
        {
            if(str.charAt(i)=='1')
            {
                result=Math.max(result,i-start);
                start=i;
            }
            i++;
        }
        return result;
    }
}