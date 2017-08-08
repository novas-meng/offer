import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/7/23.
 * �� M ��ͬ����ƻ������ N ��ͬ��������������е����ӿ��Ų��ţ��ʹ��ж����ֲ�ͬ�ķַ���
 ע�⣺5��1��1 �� 1��5��1 ��ͬһ�ַַ�����˳���޹ء�
 ��������:
 ��������������ݡ�

 ÿ�����ݰ������������� m��n��1��m, n��20����
 �������:
 ��Ӧÿ�����ݣ����һ������k����ʾ��k�ֲ�ͬ�ķַ���
 ʾ��1
 ����

 7 3
 ���

 8
 */
/*

˼·
�������ά����int[][] array
array[n][m] ��ʾm��ƻ������n�������У���������ĸ���
��Ϊ���������
��һ������� ���ڿ����ӵ��������ô������������߲�Ӱ����ܽ��,array[n-1][m]
�ڶ�������ǣ���ƻ��������������ʱ��ÿ�����Ӷ���Ϊ�յ���������ʱ��ÿ�����Ӽ���һ��1��ƻ������ô��Ӱ����array[n][m-n]
����array[n][m]=array[n-1][m]+array[n][m-n]
������������ƻ����ʱ��array[n][m]=array[m][m]


 */
public class ��ƻ�� {
    //m��ʾƻ���� n��ʾ������
    public static int getCount(int m,int n)
    {
        int[][] array=new int[n+1][m+1];
        for (int i=0;i<array.length;i++)
        {
            array[i][0]=1;
        }
        for (int i=1;i<=n;i++)
        {
            for (int j=1;j<=m;j++)
            {
                if(j>=i)
                {
                    array[i][j]=array[i-1][j]+array[i][j-i];
                }
                else
                {
                    array[i][j]=array[i-1][j];
                }
            }
        }
        return array[n][m];
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            int m=scanner.nextInt();
            int n=scanner.nextInt();
            System.out.println(getCount(m,n));
        }
    }
}
