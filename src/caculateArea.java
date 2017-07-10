import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
class xypoint{
    public double x;
    public double y;
    xypoint(double x,double y){
        this.x=x;
        this.y=y;
    }  
}  
public class caculateArea {  
        public static float caculate(xypoint vertex[],int pointNum)
        {  
            int i=0;  
            float temp=0;  
            for(;i<pointNum-1;i++)  
            {  
                temp+=(vertex[i].x-vertex[i+1].x)*(vertex[i].y+vertex[i+1].y);  
            }  
            temp+=(vertex[i].x-vertex[0].x)*(vertex[i].y+vertex[0].y);  
            return temp/2;  
        }  
        public static void main(String args[])   throws IOException
        {
            BufferedReader bufferedReader=new BufferedReader(new FileReader("temp.txt"));
            String line=bufferedReader.readLine();
            ArrayList<xypoint> list=new ArrayList<>();
            while (line!=null)
            {
                String[] var=line.split(",");
                double x=Double.valueOf(var[0]);
                double y=Double.valueOf(var[1]);
                xypoint xy=new xypoint(x,y);
                list.add(xy);
                line=bufferedReader.readLine();
            }
            xypoint[] vertex=new xypoint[list.size()];
            for (int i=0;i<list.size();i++)
            {
                vertex[i]=list.get(i);
            }
            System.out.println("多边形面积是："+caculate(vertex,vertex.length));
        }  
}  