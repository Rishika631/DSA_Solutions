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
// class Solution {
//     public int repeatedNTimes(int[] nums) {
//         int[] arr=new int[10000];
//         for(int i=0;i<nums.length;i++)
//         {
//             if(arr[nums[i]]==1)
//             {
                
//                 return nums[i];
//             }
//             else
//             {
//                 arr[nums[i]]=1;
//             }
//         }
//         return -1;// never reach this 
//     }
// }


//time-n
//space-const fully
// if 50% filled with n repeating wala num then we have to put it i-2 ya i-1 place pr ek na ek baari so just check that just one edge case if size of array is 4 then fails so it will be at the edge of the array the repeating ele so return that
class Solution {
    public int repeatedNTimes(int[] nums) {
        for(int i=2;i<nums.length;i++)
        {
            if(nums[i]==nums[i-1]|| nums[i]==nums[i-2])
            {
                return nums[i];
            }
        }
        return nums[0];// upar wala sab handle  kar lega n this will handle for size array 4
    }
}