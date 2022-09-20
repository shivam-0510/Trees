package Max_Path_Sum;
public class node {
	int data;
	node left;
	node right;
	node(int data){
		this.data=data;
	}
	public static int maxPath(node root,int[] max) {
		if(root==null)return 0;
		int left=Math.max(0,maxPath(root.left,max));
		int right=Math.max(0,maxPath(root.right,max));
		max[0]=Math.max(max[0], left+right+root.data);
		return Math.max(left, right)+root.data;
	}
	public static int maxPathSum(node root) {
		int[] ans=new int[1];
		maxPath(root,ans);
		return ans[0];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root=new node(-10);
		root.left=new node(9);
		root.right=new node(20);
		root.right.left=new node(15);
		root.right.right=new node(7);
		System.out.println(maxPathSum(root));
	}

}
