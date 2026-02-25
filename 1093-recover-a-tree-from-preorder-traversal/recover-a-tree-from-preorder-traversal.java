/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//time- o(n)-n-length of string- it will go check counts of dash but that is still less than n as each node at max 2 recursive call & loop for dash count which is still no n times as 2k(no. of nodes-k)<length of string as dashes also there and i only move once so in each recursive call it won't go through full string just dashes so nopt full n and it would be const so O(n)
// just say i only iterate obnce through the string 
// if it do scan dashes multiple imes it is still const as each time same no. of times in the loop scan so that's why not changes if n changes if it was 3 it will always be 3 even if I increase string length
//space=O(n)- for recursive stack store each node so(k-no of nodes) but if no dashes then directly n like if only one node then o(n) so that's why

// class Solution {
//     int i=0;// if global do not pass in method as parameter otherwise it will update that local and use that only for further but new recursive call again use the global
//     //either if passing as parameter use array //better method to avoid confusion
//     int depth=0;
//     public TreeNode solve(int depth, String s){
//         System.out.println(depth);
//         int n=s.length();
        
//         if(i>=n)
//         {
//             return null;
//         }

//         int j=i;
//         while(j<n && s.charAt(j)=='-')
//         {
//             j++;
//         }
//         // System.out.println(j);
//         int dash=j-i;
//         if(dash!=depth)
//         {
//             return null;
//         }
//         int num=0;
//         i=i+dash;
//         while(i<n && Character.isDigit(s.charAt(i)))
//         {
//             num=num*10+(s.charAt(i)-'0');
//             i++;
//         }
//         TreeNode root=new TreeNode(num);

//         root.left=solve(depth+1, s);
//         root.right=solve(depth+1, s);

//         return root;
//     }
//     public TreeNode recoverFromPreorder(String traversal) {
//         return solve(depth, traversal);
//     }
// }

//Approach - Using Recursion (Simulation of DFS in Tree)
//T.C : O(n)
//S.C : O(n) for System Stack used for Recursion
class Solution {
    private int n;
    
    private TreeNode solve(String traversal, int[] index, int depth) {
        if (index[0] >= n) {
            return null;
        }
        
        int j = index[0];
        while (j < n && traversal.charAt(j) == '-') {
            j++;
        }
        
        int dash = j - index[0];
        
        if (depth != dash) {
            return null;
        }
        
        index[0] += dash;
        
        int value = 0;
        while (index[0] < n && Character.isDigit(traversal.charAt(index[0]))) {
            value = value * 10 + (traversal.charAt(index[0]) - '0');
            index[0]++;
        }
        
        TreeNode root = new TreeNode(value);
        root.left = solve(traversal, index, depth + 1);
        root.right = solve(traversal, index, depth + 1);
        
        return root;
    }
    
    public TreeNode recoverFromPreorder(String traversal) {
        n = traversal.length();
        int[] index = {0}; // Using an array to pass by reference
        return solve(traversal, index, 0);
    }
}