import java.util.ArrayList;

/*
 * San Wong
 * hswong1@uci.edu
 * 
 * Serialize and Deserialize a binary tree
 */
public class SerializeANDDeserialize {

	public static void main(String[] args) {
		//Construct a tree
		TreeNode root = new TreeNode(7);
		TreeNode node2 = new TreeNode(2);
		TreeNode node5 = new TreeNode(5);		
		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		TreeNode node8 = new TreeNode(8);
		
		root.setLeftChild(node2);
		root.setRightChild(node5);
		node2.setLeftChild(node1);
		node5.setLeftChild(node3);
		node5.setRightChild(node8);
		
		ArrayList<Integer> serializeArray = new ArrayList<Integer>();
		serialize(root,serializeArray);
		System.out.println("Print Out Serialized array");
		printArrayList(serializeArray);
		
		resetIndex();
		TreeNode testNode = deserialize(serializeArray);
		System.out.println(testNode.val);
		System.out.println();
		System.out.println("Print Out deserialized tree inOrderly");
		inOrder(testNode);


	}
	
    public static void serialize(TreeNode root, ArrayList<Integer> array) {
        
        if (root == null){
        	array.add(-1);
        	return;
        }
        
        array.add(root.val);
        serialize(root.left,array);
        serialize(root.right,array);
    }
    
    static int index;
    public static void resetIndex(){
    	index = 0;
    }
    public static TreeNode deserialize(ArrayList<Integer> arrayList){
    	if (index == arrayList.size() || arrayList.get(index) == -1){
    		index++;
    		return null;
    	}
    	
    	TreeNode root = new TreeNode(arrayList.get(index));
    	index++;
    	root.left = deserialize(arrayList);
    	root.right = deserialize(arrayList);
    	
    	return root;
    }
    
    public static void printArrayList(ArrayList<Integer> arrayList){
    	for (int e: arrayList){
			System.out.print(e+ "  ");
		}
    }
    
    public static void inOrder(TreeNode root){
    	if (root == null) return;
    	
    	inOrder(root.left);
    	System.out.print(root.data + "  ");
    	inOrder(root.right);
    }

}
