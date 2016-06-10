import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.LinkedList;

/*
 * San Wong
 * hswong1@uci.edu
 */
public class LowestCommonAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode Node1 = new TreeNode(20);
		TreeNode Node2 = new TreeNode(8);
		TreeNode Node3 = new TreeNode(22);
		TreeNode Node4 = new TreeNode(4);
		TreeNode Node5 = new TreeNode(12);
		TreeNode Node6 = new TreeNode(10);
		TreeNode Node7 = new TreeNode(14);
		
		Node1.setLeftChild(Node2);
		Node1.setRightChild(Node3);
		Node2.setLeftChild(Node4);
		Node2.setRightChild(Node5);
		Node5.setLeftChild(Node6);
		Node5.setRightChild(Node7);
		
		//Run time for BST here is O(h) where h is the height of the tree
		//Iterate method will have the same run time but it is more space efficent
		//As recursive method requires keep making new stack
		TreeNode CA = BSTlowestCA(Node1,Node4,Node7);
		System.out.println("Lowest Common Ancestor: " + CA.val);
		System.out.println("With iterative method");
		TreeNode iterateCA = IterateBSTlowestCA(Node1, Node4, Node7);
		System.out.println("Lowest Common Ancestor: " + iterateCA.val);
		TreeNode BTCA = BTlowestCA(Node1,Node4,Node7);
		System.out.println("Lowest Common Ancestor of BT with recursive TOP DOWN method: " + BTCA.val);
		TreeNode BTCA1 = BTlowestCABottomUp(Node1, Node4, Node7);
		System.out.println("Lowest Common Ancestor of BT with recursive Bottom Up method: " + BTCA1.val);;
		TreeNode iterateBTCA = iterateBTLCA(Node1,Node4,Node7);
		System.out.println("LCA of BT with iterate method: " + iterateBTCA.val);
	}
	
	public static TreeNode BSTlowestCA(TreeNode root, TreeNode a, TreeNode b){
		if (a == null || b == null) return null;
		
		//Base case
		if (a==root) return a;
		if (b==root) return b;
		
		
		if(a.val < root.val && b.val < root.val) return BSTlowestCA(root.left, a,b);
		if(a.val > root.val && b.val > root.val) return BSTlowestCA(root.right, a,b);
		
		return root;
	}
	
	public static TreeNode IterateBSTlowestCA(TreeNode root, TreeNode a, TreeNode b){
		while(root != null){
			if(a.val<root.val && b.val<root.val){
				root = root.left;
			}else if(a.val>root.val && b.val>root.val){
				root = root.right;
			}else{
				break;
			}
		}
		return root;
	}
	
	//Run time: for balanced tree: it is O(n) where n is number of nodes.
	//unbalanced tree, worst case run time: O(n^2)
	public static TreeNode BTlowestCA(TreeNode root, TreeNode a, TreeNode b){
		if(root == null || a == null || b == null) return null;
		if(root == a || root ==b) return root;
		
		int countOfTargetNode = countTargetNode(root.left,a,b);
		if (countOfTargetNode == 1){
			return root;
		}else if (countOfTargetNode == 2){
			return BTlowestCA(root.left,a,b);
		}else{
			return BTlowestCA(root.right,a,b);
		}
		
	}
	
	public static int countTargetNode(TreeNode root, TreeNode a, TreeNode b){
		if (root == null) return 0;
		int count = countTargetNode(root.left,a,b) + countTargetNode(root.right,a,b);
		if (root == a || root ==b) {
			return 1+count;
		}else{
			return count;
		}
	}
	
	public static TreeNode BTlowestCABottomUp(TreeNode root, TreeNode a, TreeNode b){
		if (root == null) return null;
		
		if(root == a || root == b) return root;
		
		TreeNode L = BTlowestCABottomUp(root.left, a,b);
		TreeNode R = BTlowestCABottomUp(root.right, a,b);
		if(L!=null && R!=null) return root;
		
		if(L == null){
			return R;
		}else{
			return L;
		}
	}
	
	public static TreeNode iterateBTLCA(TreeNode root, TreeNode a, TreeNode b){
		HashMap<TreeNode, TreeNode> parent = new HashMap<>();
		Queue<TreeNode> queue = new LinkedList<>();
		parent.put(root,null); // Key = current node, Value = parent node
		queue.add(root);
		
		while(!parent.containsKey(a) || !parent.containsKey(b)){
			TreeNode node = queue.poll();
			if(node!=null){
				parent.put(node.left,node);
				parent.put(node.right,node);
				queue.add(node.left);
				queue.add(node.right);
			}
		}
		
		//At this point, we have discover both a and b Treenode
		Set<TreeNode> set = new HashSet<>();
		while(a!=null){
			set.add(a);
			a = parent.get(a);
		}
		
		while (!set.contains(b)) {
	        b = parent.get(b);
	    }
	    return b;
	}

}
