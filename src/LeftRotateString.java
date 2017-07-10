/**
 * Created by mengfanshan on 2017/7/6.
 */
public class LeftRotateString {
    public static void main(String[] args)
    {
        String s="abcde";
        System.out.println(LeftRotateString(s,4));
    }
    public static String LeftRotateString(String str,int n) {
        int m=n%str.length();
        char[] chars=str.toCharArray();
        for (int i=0;i<m;i++)
        {
            char ch=chars[0];
            for (int j=1;j<chars.length;j++)
            {
                chars[j-1]=chars[j];
            }
            chars[chars.length-1]=ch;
        }
        return new String(chars);
    }
}
