import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/7/18.
 * С���������ֳ�С����ЧӦ����Ҳ�����ȷָ����ۣ�Ӣ�ģ�Six Degrees of Separation����
 * �������������л�����ʶ����ֻ��Ҫ�����м��˾��ܽ�������ϵ������1967������ѧ������ѧ����˹̹�����׶�����ķ�������������һ��������ʵ�飬
 * ����֤��ƽ��ֻ��Ҫ5���м��˾Ϳ�����ϵ�κ�����������ʶ�������ˡ�
 * Redraiment���������罻��վFootbook�ĺ��ѹ�ϵ���ϣ������æ����һ��ĳ�����û�֮��������Ҫ�����м��˲��ܽ�����ϵ��
 ��������:
 �����һ����һ������t����ʾ��������t�����ݡ�


 ÿ�����ݰ��������֣���һ�����Ǻ��ѹ�ϵ���ϣ��ڶ������Ǵ��������û����ݡ�


 �������ϲ��ֵ�һ�а���һ������n (5��n��50)����ʾ��n���û����û�id��1->n��ʾ��

 ��������һ��ֻ����0��1��n��n�������е�y�е�x�е�ֵ��ʾid��y���û��Ƿ���idΪx���û��ĺ��ѣ�1�����ǣ�0�����ǣ���
 ������ѹ�ϵ���໥�ģ���A��B�ĺ�����ζ��BҲ��A�ĺ��ѡ�


 ���������û����ݵ�һ�а���һ������m����������m���û������ݡ�

 ÿ���������û�ID��A��B (1��A, B��n; A != B)��
 �������:
 ����ÿ����������û�������û�A������Ҫͨ�������м��˲�����ʶ�û�B��


 ���A�������Ҳ�޷���ʶB�������Sorry����
 ʾ��1
 ����


 2
 5
 1 0 1 0 1
 0 1 1 1 0
 1 1 1 0 0
 0 1 0 1 0
 1 0 0 0 1
 3
 1 2
 2 4
 3 5
 6
 1 1 0 0 1 0
 1 1 0 1 0 1
 0 0 1 0 0 1
 0 1 0 1 0 1
 1 0 0 0 1 0
 0 1 1 1 0 1
 4
 2 3
 3 6
 5 1
 4 2

 ���

 1
 0
 Sorry
 1
 0
 2
 1
 */
public class xiaoshijiexianxiang {
    static int maxvalue=10000;
    public static int[][] floyd(int[][] array)
    {

        int[][] distince=new int[array.length][array.length];
        for (int i=0;i<distince.length;i++)
        {
            for (int j=0;j<distince.length;j++)
            {
                if(i==j)
                {
                    distince[i][j]=0;
                }
                else if(array[i][j]==0)
                {
                    distince[i][j]=maxvalue;
                }
                else
                {
                    distince[i][j]=array[i][j];
                }
            }
        }

        for (int k=0;k<distince.length;k++)
        {
            for (int i=0;i<distince.length;i++)
            {
                for (int j=0;j<distince.length;j++)
                {
                    if(distince[i][j]>distince[i][k]+distince[k][j])
                    {
                        distince[i][j]=distince[i][k]+distince[k][j];
                    }
                }
            }
        }
        return distince;

    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int testcount=scanner.nextInt();
        for (int i=0;i<testcount;i++)
        {
            int personcount=scanner.nextInt();
            int[][] array=new int[personcount][personcount];
            for (int j=0;j<array.length;j++)
            {
                for (int k=0;k<array.length;k++)
                {
                    array[j][k]=scanner.nextInt();
                }
            }
            int[][] distance=floyd(array);
            int t=scanner.nextInt();
            for (int j=0;j<t;j++)
            {
                int a=scanner.nextInt();
                int b=scanner.nextInt();
                if(distance[a-1][b-1]==maxvalue)
                {
                    System.out.println("Sorry");
                }
                else
                {
                    System.out.println(distance[a-1][b-1]-1);
                }
            }

        }
    }

}
