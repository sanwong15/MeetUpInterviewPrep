/*
 * San Wong
 * hswong1@uci.edu
 * 
 * Given a value V, if we want to make change for V cents,
 *  and we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins,
 *   what is the minimum number of coins to make the change?
 */
public class MinCoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coin = {1,2,3};
		int V = 5;
		
		System.out.println("(With Recusion) Min coins needed: " + recursive(coin, V));
		System.out.println("(With DP) Min coins needed: " + dp(coin, V));
	}
	
	public static int recursive(int[] coin, int V){
		//Base case:
		if (V ==0) return 0;
		int coinCount = Integer.MAX_VALUE;
		int size = coin.length;
		
		for (int i=0; i<size; i++){
			if (coin[i] <= V){
				int recursionCoinCount = recursive(coin,V-coin[i]);
				//Find the min. Keep it update at each iteration
				if (recursionCoinCount+1 < coinCount && recursionCoinCount!=Integer.MAX_VALUE){
					coinCount = recursionCoinCount+1;
				}
			}
		}
		
		return coinCount;
	}
	
	public static int dp(int[] coin, int V){
		int[] countArray = new int[V+1];
		countArray[0] = 0;
		
		if (V ==0) return 0;
		
		int size = coin.length;
		
		for (int i=1; i<=V; i++){
			countArray[i] = Integer.MAX_VALUE;
		}
		
		for (int i=1; i<=V; i++){
			//Cal from MC(0) to MC(V)
			for (int j=0; j<size; j++){
				//And everytime we can remove one coin
				if(coin[j] <= i){
					int recursionCoinCount = countArray[i-coin[j]];
					if(recursionCoinCount+1 < countArray[i] && recursionCoinCount!=Integer.MAX_VALUE){
						countArray[i] = recursionCoinCount+1;
					}
				}
			}
		}
		
		return countArray[V];

	}

}
