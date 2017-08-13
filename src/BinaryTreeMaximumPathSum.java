/**
 * Created by mengfanshan on 2017/8/12.
 * Given a binary tree, find the maximum path sum.

 For this problem,
 a path is defined as any sequence of nodes from some starting
 node to any node in the tree along the parent-child connections.
 The path must contain at least one node and does not need to go through the root.

 For example:
 Given the below binary tree,

 1
 / \
 2   3
 Return 6.
 */
public class BinaryTreeMaximumPathSum {

    public static void main(String[] args)
    {
        TreeNode root=new TreeNode(2);
        TreeNode left=new TreeNode(-1);
        TreeNode right=new TreeNode(3);
        root.left=left;
       // root.right=right;
        System.out.println(maxPathSum(root));

    }
    static int maxpath=Integer.MIN_VALUE;
    public static int getMaxValue(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int leftmax=Math.max(0,getMaxValue(root.left));
        int rightmax=Math.max(0,getMaxValue(root.right));
        int maxsum=leftmax+rightmax+root.val;
        if(maxsum>maxpath)
        {
            maxpath=maxsum;
        }
        return Math.max(leftmax,rightmax)+root.val;
    }
    public static int maxPathSum(TreeNode root) {
        maxpath=Integer.MIN_VALUE;
        getMaxValue(root);
        return maxpath;
    }
}
