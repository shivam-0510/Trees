package Printnodes_k_distance;
import java.util.*;
public class node {
	int data;
	node left;
	node right;
	node(int data){
		this.data=data;
	}
	private static void markParents(node root, Map<node, node> parent_track, node target) {
        Queue<node> queue = new LinkedList<node>();
        queue.offer(root);
        while(!queue.isEmpty()) { 
            node current = queue.poll(); 
            if(current.left != null) {
                parent_track.put(current.left, current);
                queue.offer(current.left);
            }
            if(current.right != null) {
                parent_track.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }
    public static List<Integer> distanceK(node root, node target, int k) {
        Map<node, node> parent_track = new HashMap<>();
        markParents(root, parent_track, root); 
        Map<node, Boolean> visited = new HashMap<>(); 
        Queue<node> queue = new LinkedList<node>();
        queue.offer(target);
        visited.put(target, true);
        int curr_level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            if(curr_level == k) break;
            curr_level++;
            for(int i=0; i<size; i++) {
                node current = queue.poll(); 
                if(current.left != null && visited.get(current.left) == null) {
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                if(current.right != null && visited.get(current.right) == null ) {
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                if(parent_track.get(current) != null && visited.get(parent_track.get(current)) == null) {
                    queue.offer(parent_track.get(current));
                    visited.put(parent_track.get(current), true);
                }
            }
        }
        List<Integer> result = new ArrayList<>(); 
        while(!queue.isEmpty()) {
            node current = queue.poll(); 
            result.add(current.data);
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root=new node(1);
		root.left=new node(2);
		root.right=new node(3);
		root.left.left=new node(4);
		root.left.right=new node(5);
		root.right.right=new node(6);
		System.out.println(distanceK(root,root.left,2));
	}

}
