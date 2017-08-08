import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

class node implements Comparable{
	int val;//值
	int pos;//出现在第几个数组
	
	node(int val,int pos){
		this.val = val;
		this.pos = pos;
	}
	
	node(){
		
	}
	
	@Override
	public String toString(){
		return "["+val+","+pos+"]";
	}
	
	@Override
	public int compareTo(Object o){
		node obj = (node) o;  
        if(val != obj.val)  
        {  
            return val - obj.val;  
        }  
        return pos - obj.pos;
	}
}


public class PDDFOUR{
	public static void main(String[] args){
		int[][] array = {{1,2,4,5},{2,3,4,5},{1,400},{400,1000},{3,5},{1,3,8},{8}};
		List<node> nodelist =  new ArrayList<node>();
		for(int i = 0;i < array.length;i++){
			for(int j = 0;j < array[i].length;j++){
				node temp = new node();
				temp.val = array[i][j];
				temp.pos = i;
				nodelist.add(temp);
			}
		}
//		for(int i = 0 ; i < nodelist.size();i++){
//			System.out.println(nodelist.get(i).toString());
//		}
		Collections.sort(nodelist);
		for(int i = 0 ; i < nodelist.size();i++){
			System.out.println(nodelist.get(i).toString());
		}
		getInterval(nodelist,array.length);
	}
	
	public static void getInterval(List<node> nodelist,int k) {
		int resultbegin = 0;
		int resultend = 0;
		Set<Integer> target = new HashSet<Integer>();
		for(int i = 0;i < k;i++){
			target.add(i);
		}
//		for(Iterator it = target.iterator();it.hasNext(); )
//        {             
//            System.out.println(it.next().toString());            
//        } 
		int min = Integer.MAX_VALUE;
		for(int i = 3;i < nodelist.size();i++){
			int begin = i;
			Set<Integer> temp = new HashSet<Integer>();
			for(int j = begin;j >= 0;j--){
				temp.add(nodelist.get(j).pos);
				if(temp.equals(target)){//说明找到了符合的区间
					if((nodelist.get(begin).val - nodelist.get(j).val) < min){
						min = nodelist.get(begin).val - nodelist.get(j).val;
						resultbegin = nodelist.get(j).val;
						resultend = nodelist.get(begin).val;
					}
					break;
				}
			}
		}
		System.out.println("["+resultbegin+","+resultend+"]");
	}
}