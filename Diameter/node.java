package Diameter;
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
	public static int diameter1(node root) {
		if(root==null)return 0;
		int max=0;
		int leftDia=maxHeight(root.left);
		int rightDia=maxHeight(root.right);
		max=Math.max(max, leftDia+rightDia);
		diameter1(root.left);
		diameter1(root.right);
		return max;
	}
	//Optimized solution
	public static int height(node root,int[] maxi) {
		if(root==null)return 0;
		int leftDia=height(root.left,maxi);
		int rightDia=height(root.right,maxi);
		maxi[0]=Math.max(maxi[0],leftDia+rightDia);
		return 1+Math.max(leftDia, rightDia);
	}
	public static int diameter2(node root) {
		int[] ans=new int[1];
		height(root,ans);
		return ans[0];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root=new node(1);
		root.left=new node(2);
		root.right=new node(3);
		root.left.left=new node(4);
		root.left.right=new node(5);
		System.out.println(diameter1(root));
		System.out.println(diameter2(root));
	}

}
