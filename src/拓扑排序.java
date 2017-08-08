import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mengfanshan on 2017/7/20.
 */
public class ÍØÆËÅÅĞò {
    //Êä³öÍØÆËÅÅĞòĞòÁĞ
    public static void tuopuSort(int[][] array,HashMap<Integer,String> index_map)
    {
        int[] rudu=new int[array.length];
        for (int i=0;i<array.length;i++)
        {
            for (int j=0;j<array.length;j++)
            {
                if(array[j][i]==1)
                {
                    rudu[i]++;
                }
            }
        }
        Queue<Integer> queue=new LinkedList<>();
        for (int i=0;i<rudu.length;i++)
        {
            if(rudu[i]==0)
            {
                //System.out.println(index_map.get(i));
                queue.add(i);
                rudu[i]=-1;
            }
        }
        while (!queue.isEmpty())
        {
            int node=queue.poll();
            System.out.println(index_map.get(node));
            for (int i=0;i<array.length;i++)
            {
                if(array[node][i]==1)
                {
                    rudu[i]--;
                }
            }
            for (int i=0;i<rudu.length;i++)
            {
                if(rudu[i]==0)
                {
                    //System.out.println(index_map.get(i));
                    queue.add(i);
                    rudu[i]=-1;
                }
            }
        }
        System.out.println(array.length);
    }
    public static void main(String[] args)throws IOException
    {
        BufferedReader bufferedReader=new BufferedReader(new FileReader("res.csv"));
        String line=bufferedReader.readLine();
        ArrayList<String> linelist=new ArrayList<>();
        HashMap<String,Integer> map=new HashMap<>();
        HashMap<Integer,String> index_map=new HashMap<>();

        int count=0;
        while (line!=null)
        {
            linelist.add(line);
            String[] var=line.split(" ");
            for (int i=0;i<var.length;i++)
            {
                if(!map.containsKey(var[i]))
                {
                    map.put(var[i],count);
                    index_map.put(count,var[i]);
                    count=count+1;
                }
            }
            line=bufferedReader.readLine();
        }
        //System.out.println(map.size());
        int[][] array=new int[map.size()][map.size()];
        for (int i=0;i<linelist.size();i++)
        {
            String[] var=linelist.get(i).split(" ");
           // System.out.println(var.length+" "+linelist.get(i));
           // System.out.println(var[0]+","+var[1]);
            array[map.get(var[0])][map.get(var[1])]=1;
        }
        tuopuSort(array,index_map);
    }

}
