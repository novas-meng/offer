import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/7/30.
 * UNIXϵͳ����һ���б༭��ed����ÿ��ֻ��һ���ı���ɾ��һ���ַ���
 * ����һ���ַ����滻һ���ַ����ֲ���������ĳһ�е������ǡ�ABC����
 * �����ѵڶ����ַ��滻�ɡ�D����ɾ����һ���ַ���ĩβ����һ���ַ���B����
 * ���������������ݾͱ���ˡ�DCB��������ABC����ɡ�DCB����Ҫ����3��������
 * ���ǳ����ǵı༭����Ϊ3��
 ���ڸ������������ַ������������ո񣩣����æ�������ǵ���̱༭���롣
 ��������:
 ��������������ݡ�

 ÿ�����ݰ��������ַ���m��n�����ǽ�������ĸ�����ҳ��Ȳ�����1024��
 �������:
 ��Ӧÿ�����룬�����̱༭���롣
 ʾ��1
 ����

 ABC CBCD
 ABC DCB
 ���

 2
 3
 */
public class ��̱༭���� {
    public static int getMinEditDistance(char[] A,char[] B)
    {
        int[][] martix=new int[A.length+1][B.length+1];
        for (int i=0;i<martix.length;i++)
        {
            martix[i][0]=i;
        }
        for (int i=0;i<=B.length;i++)
        {
            martix[0][i]=i;
        }
        for (int i=1;i<martix.length;i++)
        {
            for (int j=1;j<=B.length;j++)
            {
                if(A[i-1]==B[j-1])
                {
                    martix[i][j]=martix[i-1][j-1];
                }
                else
                {
                    int insert=martix[i][j-1]+1;
                    int change=martix[i-1][j-1]+1;
                    int del=martix[i-1][j]+1;
                    int min1=Math.min(insert,change);
                    min1=Math.min(min1,del);
                    System.out.println("i="+i+"j="+j+"min1="+min1+","+insert+","+change+","+del);
                    martix[i][j]=min1;
                }
            }
        }
        return martix[A.length][B.length];
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            String line=scanner.nextLine();
            String[] var=line.split(" ");
            System.out.println(getMinEditDistance(var[0].toCharArray(),var[1].toCharArray()));
        }
    }
}
