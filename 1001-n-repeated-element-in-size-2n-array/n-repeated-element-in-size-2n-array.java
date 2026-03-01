// brute force 
//time=n^2
//space-const

// class Solution {
//     public int repeatedNTimes(int[] nums) {
//         int n=nums.length/2;
//         int ans=0;
//         for(int i=0;i<=n;i++)
//         {
//             int count=0;
//             for(int j=0;j<n+2;j++)
//             {
//                 if(nums[i]==nums[j])
//                 {
//                     count++;
//                 }
//             }
//             if(count>1)
//             {
//                 ans=nums[i];
//                 break;
//             }
//         }
//         return ans;
//     }
// }

// space-n
//time-n
// class Solution {
//     public int repeatedNTimes(int[] nums) {
//         int n=nums.length/2;
//         int ans=0;
//         HashSet<Integer> hs=new HashSet<>();
//         for(int i=0;i<=n+1;i++)// as n+1 unique values so need 1 extra so any ele comes twice
//         {
//             if(hs.contains(nums[i]))
//             {
//                 ans=nums[i];
//                 break;
//             }
//             else
//             {
//                 hs.add(nums[i]);
//             }
//         }
//         return ans;
//     }
// }

// space-const space approach as 10^4 const
//time-n
class Solution {
    public int repeatedNTimes(int[] nums) {
        int[] arr=new int[10000];
        for(int i=0;i<nums.length;i++)
        {
            if(arr[nums[i]]==1)
            {
                
                return nums[i];
            }
            else
            {
                arr[nums[i]]=1;
            }
        }
        return -1;// never reach this 
    }
}