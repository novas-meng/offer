import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import javax.print.attribute.standard.RequestingUserName;

import org.w3c.dom.NamedNodeMap;

class room {
	int left;
	int right;

	@Override
	public String toString() {
		return left+","+right;
	}
}

public class PDDTHREE {
	public static void main(String[] args) {
		int[][] roomspace = { {1,0,0,0,0}, {1,1,1,0,1 }, { 1,1,1,1,1 } };
		System.out.println(getArea(roomspace));
	}

	public static int getArea(int[][] roomspace) {

		Queue<room> queue = new LinkedList<room>();
		room begin = new room();
		begin.left = 0;
		begin.right = 0;
		queue.add(begin);

		Set<String> area = new HashSet<String>();
		area.add(begin.left+","+begin.right);
		while (!queue.isEmpty()) {
			/*for(room q : queue){
	            System.out.println(q.left + " " + q.right);
	        }*/
			room temp = queue.poll();
			System.out.println("queue:" + temp.left + " " + temp.right+","+area.size());
			for (int i = 0; i < 4; i++) {
				boolean flag = move(i, temp.left, temp.right, roomspace);
				if (flag == true) {
					if (i == 0) {
						room room0 = new room();
						room0.left = temp.left - 1;
						room0.right = temp.right;
						if (!area.contains(room0.toString())) {
							System.out.println(room0.left + " " + room0.right+"  0");
							queue.add(room0);
							area.add(room0.toString());
						}
					}
					if (i == 1) {
						room room1 = new room();
						room1.left = temp.left + 1;
						room1.right = temp.right;
						if (!area.contains(room1.toString())) {
							System.out.println(room1.left + " " + room1.right);
							queue.add(room1);
							area.add(room1.toString());
						}
					}
					if (i == 2) {
						room room2 = new room();
						room2.left = temp.left;
						room2.right = temp.right - 1;
						if (!area.contains(room2.toString())) {
							//System.out.println(room2.left + " " + room2.right);
							queue.add(room2);
							area.add(room2.toString());
						}
					}
					if (i == 3) {
						room room3 = new room();
						room3.left = temp.left;
						room3.right = temp.right + 1;
						if (!area.contains(room3.toString())) {
							//System.out.println(room3.left + " " + room3.right);
							queue.add(room3);
							area.add(room3.toString());
						}
					}

				} else
					continue;
			}
		}
			/*for(room q : queue){
	            System.out.println(q.left + " " + q.right);
	        }*/
		return area.size();

	}

	public static boolean move(int direction, int left, int right, int[][] room) {

		if (direction == 0) {
			//System.out.println(direction + ":left:" + left + " right:" + right);
			if (left > 0) {
				if (room[left - 1][right] == 1){
					//System.out.println(direction + ":left:" + left + " right:" + right);
					return true;}
				else
					return false;
			} else
				return false;
		}

		if (direction == 1) {
			//System.out.println(direction + ":left:" + left + " right:" + right);
			if (left < room.length - 1) {
				if (room[left + 1][right] == 1){
					//System.out.println(direction + ":left:" + left + " right:" + right);
					return true;}
				else
					return false;
			} else
				return false;
		}

		if (direction == 2) {
			//System.out.println(direction + ":left:" + left + " right:" + right);
			if (right > 0) {
				if (room[left][right - 1] == 1){
					//System.out.println(direction + ":left:" + left + " right:" + right);
					return true;}
				else
					return false;
			} else
				return false;
		}

		if (direction == 3) {
			//System.out.println(direction + ":left:" + left + " right:" + right);
			if (right < room[0].length - 1) {
				if (room[left][right + 1] == 1){
					//System.out.println(direction + ":left:" + left + " right:" + right);
					return true;}
				else
					return false;
			} else
				return false;
		}

		return true;
	}
}