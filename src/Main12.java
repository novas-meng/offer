import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/6/29.
 *
 ţţ���һ���������ɴα任��ֱ�������ֻʣ��һλ���֡�
 �任�Ĺ����ǣ����������� ����λ���ϵ����ֵĳ˻�������285����һ�α任��ת����2*8*5=80.
 �����ǣ�Ҫ�����ٴα任��ʹ���������ɸ�λ����
 ��������:
 ����һ��������С�ڵ���2,000,000,000��


 �������:
 ���һ����������ʾ�任������

 ��������:
 285

 �������:
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
