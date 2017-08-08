import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mengfanshan on 2017/7/21.
 * NowCoder��С��ϲ����ѧ��ϲ���ڱʼ����¼�ܶ���ʽ�����������ڵı��ʽд�����鷳��Ϊ�������������ȼ������ò���Ӻܶ����ţ���С��©��һ�������ŵĻ���֮������֮ǧ�
 ���������ǰ׺���ʽ������`(2 + 3) * 4`д��`* + 2 3 4`���������ܱ���ʹ�������ˡ������ı��ʽ��д�򵥣�������ȴ����ֱ�ۡ�����дһ���������������Щǰ׺���ʽ�ɡ�
 ��������:
 ��������������ݣ�ÿ�����ݰ������С�

 ��һ��Ϊ������n��3��n��50���������ŵڶ��а���n������ֵ���������ɵ��б�

 +-* /
�ֱ�Ϊ�Ӽ��˳��������㣬���г���Ϊ��������5/3=1��
        �������:
        ��Ӧÿһ�����ݣ�������ǵ���������
        ʾ��1
        ����

        3
        + 2 3
        5
        * + 2 2 3
        5
        * 2 + 2 3
        ���

        5
        12
        10
 */
public class ��ϲ������ {
    public static int qianzhui(String[] datas)
    {
        Stack<Integer> queue=new Stack<>();
        for (int i=datas.length-1;i>=0;i--)
        {
            if(datas[i].equals("/"))
            {
                int m1=queue.pop();
                int m2=queue.pop();
                queue.add(m1/m2);
            }
            else if(datas[i].equals("*"))
            {
                int m1=queue.pop();
                int m2=queue.pop();
                queue.add(m1*m2);
            }
            else if(datas[i].equals("+"))
            {
                int m1=queue.pop();
                int m2=queue.pop();
                queue.add(m1+m2);
            }
            else if(datas[i].equals("-"))
            {
                int m1=queue.pop();
                int m2=queue.pop();
                queue.add(m1-m2);
            }
            else
            {
                queue.push(Integer.valueOf(datas[i]));
            }
        }
        return queue.pop();
    }

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            int m=scanner.nextInt();
            scanner.nextLine();
            String line=scanner.nextLine();
            String[] datas=line.split(" ");
            System.out.println(qianzhui(datas));
        }
    }
}
