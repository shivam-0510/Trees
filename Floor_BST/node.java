package Floor_BST;
public class node {
	int data;
	node left;
	node right;
	node(int data){
		this.data=data;
	}
	public static int floorBST(node root,int key) {
		int floor=-1;
		while(root!=null) {
			if(root.data==key) {
				floor=root.data;
				return floor;
			}
			if(root.data<key) {
				floor=root.data;
				root=root.right;
			}
			else {
				root=root.left;
			}
		}
		return floor;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root=new node(4);
		root.left=new node(2);
		root.left.left=new node(1);
		root.right=new node(7);
		root.right.left=new node(5);
		System.out.print(floorBST(root,6));
	}

}
