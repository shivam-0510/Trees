package Path_Sum;
import java.util.*;
public class node {
	int data;
	node left;
	node right;
	node(int data){
		this.data=data;
	}
    public static List<List<Integer>> pathSum(node root, int targetSum) {
        List<Integer>res=new ArrayList<Integer>();
        List<List<Integer>>ans=new ArrayList<List<Integer>>();
        sum(root,targetSum,res,ans);
        return ans;
    }
	public static void sum(node root,int sum,List<Integer>res,List<List<Integer>>ans){
        if(root==null)return;
        res.add(root.data);
        if(root.left==null && root.right==null && sum==root.data){
            ans.add(new ArrayList<Integer>(res));
        }else{
            sum(root.left,sum-root.data,res,ans);
            sum(root.right,sum-root.data,res,ans);
        }
        res.remove(res.size()-1);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root=new node(1);
		root.left=new node(2);
		root.right=new node(3);
		System.out.print(pathSum(root,3));
	}

}
