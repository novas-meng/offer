import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mengfanshan on 2017/7/15.
 * 世界上有10种人，一种懂二进制，一种不懂。那么你知道两个int32整数m和n的二进制表达，有多少个位(bit)不同么？
 * 输入

 1999 2299
 输出

 7
 */
public class countBitDiff {

    public static void main(String[] args)
    {

        System.out.println(countBitDiff(1999,2299));

    }
    public static Deque<Integer> getBinary(int m)
    {
        Deque<Integer> queue=new LinkedList<>();
        while (m/2!=0)
        {
            int b=m%2;
            queue.addFirst(b);
            m=m/2;
        }
        queue.addFirst(m%2);
        for (int i=queue.size();i<32;i++)
        {
            queue.addFirst(0);
        }
        return queue;
    }
    public static int countBitDiff(int m, int n) {
        Deque<Integer> mq=getBinary(m);
        Deque<Integer> nq=getBinary(n);
        int count=0;
        for (int i=0;i<32;i++)
        {
            if(mq.poll()!=nq.poll())
            {
                count++;
            }
        }
        return count;

    }
}
