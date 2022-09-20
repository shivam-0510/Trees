package Check_Balanced;
public class node {
	int data;
	node left;
	node right;
	node(int data){
		this.data=data;
	}
	public static int maxHeight(node root) {
		if(root==null)return 0;
		return 1+Math.max(maxHeight(root.left), maxHeight(root.right));
	}
	//Naive solution
	public static boolean checkBalance1(node root) {
		if(root==null)return true;
		int leftHeight=maxHeight(root.left);
		int rightHeight=maxHeight(root.right);
		if(Math.abs(leftHeight-rightHeight)>1)return false;
		checkBalance1(root.left);
		checkBalance1(root.right);
		if(leftHeight==-1 || rightHeight==-1)return false;
		return true;
	}
	//Optimized approach
	public static int check(node root) {
		if(root==null)return 0;
		int leftHeight=maxHeight(root.left);
		int rightHeight=maxHeight(root.right);
		if(Math.abs(leftHeight-rightHeight)>1)return -1;
		if(leftHeight==-1 && rightHeight==-1)return -1;
		return 1+Math.max(leftHeight,rightHeight);
	}
	public static boolean checkBalance2(node root) {
		int ans=check(root);
		if(ans==-1)return false;
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root=new node(3);
		root.left=new node(9);
		root.right=new node(20);
		//root.left.left=new node(5);
		//root.left.right=new node(4);
		root.right.left=new node(15);
		root.right.right=new node(7);
		System.out.println(checkBalance1(root));
		System.out.println(checkBalance2(root));
	}

}
