package Serialize_Deserialize;
import java.util.*;
public class node {
	int data;
	node left;
	node right;
	node(int data){
		this.data=data;
	}
	public static String serialize(node root) {
		if(root==null)return " ";
		Queue<node>q=new LinkedList<>();
		StringBuilder res=new StringBuilder();
		q.add(root);
		while(q.isEmpty()!=true) {
			node Node=q.poll();
			if(Node==null) {
				res.append("n ");
				continue;
			}
			res.append(Node.data+" ");
			q.add(Node.left);
			q.add(Node.right);
		}
		return res.toString();
	}
	public static node deSerialize(String data) {
		if(data==" ")return null;
		Queue<node>q=new LinkedList<>();
		String[] values=data.split(" ");
		node root=new node(Integer.parseInt(values[0]));
		q.add(root);
		for(int i=1;i<values.length;i++) {
			node Node=q.poll();
			if(values[i].equals("n")!=true) {
				node left=new node(Integer.parseInt(values[i]));
				Node.left=left;
				q.add(left);
			}
			if(values[++i].equals("n")!=true) {
				node right=new node(Integer.parseInt(values[i]));
				Node.right=right;
				q.add(right);
			}
		}
		
		return root;
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root=new node(1);
		root.left=new node(2);
		root.right=new node(13);
		root.right.left=new node(4);
		root.right.right=new node(5);
		String data=serialize(root);
		node Node=deSerialize(data);
		System.out.print(getInorder(Node));
	}

}
