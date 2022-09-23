package Vertical_Traversal;
import java.util.*;
class Tuple {
    node Node; 
    int row;
    int col; 
    public Tuple(node _node, int _row, int _col) {
        Node = _node; 
        row = _row; 
        col = _col; 
    }
}
public class node {
	int data;
	node left;
	node right;
	node(int data){
		this.data=data;
	}
	public static List<List<Integer>> verticalTraversal(node root) {
	    TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>(); 
	    Queue<Tuple> q = new LinkedList<Tuple>();
	    q.offer(new Tuple(root, 0, 0)); 
	    while(!q.isEmpty()) {
	        Tuple tuple = q.poll(); 
	        node node = tuple.Node; 
	        int x = tuple.row; 
	        int y = tuple.col; 
	        
	        
	        if (!map.containsKey(x)) {
	            map.put(x, new TreeMap<>());
	        }
	        if (!map.get(x).containsKey(y)) {
	            map.get(x).put(y, new PriorityQueue<>());
	        }
	        map.get(x).get(y).offer(node.data);
	        
	        if(node.left != null) {
	            q.offer(new Tuple(node.left, x - 1, y + 1)); 
	        } 
	        if(node.right != null) {
	            q.offer(new Tuple(node.right, x + 1, y + 1)); 
	        }
	    }
	    List<List<Integer>> list = new ArrayList<>();
	    for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
	        list.add(new ArrayList<>());
	        for (PriorityQueue<Integer> nodes : ys.values()) {
	            while (!nodes.isEmpty()) {
	                list.get(list.size() - 1).add(nodes.poll());
	            }
	        }
	    }
	    return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root=new node(1);
		root.left=new node(2);
		root.right=new node(3);
		root.left.left=new node(4);
		root.left.right=new node(5);
		root.right.right=new node(6);
		System.out.println(verticalTraversal(root));
	}

}
