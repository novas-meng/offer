import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/8/9.
 */
public class huawei1 {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            String line=scanner.nextLine();
            String[] var=line.split(",");
            String s="";
            for (int i=0;i<var.length;i++)
            {
                char[] chars=var[i].toCharArray();
                s=s+chars[3];
                if(chars[2]!='F')
                {
                    s=s+chars[2];
                }
            }
            System.out.println(s);
        }
    }
}
