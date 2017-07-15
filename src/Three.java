/**
 * Created by mengfanshan on 2017/7/13.
 */
public class Three {
    public static void main(String[] args)
    {
        trans(4);
    }
    public static int[][] trans(int n)
    {
        int[][] result=new int[n][n];
        int index=1;
        for (int i=0;i<n/2;++i)
        {
            for (int j=i;j<n-1-i;j++)
            {
                result[i][j]=index;
                index++;
            }
            for (int j=i;j<n-1-i;j++)
            {
                result[j][n-i-1]=index;
                index++;
            }
            for (int j=n-i-1;j>i;j--)
            {
                result[n-i-1][j]=index;
                index++;
            }
            for (int j=n-i-1;j>i;j--)
            {
                result[j][i]=index;
                index++;
            }
        }
        if (n%2==1)
        {
            result[n/2][n/2] = index;
        }
        for (int i=0;i<n;++i)
        {
            for (int j=0;j<n;++j)
            {
                System.out.println(result[i][j]);
            }
        }
        return result;
    }

}
