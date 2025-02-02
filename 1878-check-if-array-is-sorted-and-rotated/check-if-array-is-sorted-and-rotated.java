//TC=3n----O(n)
//SC=n as array
//My approach correct but more space

// class Solution {
//     public boolean check(int[] nums) {
//         int[] b=new int[nums.length];
//         int x=0;
//         for(int i=0;i<nums.length-1;i++)
//         {
//             if(nums[i+1]<nums[i])
//             {
//                 x=i+1;
//                 break;
//             }
//         }
//         for(int j=0;j<nums.length;j++)
//         {
//            b[j]=nums[(j+x)%nums.length];
//         }
//         for(int j=0;j<b.length-1;j++)
//         {
//            if(b[j]>b[j+1])
//            {
//             return false;
//            }
//         }
//         return true;
//     }
// }

//editorial approach
//better appraoch as sc is o(1) means const with tc=o(n)
class Solution {

    public boolean check(int[] nums) {
        int n = nums.length;
        if (n <= 1) return true;

        int inversionCount = 0;

        // For every pair, count the number of inversions.
        for (int i = 1; i < n; ++i) {
            if (nums[i] < nums[i - 1]) {
                ++inversionCount;
            }
        }

        // Also check between the last and the first element due to rotation
        if (nums[0] < nums[n - 1]) {
            ++inversionCount;
        }

        return inversionCount <= 1;//< for all ele same num in array like[1,1,1,1]
    }
}