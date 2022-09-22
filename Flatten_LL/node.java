package Flatten_LL;
import java.util.*;
public class node {
	int data;
	node left;
	node right;
	node(int data){
		this.data=data;
	}
	//Approach-1
	private static node prev=null;
	public static void flatten(node root) {
		if(root==null)return;
		flatten(root.right);
		flatten(root.left);
		root.right=prev;
		root.left=null;
		prev=root;
	}
	//Approach-2
	public static void Flatten(node root) {
		if(root==null)return;
		Stack<node>s=new Stack<>();
		s.push(root);
		while(s.isEmpty()!=true) {
			node curr=s.peek();s.pop();
			if(curr.right!=null)s.push(curr.right);
			if(curr.left!=null)s.push(curr.left);
			if(s.isEmpty()!=true) {
				curr.right=s.peek();
				curr.left=null;
			}
		}
	}
	public static List<Integer>getInorder(node root){
		List<Integer>ans=new ArrayList<Integer>();
		node curr=root;
		while(curr!=null) {
			if(curr.left==null) {
				ans.add(curr.data);
				curr=curr.right;
			}
			else {
				node prev=curr.left;
				while(prev.right!=null && prev.right!=curr) {
					prev=prev.right;
				}
				if(prev.right==null) {
					prev.right=curr;
					curr=curr.left;
				}
				else {
					prev.right=null;
					ans.add(curr.data);
					curr=curr.right;
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root=new node(1);
		root.left=new node(2);
		root.left.left=new node(3);
		root.left.right=new node(4);
		root.right=new node(5);
		root.right.right=new node(6);
		root.right.right.left=new node(7);
		Flatten(root);
		System.out.print(getInorder(root));
	}

}
