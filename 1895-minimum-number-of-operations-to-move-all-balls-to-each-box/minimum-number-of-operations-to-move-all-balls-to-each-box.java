//Brute force
//TC=2n2
//SC=1 as ans is part of output
class Solution {
    public int[] minOperations(String boxes) {
        int[] ans=new int[boxes.length()];
        for(int i=0;i<boxes.length();i++)
        {
            for(int j=i+1;j<boxes.length();j++)
            {
                if(boxes.charAt(j)=='1')
                {
                    ans[i]+=j-i;
                }
            }
            if(i>0)
            {
            for(int j=i-1;j>=0;j--)
            {
                if(boxes.charAt(j)=='1')
                {
                    ans[i]+=i-j;
                }
            }
            }
        }
        return ans;
        
    }
}
//optimized approach see editorial good ques
// Input:
// boxes = "110"

// Explanation:
// Box indices: 
// 0
// ,
// 1
// ,
// 2
// 0,1,2.
// There are balls at indices 
// 0
// 0 and 
// 1
// 1.
// Left-to-Right Pass:
// i = 0:

// No moves yet; answer[0] += 0.
// Update: ballsToLeft = 1, movesToLeft = 1.
// i = 1:

// Moves from left: answer[1] += movesToLeft = 1.
// Update: ballsToLeft = 2, movesToLeft = 3.
// i = 2:

// Moves from left: answer[2] += movesToLeft = 3.
// Update: ballsToLeft = 2, movesToLeft = 5.
// Right-to-Left Pass:
// j = 2:

// No moves yet; answer[2] += 0.
// Update: ballsToRight = 0, movesToRight = 0.
// j = 1:

// Moves from right: answer[1] += movesToRight = 0.
// Update: ballsToRight = 1, movesToRight = 1.
// j = 0:

// Moves from right: answer[0] += movesToRight = 1.
// Update: ballsToRight = 2, movesToRight = 3.
// Final answer:
// [1, 1, 3]

// This indicates:

// Box 
// 0
// 0: 1 move.
// Box 
// 1
// 1: 1 move.
// Box 
// 2
// 2: 3 moves.
