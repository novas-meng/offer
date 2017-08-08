/**
 * Created by mengfanshan on 2017/8/6.
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class 跳台阶 {
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
