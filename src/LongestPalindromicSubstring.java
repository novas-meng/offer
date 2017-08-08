/**
 * Created by mengfanshan on 2017/8/8.
 */
public class LongestPalindromicSubstring {
    /*
    ���ȶ��� ����
    array[i][j] ��� i-j��ʾ���ַ����ǻ��Ĵ�����ôarray[i][j]=1
    ����Ϊ0
    if s[i]==s[j]
    ���ʱ����� i==j-1
    ��ôarray[i][j]=1
    ���� array[i][j]=array[i+1][j-1]

    ���s[i]!=s[j] array[i][j]=0

     ʱ�临�Ӷ�Ϊo(n2)
     ��ʵ��ʱ,��Ϊarray[i][j] ������ array[i+1][j-1]
     ���Ե�һ��ѭ������Ϊj���ڶ���ѭ���� j-1 ������ 0

     */
    public static String longestPalindrome(String s) {
        char[] chars=s.toCharArray();
        int max=0;
        String maxstr=null;
        int[][] array=new int[chars.length][chars.length];
        for (int i=0;i<chars.length;i++)
        {
            array[i][i]=1;
        }
        for (int j=1;j<array.length;j++)
        {
            for (int i=j-1;i>=0;i--)
            {
                if(chars[i]==chars[j])
                {
                    if(i==j-1)
                    {
                        array[i][j]=1;
                    }
                    else
                    {
                        array[i][j]=array[i+1][j-1];
                    }
                }
                else
                {
                    array[i][j]=0;
                }
            }
        }
        for (int i=0;i<array.length;i++)
        {
            for (int j=0;j<array.length;j++)
            {
                if(array[i][j]==1)
                {
                    if(j-i+1>max)
                    {
                        max=j-i+1;
                        maxstr=s.substring(i,j+1);
                    }
                }
            }
        }
        return maxstr;
    }
    public static void main(String[] args)
    {
       // String str="\"eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee\"";
        String str="aaaa";
        System.out.println(longestPalindrome(str));
    }
}
