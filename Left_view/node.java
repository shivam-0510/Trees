package Left_view;
import java.util.*;
public class node {
	int data;
	node left;
	node right;
	node(int data){
		this.data=data;
	}
	public static void leftViewCheck(node root,int level,ArrayList<Integer> ans){
		if(root==null)return ; 
		if(level==ans.size()) {
			ans.add(root.data);
		}
		leftViewCheck(root.left,level+1,ans);
		leftViewCheck(root.right,level+1,ans);
		
	}
	public static ArrayList<Integer> leftView(node root) {
		ArrayList<Integer> ans=new ArrayList<Integer>();
		leftViewCheck(root,0,ans);
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root=new node(1);
		root.left=new node(2);
		root.left.left=new node(4);
		root.left.right=new node(5);
		root.left.right.left=new node(8);
		root.left.right.right=new node(9);
		root.right=new node(3);
		root.right.left=new node(6);
		root.right.right=new node(7);
		System.out.println(leftView(root));
	}

}
