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
    思路 n 个括号，那么字符串的长度就是2*n

    首先第一个字母是必须是'('，添加到队列中
    然后当添加第二个字母的时候，
    遍历队列里面的每一个元素，对于每一个元素，进行一下判断
    如果这个队列里面的'(' 个数为n，那么在该元素末尾只能添加')'

     如果这个队列里面的'(' 个数小于 n

          如果 '(' 个数 = ')' 个数，那么说明该字符串括号已经完美匹配了，所以只能添加 '('
          否则，那么可以添加'(' 或者 ')'
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
