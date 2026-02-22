//brute force 
//time-(right-left)*(log(num)+underroot(no. of set bits)))
//space- log right( no of bits in a num is log2(num)+1)
//when integer.bitCount then O(1) because int size is 32 bits fixed so const
// class Solution {
//     public int countPrimeSetBits(int left, int right) {
//         int count=0;

//         for(int i=left;i<=right;i++)
//         {
//             String temp=Integer.toBinaryString(i);
//             int setBits=0;
//             // int setBits=Integer.bitCount(i);
//             for(int j=0;j<temp.length();j++)
//             {
//                 if(temp.charAt(j)=='1')
//                 {
//                     setBits++;
//                 }
//             }
//             if(isPrime(setBits))
//             {
//                 count++;
//             }
//         }
//         return count;
//     }

    // public boolean isPrime(int num)
    // {
    //     if(num==1)
    //     {
    //         return false;
    //     }
    //     for(int i=2;i*i<=num;i++)
    //     {
    //         if(num%i==0)
    //         {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
// small optimisation left and right is from 1 to 10^6 given in ques
//means 2^10=1024 approx 10^3
//squaring both sides
//2^20=10^6 so for 10^6 digit num we need 20 bits and only at max 20 set bits can be there so check till 20 only for prime nums
//space-o(n)-hashset
//time-(right-left)*O(1)(it can be o(lognum) but intger.bitcount so const)
class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count=0;
        HashSet<Integer> hs=new HashSet<>(Arrays.asList(2,3,5,7,11,13,17,19));

        for(int i=left;i<=right;i++)
        {
            int setBits=Integer.bitCount(i);
            if(hs.contains(setBits))
            {
                count++;
            }
        }
        return count;
    }
    
}