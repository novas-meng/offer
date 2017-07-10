import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/6/29.
 *
 给出一个区间[a, b]，计算区间内“神奇数”的个数。
 神奇数的定义：存在不同位置的两个数位，组成一个两位数（且不含前导0），且这个两位数为质数。
 比如：153，可以使用数字3和数字1组成13，13是质数，满足神奇数。同样153可以找到31和53也为质数，只要找到一个质数即满足神奇数。
 输入描述:
 输入为两个整数a和b，代表[a, b]区间 (1 ≤ a ≤ b ≤ 10000)。


 输出描述:
 输出为一个整数，表示区间内满足条件的整数个数

 输入例子:
 11 20

 输出例子:
 6
 */
public class Main13 {
    //获取100以内的所有质数，如果array[i]==0 那么i为质数
    public static int[] getOdd()
    {
        int[] array=new int[100];
        array[0]=1;
        array[1]=1;
        for (int i=2;i<array.length;i++)
        {
            for (int j=i+1;j<array.length;j++)
            {
                if(j%i==0)
                {
                    array[j]=1;
                }
            }
        }
        return array;
    }
    public static int getcount(int begin,int end)
    {
        int[] odds=getOdd();
        for (int i=0;i<10;i++)
        {
            odds[i]=1;
        }
        System.out.println("odd");
        int count=0;
        for (int k=begin;k<=end;k++)
        {
            String s=k+"";
            char[] chars=s.toCharArray();
            for (int i=0;i<chars.length;i++)
            {
                int flag=0;
                for (int j=i+1;j<chars.length;j++)
                {
                    char[] chars1=new char[2];
                    chars1[0]=chars[i];
                    chars1[1]=chars[j];
                    String s1=new String(chars1);
                    int n1=Integer.valueOf(s1);

                    char[] chars2=new char[2];
                    chars2[0]=chars[j];
                    chars2[1]=chars[i];
                    String s2=new String(chars2);
                    int n2=Integer.valueOf(s2);



                    if(odds[n1]==0||odds[n2]==0)
                    {
                        count++;
                        //System.out.println(k);
                        flag=1;
                        break;
                    }
                }
                if(flag==1)
                {
                    break;
                }
            }

        }
        return count;

    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int start=scanner.nextInt();
        int end=scanner.nextInt();
        System.out.println(getcount(start,end));
    }
}
