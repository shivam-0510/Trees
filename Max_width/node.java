package Max_width;
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
	public static int maxWidth(node root) {
		if(root==null)return 0;
		int ans=0;
		Queue<Pair> q=new LinkedList<Pair>();
		q.offer(new Pair(root,0));
		while(q.isEmpty()!=true) {
			int size=q.size();
			int min=q.peek().data;
			int first=0,last=0;
			for(int i=0;i<size;i++) {
				int cur=q.peek().data-min;
				node n=q.peek().Node;
				q.poll();
				if(i==0)first=cur;
				if(i==size-1)last=cur;
				if(n.left!=null)q.offer(new Pair(n.left,cur*2+1));
				if(n.right!=null)q.offer(new Pair(n.right,cur*2+2));
			}
			ans=Math.max(ans, last-first+1);
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root=new node(1);
		root.left=new node(3);
		root.left.left=new node(5);
		root.left.right=new node(3);
		root.right=new node(2);
		root.right.right=new node(9);
		System.out.print(maxWidth(root));
	}

}
