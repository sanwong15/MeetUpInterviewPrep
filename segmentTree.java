/*
 * San Wong
 * hswong1@uci.edu
 * 
 * Segment Tree
 */
public class segmentTree {

	public static void main(String[] args) {
		int[] A = {1,3,5,7,9,11};
		int n = A.length;
		segmentTree tree = new segmentTree(A,n);
		tree.printOutst();
		
		System.out.println("Sum of values in given range = " + tree.getSum(n, 1, 3));
		
		//Update
		tree.updateValue(A, n, 1, 10);
		
		//After update
		System.out.println("Sum of values in given range (After update) = " + tree.getSum(n, 1, 3));
		

	}
	
	//Define an array to store segment tree nodes
	int st[]; 
	
	//Constructor
	public segmentTree(int[] input, int length){
		//Cal how much memory should we allocate for the tree.
		int height = (int)(Math.ceil(Math.log(length)/Math.log(2)));
		
		int max_size = 2*(int)Math.pow(2, height) -1;
		st = new int[max_size];
		
		constructTree(input,0,length-1,0);
	}
	
	//A recursive function that constructs Segment Tree for array[start,end]
	public int constructTree(int[] input, int start, int end, int currentNodeIndex){
		System.out.println("method called");
		System.out.println("start: " + start + "  end: " + end + "  currentNodeIndex: " + currentNodeIndex);
		//If there is only element in the array.
		if(start == end){
			st[currentNodeIndex] = input[start];
			return input[start];
		}
		
		//If there is more than one element in the array
		int mid = getMid(start, end);
		//Current Node value is the sum of LST and RST
		st[currentNodeIndex] = constructTree(input, start, mid, currentNodeIndex*2+1)+constructTree(input,mid+1,end,currentNodeIndex*2+2);
		System.out.println("st[currentNodeIndex]: " + st[currentNodeIndex] + " with currentNodeIndex: " + currentNodeIndex);
		return st[currentNodeIndex];
	}
	
	public int getMid(int start, int end){
		return (start + (end-start)/2);
	}
	
	public int getSum(int length, int QueryStart, int QueryEnd){
		if(QueryStart < 0 || QueryEnd > length-1 || QueryStart > QueryEnd){
			System.out.println("Invalid Input");
			return -1;
		}
		return getSumUtil(0,length-1,QueryStart,QueryEnd,0);
	}
	
	//start is initial to be 0 and end is n-1
	//QueryStart is the start of the range of interest
	//QueryEnd is the end of the range of interest
	public int getSumUtil(int start, int end, int QueryStart, int QueryEnd, int currentNodeIndex){
		System.out.println();
		System.out.println("getSumUtil method called");
		System.out.println("start: " + start + "  end: " + end + "  QueryStart: " + QueryStart + "  QueryEnd: " + QueryEnd + "  currentNodeIndex: " + currentNodeIndex);
		if(QueryStart <= start && QueryEnd >= end){
			System.out.println("QueryStart <= start && QueryEnd >= end");
			return st[currentNodeIndex];
		}
		
		if(end < QueryStart || start > QueryEnd){
			return 0;
		}
		
		// if a part of this segment overlaps with the given range.
		int mid = getMid(start,end);
		System.out.println("mid: " + mid);
		return getSumUtil(start,mid,QueryStart,QueryEnd,2*currentNodeIndex+1) + getSumUtil(mid+1,end,QueryStart,QueryEnd,2*currentNodeIndex+2); 
	}
	
	// Update a value in input array at index i and segment tree
	public void updateValue(int[] input, int length, int i, int new_val){
		if(i<0 || i>length-1){
			System.out.println("Invalid Input");
			return;
		}
		
		int diff = new_val - input[i];
		input[i] = new_val;
		updateValueUtil(0,length-1,i,diff,0);
	}
	
	public void updateValueUtil(int start, int end, int i, int diff, int currentNodeIndex){
		//Base case
		if(i<start || i>end) return;
		
		// if input index is in range of this node, then update the value of the node and its child
		st[currentNodeIndex] = st[currentNodeIndex] + diff;
		if (end!=start){
			int mid = getMid(start,end);
			updateValueUtil(start,mid,i,diff,2*currentNodeIndex+1);
			updateValueUtil(mid+1,end,i,diff,2*currentNodeIndex+2);
		}
	}
	
	public void printOutst(){
		System.out.println("Print out the st array");
		for (int e: st){
			System.out.print(e + "  ");
		}
		System.out.println();
	}

}
