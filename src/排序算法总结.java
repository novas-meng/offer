/**
 * Created by mengfanshan on 2017/7/23.
 */
public class 排序算法总结 {
    public static void main(String[] args)
    {
        int[] array={3,1,24,3,5,24,3,6,4,67,23};
        //int[] array={1,1};
        //int[] array={3,2,1,4,5,3,4,2};
       // mergesort(array);
        //quicksort(array,0,array.length-1);
       // bubblesort(array);
       // insertsort(array);
       // selectsort(array);
        heapsort(array);
        for (int i=0;i<array.length;i++)
        {
            System.out.println(array[i]);
        }

    }
    //归并排序，主要的思想是递归
    /*
    对于数组
    array[] 首先设置每次比较的两个数组包含一个元素，也就是说第一次 array[0] array[1]之间比较，
    array[2][3]之间比较，
    第二次，每个数组之间包含两个元素，第三次就是包含4个元素
    直到大于数组的个数除以2

    这里借助sort函数
        public static void sort(int[] array,int begin1,int begin2,int end1,int end2)
    这个函数array是待排序数组，begin1 end1 是第一个数组在array中的起始和结束为止
    begin2 end2 是第二个数组在array中的起始和结束为止
    然后将begin1-end2 之间的元素进行排序


    在每次比较的时候，可以设置指针，begin1 begin2 表示要比较的两个数组元素的首位置，然后，begin1 依次递增，
    这个时候可能出现两种情况
    1：两两数组配对以后，剩下的元素，能够满足一个数组+少于一个数组元素的部分，这个时候，将 一个数组+少于一个数组元素的部分
    进行排序
    例子：假设7个元素的数组，索引为0 1 2 3 4 5 6
    第一次 （0，1），（2，3），（4，5），6 每个数组一个元素
    第二次（01，23），（45，6）每个数组两个元素，这个时候，就可以将剩余的元素进行处理了
    第三次（0123，456） 每个数组4个元素
    2：两两数组配对以后，剩下的元素，不能够满足一个数组，这个时候，这样的部分可以不参加比较，待最后的时候，执行以下这部分元素和
    之前的所有元素进行排序就可以了
    例子：假设9个元素的数组，索引为0 1 2 3 4 5 6 7 8
    第一次 （0，1），（2，3），（4，5），（6，7），8 每个数组一个元素
    第二次（01，23），（45，67），8 每个数组两个元素
    第三次（0123，4567），8 每个数组4个元素
    第四次（01234567，8） 处理剩余元素


   时间复杂度：平均时间复杂度 o(nlogn)  最好情况时间复杂度 o(nlogn)  最坏情况下时间复杂度 o(nlogn)  空间复杂度 o(N)
   稳定的排序


     */

    public static void sort(int[] array,int begin1,int begin2,int end1,int end2)
    {
        int i=begin1;
        int j=begin2;
        int[] temp=new int[end2-begin1+1];
        int index=0;
        while (i<=end1&&j<=end2)
        {
            if(array[i]<array[j])
            {
                temp[index]=array[i];
                index++;
                i++;
            }
            else
            {
                temp[index]=array[j];
                index++;
                j++;
            }
        }
        for (int k=i;k<=end1;k++)
        {
            temp[index]=array[k];
            index++;
        }
        for (int k=j;k<=end2;k++)
        {
            temp[index]=array[k];
            index++;
        }
        for (int k=begin1;k<=end2;k++)
        {
            array[k]=temp[k-begin1];
        }
    }
    public static int[] mergesort(int[] array)
    {
        int begin1=0;
        for (int i=1;i<=array.length/2;i=i*2)
        {
            begin1=0;
            int begin2=begin1+i;
            while (begin1+i<array.length)
            {
                if(begin1+2*i-1<array.length)
                {
                    sort(array,begin1,begin2,begin1+i-1,begin2+i-1);
                }
                else
                {
                    sort(array,begin1,begin2,begin1+i-1,array.length-1);
                }
                begin1=begin2+i;
                begin2=begin1+i;
            }
        }
        if(begin1<array.length)
        {
            sort(array,0,begin1,begin1-1,array.length-1);
        }
        return array;
    }

