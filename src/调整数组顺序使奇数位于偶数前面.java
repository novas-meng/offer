/**
 * Created by mengfanshan on 2017/8/7.
 */
public class ��������˳��ʹ����λ��ż��ǰ�� {
    //��ʹ�ö���Ĵ洢�ռ�,ʹ�ò��������˼��
    public static void reOrderArray(int [] array) {
        for (int i=0;i<array.length;i++)
        {
            if(array[i]%2==1)
            {
                int j=i;
                while (j-1>=0&&array[j-1]%2==0)
                {
                    int temp=array[j];
                    array[j]=array[j-1];
                    array[j-1]=temp;
                    j--;
                }
            }
        }
    }
    public static void main(String[] args)
    {
        int[] array={2,2,3,4,5,6};
        reOrderArray(array);
        for (int i=0;i<array.length;i++)
        {
            System.out.println(array[i]);
        }
    }

}
