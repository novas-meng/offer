import java.util.*;

/**
 * Created by mengfanshan on 2017/8/9.
 * Given n pairs of parentheses,
 * write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */
public class GenerateParentheses {
    public static void main(String[] args)
    {
         System.out.println(generateParenthesis(6));

    }
    /*
    ˼· n �����ţ���ô�ַ����ĳ��Ⱦ���2*n

    ���ȵ�һ����ĸ�Ǳ�����'('����ӵ�������
    Ȼ����ӵڶ�����ĸ��ʱ��
    �������������ÿһ��Ԫ�أ�����ÿһ��Ԫ�أ�����һ���ж�
    ���������������'(' ����Ϊn����ô�ڸ�Ԫ��ĩβֻ�����')'

     ���������������'(' ����С�� n

          ��� '(' ���� = ')' ��������ô˵�����ַ��������Ѿ�����ƥ���ˣ�����ֻ����� '('
          ������ô�������'(' ���� ')'
     */
    public static List<String> generateParenthesis(int n) {
        Queue<String> stringQueue=new LinkedList<>();
        for (int i=0;i<2*n;i++)
        {
            if(stringQueue.isEmpty())
            {
                stringQueue.add("(");
            }
            else
            {
                Queue<String> temp=new LinkedList<>();
                while (!stringQueue.isEmpty())
                {
                    String item=stringQueue.poll();
                    char[] chars=item.toCharArray();
                    int leftcount=0;
                    int rightcount=0;
                    for (int j=0;j<chars.length;j++)
                    {
                        if(chars[j]=='(')
                        {
                            leftcount++;
                        }
                        else
                        {
                            rightcount++;
                        }
                    }
                    if(leftcount==n)
                    {
                        String item_1=item+")";
                        temp.add(item_1);
                    }
                    else
                    {
                        if(leftcount==rightcount)
                        {
                            String item_1=item+"(";
                            temp.add(item_1);
                        }
                        else
                        {
                            String item_1=item+")";
                            String item_2=item+"(";
                            temp.add(item_1);
                            temp.add(item_2);
                        }
                    }

                }
                stringQueue.addAll(temp);
            }
        }
        ArrayList<String> list=new ArrayList<>();
        while (!stringQueue.isEmpty())
        {
            list.add(stringQueue.poll());
        }
        return list;
    }
}
