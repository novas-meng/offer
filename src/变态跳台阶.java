/**
 * Created by mengfanshan on 2017/8/6.
 *
 һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������
 */
public class ��̬��̨�� {
    public static int JumpFloorII(int target) {
        return (int)Math.pow(2,target-1);
    }
    public static void main(String[] args)
    {
        System.out.println(JumpFloorII(5));
    }

}
