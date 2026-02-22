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
 //dfs-recursion
 //time-n- for dfs goes to every node
 //space-o(n)-hashset
// class FindElements {
//     HashSet<Integer> hs=new HashSet<>();

//     public void dfs(TreeNode root, int num, HashSet<Integer> hs)
//     {
//         if(root==null)
//         {
//             return;
//         }
//         root.val=num;
//         hs.add(num);
//         dfs(root.left, 2*num+1, hs);
//         dfs(root.right, 2*num+2, hs);
//     }

//     public FindElements(TreeNode root) {

//         hs.clear();
//         dfs(root, 0, hs);

//     }
    
//     public boolean find(int target) {
//         return hs.contains(target);
//     }
// }

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */

//bfs
//space-2n (one for queue and one for hs)
//time-n(all nodes)
 class FindElements {
    HashSet<Integer> hs=new HashSet<>();

    public void bfs(TreeNode root, int num, HashSet<Integer> hs)
    {
        Queue<TreeNode> que=new LinkedList<>();//queue so root then left then right then left ka left n all
        root.val=num;
        que.add(root);
        while(!que.isEmpty())
        {
            TreeNode temp=que.remove();
            int val=temp.val;
            hs.add(val);

            if(temp.left !=null)
            {
                temp.left.val=2*val+1;
                que.add(temp.left);
            }
            if(temp.right !=null)
            {
                temp.right.val=2*val+2;
                que.add(temp.right);
            }
        }
    }

    public FindElements(TreeNode root) {

        hs.clear();
        bfs(root, 0, hs);

    }
    
    public boolean find(int target) {
        return hs.contains(target);
    }
}
