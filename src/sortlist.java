/**
 * Created by mengfanshan on 2017/7/17.
 */
public class sortlist {
    public static void main(String[] args)
    {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(2);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
       // node4.next=node5;
        sortList(node1);
        while (node1!=null)
        {
            System.out.println(node1.val);
            node1=node1.next;
        }
    }
    public static ListNode[] partition(ListNode p,ListNode q)
    {
        ListNode[] res=new ListNode[2];
        int key=q.val;
        ListNode index=null;
        int temp;
        ListNode pindex=p;
        while (pindex!=q)
        {
            if(pindex.val<key)
            {
                if(index==null)
                {
                    index=p;
                }
                else
                {
                    index=index.next;
                }
                temp=index.val;
                index.val=pindex.val;
                pindex.val=temp;
            }
            pindex=pindex.next;
        }
        if(index==null)
        {
            index=p;
            res[0]=null;
            res[1]=index;

        }
        else
        {
            res[0]=index;
            index=index.next;
            res[1]=index;

        }
        temp=index.val;
        index.val=q.val;
        q.val=temp;
        return res;
    }
    public static void quicksort(ListNode p,ListNode q)
    {
      //  System.out.println("p="+p.val+"  q="+q.val);
        if(p!=q)
        {
            ListNode[] partition=partition(p,q);
            ListNode a1=partition[0];
            ListNode a2=partition[1];
           // System.out.println("partition="+p.val+","+a1.val+","+a2.val+"  "+q.val);
            ListNode head=p;
            if(a1!=null)
            {
                quicksort(p,a1);
            }
            if(a2!=q)
            {
                quicksort(a2.next,q);
            }
        }
    }
    public static ListNode sortList(ListNode head) {
        if(head==null)
        {
            return null;
        }
        ListNode q=head;
        while (q.next!=null)
        {
            q=q.next;
        }
        quicksort(head,q);
        return head;
    }
}
