import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Created by mengfanshan on 2017/7/10.
 * ��һ������������У������ظ��Ľ�㣬
 * ��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻������
 * ��������ͷָ�롣 ���磬����1->2->3->3->4->4->5
 * �����Ϊ 1->2->5
 */
public class deleteDuplication
{
    public static void main(String[] args)
    {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(1);
        ListNode node3=new ListNode(1);
        ListNode node4=new ListNode(1);
        ListNode node5=new ListNode(1);
        ListNode node6=new ListNode(1);
        ListNode node7=new ListNode(1);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        ListNode head=deleteDuplication(node1);
        while (head!=null)
        {
            System.out.println(head.val);
            head=head.next;
        }

    }
    /*
    ���ȶ���p�ڵ㣬p�ڵ�ĺ����ǣ���headͷ�ڵ㣬��p�ڵ�֮��Ľڵ㣬���ǲ��ظ���
     */
    public static ListNode deleteDuplication(ListNode pHead)
    {
        ListNode head=new ListNode(-1);
        head.next=pHead;
        ListNode p=head;
        while (p.next!=null)
        {
            //ȡp�ڵ���������ڵ㣬q,m,���q��m��ֵ��һ������ôq�϶�������ģ���Ϊ�����m�ڵ����᲻����ڽڵ��mһ��
            //���q��m��ֵһ������ô˵�� q m ������Ҫ��ɾ���ģ�����m����Ľڵ�Ҳ���ܱ�ɾ��������
            //��m�ڵ��������Ѱ�ң�ֱ���ҵ���q m�ڵ㲻ͬ��ֵ��Ȼ���p.next ָ���Ǹ��ڵ㣬��ʾ��q m ��Щ��ֵһ���Ľڵ������ɾ��
            //��Ҫע��߽����⼴��
            ListNode q=p.next;
            ListNode m=q.next;
            if(m==null)
            {
                break;
            }
            if(q.val==m.val)
            {
                while (m.next!=null&&m.next.val==q.val)
                {
                    m=m.next;
                }
                p.next=m.next;
            }
            else
            {
                p=p.next;
            }
        }
        return head.next;
    }

}
