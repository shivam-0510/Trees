package Identical_trees;
public class node {
	int data;
	node left;
	node right;
	node(int data){
		this.data=data;
	}
	public static boolean identicalTrees(node root1,node root2) {
		if(root1==null || root2==null)return (root1==root2);
		return root1.data==root2.data && identicalTrees(root1.left,root2.left) && identicalTrees(root1.right,root2.right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root1=new node(1);
		root1.left=new node(2);
		root1.right=new node(3);
		root1.right.left=new node(4);
		root1.right.right=new node(5);
		node root2=new node(1);
		root2.left=new node(2);
		root2.right=new node(3);
		root2.right.left=new node(4);
		root2.right.right=new node(5);
		System.out.println(identicalTrees(root1,root2));
	}

}
