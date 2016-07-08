import java.util.HashMap;
import java.util.Map;

/*
 * San Wong
 * hswong1@uci.edu
 * 
 * Find Itinerary from a given list of tickets
 * Given a list of tickets, find itinerary in order using the given list.
 */

public class itinerayCheckerTwoMap {

	public static void main(String[] args) {
		HashMap<String, String> dataSet = new HashMap<String, String>();
        dataSet.put("Chennai", "Banglore");
        dataSet.put("Bombay", "Delhi");
        dataSet.put("Goa", "Chennai");
        dataSet.put("Delhi", "Goa");
        
        printItineray(dataSet);
	}
	
	public static HashMap<String,String> reverseMap(HashMap<String, String> dataSet){
		HashMap<String, String> reverseMap = new HashMap<String, String>();
		
		for (Map.Entry<String,String> entry: dataSet.entrySet()){
			reverseMap.put(entry.getValue(), entry.getKey());
		}
		
		return reverseMap;
	}
	
	public static String findStartingPoint(HashMap<String,String> dataSet, HashMap<String,String> reverseDataSet){
		String startingPoint = null;
		
		for (Map.Entry<String,String> entry: dataSet.entrySet()){
			if (!reverseDataSet.containsKey(entry.getKey())){
				startingPoint = entry.getKey();
			}
		}
		
		if (startingPoint == null){
			startingPoint = "Invalid Input";
		}
		
		return startingPoint;
	}
	
	public static void printItineray(HashMap<String,String> dataSet){
		//Reverse Map
		HashMap<String,String> reverseDataSet = reverseMap(dataSet);
		//Find starting point
		String start = findStartingPoint(dataSet, reverseDataSet);
		String errorMsg = "Invalid Input";
		
		if (start.equals(errorMsg)){
			System.out.println("There is no valid starting point");
		}
		
		String to = dataSet.get(start);
		while (to!=null){
			System.out.println(start + " -> " + to);
			start = to;
			to = dataSet.get(to);
		}

	}
	
	

}
