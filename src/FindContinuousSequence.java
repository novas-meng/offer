import java.util.ArrayList;

/**
 * Created by mengfanshan on 2017/7/5.
 */
public class FindContinuousSequence {
    public static void main(String[] args)
    {
        FindContinuousSequence(100);
    }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> resList=new ArrayList<>();
        int mid=(int)Math.sqrt(sum*2);
        int target=sum*2;
        for (int i=mid;i>=2;i--)
        {
            if(target%i==0)
            {
                int big=target/i;
                int count=i-1;
                if((big-count)%2!=0)
                {
                    continue;
                }
                int begin=(big-count)/2;
                ArrayList<Integer> list=new ArrayList<>();
                for (int j=begin;j<=begin+count;j++)
                {
                    list.add(j);
                }
                resList.add(list);
            }
        }
        for (int i=0;i<resList.size();i++)
        {
            System.out.println(resList.get(i));
        }
        return resList;
    }
}
