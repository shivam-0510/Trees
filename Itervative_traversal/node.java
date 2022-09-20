package Itervative_traversal;
import java.util.*;
public class node {
	int data;
	node left;
	node right;
	node(int data){
		this.data=data;
	}
	//Pre-order traversal
	public static List<Integer> preOrder(node root){
		List<Integer> ans=new ArrayList<Integer>();
		Stack<node> s=new Stack<node>();
		if(root==null)return ans;
		s.push(root);
		while(s.isEmpty()!=true) {
			root=s.pop();
			ans.add(root.data);
			if(root.right!=null)s.push(root.right);
			if(root.left!=null)s.push(root.left);
		}
		return ans;
	}
	//In-order traversal
	public static List<Integer> inOrder(node root){
		List<Integer> ans=new ArrayList<Integer>();
		Stack<node> s=new Stack<node>();
		if(root==null)return ans;
		node curr=root;
		while(true) {
			if(curr!=null) {
			s.push(curr);
			curr=curr.left;
			}
			else {
				if(s.isEmpty()==true) {
					break;
				}
				curr=s.pop();
				ans.add(curr.data);
				curr=curr.right;
			}
		}
		return ans;
	}
	//Post-order traversal
	public static List<Integer> postOrder(node root){
		List<Integer> ans=new ArrayList<Integer>();
		Stack<node> s1=new Stack<node>();
		Stack<node> s2=new Stack<node>();
		if(root==null)return ans;
		s1.push(root);
		while(s1.isEmpty()!=true) {
			root=s1.pop();
			s2.add(root);
			if(root.left!=null)s1.push(root.left);
			if(root.right!=null)s1.push(root.right);
		}
		while(s2.isEmpty()!=true) {
			ans.add(s2.pop().data);
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root=new node(1);
		root.left=new node(2);
		root.right=new node(7);
		root.left.left=new node(3);
		root.left.right=new node(4);
		root.left.right.left=new node(5);
		root.left.right.right=new node(6);
		System.out.println("Preorder traversal");
		System.out.println(preOrder(root));
		System.out.println();
		System.out.println("Inorder traversal");
		System.out.println(inOrder(root));
		System.out.println();
		System.out.println("Postorder traversal");
		System.out.println(postOrder(root));
	}

}
