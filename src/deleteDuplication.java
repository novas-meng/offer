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
    首先定义p节点，p节点的含义是，从head头节点，到p节点之间的节点，都是不重复的
     */
    public static ListNode deleteDuplication(ListNode pHead)
    {
        ListNode head=new ListNode(-1);
        head.next=pHead;
        ListNode p=head;
        while (p.next!=null)
        {
            //取p节点后面两个节点，q,m,如果q和m的值不一样，那么q肯定是满足的，因为不清楚m节点后面会不会存在节点和m一样
            //如果q和m的值一样，那么说明 q m 都是需要被删除的，而且m后面的节点也可能被删除，所以
            //在m节点依次向后寻找，直到找到与q m节点不同的值，然后把p.next 指向那个节点，表示把q m 这些数值一样的节点进行了删除
            //需要注意边界问题即可
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
