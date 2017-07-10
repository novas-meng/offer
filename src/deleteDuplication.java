import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Created by mengfanshan on 2017/7/10.
 * 在一个排序的链表中，存在重复的结点，
 * 请删除该链表中重复的结点，重复的结点不保留，
 * 返回链表头指针。 例如，链表1->2->3->3->4->4->5
 * 处理后为 1->2->5
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
    首先定义
     */
    public static ListNode deleteDuplication(ListNode pHead)
    {
        ListNode head=new ListNode(-1);
        head.next=pHead;
        ListNode p=head;
        while (p.next!=null)
        {
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
