import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 * Created by mengfanshan on 2017/7/11.
 */
public class isSymmetrical {
    public static void main(String[] args)
    {
        TreeNode node1=new TreeNode(5);
        TreeNode node2=new TreeNode(5);
        TreeNode node3=new TreeNode(5);
        TreeNode node4=new TreeNode(5);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(5);
        TreeNode node7=new TreeNode(5);

        node1.left=node2;
        node1.right=node3;

        node2.left=node4;
        node3.right=node5;

        node4.left=node6;

        node5.left=node7;

        System.out.println(isSymmetrical(node1));
    }
   public static boolean  isSymmetrical(TreeNode pRoot)
    {
        Queue<TreeNode> nodeQueue=new LinkedList<>();
        nodeQueue.add(pRoot);
        Queue<TreeNode> temp=new LinkedList<>();
        while (true)
        {
            ArrayList<Integer> integerArrayList=new ArrayList<>();
            while (!nodeQueue.isEmpty())
            {
                TreeNode node=nodeQueue.poll();
                if(node==null)
                {
                    temp.add(null);
                    temp.add(null);
                    integerArrayList.add(-1);
                }
                else
                {
                    integerArrayList.add(node.val);
                    if(node.left==null)
                    {
                        temp.add(null);
                    }
                    else
                    {
                        temp.add(node.left);
                    }
                    if(node.right==null)
                    {
                        temp.add(null);
                    }
                    else
                    {
                        temp.add(node.right);
                    }
                }
            }
            int i=0;
            int j=integerArrayList.size()-1;
            for (int k=0;k<integerArrayList.size();k++)
            {
                System.out.println(integerArrayList.get(i));
            }
            System.out.println(temp.size());
            while (i<j)
            {
                if(integerArrayList.get(i)!=integerArrayList.get(j))
                {
                    return false;
                }
                i++;
                j--;
            }
            int nullcount=0;
            for (TreeNode key:temp)
            {
                if(key==null)
                {
                    nullcount++;
                }
            }
            System.out.println("nullcount:"+nullcount);
            if(nullcount==temp.size())
                break;
            nodeQueue.clear();
            nodeQueue.addAll(temp);
            temp.clear();
        }




        /*
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
            //System.out.println(p.val);
            integerArrayList.add(p.val);
            if(p.right!=null)
            {
                p=p.right;
            }
            else
            {
                p=null;
            }
        }
        */

        return true;
    }
    public static void midTrave(TreeNode pRoot)
    {

    }
}
