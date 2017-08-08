/**
 * Created by mengfanshan on 2017/8/7.
 */
public class ·´×ªÁ´±í {
    public ListNode ReverseList(ListNode head) {
        ListNode phead=new ListNode(-1);
        ListNode p=head;
        while (p!=null)
        {
            ListNode q=p.next;
            p.next=phead.next;
            phead.next=p;
            q=p;
        }
        return phead.next;
    }
}
