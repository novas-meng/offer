import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;

/**
 * Created by mengfanshan on 2017/6/27.
 *
 *
 �ٶ�һ�ֱ���ı��뷶Χ��a ~ y��25����ĸ����1λ��4λ�ı��룬������ǰѸñ��밴�ֵ��������γ�һ���������£� a, aa, aaa, aaaa, aaab, aaac, �� ��, b, ba, baa, baaa, baab, baac �� ��, yyyw, yyyx, yyyy ����a��IndexΪ0��aa��IndexΪ1��aaa��IndexΪ2���Դ����ơ� ��дһ������������������һ�����룬�����������Ӧ��Index.
 ��������:
 ����һ����������ַ���,�ַ�������С�ڵ���100.


 �������:
 �����������index

 ��������:
 baca

 �������:
 16331
 */
public class Main10 {
    /*
      ����baca������ӣ����ȴ�ǰ������
      ����b��������ܳ���3����ĸ����������ĸ���������Ϊ25*25*25+25*25+25,
      Ȼ��b��������2����Ϊ����a��b��������������Թ�ʽ����
      sum=sum+(ch_index-1)*temp+ch_index
      temp Ϊ����ʣ��λ���У����е�������ܣ����� ʣ3��λ�� ����25*25*25+25*25+25��
      ʣ2��λ�þ���25*25+25��ʣ1��λ�� ����25
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
