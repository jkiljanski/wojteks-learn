package cow.farm;

import java.util.HashMap;

import cow.farm.utils.QuantityCheckingList;



public class CowHerdService implements Function{

	public CowHerdService() {
	}
	private QuantityCheckingList<Cow> cowlist = new QuantityCheckingList<Cow>();
	
	public Cow createCowAndAddToCowlist(String race, String name) {
		Cow aCow = new Cow (race, name);
		cowlist.add(aCow);
		return aCow;
		
		}
	
	
	public HashMap <Object, Integer> getQuantityOfEachRace(String function){
		HashMap <Object, Integer> hashmap = new HashMap <>();
		
		
		for (Object val : cowlist) {
			Object s =  ((Cow) val);
			
			if (hashmap.containsKey(s)) {
				int a = hashmap.get(s);
				hashmap.put(s, ++a);
			} else {
				hashmap.put(s, 1);
			}
		}
		return hashmap;

	}	
	
	
	
	public QuantityCheckingList<Cow> getTheCowlist() {
		return cowlist;
	}



	@Override
	public <T, K> K transform(T input) {
		
		
		return null;
		}
		
		
	}
	
	
	
