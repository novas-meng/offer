import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mengfanshan on 2017/7/11.
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Print {
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
        Print(null);
    }
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res=new ArrayList();
        if(pRoot==null)
        {
            return res;
        }
        Queue<TreeNode> nodeQueue=new LinkedList<>();
        nodeQueue.add(pRoot);
        Queue<TreeNode> temp=new LinkedList<>();
        int index=1;
        while (true)
        {
            ArrayList<Integer> integerArrayList=new ArrayList<>();
            while (!nodeQueue.isEmpty())
            {
                TreeNode node=nodeQueue.poll();
                integerArrayList.add(node.val);
                if(node.left!=null)
                {
                    temp.add(node.left);
                }
                if(node.right!=null)
                {
                    temp.add(node.right);
                }

            }
            if(index%2==0)
            {
                ArrayList<Integer> list=new ArrayList<>();
                for (int i=integerArrayList.size()-1;i>=0;i--)
                {
                    list.add(integerArrayList.get(i));
                }
                integerArrayList=list;
            }
            res.add(integerArrayList);
            index++;
            nodeQueue.clear();
            if(temp.size()==0)
                break;
            nodeQueue.addAll(temp);
            temp.clear();
        }
        return res;
    }
}
