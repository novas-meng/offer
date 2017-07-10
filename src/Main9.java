import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/6/26.
 */
public class Main9 {
    public static int getMaxSubstringCount(String s1,String s2)
    {
        char[] s1_char=s1.toCharArray();
        char[] s2_chars=s2.toCharArray();
        int max=0;
        int[][] array=new int[s1_char.length+1][s2_chars.length+1];
        for (int i=1;i<=s1_char.length;i++)
        {
            for(int j=1;j<=s2_chars.length;j++)
            {
                if(s1_char[i-1]==s2_chars[j-1])
                {
                    array[i][j]=array[i-1][j-1]+1;
                }
                if(array[i][j]>max)
                {
                    max=array[i][j];
                }
            }
        }
        return max;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        String s1=scanner.nextLine();
        String s2=scanner.nextLine();
        System.out.println(getMaxSubstringCount(s1,s2));

    }
}
