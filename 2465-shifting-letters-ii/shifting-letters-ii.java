//TC=N2
//SC=n because of stringbuilder
//Brute force
// class Solution {
//     public String shiftingLetters(String s, int[][] shifts) {
//         StringBuilder ans=new StringBuilder(s);
//         for(int i=0;i<shifts.length;i++)
//         {
//             int start=shifts[i][0];
//             int end=shifts[i][1];
//             int direction=shifts[i][2];
//             for(int j=start;j<=end;j++)
//             {
//                 if(direction==1&& ans.charAt(j)=='z')
//                 {
//                     ans.setCharAt(j,'a');
//                 }
//                 else if(direction==0&& ans.charAt(j)=='a')
//                 {
//                     ans.setCharAt(j,'z');
//                 }
//                 else if(direction==1)
//                 {
//                     char ch=ans.charAt(j);
//                     ch=(char)(ch+1);
//                     ans.setCharAt(j,ch);
//                     // s.replace(s.charAt(j),ch);---string immutable so can't do this has to use string builder and replace replaces all chars so not possible
//                 }
//                 else
//                 {
//                     char ch=ans.charAt(j);
//                     ch=(char)(ch-1);
//                     ans.setCharAt(j,ch);
//                 }
//             }
//         }
//         return ans.toString();
//     }
// }
//ace
//[0,0,0,0]
//[-1,0,1,0]
//[-1,1,1,-1]
//[0,2,2,-2]
//final prefix array[0,2,4,-2]
//TC=2n(shifts.length+s.length)
//SC=n( prefix n char array but only two arrays so linear no 2d array)
class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        long[] prefix=new long[s.length()+1];// this represents sum of the shifts like prefix[1]= no. of shifts for 1 is prefix[0]+prefix[1]
        for(int i=0;i<shifts.length;i++)
        {
            int val=shifts[i][2]==1?1:-1;
            prefix[shifts[i][0]]+=val;
            prefix[shifts[i][1]+1]-=val;
        }
        for(int j=1;j<s.length();j++)
        {
            prefix[j]+=prefix[j-1];//prefix array calc
        }
        char[] arr=s.toCharArray();
        for(int k=0;k<s.length();k++)
        {
            long val=((prefix[k]%26)+26)%26;// first mod for large value then second mod as when negative number so plus but if positive increase more than 26 so again mod
            int offset=(arr[k]-'a'+(int)val)%26;// for overlapping like z to a wagara we have %26 again here
            arr[k]=(char)('a'+offset);
        }
        return new String(arr);// arr.tostring will return memory reference so it doesnot work on arrays
    }
}


