import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/7/31.
 * �㳡��վ��һ֧���飬����������ȫ�����ص�Ť�������
 * �����������ǵ�������ݣ������æ�ҳ�������ε����������С�
 * ����������������ǣ�1��7��3��5��9��4��8�����������ε������������У�1��7��
 * ����1��3��5��9������1��3��4��8���ȣ�������ĳ���Ϊ4��
 ��������:
 ��������������ݣ�ÿ�����ݵ�һ�а���һ��������n��1��n��1000����

 �����ŵڶ��а���n��������m��1��n��10000�������������ÿλ��Ա����ߡ�
 �������:
 ��Ӧÿһ�����ݣ��������������еĳ��ȡ�
 ʾ��1
 ����

 7
 1 7 3 5 9 4 8
 6
 1 3 5 2 4 6
 ���

 4
 4
 */
public class ����������� {
    public static int getMaxUpSeriesLength(int[] array)
    {
        int[] length=new int[array.length];
        for (int i=0;i<length.length;i++)
        {
            length[i]=1;
        }
        for (int i=1;i<array.length;i++)
        {
            for (int j=i-1;j>=0;j--)
            {
                if(array[i]>array[j])
                {
                    length[i]=Math.max(length[i],length[j]+1);
                }
            }
        }
        int max=0;
        for (int i=0;i<length.length;i++)
        {
          //  System.out.println(length[i]);
            if(length[i]>max)
            {
                max=length[i];
            }
        }
        return max;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            int count=scanner.nextInt();
            int[] array=new int[count];
            for (int i=0;i<array.length;i++)
            {
                array[i]=scanner.nextInt();
            }
            int m=getMaxUpSeriesLength(array);
            System.out.println(m);
        }
    }
}
