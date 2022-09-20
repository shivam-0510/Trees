package Top_view;
import java.util.*;
class Pair{
	int data;
	node Node;
	Pair(node Node,int data){
		this.Node=Node;
		this.data=data;
	}
}
public class node {
	int data;
	node left;
	node right;
	node(int data){
		this.data=data;
	}
	public static ArrayList<Integer> topView(node root){
		ArrayList<Integer> ans=new ArrayList<Integer>();
		if(root==null)return ans;
		Map<Integer,Integer> m=new TreeMap<>();
		Queue<Pair> q=new LinkedList<Pair>();
		q.add(new Pair(root,0));
		while(q.isEmpty()!=true) {
			Pair p=q.remove();
			int id=p.data;
			node temp=p.Node;
			if(m.get(id)==null)m.put(id,temp.data);
			if(temp.left!=null)q.add(new Pair(temp.left,id-1));
			if(temp.right!=null)q.add(new Pair(temp.right,id+1));
		}
		for (Map.Entry<Integer,Integer> entry : m.entrySet()) {
            ans.add(entry.getValue()); 
        }
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root=new node(1);
		root.left=new node(2);
		root.left.left=new node(4);
		root.left.right=new node(5);
		root.left.right.left=new node(6);
		root.right=new node(3);
		root.right.right=new node(7);
		System.out.println(topView(root));
	}

}
