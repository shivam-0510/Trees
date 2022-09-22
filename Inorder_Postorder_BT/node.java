package Inorder_Postorder_BT;
import java.util.*;
public class node {
	int data;
	node left;
	node right;
	node(int data){
		this.data=data;
	}
	public static List<Integer>getInorder(node root){
		List<Integer>ans=new ArrayList<Integer>();
		node curr=root;
		while(curr!=null) {
			if(curr.left==null) {
				ans.add(curr.data);
				curr=curr.right;
			}
			else {
				node prev=curr.left;
				while(prev.right!=null && prev.right!=curr) {
					prev=prev.right;
				}
				if(prev.right==null) {
					prev.right=curr;
					curr=curr.left;
				}
				else {
					prev.right=null;
					ans.add(curr.data);
					curr=curr.right;
				}
			}
		}
		return ans;
	}
	public static node buildTree(int[] inOrder,int[]postOrder) {
		Map<Integer,Integer>m=new HashMap<>();
		for(int i=0;i<inOrder.length;i++) {
			m.put(inOrder[i], i);
		}
		node root=buildtree(postOrder,0,postOrder.length-1,inOrder,0,inOrder.length-1,m);
		return root;
	}
	public static node buildtree(int[] postOrder,int pS,int pE,int[] inOrder,int iS,int iE,Map<Integer,Integer>m) {
		if(pS>pE || iS>iE)return null;
		node root=new node(postOrder[pE]);
		int inRoot=m.get(root.data);
		int numsLeft=inRoot-iS;
		root.left=buildtree(postOrder,pS,pS+numsLeft-1,inOrder,iS,inRoot-1,m);
		root.right=buildtree(postOrder,pS+numsLeft,pE-1,inOrder,inRoot+1,iE,m);
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inOrder= {40,20,50,10,60,30};
		int[] postOrder= {40,50,20,60,30,10};
		node root=buildTree(inOrder,postOrder);
		System.out.print(getInorder(root));
	}

}
