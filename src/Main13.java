import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/6/29.
 *
 ����һ������[a, b]�����������ڡ����������ĸ�����
 �������Ķ��壺���ڲ�ͬλ�õ�������λ�����һ����λ�����Ҳ���ǰ��0�����������λ��Ϊ������
 ���磺153������ʹ������3������1���13��13��������������������ͬ��153�����ҵ�31��53ҲΪ������ֻҪ�ҵ�һ��������������������
 ��������:
 ����Ϊ��������a��b������[a, b]���� (1 �� a �� b �� 10000)��


 �������:
 ���Ϊһ����������ʾ������������������������

 ��������:
 11 20

 �������:
 6
 */
public class Main13 {
    //��ȡ100���ڵ��������������array[i]==0 ��ôiΪ����
    public static int[] getOdd()
    {
        int[] array=new int[100];
        array[0]=1;
        array[1]=1;
        for (int i=2;i<array.length;i++)
        {
            for (int j=i+1;j<array.length;j++)
            {
                if(j%i==0)
                {
                    array[j]=1;
                }
            }
        }
        return array;
    }
    public static int getcount(int begin,int end)
    {
        int[] odds=getOdd();
        for (int i=0;i<10;i++)
        {
            odds[i]=1;
        }
        System.out.println("odd");
        int count=0;
        for (int k=begin;k<=end;k++)
        {
            String s=k+"";
            char[] chars=s.toCharArray();
            for (int i=0;i<chars.length;i++)
            {
                int flag=0;
                for (int j=i+1;j<chars.length;j++)
                {
                    char[] chars1=new char[2];
                    chars1[0]=chars[i];
                    chars1[1]=chars[j];
                    String s1=new String(chars1);
                    int n1=Integer.valueOf(s1);

                    char[] chars2=new char[2];
                    chars2[0]=chars[j];
                    chars2[1]=chars[i];
                    String s2=new String(chars2);
                    int n2=Integer.valueOf(s2);



                    if(odds[n1]==0||odds[n2]==0)
                    {
                        count++;
                        //System.out.println(k);
                        flag=1;
                        break;
                    }
                }
                if(flag==1)
                {
                    break;
                }
            }

        }
        return count;

    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int start=scanner.nextInt();
        int end=scanner.nextInt();
        System.out.println(getcount(start,end));
    }
}
