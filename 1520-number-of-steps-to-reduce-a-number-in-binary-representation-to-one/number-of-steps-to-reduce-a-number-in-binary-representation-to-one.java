
// // won't work as 500 len for string andnot possible to store that in int
// //time-n^2(two while loops could be logn for first while loop but adding  for odd so increment so n worst case)
// //space-const
// class Solution {
//     public int binaryStringToInt(String s)
//     {
//         int num=0;
//         int len=s.length();
//         for(int i=0;i<len;i++)
//         {
//             num=num<<1|(s.charAt(i)-'0');
//         }
//         return num;
//     }
//     public int numSteps(String s) {
//         int count=0;
//         int num=binaryStringToInt(s);
//         // int num=Integer.valueOf(s,2);
//         while(num!=1){
//             if((num&1)==1)//odd
//             {
//                 int m=1;
//                 while((num&m)!=0)
//                 {
//                     num=num^m;// flip the mth digit or say 1st loop last then second last n so on
//                     m<<=1;// basically carry 1
//                 }
//                 num=num^m;// final num jaise hi 0 mila usko flip kara 
//                 count++;
//             }
//             System.out.println(num);
//             num>>=1;
//             count++;
//         }
//         return count;
//     }
// }

//brute force 2.0 through string
//time-n^2(two while loop)
//space-n(string builder)
// class Solution {
//     public void addOne(StringBuilder sb)
//     {
//         int i=sb.length()-1;
//         while(i>=0&&sb.charAt(i)!='0')
//         {
//             sb.setCharAt(i,'0');
//             i--;
//         }
//         if(i<0)
//         {
//             sb.insert(0, "1");
//         }
//         else
//         {
//             sb.setCharAt(i,'1');
//         }
//     }
//     public int numSteps(String s) {
//         int count=0;
//         StringBuilder sb=new StringBuilder(s);
//         while(sb.length()>1)
//         {
//             if(sb.charAt(sb.length()-1)=='1')// odd then only add 1 no divide
//             {
//                 addOne(sb);
//             }
//             else
//             {
//                 sb.deleteCharAt(sb.length()-1);// even then divide 
//             }
//             count++;
//         }
//         return count;
//     }
// }


//optimised approach
// if bit is even then 1 operation else 2 for odd and carry 1 and plus 1 hoga so wo aagwey ki upar wali bits mai jayega 
//time-n(one for loop)
//space-const
class Solution {
    public int numSteps(String s) {
        int count=0;
        int carry =0;
        int len=s.length();
        for(int i=len-1;i>0;i--)
        {
            if((s.charAt(i)+carry)%2==0)//even
            {
                count++;//we don't reset carry here as it helps to keep even bits addition as even
            }
            else//odd
            {
                carry=1;
                count+=2;
            }
        }
        return count+carry;
    }
}



