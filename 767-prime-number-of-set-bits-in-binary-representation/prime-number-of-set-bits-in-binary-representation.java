class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count=0;

        for(int i=left;i<=right;i++)
        {
            String temp=Integer.toBinaryString(i);
            int setBits=0;
            for(int j=0;j<temp.length();j++)
            {
                if(temp.charAt(j)=='1')
                {
                    setBits++;
                }
            }
            if(isPrime(setBits))
            {
                count++;
            }
        }
        return count;
    }

    public boolean isPrime(int num)
    {
        if(num==1)
        {
            return false;
        }
        for(int i=2;i*i<=num;i++)
        {
            if(num%i==0)
            {
                return false;
            }
        }
        return true;
    }
}