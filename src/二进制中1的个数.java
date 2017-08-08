import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by mengfanshan on 2017/8/6.
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * 首先介绍负数的补码形式
 * 假设-5
 * 1：首先求绝对值的二进制
 * 2：求反码
 * 3：反码+1
 */
public class 二进制中1的个数 {

    public static int NumberOf1(int n) {
        int count=0;
        for (int i=0;i<32;i++)
        {
            int m=n-2*(n>>1);
            if(m==1)
            {
                count++;
            }
            n=n>>1;
        }
        return count;
    }
    public static void main(String[] args)
    {
       // System.out.println(NumberOf1(-2147483648));
       // System.out.println(-2147483648<<1);

        System.out.println(-31);
     //   System.out.println(Integer.toBinaryString(-2147483648));
    }

}
