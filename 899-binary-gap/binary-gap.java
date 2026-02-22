//bruteforce
//time-logn(binary str conversion) +log(n)(while loop is also running on string length which is number of bits to represent num) but for this ques we can say that none of the num will run more than 30 so const time
//n-10^9 which is 2^30 means 30 bits2^10- aprrox 103 cubes both sides and get above so max 30 bits
//space-const as binary string const space 32 bits

// class Solution {
//     public int binaryGap(int n) {
//         String str=Integer.toBinaryString(n);//logn + 1 time complexity as divide by 2 so num of bits// it gives no leading zeroes
//         int len=str.length();
//         int result=0;// best to keep 0 as int.min val will fail for cases 000 but we donot have that in input isliye it passes with int min also
//         int i=0;
//         int start=0;//only works if not leading zeroes
//         while(i<len)
//         {
//             if(str.charAt(i)=='1')
//             {
//                 result=Math.max(result,i-start);
//                 start=i;
//             }
//             i++;
//         }
//         return result;
//     }
// }

//bitwise methods
// for both time - const as 30 bits only and space const as nothing new we take
// class Solution {
//     public int binaryGap(int n) {
        
//         int result=0;
//         int curr=0;
//         int prev=-1;
//         while(n>0)
//         {
//             if((n&1)>0)//to check if the rightmost bit is set or not do n&1
//             {
//                 result=prev != -1?Math.max(result,curr-prev):result;
//                 prev=curr;
//             }
//             curr++;
//             n>>=1;// to right shift num by 1
//         }
//         return result;
//     }
// }
// same as above just for loop now from 0 to 31 as 30 bits max
class Solution {
    public int binaryGap(int n) {
        
        int result=0;
        int prev=-1;
        for(int curr=0;curr<32;curr++)
        {
            if(((n>>curr)&1)>0)//to check if the rightmost bit is set or not do n&1 basically doing that only just curr ko automatically for loop 
            // mai plus kar rhe n utta hi uss num to right shift kar rhe and phir uske sath and le k set bit check kar rhe 
            {
                result=prev != -1?Math.max(result,curr-prev):result;
                prev=curr;
            }
        }
        return result;
    }
}