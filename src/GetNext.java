/**
 * Created by mengfanshan on 2017/7/11.
 * ����һ�������������е�һ�����
 * ���ҳ��������˳�����һ����㲢�ҷ��ء�
 * ע�⣬���еĽ�㲻�����������ӽ�㣬
 * ͬʱ����ָ�򸸽���ָ�롣
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
