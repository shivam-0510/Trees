package Inorder_Preorder_BT;
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
	public static node buildTree(int[] inOrder,int[]preOrder) {
		Map<Integer,Integer>m=new HashMap<>();
		for(int i=0;i<inOrder.length;i++) {
			m.put(inOrder[i], i);
		}
		node root=buildtree(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1,m);
		return root;
	}
	public static node buildtree(int[] preOrder,int pS,int pE,int[] inOrder,int iS,int iE,Map<Integer,Integer>m) {
		if(pS>pE || iS>iE)return null;
		node root=new node(preOrder[pS]);
		int inRoot=m.get(root.data);
		int numsLeft=inRoot-iS;
		root.left=buildtree(preOrder,pS+1,pS+numsLeft,inOrder,iS,inRoot-1,m);
		root.right=buildtree(preOrder,pS+numsLeft+1,pE,inOrder,inRoot+1,iE,m);
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inOrder= {40,20,50,10,60,30};
		int[] preOrder= {10,20,40,50,30,60};
		node root=buildTree(inOrder,preOrder);
		System.out.print(getInorder(root));
	}

}
