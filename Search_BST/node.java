package Search_BST;
public class node {
	int data;
	node left;
	node right;
	node(int data){
		this.data=data;
	}
	public static node searchBST(node root,int data) {
		while(root!=null && root.data!=data) {
			if(root.data>data) {
				root=root.left;
			}
			else {
				root=root.right;
			}
		}
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root=new node(4);
		root.left=new node(2);
		root.left.left=new node(1);
		root.right=new node(7);
		root.right.left=new node(5);
		System.out.print(searchBST(root,1));
	}

}
