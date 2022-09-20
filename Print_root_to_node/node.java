package Print_root_to_node;
import java.util.*;
public class node {
	int data;
	node left;
	node right;
	node(int data){
		this.data=data;
	}
	static public boolean getPath(node root,ArrayList<Integer>ans,int x) {
		if(root==null)return false;
		ans.add(root.data);
		if(root.data==x)return true;
		if(getPath(root.left,ans,x) || getPath(root.right,ans,x)) {
			return true;
		}
		ans.remove(ans.size()-1);
		return false;
	}
	static public ArrayList<Integer> solve(node root,int x){
		ArrayList<Integer> ans=new ArrayList<Integer>();
		if(root==null)return ans;
		getPath(root,ans,x);
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root=new node(1);
		root.left=new node(2);
		root.left.left=new node(4);
		root.left.right=new node(5);
		root.left.right.left=new node(6);
		root.left.right.right=new node(7);
		root.right=new node(3);
		System.out.print(solve(root,7));
	}

}
