import java.util.ArrayList;

/**
 * Created by mengfanshan on 2017/7/13.
 */
class  poi
{
    double begin;
    double end;
}
public class TWO {

    public static int partition(poi[] array,int p,int q)
    {
        int index=p-1;
        double key=array[q].begin;
        poi temp=new poi();
        for (int i=p;i<q;i++)
        {
            if(array[i].begin<key)
            {
                index++;
                temp.begin=array[i].begin;
                temp.end=array[i].end;
                array[i].begin=array[index].begin;
                array[i].end=array[index].end;
                array[index].begin=temp.begin;
                array[index].end=temp.end;
            }
        }
        index++;
        temp.begin=array[index].begin;
        temp.end=array[index].end;
        array[index].begin=array[q].begin;
        array[index].end=array[q].end;
        array[q].begin=temp.begin;
        array[q].end=temp.end;
        return index;
    }
    public static void quicksort(poi[] array,int p,int q)
    {
        if(p<q)
        {
            int partition=partition(array,p,q);
            quicksort(array,p,partition-1);
            quicksort(array,partition+1,q);
        }
    }
    public static double getAllLength(poi[] array)
    {
        quicksort(array,0,array.length-1);
        for (int i=0;i<array.length;i++) {
            System.out.println("==" + array[i].begin + "," + array[i].end);
        }
        ArrayList<poi> list=new ArrayList<>();
        int k=0;
        int j=1;
        while (j<array.length)
        {
            if(array[k].end>array[j].end)
            {
                j++;
            }
            else
            {
                System.out.println("k="+k+",j="+j);
                list.add(array[k]);
                list.add(array[j]);
                k=j;
                j=k+1;

            }

        }
        array=new poi[list.size()];
        for (int i=0;i<list.size();i++)
        {
            array[i]=list.get(i);
        }
        double sum=0;
        System.out.println("length="+array.length+","+list.size());
        for (int i=0;i<array.length-1;i++)
        {
            System.out.println("=="+array[i].begin+","+array[i].end);

            if(array[i].end<array[i+1].begin)
            {
                sum=sum+array[i].end-array[i].begin;
            }
            else
            {
                sum=sum+array[i+1].begin-array[i].begin;
            }
            System.out.println("sum="+sum);
        }
        double beginmax=array[array.length-1].begin;
        double endmax=0;
        for (int i=0;i<array.length;i++)
        {
            if(array[i].end>endmax)
            {
                endmax=array[i].end;
            }
        }
        sum=sum+endmax-beginmax;
        return sum;
    }
    public static void main(String[] args)
    {
        poi poi1=new poi();
        poi1.begin=19;
        poi1.end=21;

        poi poi2=new poi();
        poi2.begin=25;
        poi2.end=27;

        poi poi3=new poi();
        poi3.begin=8;
        poi3.end=24;

        poi poi4=new poi();
        poi4.begin=26;
        poi4.end=29;

        poi poi5=new poi();
        poi5.begin=6;
        poi5.end=15;

        poi poi6=new poi();
        poi6.begin=36;
        poi6.end=39;


        poi[] array=new poi[6];
        array[0]=poi1;
        array[1]=poi2;
        array[2]=poi3;
        array[3]=poi4;
        array[4]=poi5;
        array[5]=poi6;


        System.out.println(getAllLength(array));
    }
}
