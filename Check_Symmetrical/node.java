package Check_Symmetrical;
public class node {
	int data;
	node left;
	node right;
	node(int data){
		this.data=data;
	}
	public static boolean isSymmetricHelp(node left,node right) {
		if(left==null || right==null)return left==right;
		if(left.data!=right.data)return false;
		return isSymmetricHelp(left.left,right.right) && isSymmetricHelp(left.right,right.left);
	}
	public static boolean isSymmetric(node root) {
		return(root==null || isSymmetricHelp(root.left,root.right));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root=new node(1);
		root.left=new node(2);
		root.right=new node(2);
		root.left.left=new node(3);
		root.left.right=new node(4);
		root.right.left=new node(4);
		root.right.right=new node(3);
		System.out.print(isSymmetric(root));
	}

}
