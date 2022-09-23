package Ceil_BST;
public class node {
	int data;
	node left;
	node right;
	node(int data){
		this.data=data;
	}
	public static int ceilBST(node root,int key) {
		int ceil=-1;
		while(root!=null) {
			if(root.data==key) {
				ceil=root.data;
				return ceil;
			}
			if(root.data<key) {
				root=root.right;
			}
			else {
				ceil=root.data;
				root=root.left;
			}
		}
		return ceil;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root=new node(4);
		root.left=new node(2);
		root.left.left=new node(1);
		root.right=new node(7);
		root.right.left=new node(5);
		System.out.print(ceilBST(root,6));
	}

}
