import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by mengfanshan on 2017/8/6.
 * ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 *
 * ���Ƚ��ܸ����Ĳ�����ʽ
 * ����-5
 * 1�����������ֵ�Ķ�����
 * 2������
 * 3������+1
 */
public class ��������1�ĸ��� {

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
