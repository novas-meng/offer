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
 ����ͼ��ʾ���������� 1, 2, 3, ...�����һ�����޴�Ķ�������
 ��ĳһ����㵽����㣨�����1�Ľ�㣩����һ��Ψһ��·����
 �����5��������·���ǣ�5, 2, 1������4��������·���ǣ�4, 2, 1����
 �Ӹ����1��������·����ֻ����һ�����1�����·�����ǣ�1����
 �����������x��y���������ǵ�������·���ֱ��ǣ�x1, x2, ... ,1��
 �ͣ�y1, y2,...,1������ô��Ȼ��������������i��j��
 ʹ�ô�xi ��yj ��ʼ����xi = yj��xi + 1 = yj + 1��xi + 2 = yj + 2��...
 ���ڵ�������ǣ�����x��y��Ҫ�����ǵĹ������ڵ㣬��xi��Ҳ���� yj����
 ��������:
 ��������������ݣ�ÿ�����ݰ�������������x��y��1��x, y��2^31-1����
 �������:
 ��Ӧÿһ�����ݣ����һ��������xi�������ǵ��׸��������ڵ㡣
 ʾ��1
 ����

 10 4
 ���

 2
 */
public class ������ {
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
