import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * San Wong
 * hswong1@uci.edu
 * 
 * Just a simple tree that my friend ask me to implement
 */
public class justATree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree stupidTree = new Tree(57);
		stupidTree.insert(79);
		stupidTree.insert(63);
		stupidTree.insert(54);
		stupidTree.insert(75);
		stupidTree.insert(4);
		stupidTree.insert(17);
		
		System.out.println("Show case of DFS");
		DFS(stupidTree.root);
		System.out.println();
		System.out.println("The stupid tree is with height of " + treeHeight(stupidTree.root));
		System.out.println("Show case of Level-Order-Traversal");
		System.out.println();
		LevelOrderTraversal(stupidTree.root);
		System.out.println();
		System.out.println("Show case of PreOrder");
		preOrder(stupidTree.root);
		System.out.println();
		System.out.println("Show case of inOrder");
		inOrder(stupidTree.root);
		System.out.println();
		System.out.println("Show case of PostOrder");
		postOrder(stupidTree.root);
		
	}
	
	public static void DFS(TreeNode n){
		Stack<TreeNode> st = new Stack<TreeNode>();

		//Push a root to the stack
		st.push(n);

		while(!st.isEmpty()){
			TreeNode current = st.pop();
			System.out.print(current.data + " ");

			if(current.left != null){
				st.push(current.left);
			}
			if(current.right != null){
				st.push(current.right);
			}
		}

		//When your stack is empty. You are done.
		return;
	}
	
	public static int treeHeight(TreeNode n){
		if (n==null){
			return 0;
		}

		return 1+Math.max(treeHeight(n.left),treeHeight(n.right));
	}
	
	public static void LevelOrderTraversal(TreeNode n){
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		

		//Push a root to the queue
		q.add(n);

		while(!q.isEmpty()){
			TreeNode current = q.remove();
			System.out.print(current.data + " ");

			if(current.left != null){
				q.add(current.left);
			}
			if(current.right != null){
				q.add(current.right);
			}
		}

		//When your queue is empty, you are done
	}

	public static void preOrder(TreeNode n){
		if (n == null){
			return;
		}

		System.out.print(n.data + " ");
		preOrder(n.left);
		preOrder(n.right);
	}

	public static void inOrder(TreeNode n){
		if (n == null){
			return;
		}

		inOrder(n.left);
		System.out.print(n.data + " ");
		inOrder(n.right);
	}

	public static void postOrder(TreeNode n){
		if (n == null){
			return;
		}

		postOrder(n.left);
		postOrder(n.right);
		System.out.print(n.data + " ");
	}

}

class TreeNode{
	TreeNode left;
	TreeNode right;
	int data;

	//Constructor
	public TreeNode(int d){
		data = d;
		left = null;
		right = null;
	}
}

class Tree{
	public TreeNode root;

	//Constructor
	public Tree(int d){
		TreeNode newNode = new TreeNode(d);
		root = newNode;
	}

	public void insert(int d){
		TreeNode newNode = new TreeNode(d);
		TreeNode parent = null;
		TreeNode current = root;

		while(true){
			parent = current;
			//int compareResult = newNode.data.compareTo(current.data);
			if(d<current.data){
				current = current.left;
				if(current == null){
					parent.left = newNode;
					return;
				}
			}else if(d>current.data){
				current = current.right;
				if(current==null){
					parent.right = newNode;
					return;
				}
			}
		}
	}
}
