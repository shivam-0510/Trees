package Insert_BST;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
public class node {
	int data;
	node left;
	node right;
	node(int data){
		this.data=data;
	}
	public static node insertBST(node root,int val) {
		if(root==null) return new node(val);
		node curr=root;
		while(true) {
			if(curr.data<=val) {
				if(curr.right!=null)curr=curr.right;
				else {
					curr.right=new node(val);
					break;
				}
			}else {
				if(curr.left!=null)curr=curr.left;
				else {
					curr.left=new node(val);
					break;
				}
			}
		}
		return root;
	}
	public static List<List<Integer>> levelOrder(node root){
		List<List<Integer>> ans=new LinkedList<List<Integer>>();
		Queue <node> q=new LinkedList<node>();
		if(root==null)return ans;
		q.offer(root);
		while(q.isEmpty()!=true) {
			int size=q.size();
			List<Integer> list=new LinkedList<Integer>();
			for(int i=0;i<size;i++) {
				if(q.peek().left!=null)q.offer(q.peek().left);
				if(q.peek().right!=null)q.offer(q.peek().right);
				list.add(q.poll().data);
			}
			ans.add(list);
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root=new node(4);
		root.left=new node(2);
		root.left.left=new node(1);
		root.left.right=new node(3);
		root.right=new node(7);
		node ans=insertBST(root,5);
		System.out.print(levelOrder(ans));
	}

}
