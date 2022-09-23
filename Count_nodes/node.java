package Count_nodes;
public class node {
	int data;
	node left;
	node right;
	node(int data){
		this.data=data;
	}
	public static int countNodes(node root){
		if(root==null)return 0;
		int left=leftHeight(root);
		int right=rightHeight(root);
		if(left==right)return((2<<(left))-1);
		else return countNodes(root.left)+countNodes(root.right);
	}
	public static int leftHeight(node root) {
		int count=0;
		while(root.left!=null) {
			count++;
			root=root.left;
		}
		return count;
	}
	public static int rightHeight(node root) {
		int count=0;
		while(root.right!=null) {
			count++;
			root=root.right;
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root=new node(1);
		root.left=new node(2);
		root.right=new node(3);
		root.left.left=new node(4);
		root.left.right=new node(5);
		root.right.right=new node(6);
		System.out.println(countNodes(root));
	}

}
