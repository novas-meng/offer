/**
 * Created by mengfanshan on 2017/8/6.
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж�����������
 */
public class ��̨�� {
    public static int JumpFloor(int target) {
        int[] array=new int[target+1];
        array[0]=0;
        if(target==1)
        {
            return 1;
        }
        else if(target==2)
        {
            return 2;
        }
        else
        {
            array[1]=1;
            array[2]=2;
            for (int i=3;i<array.length;i++)
            {
                array[i]=array[i-1]+array[i-2];
            }
            return array[target];
        }
    }
    public static void main(String[] args)
    {
        System.out.println(JumpFloor(3));
    }
}
