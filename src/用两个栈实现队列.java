import java.util.Stack;

/**
 * Created by mengfanshan on 2017/8/6.
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class 用两个栈实现队列 {
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
