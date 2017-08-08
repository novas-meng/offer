import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/7/31.
 * �����������ַ���m��n��������ǵ��Ӵ�a��b������ͬ�����a��b��m��n�Ĺ��������С�
 * �Ӵ��е��ַ���һ����ԭ�ַ�����������
 �����ַ�����abcfbc���͡�abfcab�������С�abc��ͬʱ�����������ַ����У���ˡ�abc�������ǵĹ��������С�
 ���⣬��ab������af���ȶ������ǵ��ִ���
 ���ڸ������������ַ������������ո񣩣����æ�������ǵ�����������еĳ��ȡ�
 ��������:
 ��������������ݡ�

 ÿ�����ݰ��������ַ���m��n�����ǽ�������ĸ�����ҳ��Ȳ�����1024��
 �������:
 ��Ӧÿ�����룬�������������еĳ��ȡ�
 ʾ��1
 ����

 abcfbc abfcab
 programming contest
 abcd mnp
 ���

 4
 2
 0
 */
public class ����������� {
    public static int getLongestSeries(char[] A,char[] B)
    {
        int[][] array=new int[A.length][B.length];
        for (int i=0;i<A.length;i++)
        {
            if(A[i]==B[0])
            {
                array[i][0]=1;
            }
            else if(i>=1)
            {
                array[i][0]=array[i-1][0];
            }
        }
        for (int i=0;i<B.length;i++)
        {
            if(A[0]==B[i])
            {
                array[0][i]=1;
            }
            else if(i>=1)
            {
                array[0][i]=array[0][i-1];
            }
        }

        for (int i=1;i<A.length;i++)
        {
            for (int j=1;j<B.length;j++)
            {
                if(A[i]==B[j])
                {
                    array[i][j]=array[i-1][j-1]+1;
                }
                else
                {
                    array[i][j]=Math.max(array[i-1][j],array[i][j-1]);
                }
            }
        }
        return array[A.length-1][B.length-1];
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            String line=scanner.nextLine();
            String[] var=line.split(" ");
            System.out.println(getLongestSeries(var[0].toCharArray(),var[1].toCharArray()));
        }
    }
}
