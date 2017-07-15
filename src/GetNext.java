/**
 * Created by mengfanshan on 2017/7/11.
 * 给定一个二叉树和其中的一个结点
 * 请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，
 * 同时包含指向父结点的指针。
 */
public class GetNext {
    public static void main(String[] args)
    {

    }
    /*

     */
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode.right!=null)
        {
            TreeLinkNode p=pNode.right;
            while (p.left!=null)
            {
                p=p.left;
            }
            return p;
        }
        else
        {
            while (true)
            {
                TreeLinkNode parent=pNode.next;
                if(parent==null)
                {
                    return null;
                }
                if(parent.left==pNode)
                {
                    return parent;
                }
                else
                {
                    pNode=parent;
                }
            }
        }
    }
}
