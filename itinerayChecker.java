import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/*
 * San Wong
 * hswong1@uci.edu
 * 
 * Find Itinerary from a given list of tickets
 * Given a list of tickets, find itinerary in order using the given list.
 */

public class itinerayChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addCity("Chennai","Banglove");
		addCity("Bombay","Delhi");
		addCity("Goa","Chennai");
		addCity("Delhi","Goa");
		
		System.out.println("What's their next city?");
		System.out.println(map.get("Chennai").cityName + " => " + map.get("Chennai").printNext());
		System.out.println(map.get("Bombay").cityName + " => " + map.get("Bombay").printNext());
		System.out.println(map.get("Goa").cityName + " => " + map.get("Goa").printNext());
		System.out.println(map.get("Delhi").cityName + " => " + map.get("Delhi").printNext());
		System.out.println(map.get("Banglove").cityName + " => " + map.get("Banglove").printNext());

		System.out.println();
		System.out.println("Are they the first city?");
		System.out.println(map.get("Chennai").cityName + " : " + map.get("Chennai").isHead);
		System.out.println(map.get("Banglove").cityName + " : " + map.get("Banglove").isHead);
		System.out.println(map.get("Bombay").cityName + " : " + map.get("Bombay").isHead);
		System.out.println(map.get("Delhi").cityName + " : " + map.get("Delhi").isHead);
		System.out.println(map.get("Goa").cityName + " : " + map.get("Goa").isHead);
		
		System.out.println();
		cityNode FirstCity = findHead();
		System.out.println("First City: " + FirstCity.cityName);
		
		System.out.println("Print out the whole trip");
		printOutTrip(FirstCity);
	}
	
	public static HashMap<String, cityNode> map = new HashMap<>();
	
	//Add City
	public static void addCity(String cityFrom, String cityTo){
		if(!map.containsKey(cityFrom)){
			cityNode startPoint = new cityNode(cityFrom);
			map.put(cityFrom, startPoint);
			if (!map.containsKey(cityTo)){
				cityNode endPoint = new cityNode(cityTo);
				map.put(cityTo, endPoint);
				startPoint.nextCity = endPoint;
				endPoint.isHead = false;
			}else{
				//endPoint already exist
				cityNode endPoint = map.get(cityTo);
				startPoint.nextCity = endPoint;
				endPoint.isHead = false;
			}
		}else{
			//starting point already exist.
			cityNode startPoint = map.get(cityFrom);
			if (!map.containsKey(cityTo)){
				cityNode endPoint = new cityNode(cityTo);
				map.put(cityTo, endPoint);
				startPoint.nextCity = endPoint;
				endPoint.isHead = false;
			}else{
				//endPoint already exist
				cityNode endPoint = map.get(cityTo);
				startPoint.nextCity = endPoint;
				endPoint.isHead = false;
			}
		}
		

	}// End of add
	
	// Find head
	public static cityNode findHead(){
		Collection cityList = map.values();
	    
		Iterator itr = cityList.iterator();
		cityNode head = null;
	    while(itr.hasNext()) {
	    	//Object element = itr.next();
	    	cityNode currentNode = (cityNode) itr.next();
	    	if (currentNode.isHead){
	    		head = currentNode;
	    	}
	    }
		
		return head;
	}
	
	//Print out the whole trip
	public static void printOutTrip(cityNode city){
		while(city!=null){
			System.out.print(city.cityName + " -> ");
			city = city.nextCity;
		}
		System.out.print("End of Trip");
	}

}

class cityNode{
	String cityName;
	cityNode nextCity = null;
	boolean isHead = true;
	
	public cityNode(String name){
		cityName = name;
	}
	
	public String printNext(){
		if(this.nextCity!=null){
			return nextCity.cityName;
		}else{
			return "No Next City";
		}
	}
}
