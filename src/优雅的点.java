import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/8/12.
 * С����һ��Բ��������ԭ���Բ��С��֪��Բ�İ뾶��ƽ����
 * С����Ϊ��Բ�ϵĵ���Һ������궼�������ĵ������ŵģ�
 * С��������Ѱ��һ���㷨��������ŵĵ�ĸ������������������
 ���磺�뾶��ƽ�����Ϊ25
 ���ŵĵ���У�(+/-3, +/-4), (+/-4, +/-3), (0, +/-5) (+/-5, 0)��һ��12���㡣
 ��������:
 ����Ϊһ����������ΪԲ�뾶��ƽ��,��Χ��32λint��Χ�ڡ�


 �������:
 ���Ϊһ����������Ϊ���ŵĵ�ĸ���

 ��������1:
 25

 �������1:
 12
 */
public class ���ŵĵ� {
    public static int getCount(int r2)
    {
        int r=(int)Math.sqrt(r2)+1;
        int count=0;
        for (int i=-r;i<r;i++)
        {
            int m=r2-i*i;
            if(Math.sqrt(m)-(int)Math.sqrt(m)==0)
            {
                if((int)Math.sqrt(m)==0)
                {
                    count=count+1;
                }
                else
                {
                    count=count+2;
                }
            }
        }
        return count;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            System.out.println(getCount(scanner.nextInt()));
        }
    }
}
