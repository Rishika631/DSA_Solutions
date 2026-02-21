//time-2^n(for recurrsion- each place takes 2 options and n string length so 2^n string possible)*n(for loop)*n(.equals)
//space=n

// class Solution {
//     public void backtrack(String[] nums, StringBuilder str, String[] result)
//     {
//         if(str.length()==nums.length)
//         {
//             for(int i=0;i<nums.length;i++)
//             {
//                 if(str.toString().equals(nums[i]))
//                 {
//                     return;
//                 }
//             }
//             result[0]=str.toString();
//             return;
//         }
//         for(int i=0;i<=1;i++)
//         {
//             if(result[0].length()==nums.length)
//             {
//                 break;
//             }
//             str.append(i);
//             backtrack(nums,str,result);
//             str.deleteCharAt(str.length()-1);

//         }
//     }
    
    
//     public String findDifferentBinaryString(String[] nums) {
//         StringBuilder str=new StringBuilder();
//         String[] result={""};
//         backtrack(nums,str, result);
//         return result[0];

//     }
// }


//basic approach
// convert all binary to decimal and store it in a set then run a for loop to know if that value is in a set with one more num like n=3 then run from 0 to 3 so 4 num so atleast 1 num will not be in 
// the set and return that num
class Solution {
    
    public String findDifferentBinaryString(String[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        int n=nums.length;
        for(String num:nums)
        {
            hs.add(Integer.parseInt(num,2));//convert string to binary integer
        }

        String result="";
        for(int i=0;i<=n;i++)//instead of n we can have (2^n -1) but we only need one value which is not there so no need to iterate over he whole bunch just iterate over first n num and with 0 it will be n+1 so it will have one extra num
        {
            if(!hs.contains(i))
            {
                result=Integer.toBinaryString(i);
            
            while(result.length()<n)
            {
                result="0"+result;
            }
            return result;
            }
        }     
        return "";

    }
}

//best approach
// what is happening is we have n elements and n length string so if we just change one bit for one ele in array then we can have
// a whole different number 
//time-n
//space-const
// class Solution {
    
//     public String findDifferentBinaryString(String[] nums) {
//         String result="";
//         for(int i=0;i<nums.length;i++)
//         {
//             result+=nums[i].charAt(i)=='1'? "0":"1";// this will discard that nums[i]
//         }
//         return result;

//     }
// }