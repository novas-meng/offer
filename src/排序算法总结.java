/**
 * Created by mengfanshan on 2017/7/23.
 */
public class �����㷨�ܽ� {
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
    //�鲢������Ҫ��˼���ǵݹ�
    /*
    ��������
    array[] ��������ÿ�αȽϵ������������һ��Ԫ�أ�Ҳ����˵��һ�� array[0] array[1]֮��Ƚϣ�
    array[2][3]֮��Ƚϣ�
    �ڶ��Σ�ÿ������֮���������Ԫ�أ������ξ��ǰ���4��Ԫ��
    ֱ����������ĸ�������2

    �������sort����
        public static void sort(int[] array,int begin1,int begin2,int end1,int end2)
    �������array�Ǵ��������飬begin1 end1 �ǵ�һ��������array�е���ʼ�ͽ���Ϊֹ
    begin2 end2 �ǵڶ���������array�е���ʼ�ͽ���Ϊֹ
    Ȼ��begin1-end2 ֮���Ԫ�ؽ�������


    ��ÿ�αȽϵ�ʱ�򣬿�������ָ�룬begin1 begin2 ��ʾҪ�Ƚϵ���������Ԫ�ص���λ�ã�Ȼ��begin1 ���ε�����
    ���ʱ����ܳ����������
    1��������������Ժ�ʣ�µ�Ԫ�أ��ܹ�����һ������+����һ������Ԫ�صĲ��֣����ʱ�򣬽� һ������+����һ������Ԫ�صĲ���
    ��������
    ���ӣ�����7��Ԫ�ص����飬����Ϊ0 1 2 3 4 5 6
    ��һ�� ��0��1������2��3������4��5����6 ÿ������һ��Ԫ��
    �ڶ��Σ�01��23������45��6��ÿ����������Ԫ�أ����ʱ�򣬾Ϳ��Խ�ʣ���Ԫ�ؽ��д�����
    �����Σ�0123��456�� ÿ������4��Ԫ��
    2��������������Ժ�ʣ�µ�Ԫ�أ����ܹ�����һ�����飬���ʱ�������Ĳ��ֿ��Բ��μӱȽϣ�������ʱ��ִ�������ⲿ��Ԫ�غ�
    ֮ǰ������Ԫ�ؽ�������Ϳ�����
    ���ӣ�����9��Ԫ�ص����飬����Ϊ0 1 2 3 4 5 6 7 8
    ��һ�� ��0��1������2��3������4��5������6��7����8 ÿ������һ��Ԫ��
    �ڶ��Σ�01��23������45��67����8 ÿ����������Ԫ��
    �����Σ�0123��4567����8 ÿ������4��Ԫ��
    ���ĴΣ�01234567��8�� ����ʣ��Ԫ��


   ʱ�临�Ӷȣ�ƽ��ʱ�临�Ӷ� o(nlogn)  ������ʱ�临�Ӷ� o(nlogn)  ������ʱ�临�Ӷ� o(nlogn)  �ռ临�Ӷ� o(N)
   �ȶ�������


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
     ��������ʹ�õ���Ҫ�ǻ��ֵ�˼��
     array Ϊ���������� p��ʾ��ʼλ�ã�q��ʾ��ֹλ��
     ƽ��ʱ�临�Ӷ� o��nlogn�� ��������ʱ�临�Ӷ� o(nlogn) ������ o(n2)
     �ռ临�Ӷ� o(logn)
     ���ȶ�����
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
    ð������

    ƽ��ʱ�临�Ӷ� o��n2��
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
    ��������
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
    ѡ������
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
      ������
     */
    /*
     �������������ѵĺ�������root�ڵ�һ�µ�����·���������ж�,length Ϊ����������ĳ���
     */
    public static void putdown(int[] array,int root,int length)
    {
        int p=root;
        while (p<=(length+1)/2-1)
        {
            int leftchild=2*p+1;
            int rightchild=2*p+2;
            //��������������
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
            //ֻ����������
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
            else//��������
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
