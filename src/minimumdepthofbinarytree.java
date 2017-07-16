import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mengfanshan on 2017/7/16.
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path
 * from the root node down to the nearest leaf node.
 *
 * 使用队列进行处理
 */
public class minimumdepthofbinarytree {

    public int run(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int count=0;
        while (true)
        {
            Queue<TreeNode> temp=new LinkedList<>();
            count++;
            while (!queue.isEmpty())
            {
                TreeNode parent=queue.poll();
                if(parent.left!=null)
                {
                    temp.add(parent.left);
                }
                if(parent.right!=null)
                {
                    temp.add(parent.right);
                }
                if(parent.left==null&&parent.right==null)
                {
                    return count;
                }
            }
            if(temp.size()==0)
            {
                break;
            }
            queue.clear();
            queue.addAll(temp);
        }
        return 0;
    }
}
