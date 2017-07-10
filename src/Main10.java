import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/6/27.
 *
 *
 假定一种编码的编码范围是a ~ y的25个字母，从1位到4位的编码，如果我们把该编码按字典序排序，形成一个数组如下： a, aa, aaa, aaaa, aaab, aaac, … …, b, ba, baa, baaa, baab, baac … …, yyyw, yyyx, yyyy 其中a的Index为0，aa的Index为1，aaa的Index为2，以此类推。 编写一个函数，输入是任意一个编码，输出这个编码对应的Index.
 输入描述:
 输入一个待编码的字符串,字符串长度小于等于100.


 输出描述:
 输出这个编码的index

 输入例子:
 baca

 输出例子:
 16331
 */
public class Main10 {
    /*
      对于baca这个例子，首先从前向后遍历
      对于b，后面可能出现3个子母，这三个字母的所有情况为25*25*25+25*25+25,
      然后b的索引是2，因为包括a，b这两种情况，所以公式就是
      sum=sum+(ch_index-1)*temp+ch_index
      temp 为后面剩的位置中，所有的排序可能，比如 剩3个位置 就是25*25*25+25*25+25，
      剩2个位置就是25*25+25，剩1个位置 就是25
     */
    public static int getIndex(String line)
    {
        char[] chars=line.toCharArray();
        int sum=0;
        for (int i=0;i<chars.length;i++)
        {
            int ch_index=chars[i]-96;
            //System.out.println(ch_index);
            int temp=0;
            if(i<=2)
            {
                temp=temp+25;
            }
            if(i<=1)
            {
                temp=temp+25*25;
            }
            if(i<=0)
            {
                temp=temp+25*25*25;
            }
            sum=sum+(ch_index-1)*temp+ch_index;
            //System.out.println(sum);
        }
        return sum-1;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        System.out.println(getIndex(str));
    }

}
