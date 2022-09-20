package LCA;
import java.util.*;
public class node {
	int data;
	 node left;
	 node right;
	 node(int data){
		 this.data=data;
	 }
	 static public node LCA(node root,node a,node b) {
		 if(root==null || root==a || root==b)return root;
		 node left=LCA(root.left,a,b);
		 node right=LCA(root.right,a,b);
		 if(left==null)return right;
		 else if(right==null)return left;
		 else return root;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root=new node(1);
		root.left=new node(2);
		root.left.left=new node(4);
		root.left.right=new node(5);
		root.left.right.left=new node(6);
		root.left.right.right=new node(7);
		root.right=new node(3);
		root.right.left=new node(8);
		root.right.right=new node(9);
		System.out.print(LCA(root,root.left.left,root.left.right.right));
	}

}
