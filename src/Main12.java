import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/6/29.
 *
 牛牛想对一个数做若干次变换，直到这个数只剩下一位数字。
 变换的规则是：将这个数变成 所有位数上的数字的乘积。比如285经过一次变换后转化成2*8*5=80.
 问题是，要做多少次变换，使得这个数变成个位数。
 输入描述:
 输入一个整数。小于等于2,000,000,000。


 输出描述:
 输出一个整数，表示变换次数。

 输入例子:
 285

 输出例子:
 2
 */
public class Main12 {
    public static int getCount(int n)
    {
        int sum=n;
        int count=0;
        while (sum>10)
        {
            count++;
            String s=sum+"";
            char[] chars=s.toCharArray();
            sum=1;
            for (int i=0;i<chars.length;i++)
            {
                sum=sum*(chars[i]-48);
            }
        }
        System.out.println(count);
        return 0;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        getCount(n);
    }
}
