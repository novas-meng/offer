/**
 * Created by mengfanshan on 2017/7/16.
 * 对于一个字符串，请设计一个高效算法，找到第一次重复出现的字符。
 给定一个字符串(不一定全为字母)A及它的长度n。请返回第一个重复出现的字符。保证字符串中有重复字符，字符串的长度小于等于500。
 测试样例：
 "qywyer23tdd",11
 返回：y
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
