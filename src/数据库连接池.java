import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/7/21.
 */
public class 数据库连接池 {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            int m=scanner.nextInt();
            scanner.nextLine();
            int max=0;
            int last=0;
            for (int i=0;i<m;i++)
            {
                String line=scanner.nextLine();
                String[] var=line.split(" ");
                int l=0;
                if(var[1].equals("connect"))
                {
                    l=last+1;
                    if(l>max)
                    {
                        max=l;
                    }
                }
                else
                {
                    l=last-1;
                }
                last=l;
            }
            System.out.println(max);
        }
    }
}
