/**
 * Created by mengfanshan on 2017/8/7.
 */
public class 链表中倒数第k个结点 {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode p=head;
        int count=0;
        while (p!=null)
        {
            count++;
            p=p.next;
        }
        if(k>count)
        {
            return null;
        }
        else
        {
            int index=count-k+1;
            for (int i=1;i<index;i++)
            {
                p=p.next;
            }
        }
        return p;
    }
}
