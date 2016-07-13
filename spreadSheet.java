/*
 * San Wong
 * hswong1@uci.edu
 */

public class spreadSheet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] input = {8,2,10,10,15};
		
		System.out.println("Testing clickNaive method");
		System.out.println("Given X = 5, we got index equals to: " + clickNaive(input,5));
		System.out.println("Given X = 15, we got index equals to: " + clickNaive(input,15));
		// Testing if the OutOfBounds Error works. And it works
		//System.out.println("Given X = 50, we got index equals to: " + clickNaive(input,50));
		System.out.println();
		System.out.println("Testing clickLogN method");
		System.out.println("Given X = 5, we got index equals to: " + clickLogN(input,5));
		System.out.println("Given X = 15, we got index equals to: " + clickLogN(input,15));
		System.out.println("Given X = 20, we got index equals to: " + clickLogN(input,20));
		System.out.println("Given X = 25, we got index equals to: " + clickLogN(input,25));
		System.out.println("Given X = 30, we got index equals to: " + clickLogN(input,30));
		//System.out.println("Given X = 50, we got index equals to: " + clickLogN(input,50));
		
		System.out.println();
		System.out.println("Testing resize");
		System.out.println("Resizing 1st column to width 10");
		resize(1,10,input);
		
		resizeSegmentTree(2, 20, input);
		
	}
	
	public static int clickNaive(int[] input, int X){
		int len = input.length;
		int[] cumArray = new int[len];
		cumArray[0] = input[0];
		
		for (int i=1; i<len; i++){
			cumArray[i] = cumArray[i-1]+input[i];
		}
		
		for (int i=0; i<len; i++){
			if (X < cumArray[i]){
				return i;
			}
		}
		
		throw new IndexOutOfBoundsException("Index " + X + " is out of bounds!");
	}
	
	public static int clickLogN(int[] input, int X){
		int len = input.length;
		int[] cumArray = new int[len];
		cumArray[0] = input[0];
		
		for (int i=1; i<len; i++){
			cumArray[i] = cumArray[i-1]+input[i];
		}
		if (X > cumArray[len-1]){
			throw new IndexOutOfBoundsException("Index " + X + " is out of bounds!");
		}
		
		return BinarySearch(X,0,len-1,cumArray);
	}
	
	public static int BinarySearch(int target, int start, int end, int[] cumArray){
		
		while (start <= end){
			
			int mid = start + (end-start)/2;
			
			if (target >= cumArray[mid]){
				start = mid+1;
			}
			
			if (target < cumArray[mid]){
				end = mid-1;
			}
			
			if (mid == 0 || mid == cumArray.length-1) return mid;
			
			if (target >= cumArray[mid-1] && target < cumArray[mid]){
				return mid;
			}
			
		}
		return -1;
	}
	
	public static void resize(int index, int newWidth, int[] input){
		System.out.println();
		System.out.println("===================resize=====================");
		System.out.println("Show input");
		for (int e: input){
			System.out.print(e+ "  ");
		}
		int len = input.length;
		int diff = newWidth - input[index];
		System.out.println("resize index at: "+ index + "  newWidth: " + newWidth + "  diff: " + diff);
		
		int[] cumArray = new int[len+1];
		cumArray[0] = 0;
		cumArray[1] = input[0];
		
		for (int i=2; i<=len; i++){
			cumArray[i] = cumArray[i-1]+input[i-1];
		}
		
		System.out.println("print out cumArray before resize");
		for (int e: cumArray){
			System.out.print(e + "  ");
		}
		index++;
		for (int i=index; i<=len; i++){
			cumArray[i] += diff;
		}
		System.out.println();
		System.out.println("print out cumArray after resize");
		for (int e: cumArray){
			System.out.print(e + "  ");
		}
		
		System.out.println();
		System.out.print("New column width array:  ");
		
		for (int i=0; i<len; i++){
			input[i] = cumArray[i+1]-cumArray[i];
			System.out.print(input[i] + " ");
		}
	}
	//Resize with Segment Tree to achieve logN runtime
	public static void resizeSegmentTree(int index, int newWidth, int[] input){
		System.out.println();
		System.out.println("===================resizeSegmentTree=====================");
		System.out.println("Show input");
		for (int e: input){
			System.out.print(e+ "  ");
		}
		System.out.println("resize index at: "+ index + "  newWidth: " + newWidth);
		//Construct a tree
		int len = input.length;
		STree tree = new STree(input,len);
		System.out.println("Segment Tree Before resize");
		tree.printOutst();
		tree.updateValue(input,len, index, newWidth);
		System.out.println("Segment Tree After resize");
		tree.printOutst();
	}

}

class STree{
	int [] st;
	
	
	//Constructor
	public STree(int[] input, int length){
		int height = (int)(Math.ceil(Math.log(length)/Math.log(2)));
		int max_size = 2*(int)Math.pow(2, height)-1;
		
		st = new int[max_size];
		constructTree(input,0, length-1,0);
	}
	
	public int constructTree(int[] input, int start, int end, int currentNode){
		if (start == end){
			st[currentNode] = input[start];
			return input[start];
		}
		
		int mid = getMid(start,end);
		//CurrentNode value is the sum of Left child and Right child.
		st[currentNode] = constructTree(input, start, mid, currentNode*2+1) + constructTree(input,mid+1,end,currentNode*2+2);
		return st[currentNode];
	}
	
	public int getMid(int start, int end){
		return start + (end-start)/2;
	}
	
	public void updateValue(int[] input, int len, int i, int newVal){
		if (i<0 || i>len-1){
			System.out.println("Invalid i input");
		}
		
		int diff = newVal - input[i];
		input[i] = newVal;
		updateValueUntil(0,len-1,i,diff,0);
	}
	
	public void updateValueUntil(int start, int end, int i, int diff, int currentNode){
		if (i<start || i>end) return;
		
		st[currentNode] = st[currentNode] + diff; //Start from 0, which is the root.
		
		if(end!=start){
			int mid = getMid(start,end);
			updateValueUntil(start, mid, i, diff, 2*currentNode+1);
			updateValueUntil(mid+1,end, i, diff, 2*currentNode+2);
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
