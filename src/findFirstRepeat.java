/**
 * Created by mengfanshan on 2017/7/16.
 * ����һ���ַ����������һ����Ч�㷨���ҵ���һ���ظ����ֵ��ַ���
 ����һ���ַ���(��һ��ȫΪ��ĸ)A�����ĳ���n���뷵�ص�һ���ظ����ֵ��ַ�����֤�ַ��������ظ��ַ����ַ����ĳ���С�ڵ���500��
 ����������
 "qywyer23tdd",11
 ���أ�y
 */
public class findFirstRepeat {
    public static void main(String[] args)
    {
        String A="qywyer23tdd";
        System.out.println(findFirstRepeat(A,A.length()));
    }
    public static char findFirstRepeat(String A, int n) {
        // write code here
        char[] chars=A.toCharArray();
        int xor=chars[0];
        for (int i=1;i<chars.length;i++)
        {
            if((chars[i]^xor)==xor)
            {
                return chars[i];
            }
            else
            {
                xor=(chars[i]^xor);
            }
        }
        return 0;
    }
}
