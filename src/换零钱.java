import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/7/22.
 * ���ǽ���1�֡�5�֡�10�֡�25�ֺ�50����5��Ӳ��֧��ĳһ�������Ľ�������Ҫ֧��11��Ǯ����һ��1�ֺ�һ��10�֡�һ��1�ֺ�����5�֡�����1�ֺ�һ��5�֡�ʮһ��1����4�ַ�ʽ��
 ��дһ�����򣬼���һ�������Ľ���м���֧����ʽ��
 ע���ٶ�֧��0Ԫ��1�ַ�ʽ��
 ��������:
 ��������������ݡ�

 ÿ�����ݰ���һ��������n��1��n��10000��������Ҫ֧���Ľ�
 �������:
 ��Ӧÿһ�����ݣ����һ������������ʾ�滻��ʽ��������
 ʾ��1
 ����

 11
 26
 ���

 4
 13
 */
public class ����Ǯ {
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
