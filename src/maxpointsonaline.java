/**
 * Created by mengfanshan on 2017/7/16.
 * Given n points on a 2D plane,
 * find the maximum number of points that lie on the same straight line.
 */
public class maxpointsonaline {
    public static void main(String[] args)
    {
        Point p1=new Point(3,1);
        Point p2=new Point(12,3);
        Point p3=new Point(-6,-2);

        Point[] points=new Point[4];
        points[0]=p1;
        points[1]=p2;
        points[2]=p1;
        points[3]=p3;
        System.out.println(maxPoints(points));
    }

    public static int maxPoints(Point[] points) {
        if(points.length==1)
        {
            return 1;
        }
        int maxcount=0;
        for (int i=0;i<points.length;i++)
        {
            Point begin=points[i];
            for (int j=i+1;j<points.length;j++)
            {
                Point end=points[j];
                int count=0;
                if(end.x==begin.x&&end.y==begin.y)
                {
                    for (int m=0;m<points.length;m++)
                    {
                        Point c=points[m];
                        if(c.x==begin.x&&c.y==begin.y)
                        {
                            count++;
                        }
                    }
                }
                else
                {
                    for (int m=0;m<points.length;m++)
                    {
                        Point c=points[m];
                        int x1=end.x-begin.x;
                        int y1=end.y-begin.y;
                        int x2=c.x-begin.x;
                        int y2=c.y-begin.y;
                        if(y1*x2==y2*x1)
                        {
                            count++;
                        }
                    }
                }

                if(count>maxcount)
                {
                    maxcount=count;
                }
            }
        }
        return maxcount;

    }
}
