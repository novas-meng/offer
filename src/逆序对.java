/**
 * Created by mengfanshan on 2017/7/23.
 * 题目：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对
 * 。输入一个数组，求出这个数组中的逆序对的总数。例如，有一个数组为Array[0..n]
 * 其中有元素a[i]，a[j].如果 当i<j时，a[i]>a[j],
 * 那么我们就称（a[i],a[j]）为一个逆序对。
 * 在数组{7,5,6,4}中一共存在5对逆序对，
 * 分别是(7,6),(7,5),(7,4),(6,4),(5,4)。
 */
public class 逆序对 {
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
                //剩下的部分不够两个数组了
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
