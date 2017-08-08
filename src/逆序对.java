/**
 * Created by mengfanshan on 2017/7/23.
 * ��Ŀ���������е������������ǰ��һ�����ִ��ں�������֣����������������һ�������
 * ������һ�����飬�����������е�����Ե����������磬��һ������ΪArray[0..n]
 * ������Ԫ��a[i]��a[j].��� ��i<jʱ��a[i]>a[j],
 * ��ô���Ǿͳƣ�a[i],a[j]��Ϊһ������ԡ�
 * ������{7,5,6,4}��һ������5������ԣ�
 * �ֱ���(7,6),(7,5),(7,4),(6,4),(5,4)��
 */
public class ����� {
    public static int partsort(int[] array,int begin1,int end1,int begin2,int end2)
    {
        int nixucount=0;
        int[] temp=new int[end2-begin1+1];
        int i=begin1;
        int j=begin2;
        int index=0;
        while (i<=end1&&j<=end2)
        {
            if(array[j]<array[i])
            {
                temp[index]=array[j];
                nixucount=nixucount+j-index-begin1;
                j++;
                index++;
            }
            else
            {
                temp[index]=array[i];
                i++;
                index++;
            }
        }
        while (i<=end1)
        {
            temp[index]=array[i];
            i++;
            index++;
        }
        while (j<=end2)
        {
            temp[index]=array[j];
            nixucount=nixucount+j-index-begin1;
            j++;
            index++;
        }
        for (int k=begin1;k<=end2;k++)
        {
            array[k]=temp[k-begin1];
        }
        return nixucount;
    }
    public static int getCount(int[] array)
    {
        int begin1=0;
        int nixucount=0;
        for (int i=1;i<=array.length/2;i++)
        {
            begin1=0;
            int begin2=begin1+i;
            int end1=begin1+i-1;
            int end2=begin2+i-1;
            while (begin1+i<array.length)
            {
                if(begin1+2*i-1<array.length)
                {
                    nixucount=nixucount+ partsort(array,begin1,end1,begin2,end2);
                }
                //ʣ�µĲ��ֲ�������������
                else
                {
                    nixucount=nixucount+partsort(array,begin1,end1,begin2,array.length-1);
                }
                begin1=end2+1;
                end1=begin1+i-1;
                begin2=end1+1;
                end2=begin2+i-1;
            }
        }
        if(begin1<array.length)
        {
            partsort(array,0,begin1-1,begin1,array.length-1);
        }
        return nixucount;
    }
    public static void main(String[] args)
    {
        int[] array={1,3,7,8,2,4,6,5};
        System.out.println(getCount(array));
    }

}
