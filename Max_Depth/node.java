package Max_Depth;
import java.util.*;
public class node {
	int data;
	node left;
	node right;
	node(int data){
		this.data=data;
	}
	//Recursive solution
	public static int maxHeight1(node root) {
		if(root==null)return 0;
		return 1+Math.max(maxHeight1(root.left), maxHeight1(root.right));
	}
	//Level-order traversal
	public static int maxHeight2(node root) {
		int height=0;
		if(root==null)return height;
		Queue<node> s=new LinkedList<node>();
		s.add(root);
		while(s.isEmpty()!=true) {
			int size=s.size();
			height++;
			for(int i=0;i<size;i++) {
				root=s.remove();
				if(root.right!=null)s.add(root.right);
				if(root.left!=null)s.add(root.left);
			}
		}
		return height;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root=new node(1);
		root.left=new node(2);
		root.right=new node(3);
		root.left.left=new node(4);
		root.left.right=new node(5);
		root.right.left=new node(6);
		root.right.right=new node(7);
		System.out.println(maxHeight1(root));
		System.out.println(maxHeight2(root));
	}

}
