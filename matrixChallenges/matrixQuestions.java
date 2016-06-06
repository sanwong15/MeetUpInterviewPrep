package matrixChallenges;

/*
 * San Wong
 * hswong1@uci.edu
 */

public class matrixQuestions {

	public static void main(String[] args) {
		//Part A
		//Create a simple matrix
		int[][] matrix = {
				{1,2,3,4,5},{6,7,8,9,0},{1,2,3,4,5}
		};
		System.out.println("Test on mGetter: " + mGetter(matrix,1,1) );
		System.out.println("Test on mSetter to change matrix[1][1] to 8 ");
		mSetter(matrix,1,1,8);
		System.out.println("The new value after using mSetter: " + mGetter(matrix,1,1) );
		
		System.out.println();
		System.out.println("Testing out the mPrint method");
		mPrint(matrix);
		
		System.out.println();
		System.out.println("Testing out the mSum method");
		System.out.println("Current Sum of the current tree: " + mSum(matrix));
		
		//Part B
		System.out.println();
		System.out.println("Testing out the makeSquare method");
		mPrint(makeSquare(5));
		
		System.out.println();
		System.out.println("Testing out the Full Spiral Matrix, size 5");
		mPrint(makeFullSpiral(5));
		
		System.out.println();
		System.out.println("Testing out the Outer Spiral Matrix, size 5");
		mPrint(makeOuterSpiral(5));
		
		System.out.println();
		System.out.println("Testing out the Full Spiral Matrix, size 7");
		mPrint(makeFullSpiral(7));
		
		System.out.println();
		System.out.println("Testing out the Outer Spiral Matrix, size 7");
		mPrint(makeOuterSpiral(7));
		
		//Part C
		System.out.println();
		System.out.println("Testing out the Make Level Matrix, size 7");
		mPrint(makeLevels(7));
		
		System.out.println();
		System.out.println("Testing out the Make Level Matrix, size 9");
		mPrint(makeLevels(9));
		
		//Part E
		int[][] testMatrix = {
				{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}
		};
		int[] result = SpirallyTraversing(testMatrix);
		System.out.println();
		System.out.println("testMatrix: {1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}");
		System.out.println("Test 'SpirallyTraversing' method on testMatrix");
		System.out.println("Expecting output: {1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10}");
		
		for (int e: result){
			System.out.print(e + " ");
		}
		
		//Part G
		int[][] testMatrix1 = {
				{1,3,5,7},{10,11,16,20},{23,30,34,50}
		};
		
		System.out.println();
		System.out.println("testMatrix1: {{1,3,5,7},{10,11,16,20},{23,30,34,50}} ; Search target: 3"); 
		System.out.println("Search for '3', Result: " +matrixSearch(testMatrix1,3));
		System.out.println("Search for '23', Result: " +matrixSearch(testMatrix1,23));
		System.out.println("Search for '60', Result: " +matrixSearch(testMatrix1,60));
		System.out.println("Search for '-1', Result: " +matrixSearch(testMatrix1,-1));
		
		//Part F
		int[][] board = {
				{1,1,1,1,1,1,0,0},
				{0,0,0,0,0,1,0,0},
				{0,1,1,1,0,1,0,0},
				{0,0,0,1,0,1,0,0},
				{0,0,0,1,1,1,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0}
		};
		
		//System.out.println("Total path count: " + countPathLength(board));
}
	
	
	
	//Matrix getting and setter
	public static void mSetter(int[][] Array, int x, int y, int data){
		//If x,y values are out of bonds, return '-999'
		//If setting out of bounds, do nothing
		Array[x][y] = data;
	}
	
	public static Object mGetter(int[][] Array, int x, int y){
		int result = Array[x][y];

		return result;
	}
	
	public static void mPrint(int[][] Array){
		int xLen = Array[0].length;
		int yLen = Array.length;
		
		for(int j=0; j<yLen; j++){
			for(int i=0; i<xLen; i++){
				System.out.print(Array[j][i] + "  ");
			}
			System.out.println();
		}
	}
	
	public static int mSum(int[][] Array){
		int sum = 0;
		int xLen = Array[0].length;
		int yLen = Array.length;
		
		for(int j=0; j<yLen; j++){
			for(int i=0; i<xLen; i++){
				sum += Array[j][i];
			}
		}
		
		return sum;
	}
	
	public static int[][] makeSquare(int size){
		int[][] newMatrix = new int[size][size];
		
		for(int j=0; j<size; j++){
			for(int i=0; i<size; i++){
				newMatrix[j][i] = i+1;
				if(i==j){
					newMatrix[j][i] = -1*newMatrix[j][i];
				}
				
				if(j==(size-i-1)){
					newMatrix[j][i] = -1*newMatrix[j][i];
				}
			}
		}
		return newMatrix;
	}
	
	public static int[][] makeFullSpiral(int size){
		int[][] newMatrix = new int[size][size];
		
		int k = 1;
		int c1 = 0;
		int c2 = size-1;
		int r1 = 0;
		int r2 = size-1;
		
		while(k<=size*size){
			for (int i=c1; i<=c2; i++){
				newMatrix[r1][i] = k;
				k++;
			}
			
			for(int j=r1+1; j<=r2; j++){
				newMatrix[j][c2] = k;
				k++;
			}
			
			for (int i = c2-1; i>=c1; i--){
				newMatrix[r2][i] = k;
				k++;
			}
			
			for(int j=r2-1; j>=r1+1; j--){
				newMatrix[j][c1] = k++;
				//k++;
			}
			
			c1++;
			c2--;
			r1++;
			r2--;
			
		}
		
		
		return newMatrix;
	}
	
