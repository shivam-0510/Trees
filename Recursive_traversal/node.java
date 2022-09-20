package Recursive_traversal;
import java.util.*;
public class node {
	int data;
	node left;
	node right;
	node(int data){
		this.data=data;
	}
	//In-order traversal
	public static void inOrder(node root) {
		if(root==null) {return;}
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	//Pre-order traversal
	public static void preOrder(node root) {
		if(root==null) {return ;}
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	//Post-order traversal
	public static void postOrder(node root) {
		if(root==null) {return ;}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}
	//Level-order traversal
	public static List<List<Integer>> levelOrder(node root){
		List<List<Integer>> ans=new LinkedList<List<Integer>>();
		Queue <node> q=new LinkedList<node>();
		if(root==null)return ans;
		q.offer(root);
		while(q.isEmpty()!=true) {
			int size=q.size();
			List<Integer> list=new LinkedList<Integer>();
			for(int i=0;i<size;i++) {
				if(q.peek().left!=null)q.offer(q.peek().left);
				if(q.peek().right!=null)q.offer(q.peek().right);
				list.add(q.poll().data);
			}
			ans.add(list);
		}
		return ans;
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
		System.out.println("Inorder traversal");
		inOrder(root);
		System.out.println();
		System.out.println("Preorder traversal");
		preOrder(root);
		System.out.println();
		System.out.println("Postorder traversal");
		postOrder(root);
		System.out.println();
		System.out.println("Levelorder traversal");
		System.out.println(levelOrder(root));
	}

}