    /*
     快速排序，使用的主要是划分的思想
     array 为待排序数组 p表示起始位置，q表示终止位置
     平均时间复杂度 o（nlogn） 最好情况下时间复杂度 o(nlogn) 最坏情况下 o(n2)
     空间复杂度 o(logn)
     不稳定排序
     */
    public static int partition(int[] array,int p,int q)
    {
        int key=array[q];
        int index=p-1;
        int temp;
        for (int i=p;i<q;i++)
        {
            if(array[i]<key)
            {
                index++;
                temp=array[index];
                array[index]=array[i];
                array[i]=temp;
            }
        }
        index++;
        temp=array[q];
        array[q]=array[index];
        array[index]=temp;
        return index;
    }
    public static void quicksort(int[] array,int p,int q)
    {
        if(p<q)
        {
            int partition=partition(array,p,q);
            quicksort(array,p,partition-1);
            quicksort(array,partition+1,q);
        }
    }

    /*
    冒泡排序

    平均时间复杂度 o（n2）
     */
    public static void bubblesort(int[] array)
    {
        int temp=0;
        for (int i=0;i<array.length;i++)
        {
            for (int j=array.length-1;j>i;j--)
            {
                if(array[j]<array[j-1])
                {
                    temp=array[j-1];
                    array[j-1]=array[j];
                    array[j]=temp;
                }
            }
        }
    }

    /*
    插入排序
     */
    public static void insertsort(int[] array)
    {
        int temp=0;
        for (int i=1;i<array.length;i++)
        {
            int j=i;
            while (j-1>=0&&array[j]<array[j-1])
            {
                temp=array[j-1];
                array[j-1]=array[j];
                array[j]=temp;
                j--;
            }
        }
    }
    /*
    选择排序
     */
    public static void selectsort(int[] array)
    {

        for (int i=0;i<array.length;i++)
        {
            int key=Integer.MAX_VALUE;
            int keyindex=-1;
            for (int j=i;j<array.length;j++)
            {
                if(array[j]<key)
                {
                    key=array[j];
                    keyindex=j;
                }
            }
            int temp=array[i];
            array[i]=array[keyindex];
            array[keyindex]=temp;
        }
    }

    /*
      堆排序
     */
    /*
     这个函数是整理堆的函数，从root节点一下的所有路径均进行判断,length 为待排序数组的长度
     */
    public static void putdown(int[] array,int root,int length)
    {
        int p=root;
        while (p<=(length+1)/2-1)
        {
            int leftchild=2*p+1;
            int rightchild=2*p+2;
            //左右子树都存在
            if(rightchild<length)
            {
                if(array[leftchild]<=array[rightchild]&&array[leftchild]<array[p])
                {
                    int temp=array[leftchild];
                    array[leftchild]=array[p];
                    array[p]=temp;
                    p=leftchild;
                }
                else if(array[rightchild]<=array[leftchild]&&array[rightchild]<array[p])
                {
                    int temp=array[rightchild];
                    array[rightchild]=array[p];
                    array[p]=temp;
                    p=rightchild;
                }
                else
                {
                    break;
                }

            }
            //只存在左子树
            else if(leftchild<length)
            {
                if(array[leftchild]<array[p])
                {
                    int temp=array[leftchild];
                    array[leftchild]=array[p];
                    array[p]=temp;
                    p=leftchild;
                }
                else
                {
                    break;
                }
            }
            else//都不存在
            {
                break;
            }
        }
    }

    public static void heapsort(int[] array)
    {
        for (int i=(array.length+1)/2-1;i>=0;i--)
        {
            putdown(array,i,array.length);
        }
        int count=array.length-1;
        while (count>0)
        {
            int temp=array[count];
            array[count]=array[0];
            array[0]=temp;
            for (int i=(count+1)/2-1;i>=0;i--)
            {
                putdown(array,i,count);
            }
            count--;
        }
    }

}
