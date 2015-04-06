package cow.farm;

import cow.farm.utils.SpecialArrayList;



public class CowHerdService {

	public CowHerdService() {
		// TODO Auto-generated constructor stub
	}
	private SpecialArrayList<Cow> cowlist = new SpecialArrayList<Cow>();
	
	public Cow createCowAndAddToCowlist(String race) {
		Cow aCow = new Cow (race);
		cowlist.add(aCow);
		return aCow;
		
		
		}	
	public SpecialArrayList<Cow> getTheCowlist() {
		return cowlist;
	}

}