	public static int[][] makeOuterSpiral(int size){
		int[][] newMatrix = new int[size][size];
		for(int j=0; j<size; j++){
			for(int i=0; i<size; i++){
				newMatrix[j][i] = 0;
				}
		}
		
		int k = 1;
		int c1 = 0;
		int c2 = size-1;
		int r1 = 0;
		int r2 = size-1;
		
		while(k<(size*size) - (size-1)*(size-1)){
			for (int i=c1; i<=c2; i++){
				if(k>9){
					newMatrix[r1][i] = k%10;
				}else{
					newMatrix[r1][i] = k;
				}
				k++;
			}
			
			for(int j=r1+1; j<=r2; j++){
				if(k>9){
					newMatrix[j][c2] = k%10;
				}else{
					newMatrix[j][c2] = k;
				}
				
				k++;
			}
			
			for (int i = c2-1; i>=c1; i--){
				if(k>9){
					newMatrix[r2][i] = k%10;
				}else{
					newMatrix[r2][i] = k;
				}
				
				k++;
			}
			
			for(int j=r2-1; j>=r1+1; j--){
				if(k>9){
					newMatrix[j][c1] = k%10;
				}else{
					newMatrix[j][c1] = k;
				}
				
				k++;
			}
			
			
		}
		
		
		return newMatrix;
	}
	
	public static int[][] makeLevels(int size){
		int[][] newMatrix = new int[size][size];
		int k = (size/2)+1;
		int c1 = 0;
		int c2 = size-1;
		int r1 = 0;
		int r2 = size-1;
		
		while(k>0){
			for(int i=c1; i<=c2; i++){
				newMatrix[r1][i] = k;
			}
			
			for(int j=r1; j<=r2; j++){
				newMatrix[j][c2] = k;
			}
			
			for(int i=c2-1; i>=c1; i--){
				newMatrix[r2][i] = k;
			}
			
			for(int j=r2-1; j>=r1+1; j--){
				newMatrix[j][c1] = k;
			}
			
			k--;
			c1++;
			c2--;
			r1++;
			r2--;

		}
		return newMatrix;
	}
	
	public static int[] SpirallyTraversing(int[][] Array){
		int size = Array[0].length;
		int[] result = new int[size*size];
		
		int k = size*size;
		int n = 0;
		int c1 = 0;
		int c2 = size-1;
		int r1 = 0;
		int r2 = size-1;
		
		while(k>0){
			for(int i=c1; i<=c2; i++){
				result[n] = Array[r1][i];
				n++;
				k--;
			}
			
			for(int j=r1+1; j<=r2; j++){
				result[n] = Array[j][c2];
				n++;
				k--;
			}
			
			for(int i=c2-1; i>=c1; i--){
				result[n] = Array[r2][i];
				n++;
				k--;
			}
			
			for(int j=r2-1; j>=r1+1; j--){
				result[n] = Array[j][c1];
				n++;
				k--;
			}
			
			c1++;
			c2--;
			r1++;
			r2--;
		}
		return result;
	}
	
	public static int countPathLength(int[][] Array){
		int count = 1;
		
		//Set Up visited map
		int xLen = Array[0].length;
		int yLen = Array.length;
		boolean[][] visited = new boolean[yLen][xLen];
		
		for(int i=0; i<yLen; i++){
			for(int j=0; j<xLen; j++){
				visited[i][j] = false;
			}
		}
		
		visited[0][0] = true;
		
		
		
		//Start at the Top Left
		int i=0;
		int j=0;
		boolean end = false;
		while(!end){
			if(j+1<xLen){
				if(Array[i][j+1] == 1 && visited[i][j+1] != true && j+1<xLen){
					j++;
					visited[i][j+1] = true;
					count++;
				}
			}
			
			if(j-1>0){
				if(Array[i][j-1] == 1 && visited[i][j-1] != true && j-1>0){
					j--;
					visited[i][j-1] = true;
					count++;
				}
			}
			
			if(i+1<yLen){
				if(Array[i+1][j] == 1 && visited[i+1][j] != true && i+1<yLen){
					i++;
					visited[i+1][j] = true;
					count++;
				}
			}
			
			if(i-1>0){
				if(Array[i-1][j] == 1 && visited[i-1][j] != true && i-1>0){
					i--;
					visited[i-1][j] = true;
					count++;
				}
			}
			
			if (Array[i][j+1] != 1 && Array[i][j-1] != 1 && Array[i+1][j] != 1 && Array[i-1][j] != 1){
				end = true;
			}
			
		}
		
		return count;
	}
	
	public static boolean matrixSearch(int[][] Array, int target){
		
		int xLen = Array[0].length;
		int yLen = Array.length;
		int r1 = 0;
		int r2 = yLen-1;
		int c1 = 0;
		int c2 = xLen-1;
		
		int pointer = r1;
		boolean found = false;
		
		if(Array[r2][c2] < target) return false;
		if(Array[r1][c1] > target) return false;
		
		//Find which col is it gonna be
		while(!found){
			if(Array[pointer][c1] <= target && Array[pointer][c2] >=target){
				found = true;
			}else{
				pointer++;
			}
		}
		for(int i = c1; i<=c2; i++){
			if(Array[pointer][i] == target){
				return true;
			}
		}
		return false;
		
	}

}
