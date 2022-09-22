package Morris_traversal;
import java.util.*;
public class node {
	int data;
	node left;
	node right;
	node(int data){
		this.data=data;
	}
	//In-order traversal
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
	//Pre-order traversal
	public static List<Integer>getPreorder(node root){
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
					ans.add(curr.data);
					curr=curr.left;
				}
				else {
					prev.right=null;
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
		root.left.left=new node(4);
		root.left.right=new node(5);
		root.left.right.right=new node(6);
		root.right=new node(3);
		System.out.println(getInorder(root));
		System.out.println(getPreorder(root));
	}

}
