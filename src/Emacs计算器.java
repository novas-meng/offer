import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mengfanshan on 2017/7/20.
 * Emacs�ų���ı༭�������Դ���һ������������������������ͬ�����ǻ��ں�׺���ʽ�ģ���������ڲ������ĺ��档���硰2 3 +���ȼ�����׺���ʽ�ġ�2 + 3����
 ����ʵ��һ����׺���ʽ�ļ�������
 ��������:
 ��������������ݡ�

 ÿ�����ݰ������У���һ����һ��������n (3��n��50)�������ŵڶ��а���n������ֵ���������ɵ��б�

 +-* �ֱ�Ϊ�Ӽ��˳��������㣬���г���Ϊ����������5/3=1����
        �������:
        ��Ӧÿһ�����ݣ�������ǵ���������
        ʾ��1
        ����

        3
        2 3 +
        5
        2 2 + 3 *
        5
        2 2 3 + *
        ���

        5
        12
        10
 */

public class Emacs������ {
    public static int nibolan(String line)
    {
        String[] array=line.split(" ");
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<array.length;i++)
        {
            if(array[i].equals("+"))
            {
                int m2=stack.pop();
                int m1=stack.pop();
                stack.push(m2+m1);
            }
            else if(array[i].equals("-"))
            {
                int m2=stack.pop();
                int m1=stack.pop();
                stack.push(m1-m2);
            }
            else if(array[i].equals("*"))
            {
                int m2=stack.pop();
                int m1=stack.pop();
                stack.push(m2*m1);
            }
            else if(array[i].equals("/"))
            {
                int m2=stack.pop();
                int m1=stack.pop();
                stack.push(m1/m2);
            }
            else
            {
                stack.push(Integer.valueOf(array[i]));
            }
        }
        return stack.pop();
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            int m=scanner.nextInt();
            scanner.nextLine();
            String line=scanner.nextLine();
            System.out.println(nibolan(line));
        }
    }

}
