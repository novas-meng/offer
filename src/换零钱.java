import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/7/22.
 * 考虑仅用1分、5分、10分、25分和50分这5种硬币支付某一个给定的金额。例如需要支付11分钱，有一个1分和一个10分、一个1分和两个5分、六个1分和一个5分、十一个1分这4种方式。
 请写一个程序，计算一个给定的金额有几种支付方式。
 注：假定支付0元有1种方式。
 输入描述:
 输入包含多组数据。

 每组数据包含一个正整数n（1≤n≤10000），即需要支付的金额。
 输出描述:
 对应每一组数据，输出一个正整数，表示替换方式的种数。
 示例1
 输入

 11
 26
 输出

 4
 13
 */
public class 换零钱 {
    public static long gerSolveCount(int n)
    {
        int[] money={1,5,10,25,50};
        long[] array=new long[n+1];
        array[0]=1;
        for (int i=0;i<money.length;i++)
        {
            for (int j=money[i];j<=n;j++)
            {
                array[j]=array[j]+array[j-money[i]];
            }
        }
        return array[n];
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            int m=scanner.nextInt();
            System.out.println(gerSolveCount(m));

        }
    }
}
