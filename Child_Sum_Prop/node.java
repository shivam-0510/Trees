package Child_Sum_Prop;
import java.util.*;
public class node {
	int data;
	node left;
	node right;
	node(int data){
		this.data=data;
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
	public static void childSum(node root) {
		if(root==null)return;
		int child=0;
		if(root.left!=null)child+=root.left.data;
		if(root.right!=null)child+=root.right.data;
		if(child>=root.data)root.data=child;
		else {
			if(root.left!=null)root.left.data=root.data;
			if(root.right!=null)root.right.data=root.data;
		}
		childSum(root.left);
		childSum(root.right);
		int total=0;
		if(root.left!=null)total+=root.left.data;
		if(root.right!=null)total+=root.right.data;
		if(root.left!=null || root.right!=null)root.data=total;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root=new node(40);
		root.left=new node(10);
		root.left.left=new node(2);
		root.left.right=new node(5);
		root.right=new node(20);
		root.right.left=new node(30);
		root.right.right=new node(40);
		childSum(root);
		System.out.print(getInorder(root));
	}

}
