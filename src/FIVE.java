/**
 * Created by mengfanshan on 2017/7/13.
 */
public class FIVE {
    public static void main(String[] args)
    {
        int[] a={2,0,0,1};
        int[] b={5,1,2,2};
        System.out.println(getMinTrans(a,b));
    }
    public static int getMinTrans(int[] a,int[] b)
    {
        int count=0;
        for (int i=0;i<a.length;i++)
        {
            if(a[i]==0)
            {
                a[i]=1;
                count++;
            }
            if(a[i]>b[i])
            {
                return -1;
            }
        }
        while (true)
        {
            int flag=0;
            for (int i=0;i<a.length;i++)
            {
                if(b[i]/a[i]>=2)
                {
                    flag=1;
                    a[i]=a[i]*2;
                }
            }
            if(flag==1)
            {
                count=count+1;
            }
            else
            {
                break;
            }
        }
        for (int i=0;i<a.length;i++)
        {
            count=b[i]-a[i]+count;
        }
        return count;
    }
}
