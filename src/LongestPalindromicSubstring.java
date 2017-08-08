/**
 * Created by mengfanshan on 2017/8/8.
 */
public class LongestPalindromicSubstring {
    /*
    首先定义 数组
    array[i][j] 如果 i-j表示的字符串是回文串，那么array[i][j]=1
    否则为0
    if s[i]==s[j]
    这个时候，如果 i==j-1
    那么array[i][j]=1
    否则 array[i][j]=array[i+1][j-1]

    如果s[i]!=s[j] array[i][j]=0

     时间复杂度为o(n2)
     在实现时,因为array[i][j] 依赖于 array[i+1][j-1]
     所以第一层循环设置为j，第二层循环从 j-1 遍历到 0

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
