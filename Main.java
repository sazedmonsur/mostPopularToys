import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> ToyLists = Arrays.asList("elsa", "blocks","munchkin","drone","helicopter");
		List<String> QuotesLists = Arrays.asList("elsa is riding a helicopter", "elsa, munchkin, drone and blocks are popular in toys r us","helicopter riding by elsa","elsa can fly a drone, DJI Spark is a cool drone");
		popularNToys(4, 3, ToyLists, 5, QuotesLists);
	}

public static ArrayList<String> popularNToys(int numToys, int topToys, List<String> toys,int numQuotes, List<String> quotes){
	
	//Add list of toys on a HashSet as the toys are unique and HashSet provides better performance
	
	HashSet<String> toyset = new HashSet<>();
	
	for (String toy : toys) {
		toyset.add(toy);
	}
	
	//Convert the list of strings to a single string
	String Quotes = String.join(",", quotes);

	//HashMap to count how many times each of the toys mentioned in the quotes
	
	HashMap<String, Integer> counts = new HashMap<String, Integer>();
	for (String toy : Quotes.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ")) {
		if(toyset.contains(toy)) {
			counts.put(toy, counts.getOrDefault(toy, 0)+1);
		}
		
	}
	
    // Create a list from elements of HashMap 
    List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(counts.entrySet()); 

    // Sort the list 
    Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
        public int compare(Map.Entry<String, Integer> o1,  Map.Entry<String, Integer> o2) 
        { 
            return (o2.getValue()).compareTo(o1.getValue()); 
        }
        
    });
   
    //printing the top list of toys
    
   List<String> ListOfToys = new ArrayList<String>();
   for (int i=0; i<topToys;i++) {
	   
	   ListOfToys.add(list.get(i).getKey());
   }
   
   System.out.println(ListOfToys);
   return (ArrayList<String>) ListOfToys;
	
	}	
}
