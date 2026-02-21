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


//best approach
// what is happening is we have n elements and n length string so if we just change one bit for one ele in array then we can have
// a whole different number 
//time-n
//space-const
class Solution {
    
    public String findDifferentBinaryString(String[] nums) {
        String result="";
        for(int i=0;i<nums.length;i++)
        {
            result+=nums[i].charAt(i)=='1'? "0":"1";// this will discard that nums[i]
        }
        return result;

    }
}