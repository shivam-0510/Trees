package Boundary_Traversal;
import java.util.*;
public class node {
	int data;
	node left;
	node right;
	node(int data){
		this.data=data;
	}
	public static boolean isLeaf(node root) {
		if(root.left==null && root.right==null)return true;
		return false;
	}
	public static void addLeft(node root,ArrayList<Integer> ans) {
		node curr=root.left;
		if(isLeaf(curr)!=true) {
			ans.add(curr.data);
			if(curr.left!=null)curr=curr.left;
			else curr=curr.right;
		}
	}
	public static void addLeaf(node root,ArrayList<Integer> ans) {
		if(isLeaf(root)==true) {ans.add(root.data);}
		if(root.left!=null)addLeaf(root.left, ans);
		if(root.right!=null)addLeaf(root.right,ans);
	}
	public static void addRight(node root,ArrayList<Integer> ans) {
		ArrayList<Integer> res=new ArrayList<Integer>();
		node curr=root.right;
		while(curr!=null) {
			if(isLeaf(curr)!=true)res.add(curr.data);
			if(curr.left!=null)curr=curr.left;
			if(curr.right!=null)curr=curr.right;
		}
		for(int i=res.size()-1;i>0;i--) {
			ans.add(res.get(i));
		}
	}
	public static ArrayList<Integer> boundaryTraversal(node root){
		ArrayList<Integer> ans=new ArrayList<Integer>();
		if(isLeaf(root)==true)ans.add(root.data);
		addLeft(root,ans);
		addLeaf(root,ans);
		addRight(root,ans);
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root=new node(1);
		root.left=new node(2);
		root.left.left=new node(3);
		root.left.left.right=new node(4);
		root.left.left.right.left=new node(5);
		root.left.left.right.right=new node(6);
		root.right=new node(7);
		root.right.right=new node(8);
		root.right.right.left=new node(9);
		root.right.right.left.left=new node(10);
		root.right.right.left.right=new node(11);
		System.out.print(boundaryTraversal(root));
	}

}
