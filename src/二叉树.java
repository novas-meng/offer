import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/7/31.
 *  1
 / \
 2   3
 / \ / \
 4 5 6 7
 /\ /\ /\ /\
 如上图所示，由正整数 1, 2, 3, ...组成了一棵无限大的二叉树。
 从某一个结点到根结点（编号是1的结点）都有一条唯一的路径，
 比如从5到根结点的路径是（5, 2, 1），从4到根结点的路径是（4, 2, 1），
 从根结点1到根结点的路径上只包含一个结点1，因此路径就是（1）。
 对于两个结点x和y，假设他们到根结点的路径分别是（x1, x2, ... ,1）
 和（y1, y2,...,1），那么必然存在两个正整数i和j，
 使得从xi 和yj 开始，有xi = yj，xi + 1 = yj + 1，xi + 2 = yj + 2，...
 现在的问题就是，给定x和y，要求他们的公共父节点，即xi（也就是 yj）。
 输入描述:
 输入包含多组数据，每组数据包含两个正整数x和y（1≤x, y≤2^31-1）。
 输出描述:
 对应每一组数据，输出一个正整数xi，即它们的首个公共父节点。
 示例1
 输入

 10 4
 输出

 2
 */
public class 二叉树 {
    public static int getAncesor(int m,int n)
    {
        int max=Math.max(m,n);
        int min=Math.min(m,n);
        ArrayList<Integer> list=new ArrayList<>();
        while (max!=0)
        {
            list.add(max);
            max=max/2;
        }
        while (min!=0)
        {
            if(list.contains(min))
            {
                return min;
            }
            min=min/2;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            int m=scanner.nextInt();
            int n=scanner.nextInt();
            System.out.println(getAncesor(m,n));
        }
    }
}
