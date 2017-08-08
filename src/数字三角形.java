import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/7/23.
 *  7
 3 8
 8 1 0
 2 7 4 4
 4 5 2 6 5
 ����ͼ��ʾ����һ�����������εĶ����ߵ��ײ��кܶ�����ͬ��·����
 ������ֻ�ܴӵ�ǰ�ڵ��ߵ���һ�����ڵĽڵ㣬����һ�����߻��ұߡ�
 ��������еڶ������֡�1��ֻ���ߵ������еĵڶ������֡�7������������֡�4����
 ��Ѱ�����һ��·����ʹ������·���Ͻڵ�������ܺ����
 ��������:
 ����������顣ÿ�����ݵĵ�һ�а���һ��������n��1��n��100�������������εĲ�����

 ��������n�����֣���i��1��i��n���а���i����Ȼ����
 �������:
 ��Ӧÿ�����ݣ�������ĺ͡�
 ʾ��1
 ����

 5
 7
 3 8
 8 1 0
 2 7 4 4
 4 5 2 6 5
 ���

 30
 */
public class ���������� {
    public static int getLongestPath(int[][] array)
    {
        int[] temp=new int[array.length];
        int max=0;
        for (int i=0;i<array.length;i++)
        {
            int pre=0;
            for (int j=0;j<temp.length;j++)
            {
                int current=temp[j];
                temp[j]=Math.max(pre+array[i][j],temp[j]+array[i][j]);
                if(temp[j]>max)
                {
                    max=temp[j];
                }
                pre=current;
            }
        }
        return max;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            int linecount=scanner.nextInt();
            int[][] array=new int[linecount][linecount];
            for (int i=0;i<array.length;i++)
            {
                for (int j=0;j<i+1;j++)
                {
                    array[i][j]=scanner.nextInt();
                }
            }
            for (int i=0;i<array.length;i++)
            {
                for(int j=0;j<array.length;j++)
                {
                   // System.out.print(array[i][j]+" ");
                }
               // System.out.println();
            }
            System.out.println(getLongestPath(array));
        }
    }
}
