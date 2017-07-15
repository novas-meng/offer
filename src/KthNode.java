import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by mengfanshan on 2017/7/11.
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。
 * 例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，
 * 按结点数值大小顺序第三个结点的值为4。
 */
public class KthNode {
    public static void main(String[] args)
    {
        TreeNode node1=new TreeNode(8);
        TreeNode node2=new TreeNode(6);
        TreeNode node3=new TreeNode(10);
        TreeNode node4=new TreeNode(5);
        TreeNode node5=new TreeNode(7);
        TreeNode node6=new TreeNode(9);
        TreeNode node7=new TreeNode(11);

        node1.left=node2;
        node1.right=node3;

        node2.left=node4;
        node2.right=node5;

        node3.left=node6;

        node3.right=node7;
        midTravel(node1);
        System.out.println();
    }
    public static void midTravel(TreeNode root)
    {
        ArrayList<TreeNode> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=root;
        while (!stack.isEmpty()||p!=null)
        {
            while (p!=null)
            {
                stack.add(p);
                p=p.left;
            }
            p=stack.pop();
            list.add(p);
            System.out.println(p.val);
            if(p.right!=null)
            {
                p=p.right;
            }
            else
            {
                p=null;
            }
        }
    }
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(k==0)
        {
            return null;
        }
        ArrayList<TreeNode> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=pRoot;
        while (!stack.isEmpty()||p!=null)
        {
            while (p!=null)
            {
                stack.add(p);
                p=p.left;
            }
            p=stack.pop();
            list.add(p);
            System.out.println(p.val);
            if(p.right!=null)
            {
                p=p.right;
            }
            else
            {
                p=null;
            }
        }
        if(k>list.size())
        {
            return null;
        }
        return list.get(k-1);
    }
}
