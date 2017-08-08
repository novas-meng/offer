import java.util.Stack;

/**
 * Created by mengfanshan on 2017/8/6.
 * ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 */
public class ������ջʵ�ֶ��� {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        int data=0;
        while (!stack1.isEmpty())
        {
            data=stack1.pop();
            stack2.push(data);
        }
        if(stack2.size()>0)
        {
            stack2.pop();
            while (!stack2.isEmpty())
            {
                stack1.push(stack2.pop());
            }
        }
        return data;
    }
}
