/**
 * Created by mengfanshan on 2017/8/7.
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class 合并两个排序的链表 {
    public static void main(String[] args)
    {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(3);
        ListNode node3=new ListNode(5);
        //ListNode node4=new ListNode(34);
        //ListNode node5=new ListNode(45);
       // node1.next=node2;
        //node2.next=node3;
       // node3.next=node4;
        //node4.next=node5;


        ListNode node6=new ListNode(1);
        ListNode node7=new ListNode(4);
        ListNode node8=new ListNode(6);
        ListNode node9=new ListNode(60);

       // node6.next=node7;
       // node7.next=node8;
       // node8.next=node9;

        ListNode root=Merge(node1,node6);
        while (root!=null)
        {
            System.out.println(root.val);
            root=root.next;
        }
    }

    public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null)
        {
            return list2;
        }
        if(list2==null)
        {
            return list1;
        }
        ListNode p=list1;
        ListNode q=list2;
        if(list1.val>list2.val)
        {
            p=list2;
            q=list1;

        }
        ListNode head=p;
        ListNode prev=head;
        while (q!=null)
        {
            while (p!=null&&p.val<=q.val)
            {
                prev=p;
                p=p.next;
            }
            if(p==null)
            {
                prev.next=q;
                break;
            }
            else
            {
                ListNode m=q.next;
                prev.next=q;
                q.next=p;
                prev=q;
                q=m;
            }
        }
        return head;
    }
}
