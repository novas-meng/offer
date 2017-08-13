import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/8/9.
 */
public class huawei2 {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            String line=scanner.nextLine();
            char[] chars=line.toCharArray();
            int error=0;
            int i=0;
            ArrayList<Character> list=new ArrayList<>();
            for (char ch='0';ch<='9';ch++)
            {
                list.add(ch);
            }
            for (char ch='a';ch<='z';ch++)
            {
                list.add(ch);
            }
            StringBuilder stringBuilder=new StringBuilder();
            while (i<chars.length)
            {

               if(!list.contains(chars[i]))
               {
                   error=1;
                   break;
               }
               else
               {
                   if(chars[i]>='1'&&chars[i]<='9')
                   {
                       if(i==chars.length-1)
                       {
                           error=1;
                           break;
                       }
                       else
                       {
                           if((chars[i]=='1'||chars[i]=='2')&&chars[i+1]>'9')
                           {
                               error=1;
                               break;
                           }
                           StringBuilder number=new StringBuilder();
                           while (chars[i]>='0'&&chars[i]<='9')
                           {
                               number.append(chars[i]);
                               i++;
                               if(i==chars.length)
                               {
                                   error=1;
                                   break;
                               }
                           }

                               int length=Integer.valueOf(number.toString());
                           System.out.println("length="+length);
                               for (int j=0;j<length;j++)
                               {
                                   stringBuilder.append(chars[i]);
                               }
                       }
                   }
                   else
                   {
                       if(i==0)
                       {
                           stringBuilder.append(chars[i]);
                       }
                       else
                       {
                           if(chars[i-1]==chars[i])
                           {
                               if(i-2>=0&&chars[i-2]==chars[i])
                               {
                                   error=1;
                                   break;
                               }
                               else if(i-2>=0&&chars[i-2]>='3'&&chars[i-2]<='9')
                               {
                                   error=1;
                                   break;
                               }
                               else
                               {
                                   stringBuilder.append(chars[i]);
                               }
                           }
                           else
                           {
                               stringBuilder.append(chars[i]);
                           }
                       }
                   }
               }
               i++;
            }
            if(error==1)
            {
                System.out.println("!error");
            }
            else
            {
                System.out.println(stringBuilder.toString());
            }
        }
    }
}
