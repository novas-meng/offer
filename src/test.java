import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.BatchUpdateException;
import java.util.HashMap;

/**
 * Created by mengfanshan on 2017/6/22.
 */
public class test {
    public static void main(String[] args)throws IOException
    {
        HashMap<String,String> youxiangmap=new HashMap<>();
        HashMap<String,String> phonemap=new HashMap<>();
        BufferedReader bufferedReader=new BufferedReader(new FileReader("GEMS20170508.csv"));
        String line=bufferedReader.readLine();
        while (line!=null)
        {
            String[] var=line.split(",");
            if(var[5].length()>4)
            youxiangmap.put(var[5],var[0]);
            if(var[7].length()>6)
            phonemap.put(var[7],var[0]);
            line=bufferedReader.readLine();
        }
        bufferedReader.close();
        BufferedReader bufferedReader1=new BufferedReader(new FileReader("res.csv"));
        FileWriter fileWriter=new FileWriter("temp.csv");
        line=bufferedReader1.readLine();
        while (line!=null)
        {
            String[] var=line.split(",");
            String id="";
            if(youxiangmap.containsKey(var[6]))
            {
                id=youxiangmap.get(var[6]);
            }
            else if(phonemap.containsKey(var[5]))
            {
                id=phonemap.get(var[5]);
            }
            else if(phonemap.containsKey(var[4]))
            {
                id=phonemap.get(var[4]);
            }
            else
            {
                id="NULL";
            }
            line=id+","+line;
            fileWriter.write(line+"\n");
            line=bufferedReader1.readLine();
        }
        fileWriter.close();
    }

}
