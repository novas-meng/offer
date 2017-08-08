/**
 * Created by mengfanshan on 2017/8/7.
 */
public class 调整数组顺序使奇数位于偶数前面 {
    //不使用额外的存储空间,使用插入排序的思想
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
